package cn.itcast.bank_record.bulkload.mr;

import cn.itcast.bank_record.entity.TransferRecord;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.hbase.util.MapReduceExtendedCell;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class BankRecordMapper extends Mapper<LongWritable, Text, ImmutableBytesWritable, MapReduceExtendedCell> {
    /**
     * 1.	创建一个BankRecordMapper的类继承Mapper类，Mapper的泛型为
     * a)	输入key：LongWritable
     * b)	输入value：Text
     * c)	输出key：ImmutableBytesWritable
     * d)	输出value：MapReduceExtendedCell
     * 2.	将Mapper获取到Text文本行，转换为TransferRecord实体类

     * 4.	使用KeyValue类构建单元格，每个需要写入到表中的字段都需要构建出来单元格
     * 5.	使用context.write将输出输出
     * a)	构建输出key：new ImmutableBytesWrite(rowkey)
     * b)	构建输出的value：new MapReduceExtendedCell(keyvalue对象)
     */


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        TransferRecord transferRecord = TransferRecord.parse(value.toString());

        // 从实体类中获取ID，并转换为rowkey
        String rowkeyString = transferRecord.getId();

        byte[] rowkeyByteArray = Bytes.toBytes(rowkeyString);
        byte[] columnFamily = Bytes.toBytes("C1");
        byte[] colId = Bytes.toBytes("id");
        byte[] colCode = Bytes.toBytes("code");
        byte[] colRec_account = Bytes.toBytes("rec_account");
        byte[] colRec_bank_name = Bytes.toBytes("rec_bank_name");
        byte[] colRec_name = Bytes.toBytes("rec_name");
        byte[] colPay_account = Bytes.toBytes("pay_account");
        byte[] colPay_name = Bytes.toBytes("pay_name");
        byte[] colPay_comments = Bytes.toBytes("pay_comments");
        byte[] colPay_channel = Bytes.toBytes("pay_channel");
        byte[] colPay_way = Bytes.toBytes("pay_way");
        byte[] colStatus = Bytes.toBytes("status");
        byte[] colTimestamp = Bytes.toBytes("timestamp");
        byte[] colMoney = Bytes.toBytes("money");

        // 构建输出key：new ImmutableBytesWrite(rowkey)
        ImmutableBytesWritable immutableBytesWritable = new ImmutableBytesWritable(rowkeyByteArray);

        // 使用KeyValue类构建单元格，每个需要写入到表中的字段都需要构建出来单元格 rowkey,列族,列名,列值的Byte[]对象
        //KeyVlue实现了cell接口
        KeyValue kvId = new KeyValue(rowkeyByteArray, columnFamily, colId, Bytes.toBytes(transferRecord.getId()));
        KeyValue kvCode = new KeyValue(rowkeyByteArray, columnFamily, colCode, Bytes.toBytes(transferRecord.getCode()));
        KeyValue kvRec_account = new KeyValue(rowkeyByteArray, columnFamily, colRec_account, Bytes.toBytes(transferRecord.getRec_account()));
        KeyValue kvRec_bank_name = new KeyValue(rowkeyByteArray, columnFamily, colRec_bank_name, Bytes.toBytes(transferRecord.getRec_bank_name()));
        KeyValue kvRec_name = new KeyValue(rowkeyByteArray, columnFamily, colRec_name, Bytes.toBytes(transferRecord.getRec_name()));
        KeyValue kvPay_account = new KeyValue(rowkeyByteArray, columnFamily, colPay_account, Bytes.toBytes(transferRecord.getPay_account()));
        KeyValue kvPay_name = new KeyValue(rowkeyByteArray, columnFamily, colPay_name, Bytes.toBytes(transferRecord.getPay_name()));
        KeyValue kvPay_comments = new KeyValue(rowkeyByteArray, columnFamily, colPay_comments, Bytes.toBytes(transferRecord.getPay_comments()));
        KeyValue kvPay_channel = new KeyValue(rowkeyByteArray, columnFamily, colPay_channel, Bytes.toBytes(transferRecord.getPay_channel()));
        KeyValue kvPay_way = new KeyValue(rowkeyByteArray, columnFamily, colPay_way, Bytes.toBytes(transferRecord.getPay_way()));
        KeyValue kvStatus = new KeyValue(rowkeyByteArray, columnFamily, colStatus, Bytes.toBytes(transferRecord.getStatus()));
        KeyValue kvTimestamp = new KeyValue(rowkeyByteArray, columnFamily, colTimestamp, Bytes.toBytes(transferRecord.getTimestamp()));
        KeyValue kvMoney = new KeyValue(rowkeyByteArray, columnFamily, colMoney, Bytes.toBytes(transferRecord.getMoney()));

        // 使用context.write将输出输出
        // 构建输出的value：new MapReduceExtendedCell(keyvalue对象)
        //k2 对应rowkey   v2对应 列值
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvId));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvCode));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvRec_account));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvRec_bank_name));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvRec_name));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvPay_account));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvPay_name));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvPay_comments));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvPay_channel));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvPay_way));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvStatus));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvTimestamp));
        context.write(immutableBytesWritable, new MapReduceExtendedCell(kvMoney));
    }


    }

