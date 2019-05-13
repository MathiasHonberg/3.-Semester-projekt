package semesterprojekt.demo.Controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.Kontakt;
import semesterprojekt.demo.Service.IKontaktService;
import semesterprojekt.demo.Service.NewsServiceImpl;

@Log
@Controller
public class AdminHomeController
{
    private final String ADMIN_MENU = "/admin/adminmenu";
    private final String REDIRECT_ADMIN_MENU= "redirect:/adminmenu";
    private final String ADMIN_KONTAKT = "/admin/adminkontakt";

    @Autowired
    IKontaktService kontaktService;

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @GetMapping("/adminmenu")
    public String adminMenu(Model model)
    {
        log.info("ADMIN_MENU action called...");

        model.addAttribute("fetchAllNews", newsServiceImpl.fetchAllNews());

        log.info("ADMIN_MENU action ended...");

        return ADMIN_MENU;
    }


    @PostMapping("/uploadimage")
    public String uploadImage(@RequestParam("fileName") MultipartFile imageFile) throws Exception
    {

        if(!imageFile.isEmpty())
        {
            newsServiceImpl.saveImage(imageFile);
        }

        return REDIRECT_ADMIN_MENU;
    }

    @GetMapping("delete/specificnews/{id}")
    public String deleteSpecificNews(@PathVariable("id") Long id)
    {

        log.info("deleteSpecificNews action called...");

        if(id != null)
        {
            newsServiceImpl.deleteSpecificNews(id);
        }

        log.info("deleteSpecific action ended...");

        return REDIRECT_ADMIN_MENU;

    }

    @GetMapping("/adminkontakt")
    public String adminkontakt()
    {

        log.info("ADMIN_KONTAKT action called...");
        return ADMIN_KONTAKT;
    }

    @PostMapping("/createkontakt")
    public String createContact(Kontakt kontakt)
    {
        kontaktService.addKontakt(kontakt);
        return ADMIN_KONTAKT;
    }
}




