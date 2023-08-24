package org.example.controller;

import org.example.model.StudentModel;
import org.example.service.GenerateDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {

    GenerateDataService generateDataService;
    List<StudentModel> studentModels = new ArrayList<>();
    StudentController(GenerateDataService generateDataService) {
        StudentModel studentModel = new StudentModel();
        StudentModel studentModel2 = new StudentModel();
        studentModel.setId("ABC123");
        studentModel.setName("Ujang");
        studentModel.setMajor("informatic");
        studentModels.add(studentModel);
        studentModel2.setId("ABC124");
        studentModel2.setName("danu");
        studentModel2.setMajor("politik");
        studentModels.add(studentModel2);
    }

    @GetMapping(value = "/view" )
    public String get(Model model) {
        model.addAttribute("students",studentModels);
        return "book-view";
    }

    @GetMapping(value = "/view/{id}" )
    public String getDetail(ModelMap model, @PathVariable String id) {
        model.addAttribute("message", "Hello, World!");
        return "book-detail";
    }

    @PostMapping(value = "/add" )
    public String addStudent(@ModelAttribute StudentModel student, BindingResult errors, Model model) {
        studentModels.add(student);
        model.addAttribute("students",studentModels);
        return "book-view";
    }

    @PostMapping(value = "/delete" )
    public String deleteStudent(ModelMap model) {
        model.addAttribute("message", "Hello, World!");
        return "book-view";
    }


}
