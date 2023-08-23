import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RegistrationTest {

    //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/register.py;
    //2. Ввести ZipCode;
    //3. Нажать на кнопку "Продолжить";
    //4. Заполнить поле "First Name";
    //5. Заполнить поле "Email";
    //6. Заполнить поле "Password";
    //7. Заполнить поле "Confirm Password";
    //8. Нажать на кнопку "Регистрация";
    //9. Проверить сообщение.



    @Test
    public void verifySuccessfulRegistrationPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Alex");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("alexleo@gmail.com");
        driver.findElement(By.xpath("//input[@name = 'password1']")).sendKeys("KV12345");
        driver.findElement(By.xpath("//input[@name = 'password2']")).sendKeys("KV12345");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String message = driver.findElement(By.xpath("//span[@class='confirmation_message']")).getText();
        Assert.assertEquals(message,"Account is created!", "Сообщение неккоректное");
    }


}
