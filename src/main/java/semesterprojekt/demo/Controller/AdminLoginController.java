package semesterprojekt.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController
{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String ADMIN_LOGIN = "/adminlogin";
    private final String ADMIN_MENU = "/adminmenu";
    private final String ADMIN_LOGIN_ERROR = "/loginerror";

    @GetMapping(ADMIN_LOGIN)
    public String adminLogin()
    {
        log.info("ADMIN_LOGIN action called...");

        return ADMIN_LOGIN;
    }

    @GetMapping(ADMIN_MENU)
    public String adminMenu()
    {
        log.info("ADMIN_MENU action called...");

        return ADMIN_MENU;
    }

    @GetMapping(ADMIN_LOGIN_ERROR)
    public String loginError()
    {
        log.info("ADMIN_LOGIN_ERROR action called...");

        return ADMIN_LOGIN_ERROR;
    }
}
