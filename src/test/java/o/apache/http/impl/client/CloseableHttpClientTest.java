package o.apache.http.impl.client;

import com.github.andriell.nashorn.http.*;
import com.github.andriell.nashorn.http.HttpResponse;
import org.apache.http.*;
import org.apache.http.HttpRequest;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class CloseableHttpClientTest {

    public static void main(String[] args) throws Exception {
        CloseableHttpClientTest test = new CloseableHttpClientTest();
        //test.test1();
        test.test2();
    }

    @Test
    public void test1() {

        try {
            com.github.andriell.nashorn.http.HttpRequest httpRequest = new com.github.andriell.nashorn.http.HttpRequest();
            RequestBuilder requestBuilder = httpRequest.get("http://ya.ru");

            HttpClient httpClient = new HttpClient();
            HttpResponse httpResponse = httpClient.execute(requestBuilder);


            Header[] headers = httpResponse.getResponse().getAllHeaders();
            System.out.println("REQUEST HEADERS");
            for (Header header:headers) {
                System.out.println(header);
            }

            System.out.println("StatusLine " + httpResponse.getResponse().getStatusLine());

            headers = httpResponse.getResponse().getAllHeaders();
            System.out.println("RESPONSE HEADERS");
            for (Header header:headers) {
                System.out.println(header);
            }

            HttpEntity entity1 = httpResponse.getResponse().getEntity();
            System.out.println("Body " + EntityUtils.toString(entity1));
            EntityUtils.consume(entity1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CloseableHttpClient httpclient;
    private HttpClientContext localContext;
    private CookieStore cookieStore;


    public void test2() throws Exception {
        httpclient = HttpClients.createDefault();
        try {
            // Create a local instance of cookie store
            cookieStore = new BasicCookieStore();
            cookieStore.clear();

            // Create local HTTP context
            localContext = HttpClientContext.create();
            // Bind custom cookie store to the local context
            localContext.setCookieStore(cookieStore);

            CloseableHttpResponse response = null;
            for (int i = 0; i < 2; i++) {
                HttpGet httpGet = new HttpGet("http://ya.ru");
                System.out.println("Executing request " + httpGet.getRequestLine());

                // Pass local context as a parameter
                response = httpclient.execute(httpGet, localContext);
                org.apache.http.HttpResponse httpResponse = localContext.getResponse();
                HttpRequest httpRequest = localContext.getRequest();

                Header[] headers;

                System.out.println("---Request-------------------------------------");
                headers = httpRequest.getAllHeaders();
                for (Header header:headers) {
                    System.out.println(header);
                }

                System.out.println("---Response-------------------------------------");
                headers = httpResponse.getAllHeaders();
                for (Header header:headers) {
                    System.out.println(header);
                }
            }

            response.close();

        } finally {
            httpclient.close();
        }
    }
}
