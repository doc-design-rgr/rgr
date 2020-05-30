package com.rgr.project.webapp.controller;

;
import com.rgr.project.webapp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.rgr.project.entity.CustomerEntity;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class BouquetController {

    @PostMapping("/boquet/new")
    public String addNewBouquet(@ModelAttribute("newBouquet") NewBouquetModel newBouquetModel) {
        BouquetRepository bouquetRepository = findBouquetRepository(newBouquetModel.getRepository());
        BouquetRepository.addBouquet(newBouquetModel.getBouquet());
        return "redirect:/login";
    }

    private BouquetRepository findBouquetRepository(String repositoryName) {
        if (repositoryName.equals("From Catalog")) {
            return new CatalogBouquetRepository();
        }

        if(repositoryName.equals(("Your custom bouquet")){
            return new CustomBouquetRepository();
        }

        throw new IllegalArgumentException(String.format("Find no repository for given repository name [%s]", repositoryName));
    }
}
