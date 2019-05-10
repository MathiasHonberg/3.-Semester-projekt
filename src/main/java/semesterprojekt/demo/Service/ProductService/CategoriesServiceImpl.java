package semesterprojekt.demo.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.ProductCategories;
import semesterprojekt.demo.Repo.ProductRepo.ICategoriesRepo;

import java.util.Optional;

@Service
public class CategoriesServiceImpl implements ICategoriesService
{

    @Autowired
    ICategoriesRepo iCategoriesRepo;

    @Override
    public ProductCategories addProductCategory(ProductCategories productCategories)
    {
        return iCategoriesRepo.save(productCategories);
    }

    @Override
    public ProductCategories findProductCategory(Long id)
    {
        return iCategoriesRepo.findAllById(id);
    }

    @Override
    public Iterable<ProductCategories> fetchAll()
    {
        return iCategoriesRepo.findAll();
    }

    @Override
    public void deleteProductCategory(Long id)
    {
         iCategoriesRepo.deleteById(id);
    }
}
