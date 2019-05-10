package semesterprojekt.demo.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import semesterprojekt.demo.Model.Kontakt;
import semesterprojekt.demo.Repo.IKontaktRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class KontaktBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    IKontaktRepo kontaktRepo;

    private List<Kontakt> createContact()
    {
        List<Kontakt> kontakts = new ArrayList<>();
        Kontakt kon = new Kontakt();
        kon.setFirstName("Kenneth");
        kon.setLastName("Kurland");
        kon.setPhoneNumber(53675310);
        kon.setEmail("k.kurland@me.com");
        kon.setAdresse("Vallerød Park 2a, 2960 Rungsted Kyst");
        kontakts.add(kon);
        return kontakts;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        System.out.println("context refreshed");
        kontaktRepo.saveAll(createContact());

    }
}
