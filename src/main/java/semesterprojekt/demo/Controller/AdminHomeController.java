package semesterprojekt.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.NewsModel;
import semesterprojekt.demo.Service.NewsServiceImpl;

import java.sql.Blob;

@Controller
public class AdminHomeController
{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String ADMIN_MENU = "/admin/adminmenu";

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
}




