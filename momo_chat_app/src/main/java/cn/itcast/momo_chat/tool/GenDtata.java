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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GenDtata {
    public static void main(String[] args) throws Exception {
        Map<String, List<String>> resultMap = ExcelReader.readXlsx("F:\\idea_project\\momo_chat_app\\data\\测试数据集.xlsx", "陌陌数据");

        // 1. 获取HBase连接
        Configuration configuration = HBaseConfiguration.create();

        Connection connection = ConnectionFactory.createConnection(configuration);

        // 2. 获取HTable
        String TABLE_NAME = "MOMO_CHAT:MSG";
        Table momoChatlTable = connection.getTable(TableName.valueOf(TABLE_NAME));

        String cf_name = "C1";
        String col_msg_time = "msg_time";
        String col_sender_nickyname = "sender_nickyname";
        String col_sender_account = "sender_account";
        String col_sender_sex = "sender_sex";
        String col_sender_ip = "sender_ip";
        String col_sender_os = "sender_os";
        String col_sender_phone_type = "sender_phone_type";
        String col_sender_network = "sender_network";
        String col_sender_gps = "sender_gps";
        String col_receiver_nickyname = "receiver_nickyname";
        String col_receiver_ip = "receiver_ip";
        String col_receiver_account = "receiver_account";
        String col_receiver_os = "receiver_os";
        String col_receiver_phone_type = "receiver_phone_type";
        String col_receiver_network = "receiver_network";
        String col_receiver_gps = "receiver_gps";
        String col_receiver_sex = "receiver_sex";
        String col_msg_type = "msg_type";
        String col_distance = "distance";
        String col_message = "message";

        int i = 0;
        int max = 100000;
        while(i < max) {
            Msg msg = getOneMsg(resultMap);
            Put put = new Put(getRowkey(msg));

            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_msg_time), Bytes.toBytes(msg.getMsg_time()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_nickyname), Bytes.toBytes(msg.getSender_nickyname()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_account), Bytes.toBytes(msg.getSender_account()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_sex), Bytes.toBytes(msg.getSender_sex()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_ip), Bytes.toBytes(msg.getSender_ip()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_os), Bytes.toBytes(msg.getSender_os()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_phone_type), Bytes.toBytes(msg.getSender_phone_type()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_network), Bytes.toBytes(msg.getSender_network()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_sender_gps), Bytes.toBytes(msg.getSender_gps()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_nickyname), Bytes.toBytes(msg.getReceiver_nickyname()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_ip), Bytes.toBytes(msg.getReceiver_ip()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_account), Bytes.toBytes(msg.getReceiver_account()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_os), Bytes.toBytes(msg.getReceiver_os()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_phone_type), Bytes.toBytes(msg.getReceiver_phone_type()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_network), Bytes.toBytes(msg.getReceiver_network()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_gps), Bytes.toBytes(msg.getReceiver_gps()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_receiver_sex), Bytes.toBytes(msg.getReceiver_sex()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_msg_type), Bytes.toBytes(msg.getMsg_type()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_distance), Bytes.toBytes(msg.getDistance()));
            put.addColumn(Bytes.toBytes(cf_name), Bytes.toBytes(col_message), Bytes.toBytes(msg.getMessage()));

            // 5. 执行put请求
            momoChatlTable.put(put);
            System.out.println(i + " / " + max);
            ++i;
        }

        // 6. 关闭连接
        momoChatlTable.close();
        momoChatlTable.close();

    }

    private static byte[] getRowkey(Msg msg) throws Exception {
        // 3. 构建ROWKEY
        // 发件人ID1反转
        StringBuilder stringBuilder = new StringBuilder(msg.getSender_account());
        stringBuilder.append("_");
        stringBuilder.append(msg.getReceiver_account());
        stringBuilder.append("_");
        // 转换为时间戳
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        stringBuilder.append(sdf.parse(msg.getMsg_time()).getTime());

        byte[] orginkey = Bytes.toBytes(stringBuilder.toString());
        // 为了避免ROWKEY过长，取前八位
        String md5AsHex = MD5Hash.getMD5AsHex(orginkey).substring(0, 8);

        return Bytes.toBytes(md5AsHex + "_" + stringBuilder.toString());
    }

    private static Msg getOneMsg(Map<String, List<String>> resultMap) {
        Msg msg = new Msg();
        long timestamp = new Date().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        msg.setMsg_time(sdf.format(timestamp));
        msg.setSender_nickyname(ExcelReader.randomColumn(resultMap, "sender_nickyname"));
        msg.setSender_account(ExcelReader.randomColumn(resultMap, "sender_account"));
        msg.setSender_sex(ExcelReader.randomColumn(resultMap, "sender_sex"));
        msg.setSender_ip(ExcelReader.randomColumn(resultMap, "sender_ip"));
        msg.setSender_os(ExcelReader.randomColumn(resultMap, "sender_os"));
        msg.setSender_phone_type(ExcelReader.randomColumn(resultMap, "sender_phone_type"));
        msg.setSender_network(ExcelReader.randomColumn(resultMap, "sender_network"));
        msg.setSender_gps(ExcelReader.randomColumn(resultMap, "sender_gps"));
        msg.setReceiver_nickyname(ExcelReader.randomColumn(resultMap, "receiver_nickyname"));
        msg.setReceiver_ip(ExcelReader.randomColumn(resultMap, "receiver_ip"));
        msg.setReceiver_account(ExcelReader.randomColumn(resultMap, "receiver_account"));
        msg.setReceiver_os(ExcelReader.randomColumn(resultMap, "receiver_os"));
        msg.setReceiver_phone_type(ExcelReader.randomColumn(resultMap, "receiver_phone_type"));
        msg.setReceiver_network(ExcelReader.randomColumn(resultMap, "receiver_network"));
        msg.setReceiver_gps(ExcelReader.randomColumn(resultMap, "receiver_gps"));
        msg.setReceiver_sex(ExcelReader.randomColumn(resultMap, "receiver_sex"));
        msg.setMsg_type(ExcelReader.randomColumn(resultMap, "msg_type"));
        msg.setDistance(ExcelReader.randomColumn(resultMap, "distance"));
        msg.setMessage(ExcelReader.randomColumn(resultMap, "message"));

        return msg;
    }

}
