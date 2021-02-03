package jdbc;

import java.sql.*;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
// 注意：使用JDBC规范，采用都是 java.sql包下的内容
        //1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2 获得连接
        String url = "jdbc:mysql://localhost:3306/test";
        Connection conn = DriverManager.getConnection(url, "root", "123456");
        //3获得执行sql语句的对象
        Statement stmt = conn.createStatement();

        //4执行SQL语句
        ResultSet rs = stmt.executeQuery("select * from activity");
        ResultSetMetaData metaData = rs.getMetaData();
        System.out.println(metaData);

        //5处理结果集
        while(rs.next()){
            // 获得一行数据
            String user_id = rs.getString("user_id");
            String session_id = rs.getString("session_id");
            Date activity_date = rs.getDate("activity_date");
            String activity_type = rs.getString("activity_type");
            System.out.println(user_id + " , " + session_id+" , " +activity_date+" , "+activity_type);
        }
        //6释放资源
        rs.close();
        stmt.close();
        conn.close();

    }
}
