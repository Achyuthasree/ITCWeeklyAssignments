package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FormTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
    }

    @Test
    public void fillForm() {
        // Text fields
        driver.findElement(By.name("firstname")).sendKeys("Ravi");
        driver.findElement(By.name("lastname")).sendKeys("Kumar");

        // Radio buttons
        driver.findElement(By.id("sex-0")).click(); // Male
        driver.findElement(By.id("exp-2")).click(); // 3 years experience

        // Date
        driver.findElement(By.id("datepicker")).sendKeys("01-01-2024");

        // Checkboxes
        driver.findElement(By.id("profession-1")).click(); // Automation Tester
        driver.findElement(By.id("tool-2")).click();       // Selenium Webdriver

        // Dropdowns
        WebElement continent = driver.findElement(By.id("continents"));
        continent.findElement(By.xpath("//option[text()='Asia']")).click();

        WebElement commands = driver.findElement(By.id("selenium_commands"));
        commands.findElement(By.xpath("//option[text()='Browser Commands']")).click();

        // Submit
        driver.findElement(By.id("submit")).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
