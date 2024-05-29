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

    public static List<Subject> getAll() {
        subjects.add(
                new Subject(
                        1,
                        "MateriaUno",
                        "CursoUno",
                        3,
                        AttendanceType.VIRTUAL,
                        new Teacher(
                                "001",
                                "NombreProfesorUno",
                                "ApellidoProfesorUno",
                                "EmailProfesorUno",
                                "3880000000"
                        ),
                        new Career(
                                1,
                                "NombreCarreraUno",
                                3,
                                true
                        )
                )
        );
        subjects.add(
                new Subject(
                        2,
                        "MateriaDos",
                        "CursoDos",
                        4,
                        AttendanceType.IN_PERSON,
                        new Teacher(
                                "002",
                                "NombreProfesorDos",
                                "ApellidoProfesorDos",
                                "EmailProfesorDos",
                                "3880000001"
                        ),
                        new Career(
                                2,
                                "NombreCarreraDos",
                                4,
                                true
                        )
                )
        );
        subjects.add(
                new Subject(
                        3,
                        "MateriaTres",
                        "CursoTres",
                        5,
                        AttendanceType.IN_PERSON,
                        new Teacher(
                                "003",
                                "NombreProfesorTres",
                                "ApellidoProfesorTres",
                                "EmailProfesorTres",
                                "3880000002"
                        ),
                        new Career(
                                3,
                                "NombreCarreraTres",
                                5,
                                true
                        )
                )
        );

        return subjects;
    }

    public static Optional<Subject> search(int code) {
        Predicate<Subject> subjectByCode = subject -> subject.getCode().equals(code);
        return subjects.stream().filter(subjectByCode).findAny();
    }

    public static void add(Subject subject) {
        subjects.add(subject);
    }

    public static void modify(Subject subject) {
        Optional<Subject> optionalSubject = search(subject.getCode());

        if (optionalSubject.isPresent()) {
            optionalSubject.get().setName(subject.getName());
            optionalSubject.get().setCourse(subject.getCourse());
            optionalSubject.get().setDuration(subject.getDuration());
            optionalSubject.get().setAttendanceType(subject.getAttendanceType());
            optionalSubject.get().setTeacher(subject.getTeacher());
            optionalSubject.get().setCareer(subject.getCareer());
        }
    }

    public static void delete(int code) {
        Optional<Subject> optionalSubject = search(code);
        if (optionalSubject.isPresent()) {
            subjects.remove(optionalSubject.get());
        }
    }
}
