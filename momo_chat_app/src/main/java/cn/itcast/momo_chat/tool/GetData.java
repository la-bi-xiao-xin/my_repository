package cn.itcast.momo_chat.tool;

import cn.itcast.momo_chat.entity.Msg;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MD5Hash;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
//随机插入一条数据
public class GetData {
    public static void main(String[] args) throws IOException, ParseException {
        //获取resultMap
        Map<String, List<String>> resultMap = ExcelReader.readXlsx("F:\\idea_project\\momo_chat_app\\data\\测试数据集.xlsx", "陌陌数据");
        //1.获取HBase连接
        //创建配置对象自动读取resources目录下的配置文件
        Configuration configuration = HBaseConfiguration.create();
        //使用ConnectionFactory获取连接
        Connection connection = ConnectionFactory.createConnection(configuration);
        //通过表名连接HBase数据库表获取Htable对象
        Table table = connection.getTable(TableName.valueOf("MOMO_CHAT:MSG"));
        //创建Put对象
        Msg msg = getOneMsg(resultMap);
        Put put = new Put(getRowkey(msg));
        //向表中插入数据,要传递列族名,列名,列值
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("msg_time"),Bytes.toBytes(msg.getMsg_time()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("sender_nickyname"),Bytes.toBytes(msg.getSender_nickyname()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("sender_account"),Bytes.toBytes(msg.getSender_account()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("sender_sex"),Bytes.toBytes(msg.getSender_sex()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("sender_ip"),Bytes.toBytes(msg.getSender_ip()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("sender_os"),Bytes.toBytes(msg.getSender_os()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("sender_phone_type"),Bytes.toBytes(msg.getSender_phone_type()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("sender_network"),Bytes.toBytes(msg.getSender_network()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("sender_gps"),Bytes.toBytes(msg.getSender_gps()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("receiver_nickyname"),Bytes.toBytes(msg.getReceiver_nickyname()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("receiver_ip"),Bytes.toBytes(msg.getReceiver_ip()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("receiver_account"),Bytes.toBytes(msg.getReceiver_account()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("receiver_os"),Bytes.toBytes(msg.getReceiver_os()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("receiver_phone_type"),Bytes.toBytes(msg.getReceiver_phone_type()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("receiver_network"),Bytes.toBytes(msg.getReceiver_network()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("receiver_gps"),Bytes.toBytes(msg.getReceiver_gps()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("receiver_sex"),Bytes.toBytes(msg.getReceiver_sex()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("msg_type"),Bytes.toBytes(msg.getMsg_type()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("distance"),Bytes.toBytes(msg.getDistance()));
        put.addColumn(Bytes.toBytes("C1"),Bytes.toBytes("message"),Bytes.toBytes(msg.getMessage()));
       //执行普通请求
        table.put(put);
        table.close();
        connection.close();


    }

    //获取从excel表中获取一条随机数据,封装到Msg对象中
    private static Msg getOneMsg(Map<String, List<String>> resultMap) {
        Msg msg = new Msg();
        long time = new Date().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        msg.setMsg_time(sdf.format(time));
           msg.setSender_nickyname(ExcelReader.randomColumn(resultMap,"sender_nickyname"));
           msg.setSender_account(ExcelReader.randomColumn(resultMap,"sender_account"));
           msg.setSender_sex(ExcelReader.randomColumn(resultMap,"sender_sex"));
           msg.setSender_ip(ExcelReader.randomColumn(resultMap,"sender_ip"));
           msg.setSender_os(ExcelReader.randomColumn(resultMap,"sender_os"));
           msg.setSender_phone_type(ExcelReader.randomColumn(resultMap,"sender_phone_type"));
           msg.setSender_network(ExcelReader.randomColumn(resultMap,"sender_network"));
           msg.setSender_gps(ExcelReader.randomColumn(resultMap,"sender_gps"));
           msg.setReceiver_nickyname(ExcelReader.randomColumn(resultMap,"receiver_nickyname"));
           msg.setReceiver_ip(ExcelReader.randomColumn(resultMap,"receiver_ip"));
           msg.setReceiver_account(ExcelReader.randomColumn(resultMap,"receiver_account"));
           msg.setReceiver_os(ExcelReader.randomColumn(resultMap,"receiver_os"));
           msg.setReceiver_phone_type(ExcelReader.randomColumn(resultMap,"receiver_phone_type"));
           msg.setReceiver_network(ExcelReader.randomColumn(resultMap,"receiver_network"));
           msg.setReceiver_gps(ExcelReader.randomColumn(resultMap,"receiver_gps"));
           msg.setReceiver_sex(ExcelReader.randomColumn(resultMap,"receiver_sex"));
           msg.setMsg_type(ExcelReader.randomColumn(resultMap,"msg_type"));
           msg.setDistance(ExcelReader.randomColumn(resultMap,"distance"));
           msg.setMessage(ExcelReader.randomColumn(resultMap,"message"));

           return msg;

    }

    //自定定义rowkey
    private static byte[] getRowkey(Msg msg) throws ParseException {
        //获取收发件ID字符串连接体
        StringBuilder stringBuilder = new StringBuilder(msg.getSender_account());
        stringBuilder.append("-");
        stringBuilder.append(msg.getReceiver_account());
        stringBuilder.append("_");

        //获取时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        stringBuilder.append(sdf.parse(msg.getMsg_time()).getTime());
        byte[] orginkey = Bytes.toBytes(stringBuilder.toString());
        //避免roekey太长,截取前八位作为rowkey
        String rowkey = MD5Hash.getMD5AsHex(orginkey).substring(0, 8);
        return Bytes.toBytes(rowkey+stringBuilder.toString());


    }
}
