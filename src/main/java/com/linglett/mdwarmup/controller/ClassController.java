package com.linglett.mdwarmup.controller;

import com.linglett.mdwarmup.mapper.ClassGMapper;
import com.linglett.mdwarmup.node.LimitRequest;
import com.linglett.mdwarmup.pojo.ClassG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassController {
    @Autowired
    ClassGMapper classGMapper;

    public static int ss=0;

    @GetMapping("/queryClassGList")
    public List<ClassG> queryClassList(){
           List<ClassG> list= classGMapper.queryClassGList();
        for (ClassG classG : list) {
            System.out.println(classG.toString());
        }
        return list;
    }
    @GetMapping("/queryClassGByCid")
    public ClassG queryTeacherByTid(int cid){
        ClassG classG = classGMapper.queryClassGByCid(cid);
        return classG;
    }

    @GetMapping("/addClassG")
    public int addTeacher(String cname,String grade,String school){
        ClassG classG = new ClassG();
        classG.setCname(cname);
        classG.setCname(grade);
        classG.setCname(school);
        classGMapper.addClassG(classG);
        return 1;
    }
    @GetMapping("/deleteClassG")
    public List<ClassG> deleteTeacher(int cid){
        classGMapper.deleteClassG(cid);
        classGMapper.deleteCtr(cid);
        List<ClassG> list= classGMapper.queryClassGAndTeacherList();

        return list;
    }

    @LimitRequest
    @GetMapping("/queryClassGAndTeacherList")
    public List<ClassG> queryTeacherAndClassGList(){
        ss++;
        List<ClassG> list= classGMapper.queryClassGAndTeacherList();
        System.out.println(ss);
        return list;
    }

    @LimitRequest
    @GetMapping("/test")
    public String test(){

        return ss+"test";
    }

}
