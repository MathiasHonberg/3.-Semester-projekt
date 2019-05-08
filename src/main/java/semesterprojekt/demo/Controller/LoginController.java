package semesterprojekt.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{

    @GetMapping("/adminlogin")
    public String adminLogin()
    {
        return "adminlogin";
    }

    @GetMapping("/adminmenu")
    public String adminMenu()
    {
        return "adminmenu";
    }

    @GetMapping("/loginError")
    public String loginError()
    {
        return "LoginError";
    }


}
