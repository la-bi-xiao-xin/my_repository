package cn.itcast.momo_chat.service.impl;

import cn.itcast.momo_chat.entity.Msg;
import cn.itcast.momo_chat.service.ChatMessageService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatMessageServiceImpl implements ChatMessageService {
    private Connection connection;
    private SimpleDateFormat simpleDateFormat;

    @Override
    public List<Msg> getMassage(String date, String sender, String receiver) throws IOException {
        //创建配置对象
        Configuration configuration = HBaseConfiguration.create();
        //创建连接对象
        connection = ConnectionFactory.createConnection(configuration);
        //创建Scan 对象
        Scan scan = new Scan();
        // 构建两个带时分秒的日期字符串
        String startDateStr = date + " 00:00:00";
        String endDateStr = date + " 23:59:59";

        // 2.	构建用于查询时间的范围，例如：2020-10-05 00:00:00 – 2020-10-05 23:59:59
        // 3.	构建查询日期的两个Filter，大于等于、小于等于，此处过滤单个列使用SingleColumnValueFilter即可。
        SingleColumnValueFilter filter1 =
                new SingleColumnValueFilter(Bytes.toBytes("C1"),
                        Bytes.toBytes("msg_time"),
                        CompareOperator.GREATER_OR_EQUAL,
                        new BinaryComparator(Bytes.toBytes(startDateStr))
                );
        SingleColumnValueFilter filter2 =
                new SingleColumnValueFilter(Bytes.toBytes("C1"),
                        Bytes.toBytes("msg_time"),
                        CompareOperator.LESS_OR_EQUAL,
                        new BinaryComparator(Bytes.toBytes(endDateStr)));
        SingleColumnValueFilter filter3 = new SingleColumnValueFilter(Bytes.toBytes("C1"),
                Bytes.toBytes("sender_account"),
                CompareOperator.EQUAL,
                new BinaryComparator(Bytes.toBytes(sender)));
        SingleColumnValueFilter filter4 = new SingleColumnValueFilter(Bytes.toBytes("C1"),
                Bytes.toBytes("receiver_account"),
                CompareOperator.EQUAL,
                new BinaryComparator(Bytes.toBytes(receiver)));
        //创建过滤器集合对象
        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL, filter1, filter2, filter3, filter4);
        //设置Scan
         scan.setFilter(filterList);
        //获取Htable对象
        Table table = connection.getTable(TableName.valueOf("MOMO_CHAT:MSG"));
        //发送扫描请求,获取扫描结果集对象
        ResultScanner scanner = table.getScanner(scan);
        Iterator<Result> iterator = scanner.iterator();
        //遍历扫描结果集
        //创建Msg集合对象
        ArrayList<Msg> msgArrayList = new ArrayList<>();
        while (iterator.hasNext()) {
            Msg msg = new Msg();
            Result result = iterator.next();
            // 获取rowkey
            byte[] rowkeyByte = result.getRow();
            String rowkey = Bytes.toString(rowkeyByte);
            //获取每列单元值集合
            List<Cell> cells = result.listCells();
            for (Cell cell : cells) {
                String columnName = Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
                if (columnName.equals("msg_time")) {
                    msg.setMsg_time(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("sender_nickyname")) {
                    msg.setSender_nickyname(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("sender_account")) {
                    msg.setSender_account(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("sender_sex")) {
                    msg.setSender_sex(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("sender_ip")) {
                    msg.setSender_ip(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("sender_os")) {
                    msg.setSender_os(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("sender_phone_type")) {
                    msg.setSender_phone_type(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("sender_network")) {
                    msg.setSender_network(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("sender_gps")) {
                    msg.setSender_gps(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("receiver_nickyname")) {
                    msg.setReceiver_nickyname(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("receiver_ip")) {
                    msg.setReceiver_ip(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("receiver_account")) {
                    msg.setReceiver_account(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("receiver_os")) {
                    msg.setReceiver_os(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("receiver_phone_type")) {
                    msg.setReceiver_phone_type(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("receiver_network")) {
                    msg.setReceiver_network(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("receiver_gps")) {
                    msg.setReceiver_gps(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("receiver_sex")) {
                    msg.setReceiver_sex(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("msg_type")) {
                    msg.setMsg_type(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("distance")) {
                    msg.setDistance(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (columnName.equals("message")) {
                    msg.setMessage(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }

            }
            msgArrayList.add(msg);


        }
        //释放资源
        scanner.close();
        table.close();
        return msgArrayList;
    }

    @Override
    public void close() throws IOException {

        connection.close();
    }
}
