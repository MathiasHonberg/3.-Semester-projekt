package semesterprojekt.demo.Service;

import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.ProductModel;
import semesterprojekt.demo.Model.Servs;

import java.io.IOException;

public interface IServsService {

    Iterable<Servs> findAll();
    Servs findServsById(Long id);
    Servs createServs(Servs s);
    Servs saveNewSercs(Servs servs, MultipartFile file)throws IOException;
    void deleteServs(Long id);
    Servs saveSercsImage(Servs s, MultipartFile multipartFile) throws IOException;
    void editServs(Servs servs);

}