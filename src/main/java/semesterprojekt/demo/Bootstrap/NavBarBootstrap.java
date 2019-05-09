package semesterprojekt.demo.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import semesterprojekt.demo.Model.NavigationBar;
import semesterprojekt.demo.Model.NavigationObjects;
import semesterprojekt.demo.Repo.NavBarRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class NavBarBootstrap implements ApplicationListener<ContextRefreshedEvent>
{

    @Autowired
    NavBarRepo navBarRepo;

    private List<NavigationBar> createNavigationBar()
    {

        //Navigation bar
        List<NavigationBar> navigationBarList = new ArrayList<>();
        NavigationBar navigationBar = new NavigationBar();

        //Navigation Objects
        NavigationObjects navigationObjects = new NavigationObjects();
        NavigationObjects navigationObjects2 = new NavigationObjects();
        NavigationObjects navigationObjects3 = new NavigationObjects();
        NavigationObjects navigationObjects4 = new NavigationObjects();
        NavigationObjects navigationObjects5 = new NavigationObjects();
        NavigationObjects navigationObjects6 = new NavigationObjects();
        NavigationObjects navigationObjects7 = new NavigationObjects();
        navigationObjects.setName("Produkt");
        navigationObjects2.setName("Services");
        navigationObjects3.setName("Projekter");
        navigationObjects4.setName("Kontakt");
        navigationObjects5.setName("Om Kurland");
        navigationObjects6.setName("Ledige jobs");
        navigationObjects7.setName("Indkøbskurv");

        navigationBar.getNavigationObjects().add(navigationObjects);
        navigationBar.getNavigationObjects().add(navigationObjects2);
        navigationBar.getNavigationObjects().add(navigationObjects3);
        navigationBar.getNavigationObjects().add(navigationObjects4);
        navigationBar.getNavigationObjects().add(navigationObjects5);
        navigationBar.getNavigationObjects().add(navigationObjects6);
        navigationBar.getNavigationObjects().add(navigationObjects7);
        navigationObjects.setNavigationBar(navigationBar);
        navigationObjects2.setNavigationBar(navigationBar);
        navigationObjects3.setNavigationBar(navigationBar);
        navigationObjects4.setNavigationBar(navigationBar);
        navigationObjects5.setNavigationBar(navigationBar);
        navigationObjects6.setNavigationBar(navigationBar);
        navigationObjects7.setNavigationBar(navigationBar);

        navigationBarList.add(navigationBar);

        return navigationBarList;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        System.out.println("context refreshed");
        navBarRepo.saveAll(createNavigationBar());

    }
}
