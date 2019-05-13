package semesterprojekt.demo.Controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import semesterprojekt.demo.Model.Kontakt;
import semesterprojekt.demo.Model.ProductCategories;
import semesterprojekt.demo.Model.ProductModel;
import semesterprojekt.demo.Service.IKontaktService;
import semesterprojekt.demo.Service.NavigationBar.NavBarServiceImpl;
import semesterprojekt.demo.Service.NewsServiceImpl;
import semesterprojekt.demo.Service.ProductService.CategoriesServiceImpl;
import semesterprojekt.demo.Service.ProductService.ICategoriesService;
import semesterprojekt.demo.Service.ProductService.ProductServiceImpl;

import javax.jws.WebParam;

@Log
@Controller
public class AdminHomeController
{
    private final String ADMIN_MENU = "/admin/adminmenu";
    private final String REDIRECT_ADMIN_MENU= "redirect:/adminmenu";
    private final String ADMIN_KONTAKT = "admin/adminkontakt";

    //Category
    private final String ADMIN_CATEGORY = "/admin/admincategory";
    private final String REDIRECT_ADMIN_CATEGORY = "redirect:/admincategory";

    //Product
    private final String ADMIN_PRODUCT = "/admin/adminproduct";
    private final String REDIRECT_ADMIN_PRODUCT = "redirect:/adminproduct";

    @Autowired
    private IKontaktService kontaktService;

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

//ADMIN CATEGORY
    @GetMapping("/admincategory")
    public String adminCategory(Model model)
    {

        model.addAttribute("fetchAllCategories", categoriesService.fetchAllCategories());
        model.addAttribute("pc", new ProductCategories());

        return ADMIN_CATEGORY;
    }

    @PostMapping("/uploadcategoryimage")
    public String adminCategory(@RequestParam("fileName") MultipartFile imageFile, @ModelAttribute ProductCategories productCategories, Model model) throws Exception
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
    public String adminProduct(@RequestParam("fileName") MultipartFile imageFile, @ModelAttribute ProductModel productModel, Model model) throws Exception
    {

        if(!imageFile.isEmpty())
        {
            productService.saveProductImage(productModel, imageFile);
            System.out.println(productModel);
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




