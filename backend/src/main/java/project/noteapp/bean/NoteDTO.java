package project.noteapp.bean;

public class NoteDTO {
    private Integer cod_note;
    private String name;
    private String text;
    private Integer cod_user;
    private Integer cod_course;

    public NoteDTO() {
        super();
    }

    public NoteDTO(Integer cod_note, String name, String text, Integer cod_user, Integer cod_course) {
        this.cod_note = cod_note;
        this.name = name;
        this.text = text;
        this.cod_user = cod_user;
        this.cod_course = cod_course;
    }

    public Integer getCod_note() {
        return cod_note;
    }

    public void setCod_note(Integer cod_note) {
        this.cod_note = cod_note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCod_user() {
        return cod_user;
    }

    public void setCod_user(Integer cod_user) {
        this.cod_user = cod_user;
    }

    public Integer getCod_course() {
        return cod_course;
    }

    public void setCod_course(Integer cod_course) {
        this.cod_course = cod_course;
    }
}
