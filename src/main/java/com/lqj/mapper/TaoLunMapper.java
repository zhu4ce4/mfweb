package com.lqj.mapper;


import com.lqj.entity.TaoLun;
import com.lqj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaoLunMapper {
    @Select("select * from taolun order by id DESC limit #{idStart},#{totalNum}")
    public List<TaoLun> getLatestTL(int idStart, int totalNum);

    @Select("select count(*) from taolun")
    public int countTLnum();

    @Insert("insert into taolun values(title,message,author) values(#{title},#{message},#{author})")
    public int add(TaoLun taoLun);

    @Delete("delete from taolun where id=#{id}")
    public void delete(int id);

    @Select("select * from taolun where id=#{id}")
    public TaoLun getTlById(int id);

    @Select("select * from taolun where author=#{author}")
    public List<TaoLun> getTLsByAuthor(String author);

    @Update("update taolun set message=#{message} where id=#{id}")
    public int update(TaoLun taoLun);
}
