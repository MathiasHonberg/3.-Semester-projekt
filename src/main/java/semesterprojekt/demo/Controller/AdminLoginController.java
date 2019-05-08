package semesterprojekt.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController
{
    private final String ADMIN_LOGIN = "/adminlogin";
    private final String ADMIN_MENU = "/adminmenu";
    private final String ADMIN_LOGIN_ERROR = "/loginerror";

    @GetMapping(ADMIN_LOGIN)
    public String adminLogin()
    {
        return ADMIN_LOGIN;
    }

    @GetMapping(ADMIN_MENU)
    public String adminMenu()
    {
        return ADMIN_MENU;
    }

    @GetMapping(ADMIN_LOGIN_ERROR)
    public String loginError()
    {
        return ADMIN_LOGIN_ERROR;
    }


}
