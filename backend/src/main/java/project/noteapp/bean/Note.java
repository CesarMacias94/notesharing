package project.noteapp.bean;

import javax.persistence.*;

@Entity
@Table(name = "note", uniqueConstraints = @UniqueConstraint(columnNames = "cod_note"))
public class Note {
    private Integer cod_note;
    private String name;
    private String text;
    private User user;
    private Course course;

    public Note() {
        super();
    }

    public Note(Integer cod_note, String text, String name, User user, Course course) {
        this.cod_note = cod_note;
        this.text = text;
        this.name = name;
        this.user = user;
        this.course = course;
    }

    //verificare che nel db il tipo di chiave rispetti i canoni di @generatedvalue e di @generationtype
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cod_note", unique = true, nullable = false)
    public Integer getCod_note() {
        return cod_note;
    }

    public void setCod_note(Integer cod_note) {
        this.cod_note = cod_note;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "text", nullable = false)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_user", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_course", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}