package RHAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandlingMultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Misa i Sneza\\Downloads\\!IT BOOTCAMP\\7. SELENIJUM\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        Thread.sleep(1000);
        Set<String> pc = driver.getWindowHandles();
        Iterator<String> it = pc.iterator();

        String childid = it.next();
        String parentid = it.next();

        driver.switchTo().window(childid);
        System.out.println(driver.getTitle());  // print title from child window
        driver.close();
        driver.switchTo().window(parentid);
        System.out.println(driver.getTitle());  // print title from parent window
        driver.close();
    }
}
