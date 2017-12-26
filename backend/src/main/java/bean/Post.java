package bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "post", uniqueConstraints = @UniqueConstraint(columnNames = "cod_post"))
public class Post {
    private int cod_post;
    private String text;
    private String name;

    public Post(int cod_post, String text, String name) {
        this.cod_post = cod_post;
        this.text = text;
        this.name = name;
    }

    //verificare che nel db il tipo di chiave rispetti i canoni di @generatedvalue e di @generationtype
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cod_course", unique = true, nullable = false)
    public int getCod_post() {
        return cod_post;
    }

    public void setCod_post(int cod_post) {
        this.cod_post = cod_post;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}