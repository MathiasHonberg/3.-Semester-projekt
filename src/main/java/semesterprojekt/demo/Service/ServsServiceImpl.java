package semesterprojekt.demo.Service;

import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.ProductModel;
import semesterprojekt.demo.Model.Servs;
import semesterprojekt.demo.Repo.IServsRepo;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;

@Service
public class ServsServiceImpl implements IServsService {

    @Autowired
    IServsRepo servsRepo;

    @Override
    public Iterable<Servs> findAll() {
        return servsRepo.findAll();
    }

    @Override
    public Servs findServsById(Long id) {
        return servsRepo.findAllById(id);
    }

    @Override
    public Servs createServs(Servs s)
    {

        return servsRepo.save(s);
    }

    @Override
    public void editServs(Servs servs)
    {
        Long id = servs.getId();
        String name = servs.getName();
        String price = servs.getPrice();
        String shortDescription = servs.getShortDescription();
        String longDescription = servs.getLongDescription();
        String servsFileName = servs.getServsFileName();
        String image = servs.getImage();

        servsRepo.updateServsInfoById(name, price, shortDescription, longDescription, servsFileName, image, id);

    }

    @Override
    public void deleteServs(Long id)
    {
        servsRepo.deleteById(id);
    }

    @Transactional
    public Servs saveNewSercs(Servs servs, MultipartFile multipartFile) throws  IOException
    {
        if (!multipartFile.isEmpty())
        {
            saveImages(servs, multipartFile);
            servsRepo.save(servs);
        }
        return null;
    }

    @Transactional
    public Servs saveSercsImage(Servs servs, MultipartFile multipartFile) throws IOException
    {
        if(!multipartFile.isEmpty())
        {
            saveImages(servs, multipartFile);
            editServs(servs);
        }
        return null;
    }

    private void saveImages (Servs s, MultipartFile multipartFile) throws IOException
    {
        byte [] byteArr = multipartFile.getBytes();
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedImage = "data:image/png;base64," + encoder.encodeToString(byteArr);

        s.setServsFileName(multipartFile.getOriginalFilename());
        s.setImage(encodedImage);

    }
}
