package udemy.burns.udemy_spring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import udemy.burns.udemy_spring.repositories.AuthorRepository;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;


        //inject author repository via constructor into controller
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


            //method to handle request for authors at "/authors"
    @RequestMapping ("/authors")
        public String getAuthors(Model model){

        //add list of authors to model and return view "authors/list
        model.addAttribute("authors", authorRepository.findAll());

            return "books/authors/authorList";
    }
}
