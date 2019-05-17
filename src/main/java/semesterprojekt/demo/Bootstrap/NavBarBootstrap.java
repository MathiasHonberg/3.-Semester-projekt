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
        NavigationBar services = new NavigationBar("Services", "/contact");
        NavigationBar projekter = new NavigationBar("Projekter", "/contact");
        NavigationBar kontakt = new NavigationBar("Om Kurland", "/contact");
        NavigationBar omKurland = new NavigationBar("Kontakt", "/contact");
        NavigationBar ledigeJobs = new NavigationBar("Ledige Jobs", "/contact");
        NavigationBar indkøbskurv = new NavigationBar("Indkøbskurv", "/contact");
        NavigationBar about = new NavigationBar("About", "/about");


        navigationBarList.add(home);
        navigationBarList.add(produkter);
        navigationBarList.add(services);
        navigationBarList.add(projekter);
        navigationBarList.add(kontakt);
        navigationBarList.add(omKurland);
        navigationBarList.add(ledigeJobs);
        navigationBarList.add(indkøbskurv);
        navigationBarList.add(about);


        return navigationBarList;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        System.out.println("NAVIGATION_BAR_BOOTSTRAP context refreshed");
        navBarRepo.saveAll(createNavigationBar());

    }
}
