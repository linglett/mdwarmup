package com.linglett.mdwarmup.controller;

import com.linglett.mdwarmup.mapper.TeacherMapper;
import com.linglett.mdwarmup.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/queryTeacherList")
    public List<Teacher> queryTeacherList(){
        List<Teacher> list= teacherMapper.queryTeacherList();
        for (Teacher teacher : list) {
            System.out.println(teacher.toString());
        }
        return list;
    }

    @GetMapping("/queryTeacherByTid")
    public Teacher queryTeacherByTid(int tid){
        Teacher teacher = teacherMapper.queryTeacherByTid(tid);
        return teacher;
    }

    @GetMapping("/addTeacher")
    public int addTeacher(String tname,String sub,String email){
        Teacher teacher = new Teacher();
        teacher.setTname(tname);
        teacher.setTname(sub);
        teacher.setTname(email);
        teacherMapper.addTeacher(teacher);
        return 1;
    }
    @GetMapping("/deleteTeacher")
    public List<Teacher> deleteTeacher(int tid){
        teacherMapper.deleteTeacher(tid);
        teacherMapper.deleteCtr(tid);
        List<Teacher> list= teacherMapper.queryTeacherAndClassGList();
        return list;
    }
    @CrossOrigin
    @GetMapping("/queryTeacherAndClassGList")
    public List<Teacher> queryTeacherAndClassGList(){
        List<Teacher> list= teacherMapper.queryTeacherAndClassGList();
        for (Teacher teacher : list) {
            System.out.println(teacher.toString());
        }
        return list;
    }
    @CrossOrigin
    @GetMapping("/cancelTeaching")
    public List<Teacher> cancelTeaching(int tid,int cid){
        System.out.println(tid+" "+cid);
        teacherMapper.cancelTeaching(tid,cid);
        List<Teacher> list= teacherMapper.queryTeacherAndClassGList();
        return list;
    }
    @CrossOrigin
    @GetMapping("/addTeaching")
    public List<Teacher> addTeaching(int tid,int cid){
        teacherMapper.addTeaching(tid, cid);
        List<Teacher> list= teacherMapper.queryTeacherAndClassGList();
        return list;
    }
}
