package semesterprojekt.demo.Service.ProductService;

import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.ProductModel;

import java.util.Optional;

@Service
public interface IProductService
{
    ProductModel addProduct(ProductModel productModel);

    Optional<ProductModel> findProduct(Long id);

    Iterable<ProductModel> fetchAll();

    void deleteProduct(Long id);


}
