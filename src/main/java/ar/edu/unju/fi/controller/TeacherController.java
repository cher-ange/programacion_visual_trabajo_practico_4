package ar.edu.unju.fi.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.TeacherManager;
import ar.edu.unju.fi.model.Teacher;

@Controller
@RequestMapping(path = "/teacher")
public class TeacherController {
    private final Teacher teacher;

    public TeacherController(Teacher teacher) {
        this.teacher = teacher;
    }

    @GetMapping(path = "/list")
    public ModelAndView getListOfTeachersPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("teacher/teachers");
        modelAndView.addObject("listOfTeachers", TeacherManager.getAll());

        return modelAndView;
    }

    @GetMapping(path = "/add")
    public ModelAndView getTeacherFormPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("teacher/teacher-form");
        modelAndView.addObject("teacherSubmitted", teacher);
        modelAndView.addObject("allowEditing", false);

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView postTeacherFormPage(@ModelAttribute(name = "teacherSubmitted") Teacher teacher) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/teacher/list");
        TeacherManager.add(teacher);

        return modelAndView;
    }

    @GetMapping(path = "/modify/{teacherFile}")
    public ModelAndView getModifyTeacherFormPage(@PathVariable(value = "teacherFile") String teacherFile) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Teacher> optionalTeacher;
        
        modelAndView.setViewName("teacher/teacher-form");
        optionalTeacher = TeacherManager.search(teacherFile);

        if (optionalTeacher.isPresent()) {
            modelAndView.addObject("teacherSubmitted", optionalTeacher); 
            modelAndView.addObject("allowEditing", true);
        }
                
        return modelAndView;
    }

    @PostMapping(path = "/modify")
    public ModelAndView postModifyTeacherFormPage(@ModelAttribute(value = "teacherSubmitted") Teacher teacher) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/teacher/list");
        TeacherManager.modify(teacher);

        return modelAndView;
    }

    @GetMapping(path = "/delete/{teacherFile}")
    public ModelAndView getDeleteTeacherPage(@PathVariable(value = "teacherFile") String teacherFile) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/teacher/list");
        TeacherManager.delete(teacherFile);

        return modelAndView;
    }
}
