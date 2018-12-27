package com.lqj.DAO;
import com.lqj.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userdao")
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByNameAndPassword(String name,String password);
    User findByName(String name);
}

//    public User add(User user, MultipartFile file) throws IOException {
//        String sql = String.format("insert into %s values(null,?,?,?)", userTable);
//        Path path = null;
//        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
//            ps.setString(1, user.getName());
//            ps.setString(2, user.getPassword());
//
//            //此处jpg应该修改为客户实际传的格式
//            String fileName = nextId(getUserTable()) + ".jpg";
//            //设置filename为客户的id.jpg
//            ps.setString(3, fileName);
//            path = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/img/userPhoto", File.separator, fileName);
//            //将客户上次的文件复制到指定文件夹下的id.jpg
//            file.transferTo(path);
//
//            ps.executeUpdate();
//            //获取实际产生的id
//            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                int id = rs.getInt(1);
//                user.setId(id);
//            }
//            return user;
//        } catch (SQLException | IOException e) {
//            //若失败，将之前产生的对应的userphoto.id.jpg删除
//            if (null != path) {
//                Files.delete(path);
//            }
//            return null;
//        }
//    }
