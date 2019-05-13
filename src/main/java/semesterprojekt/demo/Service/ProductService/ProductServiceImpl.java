package semesterprojekt.demo.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.ProductModel;
import semesterprojekt.demo.Repo.ProductRepo.IProductRepo;

import java.util.List;
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
    public ProductModel findProduct(Long id)
    {
        return iProductRepo.findAllById(id);
    }

    @Override
    public Iterable<ProductModel> fetchAllProducts()
    {
        return iProductRepo.findAll();
    }

    @Override
    public void deleteProduct(Long id)
    {
        iProductRepo.deleteById(id);
    }

//    @Override
//    public List<ProductModel> findProductsByCategories(Long id)
//    {
//        System.out.println("ID: " + id);
//        return iProductRepo.findProductsByCategories(id);
//    }
}
