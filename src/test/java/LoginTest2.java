import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class LoginTest2 {

    //1. Открыть браузер на странице https://www.sharelane.com/cgi-bin/main.py;
    //2. Заполнить поле "Email";
    //3. Заполнить поле "Password";
    //4. Нажать на кнопку "Login";
    //5. Проверить сообщение.



    @Test
    public void verifyNotCorrectLoginPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys("alexleo@gmail.com");
        driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("KV12345");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        String errorMessage = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(errorMessage,"Oops, error. Email and/or password don't match our records", "Сообщение не отображается на странице");
    }

}
