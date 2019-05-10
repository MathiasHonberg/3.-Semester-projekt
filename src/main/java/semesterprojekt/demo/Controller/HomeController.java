package semesterprojekt.demo.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import semesterprojekt.demo.Model.NavigationBar;
import semesterprojekt.demo.Service.NavigationBar.NavBarServiceImpl;
import semesterprojekt.demo.Service.NewsServiceImpl;
import semesterprojekt.demo.Service.ProductService.CategoriesServiceImpl;
import semesterprojekt.demo.Service.ProductService.ICategoriesService;
import semesterprojekt.demo.Service.ProductService.ProductServiceImpl;

import javax.jws.WebParam;

@Controller
public class HomeController
{
    //Logger
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //RETURN STRINGS
    private final String REDIRECT = "redirect:/";
    private final String INDEX = "index";
    private final String KONTAKT = "kontakt";
    private final String PRODUCTCATEGORIES = "productcategories";
    private final String PRODUCTS = "products";


    @Autowired
    NewsServiceImpl newsServiceImpl;

    @Autowired
    CategoriesServiceImpl categoriesService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    NavBarServiceImpl navBarService;

    @GetMapping("/")
    public String test(Model model)
    {
        log.info("INDEX action called...");

        model.addAttribute("fetchAllNews",newsServiceImpl.fetchAllNews());
        model.addAttribute("navigationBar", navBarService.fetchAllNames());

        log.info("INDEX action called...");

        return INDEX;
    }

    @GetMapping("/productcategories")
    public String productCategories(Model model)
    {
        log.info("ProductCategories action called...");

        model.addAttribute("navigationBar", navBarService.fetchAllNames());
        model.addAttribute("productCategories", categoriesService.fetchAll());

        return PRODUCTCATEGORIES;
    }

    @GetMapping("/products/{id}")
    public String products(@PathVariable("id") Long id, Model model)
    {
        log.info("Products action called with category ID: " + id);

        model.addAttribute("navigationBar", navBarService.fetchAllNames());
        model.addAttribute("category", categoriesService.findProductCategory(id));
        model.addAttribute("products", productService.fetchAll());
        model.addAttribute("categoryid", id);

        return PRODUCTS;
    }

    @GetMapping("/kontakt")
    public String kontakt(Model model)
    {
        log.info("KONTAKT action called...");

        model.addAttribute("navigationBar", navBarService.fetchAllNames());

        return KONTAKT;
    }


}
