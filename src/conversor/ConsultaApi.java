package conversor;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaApi {

    private final String apiKey;

    public ConsultaApi() {
        this.apiKey = cargarApiKey();
    }

    private String cargarApiKey() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
            String key = props.getProperty("EXCHANGE_API_KEY");
            if (key == null || key.isBlank()) {
                throw new RuntimeException("La API key no está configurada en config.properties");
            }
            return key;
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo config.properties", e);
        }
    }

    public Conversion convertirMoneda(String base, String destino, float cantidad) {

        String cantidadFormateada = String.format(java.util.Locale.US, "%.2f", cantidad);

        URI direccion = URI.create(
                String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%s",
                        apiKey, base, destino, cantidadFormateada)
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo convertir la moneda", e);
        }
    }
}
