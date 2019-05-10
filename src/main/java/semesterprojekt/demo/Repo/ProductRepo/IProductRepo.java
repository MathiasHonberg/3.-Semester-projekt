package semesterprojekt.demo.Repo.ProductRepo;

import org.springframework.data.repository.CrudRepository;
import semesterprojekt.demo.Model.ProductCategories;
import semesterprojekt.demo.Model.ProductModel;

import java.util.Optional;

public interface IProductRepo extends CrudRepository<ProductModel, Long>
{
    Optional<ProductModel> findById (Long id);

}
