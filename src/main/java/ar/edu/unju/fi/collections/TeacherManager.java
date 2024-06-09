package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ar.edu.unju.fi.model.Teacher;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class TeacherManager {

    private static final List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(
            new Teacher(
                "001",
                "NombreProfesorUno",
                "ApellidoProfesorUno",
                "EmailProfesorUno",
                "3880000000",
                true));
        teachers.add(
            new Teacher(
                "002",
                "NombreProfesorDos",
                "ApellidoProfesorDos",
                "EmailProfesorDos",
                "3880000001",
                true));
        teachers.add(
            new Teacher(
                "003",
                "NombreProfesorTres",
                "ApellidoProfesorTres",
                "EmailProfesorTres",
                "3880000002",
                true));
        teachers.add(
            new Teacher(
                "004",
                "NombreProfesorCuatro",
                "ApellidoProfesorCuatro",
                "EmailProfesorCuatro",
                "3880000003",
                true));
    }

    public static List<Teacher> getAll() {
        return teachers.stream().filter(t -> t.getState().equals(true)).toList();
        // return teachers;
    }

    public static Optional<Teacher> search(String file) {
        return teachers.stream().filter(teacher -> teacher.getFile().equals(file)).findFirst();
    }

    public static void add(Teacher teacher) {
        teachers.add(teacher);
    }

    public static void modify(Teacher teacher) {
        Optional<Teacher> optionalTeacher = search(teacher.getFile());

        if (optionalTeacher.isPresent()) {
            teachers.set(teachers.indexOf(optionalTeacher.get()), teacher);
        }
    }

    public static void delete(String file) {
        Optional<Teacher> optionalTeacher = search(file);

        if (optionalTeacher.isPresent()) {
            optionalTeacher.get().setState(false);
            teachers.set(teachers.indexOf(optionalTeacher.get()), optionalTeacher.get());
        }
    }
}
