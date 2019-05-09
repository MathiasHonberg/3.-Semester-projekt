package semesterprojekt.demo.Repo;

import org.springframework.data.repository.CrudRepository;
import semesterprojekt.demo.Model.NavigationBar;
import semesterprojekt.demo.Model.NavigationObjects;

import java.util.Optional;
import java.util.Set;

public interface NavBarRepo extends CrudRepository<NavigationBar, Long>
{
    Optional<NavigationBar> findById (Long id);


}
