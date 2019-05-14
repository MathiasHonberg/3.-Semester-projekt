package semesterprojekt.demo.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.ProductModel;
import semesterprojekt.demo.Repo.ProductRepo.IProductRepo;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
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

    @Transactional
    public ProductModel saveProductImage(ProductModel productModel, MultipartFile imageFile)throws IOException
    {
        //Converting imageFile into String
        if(!imageFile.isEmpty())
        {
            byte [] byteArr = imageFile.getBytes();
            Base64.Encoder encoder = Base64.getEncoder();
            String encodedImage = "data:image/png;base64," + encoder.encodeToString(byteArr);

            productModel.setProductFileName(imageFile.getOriginalFilename());
            productModel.setProductImage(encodedImage);
            iProductRepo.save(productModel);
//            System.out.println(productModel);
        }
        return null;
    }
}
