package cn.itcast.hbase.admin.api_test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TableAmdinTest {
    /*
        实现步骤：
        1.	使用HbaseConfiguration.create()创建Hbase配置
        2.	使用ConnectionFactory.createConnection()创建Hbase连接
        3.	要创建表，需要基于Hbase连接获取admin管理对象
        4.	使用admin.close、connection.close关闭连接
*/
    private Configuration configuration;
    private Connection connection;
    private Admin admin;

    @BeforeTest
    public void beforeTest() throws IOException {
        configuration = HBaseConfiguration.create();
        connection = ConnectionFactory.createConnection(configuration);
        admin = connection.getAdmin();


    }

    /*创建一个名为WATER_BILL的表，包含一个列蔟C1。
        实现步骤：
        1.	判断表是否存在
        a)	存在，则退出
        2.	使用TableDescriptorBuilder.newBuilder构建表描述构建器
        3.	使用ColumnFamilyDescriptorBuilder.newBuilder构建列蔟描述构建器
        4.	构建列蔟描述，构建表描述
        5.	创建表
*/
    @Test
    public void createtTable() throws IOException {
        // 表名
        String TABLE_NAME = "WATER_BILL";
        // 列蔟名
        String COLUMN_FAMILY = "C1";

        if (admin.tableExists(TableName.valueOf(TABLE_NAME))) {
            return;
        }
        //2.	使用TableDescriptorBuilder.newBuilder构建表描述构建器
        TableDescriptorBuilder tableDescriptorBuilder = TableDescriptorBuilder.newBuilder(TableName.valueOf(TABLE_NAME));
        //3.	使用ColumnFamilyDescriptorBuilder.newBuilder构建列蔟描述构建器
        ColumnFamilyDescriptorBuilder columnFamilyDescriptorBuilder = ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(COLUMN_FAMILY));
        // 4.	构建列蔟描述，构建表描述
        ColumnFamilyDescriptor columnFamilyDescriptor = columnFamilyDescriptorBuilder.build();
        tableDescriptorBuilder.setColumnFamily(columnFamilyDescriptor);
        TableDescriptor tableDescriptor = tableDescriptorBuilder.build();
        //   5.	创建表
        admin.createTable(tableDescriptor);

    }

        @Test
        public void dropTable() throws IOException {
                /*实现步骤：
                            1.	判断表是否存在
                            2.	如果存在，则禁用表
                            3.	再删除表
    */
                 //1.	判断表是否存在
            if (admin.tableExists(TableName.valueOf("WATER_BILL"))) {
                // 2.	如果存在，则禁用表
                admin.disableTable(TableName.valueOf("WATER_BILL"));
                //3.    再删除表
                admin.deleteTable(TableName.valueOf("WATER_BILL"));

            }
        }

    @AfterTest
    public void afterTest() throws IOException {
        admin.close();
        connection.close();


    }

}


