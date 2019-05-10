package semesterprojekt.demo.Model;

import javax.persistence.*;

@Entity
public class NavigationBar
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String urlPath;

    public NavigationBar()
    {

    }

    public NavigationBar(String name, String urlPath)
    {
        this.name = name;
        this.urlPath = urlPath;
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

    public String getUrlPath()
    {
        return urlPath;
    }

    public void setUrlPath(String urlPath)
    {
        this.urlPath = urlPath;
    }

    @Override
    public String toString() {
        return "NavigationBar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlPath='" + urlPath + '\'' +
                '}';
    }
}
