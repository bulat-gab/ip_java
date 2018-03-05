import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequestSample {

    public static void main(String[] args) throws IOException {
	// write your code here
        URL url = new URL("https://www.google.ru/search?q=stc&oq=stc");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = connection.getResponseCode();
        //connection.getContent();
        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            String temp;

            while((temp = reader.readLine()) != null){
                System.out.println(temp);
            }

            reader.close();
        }
    }
}
