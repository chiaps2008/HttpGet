import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGet {

    private String query_string;
    private String host;

    private String data;
    private String charset = "UTF-8";
    private String metodo = "GET";
    private String type = "application/json";

    private URL server;
    private HttpURLConnection service;
    private BufferedReader input;
    private int status = 1000;
    private String line;

    public HttpGet(String query_string, String host) {
        this.query_string = query_string;
        this.host = host;
    }

    public String getData() {
        return data;
    }

    int esegui(){
        try{
            //Costruzione del URL di interrogazione
            // del webservice
            server = new URL(query_string);
            service = (HttpURLConnection) server.openConnection();
            // inizializzare intestazione del socket
            service.setRequestProperty("Host", host);
            service.setRequestProperty("Accept", type);
            service.setRequestProperty("Accept-Charset", charset);
            // Assegno il metodo
            service.setRequestMethod(metodo);
            //attivo la ricezione
            service.setDoInput(true);
            //stabilisco connessione
            service.connect();
            // verifico stato della risposta
            status = service.getResponseCode();
            if(status != 200){
                throw new Exception();
            }
            input = new BufferedReader(new InputStreamReader(service.getInputStream(), charset));
            data = "";
            while((line = input.readLine()) != null){
                data += line;
            }
            input.close();

        }catch (Exception e){
            return status;
        }
        return status;
    }
}
