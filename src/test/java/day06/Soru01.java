package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Soru01 {
    /*
    1-Test01 isimli bir class olusturun
    2- https://www.walmart.com/ adresine gidin
    3- Browseri tam sayfa yapin
    4-Sayfayi “refresh” yapin
    5- Sayfa basliginin title “Save” ifadesi icerdigini control edin
    6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
    7- URL in walmart.com icerdigini control edin
    8-”Nutella” icin arama yapiniz
    9- Kac sonuc bulundugunu yaziniz
    10-Sayfayi kapatin

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       //2
        driver.get("https://www.walmart.com/");
        //3
        driver.manage().window().maximize();
        //4
        driver.navigate().refresh();
        //5Sayfa basliginin title “Save” ifadesi icerdigini control edin
        String getTitle = driver.getTitle();
        if(getTitle.contains("Save")){
            System.out.println("Baslik Save iceriyor, test PASS");
        }else{
            System.out.println("Baslikta Save yok. TEST FAILED");
        }
        //6Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        if(getTitle.equals("Walmart.com | Save Money.Live Better")){
            System.out.println("Baslik verilen degere esit,test PASS");
        }else{
            System.out.println("Baslik verilen degere esit degil,TEST FAILED");
            System.out.println("current title: " +getTitle);
        }
        //7- URL in walmart.com icerdigini control edin
       String currentURL=  driver.getCurrentUrl();
        if(currentURL.contains("walmart.com")){
            System.out.println("URL walmart.com iceriyor,test PASS");
        }else{
            System.out.println("URL walmart.com icermiyor,TEST FAILED");
            System.out.println("current URL" + currentURL);
        }

        //8-”Nutella” icin arama yapiniz
       WebElement aramaButon = driver.findElement(By.xpath("//input[@placeholder='Search Walmart.com']"));
        aramaButon.sendKeys("Nutella" + Keys.ENTER);

        // 9- Kac sonuc bulundugunu yaziniz

       // 10-Sayfayi kapatin


    }
}
