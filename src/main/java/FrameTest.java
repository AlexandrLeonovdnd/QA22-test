import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameTest extends BaseTest{

    @Test
    public void verifyFrameTest(){
        driver.get("http://the-internet.herokuapp.com/frames");
        WebElement iFrameElement = driver.findElement(By.linkText("iFrame"));
        iFrameElement.click();
        driver.switchTo().frame("mce_0_ifr");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement frameContent = driver.findElement(By.xpath("/html/body/p"));
        String textInFrame = frameContent.getText();
        Assert.assertEquals(textInFrame, "Your content goes here.");
    }
}