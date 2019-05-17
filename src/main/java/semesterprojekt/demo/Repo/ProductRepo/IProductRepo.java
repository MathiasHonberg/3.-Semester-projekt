package semesterprojekt.demo.Repo.ProductRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import semesterprojekt.demo.Model.ProductModel;

import java.util.Optional;


public interface IProductRepo extends CrudRepository<ProductModel, Long>
{

    ProductModel findAllById (Long id);

//    @Query("SELECT p.id, p.name, p.shortDescription, p.shortDescription, p.price" +
//            " FROM ProductModel p WHERE p.productCategories.id = :id")
//    List<ProductModel> findProductsByCategories(Long id);

}
