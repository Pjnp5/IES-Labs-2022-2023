package IES.Lab3_3.Controller;

import IES.Lab3_3.Service.ProductQuote;
import IES.Lab3_3.Service.QuoteService;
import IES.Lab3_3.model.Movie;
import IES.Lab3_3.model.NewQuote;
import IES.Lab3_3.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
    @Autowired
    private QuoteService Quoteservice;

    @Autowired
    private ProductQuote MovieService;


    @PostMapping("/addQuote")
    public Quote newQuotes(@RequestBody NewQuote m) {
        return Quoteservice.saveQuote(new Quote (m.getQuote(),MovieService.getMovieById(m.getShowId())));
    }


    @GetMapping("/quote")
    public Quote findAllQuotes() {
        List<Quote> a = Quoteservice.getQuotes();
        Quote ret;
        if (a.size() >0 ){
            Random r = new Random();
            int result = r.nextInt(a.size());
            ret = a.get(result);
        }
        else{
            ret = new Quote();
        }
        return ret;
    }

    @GetMapping("/quotes")
    public Quote findQuoteById(@RequestParam(value = "show")  int id) {
        List<Quote> a = Quoteservice.getQuotes();
        List<Quote> rets= new ArrayList<>();
        for (Quote qu: a){
            if (qu.getOrder().getId() == id ){
                rets.add(qu);
            }
        }
        Random r = new Random();
        int result = r.nextInt(rets.size());
        return rets.get(result);
    }



    @PutMapping("/updateQuote")
    public Quote updateQuote(@RequestBody Quote product) {
        return Quoteservice.updateQuote(product);
    }


    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie m) {
        return MovieService.saveMovie(m);
    }



    @GetMapping("/shows")
    public List<Movie> findAllMovies() {
        return MovieService.getMovies();
    }





    @PutMapping("/update")
    public Movie updateProduct(@RequestBody Movie product) {
        return MovieService.updateMovie(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id) {
        return MovieService.deleteMovie(id);
    }
}
