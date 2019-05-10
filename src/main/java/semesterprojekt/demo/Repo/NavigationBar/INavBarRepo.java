package semesterprojekt.demo.Repo.NavigationBar;

import org.springframework.data.repository.CrudRepository;
import semesterprojekt.demo.Model.NavigationBar;

import java.util.Optional;

public interface INavBarRepo extends CrudRepository<NavigationBar, Long>
{
    Optional<NavigationBar> findById (Long id);
}
