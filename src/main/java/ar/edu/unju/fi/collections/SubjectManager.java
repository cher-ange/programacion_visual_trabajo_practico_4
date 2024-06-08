package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.AttendanceType;
import ar.edu.unju.fi.model.Career;
import ar.edu.unju.fi.model.Subject;
import ar.edu.unju.fi.model.Teacher;

public class SubjectManager {

    private static final List<Subject> subjects = new ArrayList<>();

    static {
        subjects.add(
                new Subject(
                        "001",
                        "MateriaUno",
                        "CursoUno",
                        3,
                        AttendanceType.VIRTUAL,
                        new Teacher(
                                "001",
                                "NombreProfesorUno",
                                "ApellidoProfesorUno",
                                "EmailProfesorUno",
                                "3880000000",
                                true),
                        new Career(
                                "001",
                                "NombreCarreraUno",
                                3,
                                true),
                        true));
        subjects.add(
                new Subject(
                        "002",
                        "MateriaDos",
                        "CursoDos",
                        4,
                        AttendanceType.IN_PERSON,
                        new Teacher(
                                "002",
                                "NombreProfesorDos",
                                "ApellidoProfesorDos",
                                "EmailProfesorDos",
                                "3880000001",
                                true),
                        new Career(
                                "002",
                                "NombreCarreraDos",
                                4,
                                true),
                        true));
        subjects.add(
                new Subject(
                        "003",
                        "MateriaTres",
                        "CursoTres",
                        5,
                        AttendanceType.IN_PERSON,
                        new Teacher(
                                "003",
                                "NombreProfesorTres",
                                "ApellidoProfesorTres",
                                "EmailProfesorTres",
                                "3880000002",
                                true),
                        new Career(
                                "003",
                                "NombreCarreraTres",
                                5,
                                true),
                        true));
    }

    public static List<Subject> getAll() {
        // return subjects.stream().filter(subject -> subject.getState().equals(true)).toList();
        return subjects;
    }

    public static Optional<Subject> search(String code) {
        return subjects.stream().filter(subject -> subject.getCode().equals(code)).findFirst();
    }

    public static void add(Subject subject) {
        Optional<Teacher> optionalTeacher = TeacherManager.search(subject.getTeacher().getFile());
        Optional<Career> optionalCareer = CareerManager.search(subject.getCareer().getCode());

        if (optionalTeacher.isPresent()) {
            subject.setTeacher(optionalTeacher.get());
        }

        if (optionalCareer.isPresent()) {
            subject.setCareer(optionalCareer.get());
        }

        subjects.add(subject);
    }

    public static void modify(Subject subject) {
        Optional<Subject> optionalSubject = search(subject.getCode());
        Optional<Teacher> optionalTeacher = TeacherManager.search(subject.getTeacher().getFile());
        Optional<Career> optionalCareer = CareerManager.search(subject.getCareer().getCode());

        if (optionalSubject.isPresent()) {
            
            if (optionalTeacher.isPresent()) {
                subject.setTeacher(optionalTeacher.get());
            }

            if (optionalCareer.isPresent()) {
                subject.setCareer(optionalCareer.get());
            }

            subjects.set(subjects.indexOf(optionalSubject.get()), subject);
        }
    }

    public static void delete(String code) {
        Optional<Subject> optionalSubject = search(code);
        if (optionalSubject.isPresent()) {
            optionalSubject.get().setState(false);
            subjects.set(subjects.indexOf(optionalSubject.get()), optionalSubject.get());
        }
    }
}
