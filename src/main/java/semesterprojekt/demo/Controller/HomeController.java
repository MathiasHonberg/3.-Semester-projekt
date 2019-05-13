package semesterprojekt.demo.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import semesterprojekt.demo.Service.ContactServiceImpl;
import semesterprojekt.demo.Service.NavigationBar.NavBarServiceImpl;
import semesterprojekt.demo.Service.NewsServiceImpl;

@Controller
public class HomeController
{
    //Logger
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //RETURN STRINGS
    private final String REDIRECT = "redirect:/";
    private final String INDEX = "index";
    private final String CONTACT = "contact";


    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    private NavBarServiceImpl navBarService;

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping("/")
    public String test(Model model)
    {
        log.info("INDEX action called...");

        model.addAttribute("fetchAllNews",newsServiceImpl.fetchAllNews());
        model.addAttribute("navigationBar", navBarService.fetchAllNames());

        log.info("INDEX action called...");

        return INDEX;
    }

    @GetMapping("/contact")
    public String kontakt(Model model)
    {
        log.info("CONTACT action called...");

        model.addAttribute("navigationBar", navBarService.fetchAllNames());
        model.addAttribute("contact", contactService.findAll());

        return CONTACT;
    }

}
