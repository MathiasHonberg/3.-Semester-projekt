package semesterprojekt.demo.Controller;

import org.hibernate.Hibernate;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import semesterprojekt.demo.Model.NewsModel;
import semesterprojekt.demo.Service.NewsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.Blob;

@Controller
public class AdminHomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final String ADMIN_MENU = "/admin/adminmenu";

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @GetMapping("/adminmenu")
    public String adminMenu(Model model)
    {
        log.info("ADMIN_MENU action called...");

        model.addAttribute("fetchAllNews",newsServiceImpl.fetchAllNews());

        log.info("ADMIN_MENU action ended...");

        return ADMIN_MENU;
    }

    @PostMapping("/uploadimage")
    public String uploadImage(@RequestParam("fileName") MultipartFile file) throws Exception
    {
                System.out.println("Saving file: " + file.getOriginalFilename());

                NewsModel newsModel = new NewsModel();

                newsModel.setFileName(file.getOriginalFilename());

                newsModel.setImage(file.getBytes());

                newsServiceImpl.saveImage(newsModel);


        return "Success";
    }

}

    /*
    @PostMapping("/uploadimage")
    public ModelAndView uploadImage(@ModelAttribute NewsModel newsModel)
    {
        try{

            Blob blob = newsModel.getImage();
            //Convert img datatype "MultiPartFile" into Blob datatype.
            //byte[] bytes = img.getBytes();
            //Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

            newsServiceImpl.createNews((NewsModel) blob);

            return new ModelAndView("index", "msg", "Image succesfully inserted into database.");

        } catch (Exception e){
            return new ModelAndView("index", "msg", "Error: " + e.getMessage());
        }
    }
    */



