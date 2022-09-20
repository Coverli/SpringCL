package com.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 *      耦合：程序间的依赖关系
 *          包括：
 *              类之间的依赖
 *              方法间的依赖
 *      解耦：
 *          降低程序间的依赖关系
 *      实际开发中：
 *          应该做到：编译期不依赖，运行时才依赖。
 *      解耦的思路：
 *          第一步：使用反射来创建对象，而避免使用new关键字。
 *          第二步：通过读取配置文件来获取要创建的对象全限定类名
 *
 */
public class JdbcDemo1 {
    public static void main (String[] args) throws ClassNotFoundException {
        //1.注册驱动
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy",
                        "root","123456");
                PreparedStatement pstm = conn.prepareStatement("select * from account");
                ResultSet rs = pstm.executeQuery();
        )
        {
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
