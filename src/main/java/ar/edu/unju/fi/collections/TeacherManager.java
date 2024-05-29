package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Teacher;

public class TeacherManager {

    private static final List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getAll() {
        teachers.add(
                new Teacher(
                        "001",
                        "NombreProfesorUno",
                        "ApellidoProfesorUno",
                        "EmailProfesorUno",
                        "3880000000"));
        teachers.add(
                new Teacher(
                        "002",
                        "NombreProfesorDos",
                        "ApellidoProfesorDos",
                        "EmailProfesorDos",
                        "3880000001"));
        teachers.add(
                new Teacher(
                        "003",
                        "NombreProfesorTres",
                        "ApellidoProfesorTres",
                        "EmailProfesorTres",
                        "3880000002"));

        return teachers;
    }

    public Optional<Teacher> search(String file) {
        Predicate<Teacher> teacherByFile = teacher -> teacher.getFile().equals(file);
        return teachers.stream().filter(teacherByFile).findAny();
    }

    public static void add(Teacher teacher) {
        teachers.add(teacher);
    }

    public void modify(Teacher teacher) {
        Optional<Teacher> optionalTeacher = search(teacher.getFile());

        if (optionalTeacher.isPresent()) {
            optionalTeacher.get().setName(teacher.getName());
            optionalTeacher.get().setLastName(teacher.getLastName());
            optionalTeacher.get().setEmail(teacher.getEmail());
            optionalTeacher.get().setPhone(teacher.getPhone());
        }
    }

    public void delete(Teacher teacher) {
        Optional<Teacher> optionalTeacher = search(teacher.getFile());
        if (optionalTeacher.isPresent()) {
            teachers.remove(optionalTeacher.get());
        }
    }
}
