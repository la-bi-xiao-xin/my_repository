package cn.itcast.hbase.admin.api_test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.client.metrics.ScanMetrics;
import org.apache.hadoop.hbase.filter.BinaryComparator;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.protobuf.generated.FilterProtos;
import org.apache.hadoop.hbase.util.Bytes;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class DataOpTest {
    private Configuration configuration;
    private Connection connection;

    @BeforeTest
    public void beforeTest() throws IOException {
        configuration = HBaseConfiguration.create();
        connection = ConnectionFactory.createConnection(configuration);
    }
    @Test
    public void addTest() throws IOException {
        // 1.使用Hbase连接获取Htable
        TableName waterBillTableName = TableName.valueOf("WATER_BILL");
        Table waterBillTable = connection.getTable(waterBillTableName);

        // 2.构建ROWKEY、列蔟名、列名
        String rowkey = "4944191";
        String cfName = "C1";
        String colName = "NAME";

        // 3.构建Put对象（对应put命令）,传如rowkey的Bytes的对象
        Put put = new Put(Bytes.toBytes(rowkey));

        // 4.添加姓名列,传如列族,列名,列值的Bytes的对象
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colName)
                , Bytes.toBytes("登卫红"));

        // 5.使用Htable表对象执行put操作
        waterBillTable.put(put);
        // 6. 关闭表
        waterBillTable.close();
    }
    @Test
    public void addTest2() throws IOException {
        // 1.使用Hbase连接获取Htable
        TableName waterBillTableName = TableName.valueOf("WATER_BILL");
        Table waterBillTable = connection.getTable(waterBillTableName);

        // 2.构建ROWKEY、列蔟名、列名
        String rowkey = "4944191";
        String cfName = "C1";
        String colName = "NAME";
        String colADDRESS = "ADDRESS";
        String colSEX = "SEX";
        String colPAY_DATE = "PAY_DATE";
        String colNUM_CURRENT = "NUM_CURRENT";
        String colNUM_PREVIOUS = "NUM_PREVIOUS";
        String colNUM_USAGE = "NUM_USAGE";
        String colTOTAL_MONEY = "TOTAL_MONEY";
        String colRECORD_DATE = "RECORD_DATE";
        String colLATEST_DATE = "LATEST_DATE";

        // 3.构建Put对象（对应put命令）
        Put put = new Put(Bytes.toBytes(rowkey));

        // 4.添加姓名列
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colName)
                , Bytes.toBytes("登卫红"));
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colADDRESS)
                , Bytes.toBytes("贵州省铜仁市德江县7单元267室"));
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colSEX)
                , Bytes.toBytes("男"));
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colPAY_DATE)
                , Bytes.toBytes("2020-05-10"));
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colNUM_CURRENT)
                , Bytes.toBytes("308.1"));
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colNUM_PREVIOUS)
                , Bytes.toBytes("283.1"));
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colNUM_USAGE)
                , Bytes.toBytes("25"));
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colTOTAL_MONEY)
                , Bytes.toBytes("150"));
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colRECORD_DATE)
                , Bytes.toBytes("2020-04-25"));
        put.addColumn(Bytes.toBytes(cfName)
                , Bytes.toBytes(colLATEST_DATE)
                , Bytes.toBytes("2020-06-09"));

        // 5.使用Htable表对象执行put操作
        waterBillTable.put(put);

        // 6. 关闭表
        waterBillTable.close();
    }
    /*实现步骤：
                1.	获取HTable
                2.	使用rowkey构建Get对象
                3.	执行get请求
                4.	获取所有单元格
                5.	打印rowkey
                6.	迭代单元格列表
                7.	关闭表

*/
    @Test
    public void getOneTest() throws IOException {
        //1.	获取HTable
        Table water_bill = connection.getTable(TableName.valueOf("WATER_BILL"));
        // 2.	使用rowkey构建Get对象
        Get get = new Get(Bytes.toBytes("4944191"));
        // 3.	执行get请求
        Result result = water_bill.get(get);
        // 4.	获取所有单元格
        List<Cell> cells = result.listCells();
        //  5.	打印rowkey
        System.out.println("roekey=>"+result.getRow());
        //6.	迭代单元格列表
        for (Cell cell : cells) {
            String cf=Bytes.toString(cell.getFamilyArray(),cell.getFamilyOffset(),cell.getFamilyLength());
            String columnName=Bytes.toString(cell.getQualifierArray(),cell.getQualifierOffset(),cell.getQualifierLength());
            String value=Bytes.toString(cell.getValueArray(),cell.getValueOffset(),cell.getValueLength());
            System.out.println(cf + ":" + columnName + " -> " + value);

        }
       //7.	关闭表
        water_bill.close();


    }
    /*实现步骤：
                1.	获取HTable对象
                2.	根据rowkey构建delete对象
                3.	执行delete请求
                4.	关闭表
*/
    @Test
    public void deleteOneTest() throws IOException {
        // 1.	获取HTable对象
        Table water_bill = connection.getTable(TableName.valueOf("WATER_BILL"));
        // 2.	根据rowkey构建delete对象
        Delete delete = new Delete(Bytes.toBytes("4944191"));
        //3.	执行delete请求
        water_bill.delete(delete);
        //4.	关闭表
        water_bill.close();

    }
    /*实现步骤：
                1.	获取表
                2.	构建scan请求对象
                3.	构建两个过滤器
                a)	构建两个日期范围过滤器（注意此处请使用RECORD_DATE——抄表日期比较
                b)	构建过滤器列表
                4.	执行scan扫描请求
                5.	迭代打印result
                6.	迭代单元格列表
                7.	关闭ResultScanner（这玩意把转换成一个个的类似get的操作，注意要关闭释放资源）
                8.	关闭表
*/
    @Test
    public void queryTest1() throws IOException {
        //  1.	获取表
        Table water_bill = connection.getTable(TableName.valueOf("WATER_BILL"));
        // 2.	构建scan请求对象
        Scan scan = new Scan();
        //  3.	构建两个过滤器
        SingleColumnValueFilter startFilter = new SingleColumnValueFilter(Bytes.toBytes("C1")
                , Bytes.toBytes("RECORD_DATE")
                , CompareOperator.GREATER_OR_EQUAL
                , new BinaryComparator(Bytes.toBytes("2020-06-01")));
        SingleColumnValueFilter endFilter = new SingleColumnValueFilter(Bytes.toBytes("C1")
                , Bytes.toBytes("RECORD_DATE")
                , CompareOperator.GREATER_OR_EQUAL
                , new BinaryComparator(Bytes.toBytes("2020-06-30")));
        // b)	构建过滤器列表
        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL, startFilter, endFilter);
        //4.	执行scan扫描请求
        Scan scan1 = scan.setFilter(filterList);
        ResultScanner resultsScanner = water_bill.getScanner(scan1);
        //5.	迭代打印result
        int count=0;
        Iterator<Result> iterator = resultsScanner.iterator();
        while(iterator.hasNext()){
            count++;
            Result result = iterator.next();
            List<Cell> cells = result.listCells();
            for (Cell cell : cells) {
                // 将字节数组转换为字符串
                // 获取列蔟的名称
                String cf = Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength());
                // 获取列的名称
                String columnName = Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
                String value = "";

                // 解决乱码问题：
                // 思路：
                // 如果某个列是以下列中的其中一个，调用toDouble将它认为是一个数值来转换
                //1.	NUM_CURRENT
                //2.	NUM_PREVIOUS
                //3.	NUM_USAGE
                //4.	TOTAL_MONEY
                if(columnName.equals("NUM_CURRENT")
                        || columnName.equals("NUM_PREVIOUS")
                        || columnName.equals("NUM_USAGE")
                        || columnName.equals("TOTAL_MONEY")) {
                    value = Bytes.toDouble(cell.getValueArray()) + "";
                }
                else {
                    // 获取值
                    value = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                }

                System.out.println(cf + ":" + columnName + " -> " + value);
            }
            }
        System.out.println("有"+count+"条数据");


        }


    @AfterTest
    public void afterTest() throws IOException {
        connection.close();
    }
}
