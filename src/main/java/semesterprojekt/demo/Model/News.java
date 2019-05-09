package semesterprojekt.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.image.BufferedImage;

@Entity
public class News {

    @Id  //primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;

    private BufferedImage image;

    public News() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", image=" + image +
                '}';
    }
}
