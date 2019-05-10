package semesterprojekt.demo.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class ProductCategories
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductModel> productModels = new HashSet<>();

    public ProductCategories()
    {

    }

    public ProductCategories(String name) {
        this.name = name;
    }
}
