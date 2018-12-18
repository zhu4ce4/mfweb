package com.lqj.DAO;

import com.lqj.POJO.DAO;
import com.lqj.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("userdao")
public class UserDAO extends DAO<User> {

    private String userTable;

    //    //add前需先进行校验操作，看是否有重名
    public boolean registerable(String aname) {
        String sql = String.format("select count(*) from %s where name=?", userTable);
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, aname);
            ResultSet rs = ps.executeQuery();
            int result = 1;
            while (rs.next()) {
                result = rs.getInt(1);
            }
            return result == 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


//    public  User getAuser(int id) {
//        User aUser = null;
//        String sql = "select name,picpath from users where id=?";
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String name = rs.getString(1);
//                String picpath = rs.getString(2);
//                aUser = new User(id, name, picpath);
//                System.out.println("根据id查询数据库结果：" + aUser);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return aUser;
//    }
//
//    //更新前需先进行校验操作
//    public  int update(User aUser, String sthTobeModified, String newValue) {
//        String sql = String.format("update users set %s=? where id=?", sthTobeModified);
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setString(1, newValue);
//            ps.setInt(2, aUser.getId());
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//     public  int delete(int id) {
//        String sql = String.format("delete from users where id=%d", id);
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            System.out.println("id为：" + id + "的user被删除成功!");
//            return ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("id为：" + id + "的user删除失败!");
//            return 0;
//        }
//    }
//
//    public  List<User> list() {
//        return list(0, Short.MAX_VALUE);
//    }
//
//    public  List<User> list(int start, int count) {
//        List<User> users = new ArrayList<>();
//        String sql = "select * from users order by id desc limit ?,?";
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setInt(1, start);
//            ps.setInt(2, count);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                User aUser = new User();
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                String picpath = rs.getString(4);
//                aUser.setId(id);
//                aUser.setName(name);
//                aUser.setPicpath(picpath);
//
//                users.add(aUser);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }


    @Override
    public User add(User user) {
        return null;
    }

    public User add(User user, MultipartFile file) throws IOException {
        String sql = String.format("insert into %s values(null,?,?,?)", userTable);
        Path path = null;
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());

            //此处jpg应该修改为客户实际传的格式
            String fileName = nextId(getUserTable()) + ".jpg";
            //设置filename为客户的id.jpg
            ps.setString(3, fileName);
            path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/img/userPhoto", File.separator, fileName);
            //将客户上次的文件复制到指定文件夹下的id.jpg
            file.transferTo(path);

            ps.executeUpdate();
            //获取实际产生的id
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.setId(id);
            }
            return user;
        } catch (SQLException | IOException e) {
            //若失败，将之前产生的对应的userphoto.id.jpg删除
            if (null != path) {
                Files.delete(path);
            }
            return null;
        }
    }


    @Override
    public void delete(User aT) {

    }

    @Override
    public void update(User aT) {

    }

    //    @Override
    public User loginable(User user) {
        String sql = "select id,picpath from users where name=? and password=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
            if (rs.next()) {
                int id = rs.getInt(1);
                String picpath = rs.getString(2);
                String password = "password";
                User registerd_user = new User(id, user.getName(),password, picpath);
                return registerd_user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getAuser(String name) {
        User aUser = null;
        String sql = "select id,picpath from users where name=?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String picpath = rs.getString(2);
                aUser = new User(id, name, picpath);
                System.out.println("根据name查询数据库结果：" + aUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aUser;
    }

    @Override
    public List<User> getAll(int idStart, int totalNum) {
        return null;
    }

    @Override
    public User getOne(int id) {
        return null;
    }

    public String getUserTable() {
        return userTable;
    }

    public void setUserTable(String userTable) {
        this.userTable = userTable;
    }
}

