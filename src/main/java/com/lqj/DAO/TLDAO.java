package com.lqj.DAO;

import com.lqj.POJO.DAO;
import com.lqj.entity.TaoLun;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("tldao")
public class TLDAO extends DAO<TaoLun> {

    private String tlTable;
//    public static int totalNumofMes = tldao.getTLNums();

    public int nextId() {
        return super.newestId(tlTable);
    }

//    public

    @Override
//    @RequestMapping("/addTaoLunInDAO")
    public TaoLun add(TaoLun aTaoLun) {
//        String sql = String.format("insert into %s values(null,?,?,?)", tlTable);
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setString(1, aTaoLun.getTitle());
//            ps.setString(2, aTaoLun.getMessage());
//            ps.setString(3, aTaoLun.getAuthor());
//            ps.executeUpdate();
//            return TaoLun
//            //应该返回是否添加成功的结果给前端
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return null;
    }


    @Override
    public void delete(TaoLun aT) {

    }

    @Override
    public void update(TaoLun aT) {

    }

//    @Override
    public boolean select(TaoLun aT) {
        return false;
    }

    @Override
    public List<TaoLun> getAll(int idStart, int totalNum) {
        return null;
    }

    @Override
    public TaoLun getOne(int id) {
        return null;
    }


    //按照id倒排序（最新的在前面）从最新的数据开始取totalnum条数据
    public List<TaoLun> getLatest(int idStart, int totalNum) {
//        if (idStart < 0) {
//            idStart = 0;
//        } else {
//            idStart = totalNum - 1;
//        }

        String sql = String.format("select * from %s order by id desc LIMIT ?,?", tlTable);
        List<TaoLun> tls = new ArrayList<>();
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, idStart);
            ps.setInt(2, totalNum);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tilte = rs.getString(2);
                String message = rs.getString(3);
                String author = rs.getString(4);
                TaoLun tl = new TaoLun(id, tilte, message, author);
                tls.add(tl);
            }
            return tls;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "DAO{" +
                "url='" + getUrl() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", table='" + getTlTable() + '\'' +
                '}';
    }

    public String getTlTable() {
        return tlTable;
    }

    public void setTlTable(String tlTable) {
        this.tlTable = tlTable;
    }

}
