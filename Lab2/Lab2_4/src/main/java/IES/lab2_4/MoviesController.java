package IES.lab2_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
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
    public String RandomQuotes(){

        ArrayList<String> quotes = getQuotes(); // get the full list of quotes

        Random rand = new Random();
        int index = rand.nextInt(quotes.size());

        return "{"+'"'+"ID"+'"'+": "+ counter.incrementAndGet() +", "+ '"'+"Random_Quote"+'"'+": "+'"'+ quotes.get(index) +'"'+"}";
    }
    @GetMapping("/api/shows")
    public String getShows() {
        HashMap<Integer, String> Show_ID = getShowId();

        StringBuilder msg = new StringBuilder();
        for (Map.Entry<Integer, String> entry : Show_ID.entrySet()) {
            int id = entry.getKey();
            String movie = entry.getValue();

            msg.append("{" + '"' + "ID" + '"' + ": ").append(id).append(", ").append('"').append("Movie").append('"').append(": ").append('"').append(movie).append('"').append("}<br>");

        }
        return msg.toString();
    }

    @GetMapping("/api/quotes")
    public String getShowById(@RequestParam(value = "show", defaultValue = "1") int id) {
        HashMap<Integer, String> id_show = getShowId();
        String show = "";
        int film_id = 1;

        for (Map.Entry<Integer, String> entry : id_show.entrySet()) {
            if (id == entry.getKey()) {
                show = entry.getValue();
                film_id = entry.getKey();
                break;
            }
        }

        if (show.equals("")) return "[ERRO]: id não encontrado";

        HashMap<String, ArrayList<String>> movies = getMovies();
        for (Map.Entry<String, ArrayList<String>> entry : movies.entrySet()) {
            if (show.equals(entry.getKey())) {
                Random rand = new Random();
                int quote_index = rand.nextInt(entry.getValue().size());

                return "{"+'"'+"Movie_ID"+'"'+": "+ film_id +", "+'"'+"Movie"+'"'+": "+ '"' + entry.getKey() + '"' + ", "+ '"'+"Quote"+'"'+": "+'"'+ entry.getValue().get(quote_index)+'"'+"}";
            }
        }
        return "";
    }

    public HashMap<String, ArrayList<String>> getMovies() {
        HashMap<String, ArrayList<String>> movies_quotes = new HashMap<>();

        movies_quotes.put("The Wizard of Oz", new ArrayList<>(List.of("There's no place like home.")));
        movies_quotes.put("Casablanca", new ArrayList<>(Arrays.asList("Here's looking at you, kid", "Louis, I think this is the beginning of a beautiful friendship", "Play it, Sam. Play 'As Time Goes By.", "Round up the usual suspects.", "We'll always have Paris.")));
        movies_quotes.put("Titanic", new ArrayList<>(List.of("I'm the king of the world!", "Jack, I'm flying!", "I'll never let go, Jack. I'll never let go.")));
        movies_quotes.put("Star Wars", new ArrayList<>(Arrays.asList("May the Force be with you.", "Try not. Do or do not. There is no try.", "In a dark place we find ourselves and a little more knowledge lights our way")));
        movies_quotes.put("Dead Poets Society", new ArrayList<>(List.of("Carpe diem. Seize the day, boys. Make your lives extraordinary.")));
        movies_quotes.put("The Adventures of Sherlock Holmes", new ArrayList<>(List.of("Elementary, my dear Watson.")));
        movies_quotes.put("Frankenstein", new ArrayList<>(List.of("It's alive! It's alive!","Nothing is so painful to the human mind as a great and sudden change.", "Beware; for I am fearless, and therefore powerful.")));
        movies_quotes.put("Forrest Gump", new ArrayList<>(List.of("My mama always said life was like a box of chocolates. You never know what you're gonna get.")));
        movies_quotes.put("Jaws", new ArrayList<>(List.of("You're gonna need a bigger boat.", "Run, Forrest! Run!", "Stupid is as stupid does.")));

        return movies_quotes;
    }
    private ArrayList<String> getQuotes() {
        HashMap<String, ArrayList<String>> movies = getMovies();
        ArrayList<String> quotes = new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry : movies.entrySet()) {
            quotes.addAll(entry.getValue());
        }
        return quotes;
    }

    public HashMap<Integer, String> getShowId() {
        HashMap<Integer, String> id_show = new HashMap<>();
        HashMap<String, ArrayList<String>> movies = getMovies();

        int id = 0;
        for (Map.Entry<String, ArrayList<String>> entry : movies.entrySet()) {
            String movie = entry.getKey();

            id_show.put(id, movie);
            id += 1;
        }

        return id_show;
    }
}
