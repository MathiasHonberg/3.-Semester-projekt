package semesterprojekt.demo.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String ADMIN_MENU = "/admin/adminmenu";


    @GetMapping("/adminmenu")
    public String adminMenu()
    {
        log.info("ADMIN_MENU action called...");

        return ADMIN_MENU;
    }


}
