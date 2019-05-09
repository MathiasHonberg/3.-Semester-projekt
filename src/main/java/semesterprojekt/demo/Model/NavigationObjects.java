package semesterprojekt.demo.Model;

import javax.persistence.*;

@Entity
public class NavigationObjects
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private NavigationBar navigationBar;

    public NavigationObjects()
    {

    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public NavigationBar getNavigationBar()
    {
        return navigationBar;
    }

    public void setNavigationBar(NavigationBar navigationBar)
    {
        this.navigationBar = navigationBar;
    }
}
