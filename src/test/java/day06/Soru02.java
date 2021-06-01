package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Soru02 {
    public static void main(String[] args) {
    /*
        1. http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3. Login alanine “username” yazdirin
        4. Password alanine “password” yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Bills sayfasina gidin
        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin 8. tarih kismina “2020-09-10”
        9. Pay buttonuna tiklayin
        10. “The payment was successfully submitted.” mesajinin ciktigini control edin
    */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.id("signin_button")).click();
        WebElement userNameKutusu = driver.findElement(By.id("user_login"));
        userNameKutusu.sendKeys("username");
        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        driver.findElement(By.linkText("Pay Bills")).click();
        WebElement amountKutusu = driver.findElement(By.id("sp_amount"));
        amountKutusu.sendKeys("1000");
        WebElement dateKutusu = driver.findElement(By.id("sp_date"));
        dateKutusu.sendKeys("2020-09-10");
        driver.findElement(By.id("pay_saved_payees")).click();
        WebElement onayMesajiWE = driver.findElement(By.xpath("//span[@title='$ 1000 payed to payee sprint']"));
        String onayMesaji = onayMesajiWE.getText();
        System.out.println("ONAY MESAJI\n");
        if (!onayMesaji.equals("The payment was successfully submitted.")) {
            System.out.println("istenilen onay mesaji cikmamistir. \nDogrusu: "+onayMesaji+" olmalidir.\nFAILD");
        } else{
            System.out.println(onayMesaji+"\nPASS");
        }
        driver.close();
    }
}
