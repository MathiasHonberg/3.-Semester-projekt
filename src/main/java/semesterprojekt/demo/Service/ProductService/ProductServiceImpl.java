package semesterprojekt.demo.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.ProductModel;
import semesterprojekt.demo.Repo.ProductRepo.IProductRepo;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService
{
    @Autowired
    IProductRepo iProductRepo;

    @Override
    public ProductModel addProduct(ProductModel product)
    {
        return iProductRepo.save(product);
    }

    @Override
    public Optional<ProductModel> findProduct(Long id)
    {
        return iProductRepo.findById(id);
    }

    @Override
    public Iterable<ProductModel> fetchAll()
    {
        return iProductRepo.findAll();
    }

    @Override
    public void deleteProduct(Long id)
    {
        iProductRepo.deleteById(id);
    }
}
