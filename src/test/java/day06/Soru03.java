package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Soru03 {
    public static void main(String[] args) {
        /*
            1. “https://www.saucedemo.com” Adresine gidin
            2. Username kutusuna “standard_user” yazdirin
            3. Password kutusuna “secret_sauce” yazdirin
            4. Login tusuna basin
            5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
            6. Add to Cart butonuna basin
            7. Alisveris sepetine tiklayin
            8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
            9. Sayfayi kapatin
        */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        WebElement usernameKutusu = driver.findElement(By.id("user-name"));
        usernameKutusu.sendKeys("standard_user");
        WebElement passwordKutusu = driver.findElement(By.id("password"));
        passwordKutusu.sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement ilkUrunWE = driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]"));
        String ilkUrun = ilkUrunWE.getText();
        ilkUrunWE.click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        WebElement sepettekiUrunWE = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String sepettekiUrun = sepettekiUrunWE.getText();
        System.out.println("Sepete Dogru Ürün Mü Eklendi?");
        if (ilkUrun.equals(sepettekiUrun)) {
            System.out.println("PASS\nÜrün adi: "+sepettekiUrun);
        } else{
            System.out.println("FAILD\nSepette olmasi gereken ürünün adi: "+ilkUrun);
        }
        driver.close();
    }
}
