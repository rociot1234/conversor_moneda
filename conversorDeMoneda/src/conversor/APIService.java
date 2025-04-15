package conversor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class APIService {
    private static final String API_KEY = "e73273d2e9a7111a1d21a0e0";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double obtenerTasaCambio(String base, String destino) {
        try {
            URL url = new URL(API_URL + base);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = in.readLine()) != null) {
                contenido.append(linea);
            }

            in.close();
            con.disconnect();

            Gson gson = new Gson();
            ExchangeRatesResponse response = gson.fromJson(contenido.toString(), ExchangeRatesResponse.class);

            return response.conversion_rates.get(destino);

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return -1;
        }
    }
}

