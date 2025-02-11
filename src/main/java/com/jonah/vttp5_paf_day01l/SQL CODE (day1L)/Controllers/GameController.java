package com.jonah.vttp5_paf_day01l.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jonah.vttp5_paf_day01l.Models.Book;
import com.jonah.vttp5_paf_day01l.Models.Game;
import com.jonah.vttp5_paf_day01l.Services.GameService;

@Controller
@RequestMapping("")
public class GameController {
    @Autowired
    GameService gameService;
    
    @GetMapping("/games")
    public ModelAndView getGames(@RequestParam(defaultValue = "5") int count){
        ModelAndView mav = new ModelAndView("games");
        List<Game> games = gameService.getGames();
        mav.addObject("games", games);
        return mav;
    }

    @GetMapping("/gameslimit")
    public ModelAndView getGamesLimit(@RequestParam(defaultValue = "5") int count){
        ModelAndView mav = new ModelAndView("games");
        List<Game> games = gameService.getGamesLimit(count);
        mav.addObject("games", games);
        return mav;
    }



    @GetMapping("/search")
    public ModelAndView getSearch(){
        ModelAndView mav = new ModelAndView("search");
        gameService.printAuthors(4.5f);
        
        return mav;
    }


    @GetMapping("/book")
    public ModelAndView getBooks(){
        ModelAndView mav = new ModelAndView("books");
        List<Book> listOfBooks = gameService.getBooks();

        mav.addObject("books", listOfBooks);
        return mav;
    }

    @GetMapping("/searchbooks")
    public ModelAndView getSearchBooks(@RequestParam(defaultValue = "10") int count,@RequestParam String author){
        ModelAndView mav = new ModelAndView("books");
        List<Book> listOfBooks = gameService.getBookSearch(author, count);
        mav.addObject("books", listOfBooks);
        return mav;
    }

    @GetMapping("/bookdetail/{asin}")
    public ModelAndView getBookWithAsin(@PathVariable("asin") String asin){
        ModelAndView mav = new ModelAndView("bookdetail");
        Book book = gameService.getBookFromAsin(asin);
        mav.addObject("book", book);
        System.out.println("Book is" + book.getTitle());
        return mav;
    }
} 
    
    
