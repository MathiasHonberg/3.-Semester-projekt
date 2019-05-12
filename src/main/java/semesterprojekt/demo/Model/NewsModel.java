package semesterprojekt.demo.Model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class NewsModel
{
    @Id  //primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;

    private String fileName;

    @Type(type="text")
    private String image;
}
