package com.ttknpdev.understandthymeleaf.service;

import com.ttknpdev.understandthymeleaf.entity.Student;
import com.ttknpdev.understandthymeleaf.log.Logging;

import java.util.ArrayList;
import java.util.List;

public class Crud {
    private List<Student> data;

    public Crud() {
        data = new ArrayList<>();
        data.add(new Student((short)19,"Json smite",60.6F,166.6F,"junior"));
        data.add(new Student((short)20,"Adam smite",55.6F,156.6F,"junior"));
        data.add(new Student((short)19,"Mark smite",82.6F,196.6F,"senior"));
    }

    public List<Student> reads() {
        Logging.crud.info("logging before reads() return list");
        return data;
    }
    public Student getStudentExample() {
        try {
            return data.get(0);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            /*
                when in my list was empty index
                I will send Student Object (any attribute will be null)
            */
            return new Student();
        }
    }
    public void create(Student student) {
        data.add(student);
        Logging.crud.info("logging after add() method was done");
    }

    public boolean deleteByFullname (String fullname) {
        boolean check = data.removeIf(student -> student.getFullname().equals(fullname));
        if (check) {
            Logging.crud.info("logging after removeIf() returned true ");
        }
        else {
            Logging.crud.info("not found "+fullname+" inside list");
        }
        return check;
    }
}
