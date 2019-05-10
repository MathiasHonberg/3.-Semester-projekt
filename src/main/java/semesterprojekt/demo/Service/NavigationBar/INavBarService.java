package semesterprojekt.demo.Service.NavigationBar;

import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.NavigationBar;

import java.util.Optional;

@Service
public interface INavBarService
{

    NavigationBar addNavigationName(NavigationBar navigationBar);

    Optional<NavigationBar> findNavigationName(Long id);

    Iterable<NavigationBar> fetchAllNames();

    void deleteNavigationName(Long id);


}
