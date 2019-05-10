package semesterprojekt.demo.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import semesterprojekt.demo.Model.NavigationBar;
import semesterprojekt.demo.Service.NavigationBar.NavBarServiceImpl;
import semesterprojekt.demo.Service.NewsServiceImpl;

import javax.jws.WebParam;

@Controller
public class HomeController
{
    //Logger
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //RETURN STRINGS
    private final String REDIRECT = "redirect:/";
    private final String INDEX = "index";
    private final String KONTAKT = "kontakt";


    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    private NavBarServiceImpl navBarService;

    @GetMapping("/")
    public String test(Model model)
    {
        log.info("INDEX action called...");

        model.addAttribute("fetchAllNews",newsServiceImpl.fetchAllNews());
        model.addAttribute("navigationBar", navBarService.fetchAllNames());

        log.info("INDEX action called...");

        return INDEX;
    }

    @GetMapping("/kontakt")
    public String kontakt(Model model)
    {
        log.info("KONTAKT action called...");

        model.addAttribute("navigationBar", navBarService.fetchAllNames());

        return KONTAKT;
    }

}
