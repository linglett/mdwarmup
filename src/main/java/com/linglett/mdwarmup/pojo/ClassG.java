package com.linglett.mdwarmup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassG {
    private int cid;
    private String cname;
    private String grade;
    private String school;
    private List<Teacher> teachers;
}
