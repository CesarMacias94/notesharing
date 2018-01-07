package project.noteapp.bean;

public class NoteDTO {
    private Integer cod_note;
    private String name;
    private String text;

    public NoteDTO() {
        super();
    }

    public NoteDTO(Integer cod_note, String name, String text) {
        this.cod_note = cod_note;
        this.name = name;
        this.text = text;
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
}
