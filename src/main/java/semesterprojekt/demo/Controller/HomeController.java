package semesterprojekt.demo.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import semesterprojekt.demo.Service.NewsServiceImpl;

@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String INDEX = "index";


    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @GetMapping("/")
    public String test(Model model)
    {
        log.info("INDEX action called...");

        model.addAttribute("fetchAllNews",newsServiceImpl.fetchAllNews());

        log.info("INDEX action called...");

        return INDEX;
    }


}
