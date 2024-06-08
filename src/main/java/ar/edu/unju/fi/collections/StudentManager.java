package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Student;

public class StudentManager {

    private static final List<Student> students = new ArrayList<>();
    static {
        students.add(
            new Student(
                "0001",
                "NombreEstudianteUno",
                "ApellidoEstudianteUno",
                "EmailEstudianteUno",
                "3880000000",
                LocalDate.of(1990, 1, 1),
                "DirecciónEstudianteUno",
                "LU000000",
                true)
        );
        students.add(
            new Student(
                "0002",
                "NombreEstudianteDos",
                "ApellidoEstudianteDos",
                "EmailEstudianteDos",
                "3880000001",
                LocalDate.of(1991, 2, 2),
                "DirecciónEstudianteDos",
                "LU000001",
                true)
        );
        students.add(
            new Student(
                "0003",
                "NombreEstudianteTres",
                "ApellidoEstudianteTres",
                "EmailEstudianteTres",
                "3880000002",
                LocalDate.of(1992, 3, 3),
                "DirecciónEstudianteTres",
                "LU000002",
                true)
        );
        students.add(
            new Student(
                "0004",
                "NombreEstudianteCuatro",
                "ApellidoEstudianteCuatro",
                "EmailEstudianteCuatro",
                "3880000003",
                LocalDate.of(1993, 4, 4),
                "DirecciónEstudianteCuatro",
                "LU000003",
                true)
        );
    }
    
    public static List<Student> getAll() {    
        // return students.stream().filter(student -> student.getState().equals(true)).toList();
        return students;
    }

    public static Optional<Student> search(String identification) {
        return students.stream().filter(student -> student.getIdentification().equals(identification)).findFirst();
    }

    public static void add(Student student) {
        students.add(student);
    }

    public static void modify(Student student) {
        Optional<Student> optionalStudent = search(student.getIdentification());
        
        if (optionalStudent.isPresent()) {
            students.set(students.indexOf(optionalStudent.get()), student);
        }   
    }

    public static void delete(String identification) {
        Optional<Student> optionalStudent = search(identification);
        
        if (optionalStudent.isPresent()) {
            optionalStudent.get().setState(false);
            students.set(students.indexOf(optionalStudent.get()), optionalStudent.get());
        }
    }
}
