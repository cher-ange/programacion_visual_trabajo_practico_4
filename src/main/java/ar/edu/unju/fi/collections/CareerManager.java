package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Career;

public class CareerManager {

    private static final List<Career> careers = new ArrayList<>();

    public static List<Career> getAll() {
        careers.add(
                new Career(
                        1,
                        "MateriaUno",
                        2,
                        true));
        careers.add(
                new Career(
                        2,
                        "MateriaDos",
                        3,
                        true));
        careers.add(
                new Career(
                        3,
                        "MateriaTres",
                        4,
                        true));
        return careers;
    }

    public static Optional<Career> search(int code) {
        Predicate<Career> careerByCode = career -> career.getCode().equals(code);
        return careers.stream().filter(careerByCode).findAny();
    }

    public static void Add(Career career) {
        careers.add(career);
    }

    public static void modify(Career career) {
        Optional<Career> optionalCareer = search(career.getCode());

        if (optionalCareer.isPresent()) {
            optionalCareer.get().setName(career.getName());
            optionalCareer.get().setDuration(career.getDuration());
            optionalCareer.get().setState(career.getState());
        }
    }

    public static void delete(int id) {
        Optional<Career> optionalCareer = search(id);
        if (optionalCareer.isPresent()) {
            careers.remove(optionalCareer.get());
        }
    }
}
