package RHAcademyTests;

import Projekat.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class AutomationPracticeTests {
    public static void main(String[] args) {
    }

    private static WebDriver driver;
    private static SoftAssert sa;

    @BeforeSuite
    public void setProperties() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Misa i Sneza\\Downloads\\!IT BOOTCAMP\\7. SELENIJUM\\chromedriver.exe");
    }

    @BeforeMethod
    public void setDriver() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Test
    public void checkRadio() {
        driver.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[1]/input[1]")).click();
        System.out.println(driver.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[1]/input[1]")).isSelected()); // return true
        Assert.assertTrue(driver.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[1]/input[1]")).isSelected());
        driver.close();
    }

    @Test
    public void checkDropDown() {
        Assert.assertEquals(driver.findElement(By.xpath("//option[contains(text(),'Option1')]")).getText(), "Option1");
        System.out.println(driver.findElement(By.xpath("//option[contains(text(),'Option1')]")).getText());  // return "Option1"
        driver.close();
    }


}

