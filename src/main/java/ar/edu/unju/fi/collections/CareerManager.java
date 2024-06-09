package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ar.edu.unju.fi.model.Career;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class CareerManager {

    private static final List<Career> careers = new ArrayList<>();

    static {
        careers.add(
            new Career(
                "001",
                "Ingeniero/a Agrónomo",
                5,
                true));
        careers.add(
            new Career(
                "002",
                "Licenciado/a en Ciencias Biológicas",
                5 ,
                true));
        careers.add(
            new Career(
                "003",
                "Técnico/a Universtario en Producción Lechera",
                2,
                true));
        careers.add(
            new Career(
                "004",
                "Técnico/a Universitario en Mecanización Agrícola",
                2,
                true));
    }

    public static List<Career> getAll() {    
        return careers.stream().filter(c -> c.getState().equals(true)).toList();
        // return careers;
    }

    public static Optional<Career> search(String code) {
        return careers.stream().filter(career -> career.getCode().equals(code)).findFirst();
    }

    public static void add(Career career) {
        careers.add(career);
    }

    public static void modify(Career career) {
        Optional<Career> optionalCareer = search(career.getCode());
        
        if (optionalCareer.isPresent()) {
            int indexOfCareerFound = careers.indexOf(optionalCareer.get());
            careers.set(indexOfCareerFound, career);
        }   
    }

    public static void delete(String code) {
        Optional<Career> optionalCareer = search(code);
        if (optionalCareer.isPresent()) {
            optionalCareer.get().setState(false);
            careers.set(careers.indexOf(optionalCareer.get()), optionalCareer.get());
        }
    }
}
