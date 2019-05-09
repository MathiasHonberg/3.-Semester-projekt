package semesterprojekt.demo.Service;

import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.NavigationBar;
import semesterprojekt.demo.Model.NavigationObjects;
import semesterprojekt.demo.Model.NewsModel;

import java.util.Optional;

@Service
public interface INavBarService {

    NavigationObjects createNavObject(NavigationObjects navigationObjects);

    Optional<NavigationBar> findNavBarById(Long id);

    void deleteNavObject(Long id);


}
