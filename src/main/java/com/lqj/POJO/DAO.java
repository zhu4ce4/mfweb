//package com.lqj.POJO;
//
//import com.lqj.entity.TaoLun;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
//
//import java.sql.*;
//import java.util.List;
//
//@PropertySource("classpath:application.properties")
//@Component("dao")
//@ConfigurationProperties(prefix = "mysql")
//public abstract interface DAO<T> {
////public interface DAO{
//
//}
////    private String url;
////    private String username;
////    private String password;
////    private String database;
////
////    public Connection getConnection() throws SQLException {
////        try {
////            Class.forName("com.mysql.cj.jdbc.Driver");
//////            Class.forName("com.mysql.jdbc.Driver");
////        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
////        }
////        return DriverManager.getConnection(url, username, password);
////    }
////
////    public int getTotalNums(String table) {
////        int num = 0;
////        String sql = String.format("select count(*) from %s", table);
////        try (Connection c = getConnection(); Statement ps = c.createStatement()) {
////            ResultSet rs = ps.executeQuery(sql);
////            while (rs.next()) {
////                num = rs.getInt(1);
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return num;
////    }
////
////    public int newestId(String table) {
////        String sql = String.format("select id from %s order by id DESC limit 1",table);
////        try (Connection c = getConnection(); Statement s = c.createStatement()) {
////            ResultSet rs = s.executeQuery(sql);
////            int newestId = -1;
////            while (rs.next()) {
////                newestId = rs.getInt(1);
////            }
////            return newestId;
////        } catch (SQLException e) {
////            e.printStackTrace();
////            return -1;
////        }
////    }
////
////    //由于id自增，删除某个id后，继续添加的内容的id会在被删除的id基础上+1，故不能用查询信息个数或者获取最新一个id并+1的方式去产生id
////    public int nextId(String table) {
////        try (Connection c = getConnection(); Statement s = c.createStatement()) {
////            String sql = String.format("SELECT auto_increment FROM information_schema.`TABLES` WHERE TABLE_SCHEMA='%s' AND TABLE_NAME='%s'", getDatabase(), table);
////            ResultSet rs = s.executeQuery(sql);
////            int nextId = -1;
////            while (rs.next()) {
////                nextId = rs.getInt(1);
////            }
////            return nextId;
////        } catch (SQLException e) {
////            e.printStackTrace();
////            return -1;
////        }
////    }
////

