package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Student;

public class StudentManager {

    private static final List<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        students.add(
                new Student(
                        "0001",
                        "NombreEstudianteUno",
                        "ApellidoEstudianteUno",
                        "EmailEstudianteUno",
                        "3880000000",
                        LocalDate.of(1990, 1, 1),
                        "DirecciónEstudianteUno",
                        "LU000000")
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
                        "LU000001")
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
                        "LU000002")
        );

        return students;
    }

    public static Optional<Student> search(String identification) {
        Predicate<Student> studentByIdentification = student -> student.getIdentification().equals(identification);
        return students.stream().filter(studentByIdentification).findAny();
    }

    public static void Add(Student student) {
        students.add(student);
    }

    public static void modify(Student student) {
        Optional<Student> optionalStudent = search(student.getIdentification());

        if (optionalStudent.isPresent()) {
            optionalStudent.get().setName(student.getName());
            optionalStudent.get().setLastName(student.getLastName());
            optionalStudent.get().setEmail(student.getEmail());
            optionalStudent.get().setPhone(student.getPhone());
            optionalStudent.get().setBirthdate(student.getBirthdate());
            optionalStudent.get().setAddress(student.getAddress());
            optionalStudent.get().setUniversityRecord(student.getUniversityRecord());
        }
    }

    public static void delete(String identification) {
        Optional<Student> optionalStudent = search(identification);
        if (optionalStudent.isPresent()) {
            students.remove(optionalStudent.get());
        }
    }
}
