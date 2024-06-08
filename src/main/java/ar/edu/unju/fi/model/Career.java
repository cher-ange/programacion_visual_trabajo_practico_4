package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
@Component
public class Career {

    private String code;
    private String name;
    private Integer duration;
    private Boolean state = true;

    public Career() {
    }

    public Career(
            String code,
            String name,
            Integer duration,
            Boolean state) {
        this.code = code;
        this.name = name;
        this.duration = duration;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Career [code=" + code + ", name=" + name + ", duration=" + duration + ", state=" + state + "]";
    }
}
