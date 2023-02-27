package udemy.burns.udemy_spring.controller;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import udemy.burns.udemy_spring.repositories.BookRepository;


//annotate controller class with @Controller
//this will register the class as a Spring Bean and as a Controller in Spring MVC
//To map methods to http request paths use @Request Mapping
@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
@RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}
