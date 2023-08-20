package com.ttknpdev.understandthymeleaf.controller;

import com.ttknpdev.understandthymeleaf.entity.Student;
import com.ttknpdev.understandthymeleaf.log.Logging;
import com.ttknpdev.understandthymeleaf.service.Crud;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
public class ControlPath {
    private Crud crud;
    public ControlPath() {

        this.crud = new Crud();

    }
    @GetMapping(value = "/test")
    private String test(Model model){
        /*
            when i don't set thymeleaf view (ClassLoaderTemplateResolver)
            it'll look at templates folder first
        */
        model.addAttribute("message","test() method works");
        return "page-first";
    }
    /*
        These methods below I have set thymeleaf view
        So I can access ui folder
    */
    @GetMapping(value = "/get-student")
    private String getStudent(Model model) { // ** Use Model to be args then I can send any Java attribute
        model.addAttribute("data",crud.reads());
        model.addAttribute("descript","print list collection");
        return "page-second-print-list";
    }
    @GetMapping(value = "/get-student-second")
    private String getStudentSecond(Model model) {
        // test if in thymeleaf
        model.addAttribute("data",crud.reads());
        model.addAttribute("descript","print list collection");
        return "page-fourth-print-list-include-if";
    }

    @GetMapping(value = "/form")
    private String formStudent(Model model) {
        // test , how to handle null values in Thymeleaf
        // and sent method post by ajax
        model.addAttribute("descript","Student Form");
        model.addAttribute("student",crud.getStudentExample());
        return "page-third-request-student";
    }

    @GetMapping(value = "/delete/{fullname}")
    private String deleteByFullname(@PathVariable String fullname) {
        // Logging.control.info("fullname store : "+fullname);
        boolean check = crud.deleteByFullname(fullname);
        if (check) return "redirect:/api/get-student";
        else return "redirect:/api/form"; /* when fullname didn't exit*/
    }

    @PostMapping(value = "/add-student")
    private String addStudent(@ModelAttribute Student student) {
        /*
            Logging.control.info("request method post was success");
            Logging.control.info("student store : "+student);
        */
        crud.create(student);
        return "redirect:/api/get-student"; /* when do you have to use redirect ? when you need to reload your url */
    }

}
