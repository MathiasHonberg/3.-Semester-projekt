package semesterprojekt.demo.Controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.Contact;
import semesterprojekt.demo.Model.NavigationBar;
import semesterprojekt.demo.Service.NavigationBar.NavBarServiceImpl;
import semesterprojekt.demo.Service.NewsServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import semesterprojekt.demo.Service.IContactService;
import semesterprojekt.demo.Model.ProductCategories;
import semesterprojekt.demo.Model.ProductModel;
import semesterprojekt.demo.Service.ProductService.CategoriesServiceImpl;
import semesterprojekt.demo.Service.ProductService.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Log
@Controller
public class AdminHomeController
{

    Long tmpId;
    Long tempPId;
    Long tempNBId;


    //Menu
    private final String ADMIN_MENU = "/admin/adminmenu";
    private final String REDIRECT_ADMIN_MENU= "redirect:/adminmenu";

    //Contact
    private final String ADMIN_CONTACT = "/admin/admincontact";
    private final String ADMIN_CONTACT_UPDATE = "/admin/adminupdatecontact";

    //Category
    private final String ADMIN_CATEGORY = "/admin/admincategory";
    private final String REDIRECT_ADMIN_CATEGORY = "redirect:/admincategory";

    //Product
    private final String REDIRECT_ADMIN_PRODUCT = "redirect:/adminproduct";
    private final String ADMIN_PRODUCT = "/admin/adminproduct";
    private final String ADMIN_PRODUCT_UPDATE = "/admin/adminupdateproduct";

    //Navigation bar
    private final String ADMIN_NAVIGATION_BAR = "/admin/adminnavigationbar";
    private final String REDIRECT_ADMIN_NB = "redirect:/adminnavigationbar";

    @Autowired
    IContactService contactService;

    @Autowired
    private CategoriesServiceImpl categoriesService;

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private NavBarServiceImpl navBarService;

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

//ADMIN CATEGORY
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

//ADMIN PRODUCT

    @GetMapping("/adminproduct")
    public String adminProduct(Model model)
    {

        model.addAttribute("fetchAllProducts", productService.fetchAllProducts());
        model.addAttribute("fetchAllCategories", categoriesService.fetchAllCategories());
        model.addAttribute("product", new ProductModel());

        return ADMIN_PRODUCT;
    }

    @PostMapping("/uploadproductimage")
    public String adminProduct(@RequestParam("fileName") MultipartFile imageFile, @ModelAttribute ProductModel productModel) throws Exception
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

    @GetMapping("/updateproduct/{id}")
    public String updateProduct(@PathVariable("id") Long id, Model model)
    {
        tempPId = id;
        ProductModel productModel = productService.findProduct(id);

        model.addAttribute("fetchAllCategories", categoriesService.fetchAllCategories());
        model.addAttribute("oldProduct", productModel);
        model.addAttribute("product", new ProductModel());


        return ADMIN_PRODUCT_UPDATE;
    }

    @PostMapping("/updateproduct")
    public String updateProduct(@RequestParam("fileName") MultipartFile imageFile, @ModelAttribute ProductModel productModel) throws Exception
    {
        productService.deleteProduct(tempPId);

        if(!imageFile.isEmpty())
        {
            productService.saveProductImage(productModel, imageFile);
        }

        return "redirect:/adminproduct";
    }


//ADMIN CONTACT
    @GetMapping("/updatecontact/{id}")
    public String updateContact(@PathVariable("id") Long id, Model model)
    {
        tmpId = id;
        Contact contact = contactService.findKontaktById(id);
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
        contactService.addKontakt(contact);
        return "redirect:/admincontact";
    }
    @GetMapping("/deletecontact/{id}")
    public String deleteContact(@PathVariable("id") Long id)
    {
        contactService.deleteKontakt(id);

        return "redirect:/admincontact";
    }

//ADMIN NAVIGATION BAR
    @GetMapping("/adminnavigationbar")
    public String adminNavigationBar(Model model)
    {
        model.addAttribute("navigationBar", navBarService.fetchAllNames());

        return ADMIN_NAVIGATION_BAR;
    }

//    @GetMapping("/updatenavbar/{id}")
//    public String updateNavBar(@PathVariable("id") Long id, Model model)
//    {
//        tempNBId = id;
//        NavigationBar navigationBar = navBarService.findNavigationName(id);
//        model.addAttribute("navbar", navigationBar);
//        return ADMIN_CONTACT_UPDATE;
//    }
//
//    @PostMapping("/updatecontact")
//    public String updateNavBar(NavigationBar nb)
//    {
//        navBarService.deleteNavigationName(tempNBId);
//        navBarService.editNavBar(nb);
//
//
//        return "redirect:/admincontact";
//    }

}




