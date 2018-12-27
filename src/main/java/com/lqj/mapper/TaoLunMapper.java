package com.lqj.mapper;


import com.lqj.entity.TaoLun;
import com.lqj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaoLunMapper {
    @Select("select * from taolun")
    List<TaoLun> getLatest(int idStart, int totalNum);

    @Insert("insert into taolun values(title,message,author) values(#{title},#{message},#{author}")
    public int save(TaoLun taoLun);

    @Delete("delete from taolun where id=#{id}")
    public void delete(int id);

    @Select("select * from taolun where id=#{id}")
    public TaoLun get(int id);

    @Update("update taolun set title=#{title} where id=#{id}")
    public int update(TaoLun taoLun);
}
