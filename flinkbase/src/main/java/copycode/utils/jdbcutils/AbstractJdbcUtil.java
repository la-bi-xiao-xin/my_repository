package copycode.utils.jdbcutils;

import avro.shaded.com.google.common.collect.Lists;
import com.alibaba.druid.util.JdbcUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Date;
public class AbstractJdbcUtil {
    public AbstractJdbcUtil() {
    }

    //1.获取连接的方法
    public static Connection getConnection(String driveClassName, String url, String username, String password) {
        //声明连接
        Connection connection;

        try {
            Object o = Class.forName(driveClassName).newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
            throw new RuntimeException();
        }

        return connection;

    }

    //2.查询数据的方法
    public static List<Map<String, Object>> query(Connection connection, String sql) {
        try {
            List<Map<String, Object>> list = JdbcUtils.executeQuery(connection, sql, Lists.newArrayList());
            list.forEach(map -> {
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, Object> entry = it.next();
                    String key = entry.getKey();
                    Object value = entry.getValue();
                     if(value instanceof Date){
                       //
                     }
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //3.关闭连接的方法
    public static void closeConnection(Connection connection) {

        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("关闭连接异常");
            throw new RuntimeException();
        }

    }

    //3.
}
