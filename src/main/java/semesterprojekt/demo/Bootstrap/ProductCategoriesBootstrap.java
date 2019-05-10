package semesterprojekt.demo.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import semesterprojekt.demo.Model.ProductCategories;
import semesterprojekt.demo.Model.ProductModel;
import semesterprojekt.demo.Repo.ProductRepo.ICategoriesRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductCategoriesBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    ICategoriesRepo iCategoriesRepo;

    private List<ProductCategories> createProductCategories()
    {

        //Product Categories
        List<ProductCategories> productCategoriesList = new ArrayList<>();
        ProductCategories fjernsyn = new ProductCategories("Fjernsyn");
        ProductCategories køleskabe = new ProductCategories("Køleskabe");
        ProductCategories vin = new ProductCategories("Vin");
        ProductCategories elapparater = new ProductCategories("Elapparater");

        //Products
        ProductModel fjersyn1 = new ProductModel("Phillips", 7500, "Good quality", "Really good quality actually", fjernsyn);
        ProductModel fjersyn2 = new ProductModel("Samsung", 6500.50, "Best quality", "The best quality in the world", fjernsyn);
        ProductModel fjersyn3 = new ProductModel("LG", 5400, "Good quality", "Really good quality actually", fjernsyn);
        ProductModel køleskabe1 = new ProductModel("Maffeno", 3000, "Low price", "perfect to store food", køleskabe);
        ProductModel køleskabe2 = new ProductModel("Fexez", 3800, "yes", "Pretty good actually", køleskabe);
        ProductModel køleskabe3 = new ProductModel("SENZ", 4000.5, "Amazing good", "amazingly perfect", køleskabe);
        ProductModel vin1 = new ProductModel("Amarone", 230, "nice", "really nice", vin);
        ProductModel vin2 = new ProductModel("bourgogne", 300, "Tasteful", "quality wine", vin);
        ProductModel vin3 = new ProductModel("Hardy's", 240, "Lækkert", "Virkelig lækker vin", vin);
        ProductModel vin4 = new ProductModel("Yellow Tail", 300, "Pragtfuld", "Lækker vin!", vin);
        ProductModel vin5 = new ProductModel("Jacobs creek", 430, "yep", "SMukt!", vin);
        ProductModel vin6 = new ProductModel("Beringer", 290, "God", "Udmærkert vin", vin);
        ProductModel elapparater1 = new ProductModel("Kaffe maskine", 501.50, "Brugbar", "Brugbar til kaffe", elapparater);
        ProductModel elapparater2 = new ProductModel("Baby alarmer", 730, "Effektiv", "Virkelig effektiv apparat", elapparater);
        ProductModel elapparater3 = new ProductModel("Støvsuger", 300, "Lige til brug", "Virker 100 % som den skal", elapparater);

        //fjernsyn
        fjernsyn.getProductModels().add(fjersyn1);
        fjernsyn.getProductModels().add(fjersyn2);
        fjernsyn.getProductModels().add(fjersyn3);


        //Købeskab
        køleskabe.getProductModels().add(køleskabe1);
        køleskabe.getProductModels().add(køleskabe2);
        køleskabe.getProductModels().add(køleskabe3);

        //vin
        vin.getProductModels().add(vin1);
        vin.getProductModels().add(vin2);
        vin.getProductModels().add(vin3);
        vin.getProductModels().add(vin4);
        vin.getProductModels().add(vin5);
        vin.getProductModels().add(vin6);

        //elapparater
        elapparater.getProductModels().add(elapparater1);
        elapparater.getProductModels().add(elapparater2);
        elapparater.getProductModels().add(elapparater3);

        //Add the categories to list
        productCategoriesList.add(fjernsyn);
        productCategoriesList.add(køleskabe);
        productCategoriesList.add(vin);
        productCategoriesList.add(elapparater);

        return productCategoriesList;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("ProductCategories Refreshed");
        iCategoriesRepo.saveAll(createProductCategories());
    }
}
