package semesterprojekt.demo.Repo.ProductRepo;

import org.springframework.data.repository.CrudRepository;
import semesterprojekt.demo.Model.ProductCategories;

import java.util.Optional;

public interface ICategoriesRepo extends CrudRepository<ProductCategories, Long>
{
    ProductCategories findAllById(Long id);

}
