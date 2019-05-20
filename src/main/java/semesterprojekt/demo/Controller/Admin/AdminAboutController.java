package semesterprojekt.demo.Controller.Admin;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.AboutModel;
import semesterprojekt.demo.Service.AboutService.AboutServiceImpl;


@Log
@Controller
public class AdminAboutController
{
    private final String ADMIN_FETCH_ABOUT_TEXT = "/admin/adminabout";
    private final String ADMIN_UPDATE_ABOUT = "/admin/adminupdateabout";
    private final String REDIRECT_ADMIN_FETCH_ABOUT_TEXT = "redirect:/adminabout";

    Long tmpId;

    @Autowired
    private AboutServiceImpl aboutService;

    @GetMapping("/adminabout")
    public String fetchAboutText(Model model)
    {
        log.info("FETCH_ABOUT_TEXT action called...");

        model.addAttribute("fetchAboutTextandprofileimage", aboutService.fetchTextAndProfileImage());

        log.info("FETCH_ABOUT_TEXT action ended...");

        return ADMIN_FETCH_ABOUT_TEXT;
    }

    @PostMapping("/saveabouttextandprofiletext")
    public String saveAboutTextAndProfileText(@RequestParam("fileName") MultipartFile imageFile, @RequestParam("heading") String heading)throws Exception
    {
        log.info("SAVE_ABOUT_TEXT action called...");

        if(!imageFile.isEmpty())
        {
            aboutService.saveProfileImage(imageFile, heading);
        }

        log.info("SAVE_ABOUT_TEXT action called...");

        return REDIRECT_ADMIN_FETCH_ABOUT_TEXT;
    }

    @GetMapping("/updateabout/{id}")
    public String updateContact(@PathVariable("id") Long id, Model model)
    {
        log.info("UPDATE_ABOUT_SPECIFIC action called...");

        tmpId = id;
        AboutModel about = aboutService.findAllById(id);
        model.addAttribute("oldAbout", about);

        log.info("UPDATE_ABOUT_SPECIFIC action ended...");

        return ADMIN_UPDATE_ABOUT;
    }

    @PostMapping("/updateabout")
    public String updateContact(@RequestParam("fileName") MultipartFile imageFile, @RequestParam("heading") String heading)throws Exception
    {
        log.info("UPDATE_ABOUT action called...");

            aboutService.updateAboutSubmit(imageFile, heading, tmpId);

        log.info("UPDATE_ABOUT action ended...");

        return REDIRECT_ADMIN_FETCH_ABOUT_TEXT;
    }

}
