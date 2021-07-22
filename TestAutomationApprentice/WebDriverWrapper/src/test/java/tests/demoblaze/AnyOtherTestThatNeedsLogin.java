package tests.demoblaze;

import org.apache.commons.logging.Log;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class AnyOtherTestThatNeedsLogin {

    private WebDriver driver;

    public AnyOtherTestThatNeedsLogin() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

    }

    @Test
    public void CookieLogin() {
        Cookie cookie = new Cookie("tokenp_", "dGVhY2h5dGVjaGllMTYyNzU3MQ==");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        driver.manage().addCookie(cookie);
    }

    @Test
    public void LoginWithHttpCallAndCookie() throws IOException {

        // create default http client
        CloseableHttpClient client = HttpClients.createDefault();
        // make login http post call to demoblaze website
        HttpPost httpPost = new HttpPost("https://api.demoblaze.com/login");
        // prepare json request body data - login and password (after encryption here)
        httpPost.setEntity(new StringEntity("{ \"username\": \"teachytechie\", \"password\": \"cXdlcnR5\" }"));
        httpPost.setHeader("Content-type", "application/json");
        // execute the requests and cut the token out of the response
        CloseableHttpResponse response = client.execute(httpPost);
        String content = EntityUtils.toString(response.getEntity());
        String authToken = content.split(" ")[1].replace("\"\n","");
        client.close();

        // authToken is our access cookie! So add cookie once again
        Cookie cookie = new Cookie("tokenp_", authToken);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}
