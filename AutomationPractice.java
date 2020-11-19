package RHAcademy;

import Projekat.Home;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Misa i Sneza\\Downloads\\!IT BOOTCAMP\\7. SELENIJUM\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);  // OR implicitlyWait(10, TimeUnit.SECONDS)
        System.out.println(driver.getTitle());


        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click(); // check Checkbox button
        System.out.println(driver.findElement(By.xpath ("//input[@id='checkBoxOption1']")).isSelected()); // return true
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click(); // uncheck Checkbox button
        System.out.println(driver.findElement(By.xpath ("//input[@id='checkBoxOption1']")).isSelected()); // return false


        String text="Snezana";
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();                      //POP - UP accept alert by clicking OK
        Thread.sleep(2000);
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();                    // POP - UP if you wants to click CANCEL


        Select s = new Select (driver.findElement(By.cssSelector("#dropdown-class-example")));
        s.selectByVisibleText("Option1");  //dropDown button
        Thread.sleep(2000);


        driver.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[1]/input[1]")).click(); // check Radio buttom
        System.out.println(driver.findElement(By.xpath ("//body/div[1]/div[1]/fieldset[1]/label[1]/input[1]")).isSelected()); // return true
        Thread.sleep(2000);


        driver.findElement(By.id("autocomplete")).sendKeys("Ja");
        Thread.sleep(2000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
//        for(int i=0;i<options.size(); i++) {
//            String text = options.get(i).getText();
//            if(text.equals("Japan")) {
//                options.get(i).click();
//                System.out.println(text);
//                break;
//            }
//        }
        for(WebElement option :options) {
            if(option.getText().equalsIgnoreCase("Japan")){  //enter country in the filed
                System.out.println(option.getText());
                option.click();
                break;
            }
        }
//        String country="Japan";  // one more way to enter country in the filed
//        driver.findElement(By.cssSelector("#autocomplete")).sendKeys(country);
//        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#openwindow")).click(); // open new Window
        Thread.sleep(2000);


        driver.findElement(By.cssSelector("#opentab")).click(); // open Tab
        Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();     // close new tab
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(2000);


        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);

        WebElement mouseHover = driver.findElement(By.xpath("//button[@id='mousehover']"));  // mouse hover button
        a.moveToElement(mouseHover).build().perform();
        Thread.sleep(2000);
        WebElement top = driver.findElement(By.xpath("//a[@href='#top']"));
        top.click();
        Thread.sleep(2000);

        driver.quit();

}

}