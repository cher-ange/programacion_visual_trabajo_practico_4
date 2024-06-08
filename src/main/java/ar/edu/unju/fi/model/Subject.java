package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

/**
 * @author Gutierrez Angel Gonzalo
 * @version 1.0
 */
@Component
public class Subject {

    private String code;
    private String name;
    private String course;
    private Integer duration;
    private AttendanceType attendanceType;
    private Teacher teacher;
    private Career career;
    private Boolean state = true;

    public Subject() {
    }

    public Subject(
            String code,
            String name,
            String course,
            Integer duration,
            AttendanceType attendanceType,
            Teacher teacher,
            Career career,
            Boolean state) {
        this.code = code;
        this.name = name;
        this.course = course;
        this.duration = duration;
        this.attendanceType = attendanceType;
        this.teacher = teacher;
        this.career = career;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public AttendanceType getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(AttendanceType attendanceType) {
        this.attendanceType = attendanceType;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Subject [code=" + code + ", name=" + name + ", course=" + course + ", duration=" + duration
                + ", attendanceType=" + attendanceType + ", teacher=" + teacher + ", career=" + career + ", state="
                + state + "]";
    }
}
