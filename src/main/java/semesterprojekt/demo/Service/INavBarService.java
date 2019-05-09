package semesterprojekt.demo.Service;

import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.NavigationBar;

import java.util.Optional;

@Service
public interface INavBarService {

    Optional<NavigationBar> findNavBarById(Long id);


}
