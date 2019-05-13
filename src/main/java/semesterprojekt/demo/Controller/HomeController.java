package semesterprojekt.demo.Controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import semesterprojekt.demo.Service.KontaktServiceImpl;
import semesterprojekt.demo.Service.NavigationBar.NavBarServiceImpl;
import semesterprojekt.demo.Service.NewsServiceImpl;
import java.sql.SQLException;

@Log
@Controller
public class HomeController
{
    //RETURN STRINGS
    private final String REDIRECT = "redirect:/";
    private final String INDEX = "index";
    private final String KONTAKT = "kontakt";

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    private NavBarServiceImpl navBarService;

    @Autowired
    private KontaktServiceImpl kontaktService;

    @GetMapping("/")
    public String fetchNews(Model model) throws SQLException
    {
        log.info("fetchNews action called...");

        model.addAttribute("fetchAllNewsPictures",newsServiceImpl.fetchAllNews());

        model.addAttribute("navigationBar", navBarService.fetchAllNames());

        log.info("fetchNews action called...");

        return INDEX;
    }

    @GetMapping("/kontakt")
    public String kontakt(Model model)
    {
        log.info("KONTAKT action called...");

        model.addAttribute("navigationBar", navBarService.fetchAllNames());
        model.addAttribute("kontakt", kontaktService.findAll());

        return KONTAKT;
    }

}
