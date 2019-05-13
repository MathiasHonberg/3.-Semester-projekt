package semesterprojekt.demo.Service.ProductService;

import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.ProductCategories;

import java.util.Optional;

@Service
public interface ICategoriesService
{
    ProductCategories addProductCategory(ProductCategories productCategories);

    ProductCategories findProductCategory(Long id);

    Iterable<ProductCategories> fetchAllCategories();

    void deleteProductCategory(Long id);

}
