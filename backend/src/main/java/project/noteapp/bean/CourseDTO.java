package project.noteapp.bean;

public class CourseDTO {
    private Integer cod_course;
    private String name;
    private String description;

    public CourseDTO() {
        super();
    }

    public CourseDTO(Integer cod_course, String name, String description) {
        this.cod_course = cod_course;
        this.name = name;
        this.description = description;
    }

    public Integer getCod_course() {
        return cod_course;
    }

    public void setCod_course(Integer cod_course) {
        this.cod_course = cod_course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
