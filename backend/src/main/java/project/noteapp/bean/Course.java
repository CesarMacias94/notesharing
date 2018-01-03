package project.noteapp.bean;

import javax.persistence.*;

@Entity
@Table(name = "course", uniqueConstraints = @UniqueConstraint(columnNames = "cod_course"))
public class Course {
    private Integer cod_course;
    private String name;
    private String description;
    private Note[] notes;

    public Course() {
        super();
    }

    public Course(Integer cod_course, String description, String name, Note[] notes) {
        this.cod_course = cod_course;
        this.description = description;
        this.name = name;
        this.notes = notes;
    }

    //verificare che nel db il tipo di chiave rispetti i canoni di @generatedvalue e di @generationtype
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cod_course", unique = true, nullable = false)
    public Integer getCod_course() {
        return cod_course;
    }

    public void setCod_course(Integer cod_course) {
        this.cod_course = cod_course;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    public Note[] getNotes() {
        return notes;
    }

    public void setNotes(Note[] notes) {
        this.notes = notes;
    }
}