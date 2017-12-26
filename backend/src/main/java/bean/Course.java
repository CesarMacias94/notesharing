package bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "course", uniqueConstraints = @UniqueConstraint(columnNames = "cod_course"))
public class Course {
    private int cod_course;
    private String description;
    private String name;

    public Course(int cod_course, String description, String name) {
        this.cod_course = cod_course;
        this.description = description;
        this.name = name;
    }

    //verificare che nel db il tipo di chiave rispetti i canoni di @generatedvalue e di @generationtype
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cod_course", unique = true, nullable = false)
    public int getCod_course() {
        return cod_course;
    }

    public void setCod_course(int cod_course) {
        this.cod_course = cod_course;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}