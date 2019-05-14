package semesterprojekt.demo.Controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.Contact;
import semesterprojekt.demo.Service.NewsServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import semesterprojekt.demo.Service.IContactService;
import semesterprojekt.demo.Model.ProductCategories;
import semesterprojekt.demo.Model.ProductModel;
import semesterprojekt.demo.Service.ProductService.CategoriesServiceImpl;
import semesterprojekt.demo.Service.ProductService.ProductServiceImpl;

@Log
@Controller
public class AdminHomeController
{
    private final String ADMIN_MENU = "/admin/adminmenu";
    private final String ADMIN_CONTACT = "/admin/admincontact";
    private final String ADMIN_CONTACT_UPDATE = "/admin/adminupdatecontact";
    private final String ADMIN_CATEGORY = "/admin/admincategory";
    private final String ADMIN_PRODUCT = "/admin/adminproduct";
    private final String REDIRECT_ADMIN_CATEGORY = "redirect:/admincategory";
    private final String REDIRECT_ADMIN_MENU= "redirect:/adminmenu";
    private final String REDIRECT_ADMIN_PRODUCT = "redirect:/adminproduct";
    private final String REDIRECT_ADMIN_CONTACT = "redirect:/admincontact";

    Long tmpId;

    @Autowired
    IContactService contactService;

    @Autowired
    private CategoriesServiceImpl categoriesService;

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    private ProductServiceImpl productService;

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

    @GetMapping("/admincategory")
    public String adminCategory(Model model)
    {

        model.addAttribute("fetchAllCategories", categoriesService.fetchAllCategories());
        model.addAttribute("pc", new ProductCategories());

        return ADMIN_CATEGORY;
    }

    @PostMapping("/uploadcategoryimage")
    public String adminCategory(@RequestParam("fileName") MultipartFile imageFile, @ModelAttribute ProductCategories productCategories) throws Exception
    {

        if(!imageFile.isEmpty())
        {
            categoriesService.savePCImage(productCategories, imageFile);
        }


        return REDIRECT_ADMIN_CATEGORY;
    }

    @GetMapping("delete/specificcategory/{id}")
    public String deleteSpecificCategory(@PathVariable("id") Long id)
    {

        log.info("DELETE_SPECIFIC_CATEGORY action called...");

        if(id != null)
        {
            categoriesService.deleteProductCategory(id);
        }

        log.info("DELETE_SPECIFIC_CATEGORY action ended...");

        return REDIRECT_ADMIN_CATEGORY;
    }


    @GetMapping("/adminproduct")
    public String adminProduct(Model model)
    {
        model.addAttribute("fetchAllProducts", productService.fetchAllProducts());
        model.addAttribute("fetchAllCategories", categoriesService.fetchAllCategories());
        model.addAttribute("product", new ProductModel());

        return ADMIN_PRODUCT;
    }

    @PostMapping("/uploadproductimage")
    public String adminProduct(@RequestParam("fileName") MultipartFile imageFile, @ModelAttribute ProductModel productModel, Model model) throws Exception
    {
        if(!imageFile.isEmpty())
        {
            productService.saveProductImage(productModel, imageFile);
        }

        return REDIRECT_ADMIN_PRODUCT;
    }

    @GetMapping("delete/specificproduct/{id}")
    public String deleteSpecificProduct(@PathVariable("id") Long id)
    {

        log.info("DELETE_SPECIFIC_PRODUCT action called...");

        if(id != null)
        {
            productService.deleteProduct(id);
        }

        log.info("DELETE_SPECIFIC_PRODUCT action ended...");

        return REDIRECT_ADMIN_PRODUCT;

    }
    @GetMapping("/admincontact")
    public String adminContact(Model model)
    {
        model.addAttribute("contact", contactService.findAll());
        log.info("ADMIN_CONTACT action called...");
        return ADMIN_CONTACT;
    }

    @PostMapping("/createcontact")
    public String createContact(Contact contact)
    {
        contactService.addContact(contact);
        return REDIRECT_ADMIN_CONTACT;
    }
    @GetMapping("/deletecontact/{id}")
    public String deleteContact(@PathVariable("id") Long id)
    {
        contactService.deleteContact(id);

        return REDIRECT_ADMIN_CONTACT;
    }
    @GetMapping("/updatecontact/{id}")
    public String updateContact(@PathVariable("id") Long id, Model model)
    {
        tmpId = id;
        Contact contact = contactService.findContactById(id);
        System.out.println(contact);
        model.addAttribute("contact", contact);
        return ADMIN_CONTACT_UPDATE;
    }

    @PostMapping("/updatecontact")
    public String updateContact(Contact k)
    {
        contactService.deleteContact(tmpId);
        contactService.editContact(k);

        return REDIRECT_ADMIN_CONTACT;
    }
}




