package ar.edu.unju.fi.model;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public enum AttendanceType {
    VIRTUAL("Virtual"),
    IN_PERSON("Presencial");

    private final String value;

    private AttendanceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
