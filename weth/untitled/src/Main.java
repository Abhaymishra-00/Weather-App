import java.net.*;
import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        String apiKey = "6OyKk6uMYNjZGPnSzbajLp5rN17Msz8b";
        String[] cities = {"New York", "London", "Paris", "Tokyo", "Sydney"};
        Random random = new Random();
        String location = cities[random.nextInt(cities.length)];
        URL url = new URL("https://api.tomorrow.io/v4/timelines?location=" + location + "&fields=temperature&timesteps=1h&apikey=" + apiKey);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("Weather forecast for " + location + ":");
        System.out.println(response.toString());
    }
}