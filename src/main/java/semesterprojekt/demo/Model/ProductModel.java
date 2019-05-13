package semesterprojekt.demo.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class ProductModel
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    private String shortDescription;

    private String longDescription;

    @ManyToOne
    private ProductCategories productCategories;

    public ProductModel()
    {

    }

    public ProductModel(String name, double price, String shortDescription, String longDescription, ProductCategories productCategories) {
        this.name = name;
        this.price = price;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.productCategories = productCategories;
    }
}
