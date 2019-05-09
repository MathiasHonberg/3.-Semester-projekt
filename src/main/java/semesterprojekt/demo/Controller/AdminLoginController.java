package semesterprojekt.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController
{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String ADMIN_LOGIN = "/admin/adminlogin";
    private final String ADMIN_LOGIN_ERROR = "/admin/loginerror";

    @GetMapping("/adminlogin")
    public String adminLogin()
    {
        log.info("ADMIN_LOGIN action called...");

        return ADMIN_LOGIN;
    }

    @GetMapping("/loginerror")
    public String loginError()
    {
        log.info("ADMIN_LOGIN_ERROR action called...");

        return ADMIN_LOGIN_ERROR;
    }
}
