package com.linglett.mdwarmup.mapper;

import com.linglett.mdwarmup.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示这是一个mapper
@Mapper
@Repository
public interface TeacherMapper {
    List<Teacher> queryTeacherList();

    Teacher queryTeacherByTid(int tid);

    int addTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    int deleteTeacher(int tid);

    List<Teacher> queryTeacherAndClassGList();

    int deleteCtr(int tid);


    @Delete("delete from ctrel where tid=#{tid} and cid = #{cid};")
    int cancelTeaching(@Param("tid") int tid,@Param("cid") int cid);

   @Insert("insert into ctrel (tid,cid) values (#{tid},#{cid})")
    int addTeaching(@Param("tid") int tid,@Param("cid") int cid);
}
