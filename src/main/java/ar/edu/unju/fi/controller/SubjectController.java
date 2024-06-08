package ar.edu.unju.fi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CareerManager;
import ar.edu.unju.fi.collections.SubjectManager;
import ar.edu.unju.fi.collections.TeacherManager;
import ar.edu.unju.fi.model.AttendanceType;
import ar.edu.unju.fi.model.Subject;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
@Controller
@RequestMapping(path = "/subject")
public class SubjectController {
    
    private final Subject subject;

    public SubjectController(Subject subject) {
        this.subject = subject;
    }

    @GetMapping(path = "/list")
    public ModelAndView getListOfSubjectsPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("subject/subjects");
        modelAndView.addObject("listOfSubjects", SubjectManager.getAll());

        return modelAndView;
    }

    @GetMapping(path = "/add")
    public ModelAndView getSubjectFormPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("subject/subject-form");
        modelAndView.addObject("listOfAttendanceTypes", new ArrayList<>(Arrays.asList(AttendanceType.values())));
        modelAndView.addObject("listOfTeachers", TeacherManager.getAll());
        modelAndView.addObject("listOfCareers", CareerManager.getAll());
        modelAndView.addObject("subjectSubmitted", subject);
        modelAndView.addObject("allowEditing", false);

        return modelAndView;
    }

    @PostMapping(path = "/save")
    public ModelAndView postSubjectFormPage(@ModelAttribute(name = "subjectSubmitted") Subject subject) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/subject/list");
        SubjectManager.add(subject);

        return modelAndView;
    }

    @GetMapping(path = "/modify/{subjectCode}")
    public ModelAndView getModifySubjectFormPage(@PathVariable(value = "subjectCode") String subjectFile) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<Subject> optionalSubject;
        
        modelAndView.setViewName("subject/subject-form");
        optionalSubject = SubjectManager.search(subjectFile);

        if (optionalSubject.isPresent()) {
            modelAndView.addObject("listOfAttendanceTypes", new ArrayList<>(Arrays.asList(AttendanceType.values())));
            modelAndView.addObject("listOfTeachers", TeacherManager.getAll());
            modelAndView.addObject("listOfCareers", CareerManager.getAll());
            modelAndView.addObject("subjectSubmitted", optionalSubject); 
            modelAndView.addObject("allowEditing", true);
        }
                
        return modelAndView;
    }

    @PostMapping(path = "/modify")
    public ModelAndView postModifySubjectFormPage(@ModelAttribute(value = "subjectSubmitted") Subject subject) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/subject/list");
        SubjectManager.modify(subject);

        return modelAndView;
    }

    @GetMapping(path = "/delete/{subjectFile}")
    public ModelAndView getDeleteSubjectPage(@PathVariable(value = "subjectFile") String subjectFile) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/subject/list");
        SubjectManager.delete(subjectFile);

        return modelAndView;
    }
}
