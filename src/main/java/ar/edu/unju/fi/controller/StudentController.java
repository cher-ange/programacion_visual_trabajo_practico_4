package ar.edu.unju.fi.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.StudentManager;
import ar.edu.unju.fi.model.Student;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
    private final Student student;

    public StudentController(Student student) {
        this.student = student;
    }

    @GetMapping(path = "/list")
    public ModelAndView getListOfStudentsPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("student/students");
        modelAndView.addObject("listOfStudents", StudentManager.getAll());

        return modelAndView;
    }

    @GetMapping(path = "/add")
    public ModelAndView getStudentFormPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("student/student-form");
        modelAndView.addObject("studentSubmitted", student);
        modelAndView.addObject("allowEditing", false);

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView postStudentFormPage(@ModelAttribute(name = "studentSubmitted") Student student) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/student/list");
        StudentManager.add(student);

        return modelAndView;
    }

    @GetMapping(path = "/modify/{identification}")
    public ModelAndView getModifyStudentFormPage(@PathVariable(value = "identification") String studentIdentification) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Student> optionalStudent;
        
        modelAndView.setViewName("student/student-form");
        optionalStudent = StudentManager.search(studentIdentification);

        if (optionalStudent.isPresent()) {
            modelAndView.addObject("studentSubmitted", optionalStudent); 
            modelAndView.addObject("allowEditing", true);
        }
                
        return modelAndView;
    }

    @PostMapping(path = "/modify")
    public ModelAndView postModifyUserFormPage(@ModelAttribute(value = "studentSubmitted") Student student) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/student/list");
        StudentManager.modify(student);

        return modelAndView;
    }

    @GetMapping(path = "/delete/{studentIdentification}")
    public ModelAndView getDeleteStudentPage(@PathVariable(value = "studentIdentification") String studentIdentification) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/student/list");
        StudentManager.delete(studentIdentification);

        return modelAndView;
    }
}
