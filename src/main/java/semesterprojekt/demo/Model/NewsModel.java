package semesterprojekt.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;

@Entity
public class NewsModel {

    @Id  //primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;

    private java.sql.Blob image;

    public NewsModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "id=" + id +
                ", image=" + image +
                '}';
    }
}
