package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait().
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

       WebElement aramaButon = driver.findElement(By.id("twotabsearchtextbox"));
        aramaButon.sendKeys("Samsung headphones" + Keys.ENTER);
        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisiWebElement = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYazisiWebElement.getText()); //1-16 of 193 results for

        //sadece sonuc sayisini istersek sonuc sayisini Stringe atayip string manpulation yapabiliriz

    //ILK urune tiklayalim
        Thread.sleep(5000);
       driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

       //geri giderek arama ssayfasindaki tum basliklari yazdiralim
        driver.navigate().back();
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        for(WebElement each : basliklarListesi){
            System.out.println(" Baslilar listesi " + each.getText());
        }

        //basliklarListesi.stream().forEach(x-> System.out.println(x.getText()));

        driver.close();
    }

}
