package project.noteapp.bean;

import javax.persistence.*;

@Entity
@Table(name = "note", uniqueConstraints = @UniqueConstraint(columnNames = "cod_note"))
public class Note {
    private Integer cod_note;
    private String name;
    private String text;
    private Integer cod_user;
    private Integer cod_course;

    public Note() {
        super();
    }

    public Note(Integer cod_note, String text, String name, Integer cod_user, Integer cod_course) {
        this.cod_note = cod_note;
        this.text = text;
        this.name = name;
        this.cod_user = cod_user;
        this.cod_course = cod_course;
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
    public Integer getCod_user() {
        return cod_user;
    }

    public void setCod_user(Integer cod_user) {
        this.cod_user = cod_user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_course", nullable = false)
    public Integer getCod_course() {
        return cod_course;
    }

    public void setCod_course(Integer cod_course) {
        this.cod_course = cod_course;
    }
}