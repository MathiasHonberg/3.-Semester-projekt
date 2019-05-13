package semesterprojekt.demo.Service.ProductService;

import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.ProductModel;

@Service
public interface IProductService
{
    ProductModel addProduct(ProductModel productModel);

    ProductModel findProduct(Long id);

    Iterable<ProductModel> fetchAllProducts();

    void deleteProduct(Long id);

//    List<ProductModel> findProductsByCategories(Long id);


}
