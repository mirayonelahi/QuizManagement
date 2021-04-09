package softeng.project.main.model;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/");
        driver.findElement(By.linkText("Yes, I'm Ready!")).click();
        WebElement inputField = driver.findElement(By.id("nameInput"));
        Thread.sleep(1000);
        inputField.sendKeys("ayon elahi");

        inputField.submit();


        Thread.sleep(5000);
        driver.quit();
    }

}