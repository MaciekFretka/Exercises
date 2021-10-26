import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SecondMethod {
    public static void main(String[] args) {
        //Method 2: java.net.http.HttpClient
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("https://jsonplaceholder.typicode.com/albums");
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(SecondMethod::parse)
                .join();

    }
    public static String parse(String responseBody){
        JSONArray albums = new JSONArray(responseBody);
        for(int i=0; i<albums.length();i++){
            JSONObject album = albums.getJSONObject(i);
            int id = album.getInt("id");
            int userId= album.getInt("userId");
            String title = album.getString("title");
            System.out.println(id+" "+title+" "+userId);
        }
    return null;
    }
}
