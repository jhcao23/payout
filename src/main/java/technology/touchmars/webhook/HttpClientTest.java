package technology.touchmars.webhook;

import com.paypal.http.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.Iterator;

public class HttpClientTest {
    
    public static final String LINE_SEP = System.getProperty("line.separator");

    public void init() {
        try {
//            URL url = new URL("http://www.google.com");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            con.setRequestMethod("GET");
//            int code = con.getResponseCode();
//            String result = con.getContent().toString();
//            System.out.println(code);
//            System.out.println(result);

            Environment env = () -> "https://developer.paypal.com/";
            HttpClient client = new HttpClient(env);
            HttpRequest<String> req = new HttpRequest<String>("/docs", "GET", String.class);
            HttpResponse<String> resp = client.execute(req);
            Integer statusCode = resp.statusCode();
            Headers headers = resp.headers();
            String responseData = resp.result();
            StringBuilder sb = new StringBuilder();
            sb.append(statusCode).append(LINE_SEP);
            if (headers!=null)
                headers.forEach( key -> {
                    if (key!=null)
                        sb.append(key.trim()).append("=").append(headers.header(key).trim()).append(LINE_SEP);
                } );
            sb.append(LINE_SEP).append(responseData);
            System.out.println(sb.toString());

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        HttpClientTest t = new HttpClientTest();
        t.init();
    }
}
