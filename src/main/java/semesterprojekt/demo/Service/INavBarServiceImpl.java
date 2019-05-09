package semesterprojekt.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.NavigationBar;
import semesterprojekt.demo.Model.NavigationObjects;
import semesterprojekt.demo.Repo.NavBarRepo;

import java.util.Optional;

@Service
public class INavBarServiceImpl implements INavBarService
{

    @Autowired
    NavBarRepo navBarRepo;

    @Override
    public NavigationObjects createNavObject(NavigationObjects navigationObjects) {
        return null;
    }

    @Override
    public void deleteNavObject(Long id) {

    }

    @Override
    public Optional<NavigationBar> findNavBarById(Long id)
    {
        return navBarRepo.findById(id);
    }
}
