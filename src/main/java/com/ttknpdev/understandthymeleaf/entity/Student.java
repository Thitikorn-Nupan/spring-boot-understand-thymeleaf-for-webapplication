package com.ttknpdev.understandthymeleaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Short age;
    private String fullname;
    private Float weight;
    private Float height;
    private String nisitYear;

}
