package com.example.express.Controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.express.Entity.Categorie;
import com.example.express.Entity.Livre;
import com.example.express.Repository.CategorieRepository;
import com.example.express.Service.CategorieServiceImpl;
import com.example.express.Service.LivreService;
import com.example.express.dto.LivreDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class LivreController {



      private LivreService livreService;
   
    @Autowired
    private CategorieRepository categorieRepository;
    private CategorieServiceImpl categorieService;

    private static final Logger logger = LoggerFactory.getLogger(LivreController.class);

    public LivreController(LivreService livreService, CategorieRepository categorieRepository){
        this.livreService = livreService;
        this.categorieRepository=categorieRepository;

    }

 

      @GetMapping("/list")
    public String listlivre(Model model) {
        List<LivreDto> livre;

     
            livre = livreService.findAllLivre();
        
        model.addAttribute("livre", livre);
       
        return "list";
    }

    //@PreAuthorize("hasRole('BIBLIOTHECAIRE')")
     @RequestMapping(value = "/list/{id}", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String  deleteBook(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
    // delete book from DB
        livreService.deleteLivre(id);
        redirectAttributes.addFlashAttribute("deleteSuccess", true);
        return "redirect:/list";
    }

  //  @PreAuthorize("hasRole('BIBLIOTHECAIRE')")
    @PostMapping("/livre")
    public String add(@ModelAttribute("livre") LivreDto livre,
                               BindingResult result,
                               Model model){

        if (result.hasErrors()) {
            model.addAttribute("livre", livre);
            return "new_livre";
        }
        livreService.saveLivre(livre);
        return "list";
    }
    //@PreAuthorize("hasRole('BIBLIOTHECAIRE')")
    @GetMapping("/livre")
    public String addlivre(Model model){
        LivreDto livreDto = new LivreDto();
        List<Categorie> allCategories = categorieRepository.findAll();
        model.addAttribute("allCategories", allCategories);
        model.addAttribute("livre", livreDto);
        return "new_livre";
    }

    @GetMapping("/update_livre/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        System.out.println("hello");
        Livre livre = livreService.getLivreById(id);
        List<Categorie> allCategories = categorieService.getAllCategories();
        model.addAttribute("livre", livre);
        model.addAttribute("allCategories", allCategories);
        return "update_livre";
    }
    //@PreAuthorize("hasRole('BIBLIOTHECAIRE')")
    @PostMapping("/updatelivre")
    public String updatelivre(@ModelAttribute("livre") LivreDto updatedBook, @RequestParam(name = "selectedCategories", required = false) List<Long> selectedCategories, RedirectAttributes redirectAttributes) {
       
        Long id = updatedBook.getId();
        updatedBook.setCategorieIds(selectedCategories);
        livreService.updateBook(id, updatedBook);
        redirectAttributes.addFlashAttribute("updateSuccess", true);
        return "list";
    }


}