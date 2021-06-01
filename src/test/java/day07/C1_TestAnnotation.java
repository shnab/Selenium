package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C1_TestAnnotation {

    WebDriver driver; //bu variable oldugu icin class seviyesinde kullandik. Instance variable

    @Test //alt+enter ==> import eder ==> main methoda gerek kalmiyor
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //implicitlyWait eger 1. saniyede acilirsa 15 sn beklemez
        //ama thread.sleep (3000) bu kadar bekler
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test02() throws InterruptedException {
        WebDriverManager.chromedriver().setup();// bu variable degil. clsass seviyesine koyamayiz
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.techproeducation.com");
        Thread.sleep(3000);
        driver.close();
    }


    @Test
    public void test03() throws InterruptedException {
        WebDriverManager.chromedriver().setup();// bu variable degil. clsass seviyesine koyamayiz
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        Thread.sleep(5000);
        driver.close();

    }
}
