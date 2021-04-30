package com.linglett.mdwarmup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private int tid;
    private String tname;
    private String sub;
    private String email;

    private List<ClassG> classGs;
}
