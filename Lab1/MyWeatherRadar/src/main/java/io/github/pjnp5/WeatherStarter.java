package io.github.pjnp5;

import io.github.pjnp5.ipma_client.CityForecast;
import io.github.pjnp5.ipma_client.IpmaCityForecast;
import io.github.pjnp5.ipma_client.IpmaService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //todo: should generalize for a city passed as argument
    private static final int CITY_ID_AVEIRO = 1010500;
    private static Logger logger = LogManager.getLogger(WeatherStarter.class);

    public static void  main(String[] args ) {
        int city_name ;
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");

        try {
            city_name = Integer.parseInt(args[0]);
            logger.info("User gived a correct argument");
        } catch (Exception e) {
            logger.info("User did not give a correct argument");
            System.out.println("No city ID provided\nExample: 1010500\n");
            Scanner scan = new Scanner(System.in);  // Create a Scanner object
            System.out.println("City ID: ");
            city_name = scan.nextInt();  // Read user input
            System.out.println("City ID is: " + city_name);  // Output user input
            logger.info("Received good input");
        }


        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        logger.info("Calling API");
        Call<IpmaCityForecast> callSync = service.getForecastForACity(city_name);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                CityForecast firstDay = forecast.getData().listIterator().next();
                logger.info("Printing info");
                System.out.printf( "max temp for %s is %4.1f %n",
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()));
            } else {
                logger.error("No results found");
                System.out.println( "No results for this request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.info("Ending...");
    }
}
