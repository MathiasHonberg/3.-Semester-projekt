package semesterprojekt.demo.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import semesterprojekt.demo.Model.Kontakt;
import semesterprojekt.demo.Repo.IKontaktRepo;
import semesterprojekt.demo.Service.IKontaktService;

@Controller
public class AdminHomeController
{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String ADMIN_MENU = "/admin/adminmenu";
    private final String ADMIN_KONTAKT = "/admin/adminkontakt";

    @Autowired
    IKontaktService kontaktService;


    @GetMapping("/adminmenu")
    public String adminMenu()
    {
        log.info("ADMIN_MENU action called...");

        return ADMIN_MENU;
    }

    @GetMapping("/adminkontakt")
    public String adminkontakt()
    {

        log.info("ADMIN_KONTAKT action called...");
        return ADMIN_KONTAKT;
    }

    @PostMapping("/createkontakt")
    public String createContact(Kontakt kontakt)
    {
        kontaktService.addKontakt(kontakt);
        return ADMIN_KONTAKT;
    }


}
