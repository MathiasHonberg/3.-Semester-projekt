package semesterprojekt.demo.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import semesterprojekt.demo.Model.NavigationBar;
import semesterprojekt.demo.Repo.NavigationBar.INavBarRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class NavBarBootstrap implements ApplicationListener<ContextRefreshedEvent>
{

    @Autowired
    INavBarRepo navBarRepo;

    private List<NavigationBar> createNavigationBar()
    {

        //Navigation bar
        List<NavigationBar> navigationBarList = new ArrayList<>();
        NavigationBar home = new NavigationBar("Home", "/");
        NavigationBar produkter = new NavigationBar("Produkter", "/productcategories");
        NavigationBar projekter = new NavigationBar("Projekter", "/kontakt");
        NavigationBar kontakt = new NavigationBar("Om Kurland", "/kontakt");
        NavigationBar omKurland = new NavigationBar("Kontakt", "/kontakt");
        NavigationBar ledigeJobs = new NavigationBar("Ledige Jobs", "/kontakt");
        NavigationBar indkøbskurv = new NavigationBar("Indkøbskurv", "/kontakt");

        navigationBarList.add(home);
        navigationBarList.add(produkter);
        navigationBarList.add(projekter);
        navigationBarList.add(kontakt);
        navigationBarList.add(omKurland);
        navigationBarList.add(ledigeJobs);
        navigationBarList.add(indkøbskurv);


        return navigationBarList;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        System.out.println("context refreshed");
        navBarRepo.saveAll(createNavigationBar());

    }
}
