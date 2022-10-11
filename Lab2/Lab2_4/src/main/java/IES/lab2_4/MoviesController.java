package IES.lab2_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MoviesController {
    private static final String template = "Welcome, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/api")
    public Movies greeting(@RequestParam(value = "name", defaultValue = "Pjnp5") String name){
        return new Movies(counter.incrementAndGet(), String.format(template,name));
    }

    @GetMapping("/api/quote")
    public String RandomQuotes(@RequestParam(value = "name", defaultValue = "Pjnp5") String name){

        ArrayList<String> quotes = getQuotes(); // get the full list of quotes

        Random rand = new Random();
        int index = rand.nextInt(quotes.size());

        return "{"+'"'+"ID"+'"'+": "+ counter.incrementAndGet() +", "+ '"'+"Random_Quote"+'"'+": "+'"'+ quotes.get(index)+'"'+"}";
    }

    private ArrayList<String> getQuotes() {
    }
}
