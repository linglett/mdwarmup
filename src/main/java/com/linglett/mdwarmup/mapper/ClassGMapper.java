package com.linglett.mdwarmup.mapper;

import com.linglett.mdwarmup.pojo.ClassG;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ClassGMapper {

    List<ClassG> queryClassGList();

    ClassG queryClassGByCid(int cid);

    int addClassG(ClassG ClassG);

    int updateClassG(ClassG ClassG);

    int deleteClassG(int cid);

    List<ClassG> queryClassGAndTeacherList();

    int deleteCtr(int cid);

}
