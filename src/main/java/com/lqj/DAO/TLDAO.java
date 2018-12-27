package com.lqj.DAO;

import com.lqj.entity.TaoLun;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tldao")
public interface TLDAO extends JpaRepository<TaoLun, Integer> {
    List<TaoLun> findByAuthor(String author);
    List<TaoLun> findByAuthor(String author, Pageable pageable);
}

//    private String tlTable;
//
//    public int nextId() {
//        return super.newestId(tlTable);
//    }
//
//    @Override
//    public boolean add(TaoLun taoLun) {
//        String sql = String.format("insert into %s values(null,?,?,?)", tlTable);
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setString(1, taoLun.getTitle());
//            ps.setString(2, taoLun.getMessage());
//            ps.setString(3, taoLun.getAuthor());
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public void delete(TaoLun aT) {
//
//    }
//
//    @Override
//    public void update(TaoLun aT) {
//
//    }
//
//    public boolean select(TaoLun aT) {
//        return false;
//    }
//
//    @Override
//    public List<TaoLun> getAll(int idStart, int totalNum) {
//        return null;
//    }
//
//    @Override
//    public TaoLun getOne(int id) {
//        String sql = String.format("select * from %s where id=?", tlTable);
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                String tilte = rs.getString(2);
//                String message = rs.getString(3);
//                String author = rs.getString(4);
//                return new TaoLun(id, tilte, message, author);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return null;
//    }
//
//    //按照id倒排序（最新的在前面）从最新的数据开始取totalnum条数据
//    public List<TaoLun> getLatest(int idStart, int totalNum) {
//        String sql = String.format("select * from %s order by id desc LIMIT ?,?", tlTable);
//        List<TaoLun> tls = new ArrayList<>();
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
//            ps.setInt(1, idStart);
//            ps.setInt(2, totalNum);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String tilte = rs.getString(2);
//                String message = rs.getString(3);
//                String author = rs.getString(4);
//                TaoLun tl = new TaoLun(id, tilte, message, author);
//                tls.add(tl);
//            }
//            return tls;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "DAO{" +
//                "url='" + getUrl() + '\'' +
//                ", username='" + getUsername() + '\'' +
//                ", password='" + getPassword() + '\'' +
//                ", table='" + getTlTable() + '\'' +
//                '}';
//    }
//
//    public String getTlTable() {
//        return tlTable;
//    }
//
//    public void setTlTable(String tlTable) {
//        this.tlTable = tlTable;
//    }
//
//}
