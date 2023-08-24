package org.example.service;

import org.example.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenerateDataService {

    public List<StudentModel> generate(List<StudentModel> studentModels) {

        return studentModels;
    }
}
