package com.example.express.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.express.Entity.Catalogue;
import com.example.express.Entity.Livre;
import com.example.express.Repository.LivreRepository;
import com.example.express.Service.CatalogueService;

import com.example.express.dto.CatalogueDto;




@Controller
public class CatalogueController {
  @Autowired
private LivreRepository livrerepo ;
private CatalogueService catalogueService;
 private static final Logger logger = LoggerFactory.getLogger(LivreController.class);

    public CatalogueController(CatalogueService catalogueService, LivreRepository livreRepository){
        this.catalogueService = catalogueService;
        this.livrerepo=livreRepository;

    }


// Ajouter 
 @PostMapping("/cat")
    public String add(@ModelAttribute("catalogue") CatalogueDto catalogue,
                               BindingResult result,
                               Model model){

        if (result.hasErrors()) {
            model.addAttribute("catalogue", catalogue);
            return "new_catalogue";
        }
        catalogueService.saveCat(catalogue);
        return "redirect:/cat?success";
    }

      @GetMapping("/cat")
    public String addCat(Model model){
       
        CatalogueDto catalogueDto = new CatalogueDto();
       List<Livre> allLivre = livrerepo.findAll();

      
       model.addAttribute("catalogue", catalogueDto);
     
       model.addAttribute("allLivre", allLivre);
        return "new_catalogue";
    }
    

  
// list

    @GetMapping("/list_cat")
    public String list_cat(Model model){
        List<CatalogueDto> catalogue = catalogueService.findAllCatalogue();
        model.addAttribute("catalogue", catalogue);
        return "list_cat";
    }





@GetMapping("/update_cat/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Catalogue catalogue = catalogueService.getCatalogueById(id);
        List<Livre> allLivres = livrerepo.findAll();
        model.addAttribute("allLivres", allLivres);
        model.addAttribute("catalogue", catalogue);
        return "update_cat";
    }
   
    @PostMapping("/update_cat")
    public String update_cat(@ModelAttribute("catalogue") CatalogueDto updat, @RequestParam(name = "selectedLivre", required = false) List<Long> selectedLivre, RedirectAttributes redirectAttributes) {
        Long id = updat.getId();
        updat.setLivreId(selectedLivre);
        catalogueService.updateCat(id, updat);
        redirectAttributes.addFlashAttribute("updateSuccess", true);
        return "redirect:/list_cat";
    }

    @GetMapping("/deletecat/{id}")
    public String deletecat(@PathVariable (value = "id") long id) {
     
    
     this.catalogueService.deleteCat(id);
     return "redirect:/list_cat";
    }
}

   