package semesterprojekt.demo.Model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;

@Entity
@Getter
@Setter
@ToString
public class NewsModel
{

    @Id  //primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;

    private String fileName;

    private Blob image;

    public NewsModel() {
    }

}
