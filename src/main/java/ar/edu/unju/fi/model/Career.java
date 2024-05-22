package ar.edu.unju.fi.model;

/** 
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
public class Career {
    private Integer code;
    private String name;
    private Integer duration;
    private Boolean state;
    
    public Career() {
    }

    public Career(Integer code,
                  String name,
                  Integer duration,
                  Boolean state) {
        this.code = code;
        this.name = name;
        this.duration = duration;
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
}
