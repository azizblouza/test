package com.vermeg.bookstore_springboot.controllers;

import com.vermeg.bookstore_springboot.entities.Categorie;
import com.vermeg.bookstore_springboot.entities.Livre;
import com.vermeg.bookstore_springboot.repository.CategorieRepository;
import com.vermeg.bookstore_springboot.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/livre/")
public class LivreController {

    private final LivreRepository livreRepository;
    private final CategorieRepository categorieRepository;
    public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";

    @Autowired
    public LivreController(LivreRepository livreRepository, CategorieRepository categorieRepository) {
       this. livreRepository = livreRepository;
        this.categorieRepository = categorieRepository;
    }
    @GetMapping("list")
    public String listArticles(Model model) {
        List<Livre> l = (List<Livre>) livreRepository.findAll();
        if (l.size() == 0)
            l = null;
        model.addAttribute("providers", categorieRepository.findAll());
        model.addAttribute("livres", l);
        return "livre/listLivre";
    }
    @GetMapping("add")
    public String showAddArticleForm(Livre article, Model model) {
        model.addAttribute("article", new Livre());
        model.addAttribute("categorie", categorieRepository.findAll());
        return "livre/ajouterLivre";
    }

    @PostMapping("add")
    public String addArticle(@Valid Livre livre, BindingResult result,
                             @RequestParam(name = "categorieId", required = false) int p,
                             @RequestParam("files") MultipartFile[] files) {

        Categorie categorie = categorieRepository.findById(p)
                .orElseThrow(() -> new IllegalArgumentException("Invalid categorie Id:" + p));
        livre.setCategorie(categorie);
        /// part upload
        StringBuilder fileName = new StringBuilder();
        MultipartFile file = files[0];
        Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, file.getBytes()); //upload
        } catch (IOException e) {
            e.printStackTrace();
        }
        livre.setImg(fileName.toString());

        livreRepository.save(livre);
        return "redirect:list";
        // return article.getLabel() + " " +article.getPrice() + " " + p.toString();
    }
    @GetMapping("delete/{id}")
    public String deleteProvider(@PathVariable("id") int id, Model model) {
        Livre livre = livreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid livre Id:" + id));
        livreRepository.delete(livre);
        return "redirect:../list";
    }

    @GetMapping("edit/{id}")
    public String showBookFormToUpdate(@PathVariable("id") int id, Model model) {
        Livre livre = livreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("livre", livre);
        model.addAttribute("categorie", categorieRepository.findAll());
        model.addAttribute("idCategorie", livre.getCategorie().getId_categorie());
        return "livre/modifierLivre";
    }
    @PostMapping("modifier")
    public String updateBook(@Valid Livre livre, BindingResult result, Model model,
    @RequestParam(name = "categorieId", required = false) int p) {
        if (result.hasErrors()) {
            return "livre/modifierLivre";
        }
        Categorie categorie = categorieRepository.findById(p)
                .orElseThrow(() -> new IllegalArgumentException("Invalid provider Id:" + p));
        livre.setCategorie(categorie);
        livreRepository.save(livre);
        return "redirect:list";
    }
}

