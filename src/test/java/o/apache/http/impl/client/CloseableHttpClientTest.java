package o.apache.http.impl.client;

import com.github.andriell.processor.ProcessHTTPData;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CloseableHttpClientTest {

    public static void main(String[] args) throws Exception {
        CloseableHttpClientTest test = new CloseableHttpClientTest();
        test.test1();
        test.test2();
    }

    @Test
    public void test1() {

        try {
            org.apache.http.impl.client.CloseableHttpClient httpclient = HttpClients.createDefault();
            ProcessHTTPData httpGet = new ProcessHTTPData("http://ya.ru");
            CloseableHttpResponse response1 = httpclient.execute(httpGet);

            try {
                Header[] headers = httpGet.getAllHeaders();
                System.out.println("REQUEST HEADERS");
                for (Header header:headers) {
                    System.out.println(header);
                }

                System.out.println("StatusLine " + response1.getStatusLine());

                headers = response1.getAllHeaders();
                System.out.println("RESPONSE HEADERS");
                for (Header header:headers) {
                    System.out.println(header);
                }

                HttpEntity entity1 = response1.getEntity();
                System.out.println("Body " + EntityUtils.toString(entity1));
                EntityUtils.consume(entity1);

                EntityUtils.consume(entity1);
            } finally {
                response1.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test2() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // Create a local instance of cookie store
            CookieStore cookieStore = new BasicCookieStore();

            // Create local HTTP context
            HttpClientContext localContext = HttpClientContext.create();
            // Bind custom cookie store to the local context
            localContext.setCookieStore(cookieStore);

            HttpGet httpget = new HttpGet("http://ya.ru");
            System.out.println("Executing request " + httpget.getRequestLine());

            // Pass local context as a parameter
            CloseableHttpResponse response = httpclient.execute(httpget, localContext);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                List<Cookie> cookies = cookieStore.getCookies();
                for (int i = 0; i < cookies.size(); i++) {
                    System.out.println("Local cookie: " + cookies.get(i));
                }
                EntityUtils.consume(response.getEntity());
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}
