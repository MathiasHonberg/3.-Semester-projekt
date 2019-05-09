package semesterprojekt.demo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class NavigationBar
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<NavigationObjects> navigationObjects = new HashSet<>();

    public NavigationBar()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<NavigationObjects> getNavigationObjects()
    {
        return navigationObjects;
    }

    public void setNavigationObjects(Set<NavigationObjects> navigationObjects)
    {
        this.navigationObjects = navigationObjects;
    }
}
