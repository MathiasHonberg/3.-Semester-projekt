package semesterprojekt.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.Contact;
import semesterprojekt.demo.Model.NewsModel;
import semesterprojekt.demo.Service.NewsServiceImpl;
import java.sql.Blob;

import org.springframework.web.bind.annotation.PostMapping;
import semesterprojekt.demo.Service.IContactService;


@Controller
public class AdminHomeController
{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String ADMIN_MENU = "/admin/adminmenu";
    private final String ADMIN_CONTACT = "/admin/admincontact";
    private final String ADMIN_CONTACT_UPDATE = "/admin/adminupdatecontact";

    Long tmpId;


    @Autowired
    IContactService contactService;

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
    public String uploadImage(@RequestParam("fileName") MultipartFile file) throws Exception
    {
        NewsModel newsModel = new NewsModel();

        newsModel.setFileName(file.getOriginalFilename());

        Blob convertedByteToBlobFormat = new javax.sql.rowset.serial.SerialBlob(file.getBytes());

        newsModel.setImage(convertedByteToBlobFormat);

        newsServiceImpl.saveImage(newsModel);

        return "redirect:/";
    }
    @GetMapping("/admincontact")
    public String adminkontakt(Model model)
    {
        model.addAttribute("contact", contactService.findAll());
        log.info("ADMIN_CONTACT action called...");
        return ADMIN_CONTACT;
    }

    @PostMapping("/createcontact")
    public String createContact(Contact contact)
    {
        contactService.addKontakt(contact);
        return "redirect:/admincontact";
    }
    @GetMapping("/deletecontact/{id}")
    public String deleteContact(@PathVariable("id") Long id)
    {
        contactService.deleteKontakt(id);

        return "redirect:/admincontact";
    }
    @GetMapping("/updatecontact/{id}")
    public String updateContact(@PathVariable("id") Long id, Model model)
    {
        tmpId = id;
        Contact contact = contactService.findKontaktById(id);
        System.out.println(contact);
        model.addAttribute("contact", contact);
        return ADMIN_CONTACT_UPDATE;
    }

    @PostMapping("/updatecontact")
    public String updateContact(Contact k)
    {
        contactService.deleteKontakt(tmpId);
        contactService.editKontakt(k);


        return "redirect:/admincontact";
    }
}




