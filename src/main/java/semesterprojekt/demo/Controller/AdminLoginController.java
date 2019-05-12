package semesterprojekt.demo.Controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log
@Controller
public class AdminLoginController
{
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
