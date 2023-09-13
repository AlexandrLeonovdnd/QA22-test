import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest{
    @Test
    public void verifyRightClickOptions (){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement whiteBox=driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(whiteBox).perform();
        Alert alert = driver.switchTo().alert();
        String alertText=alert.getText();
        Assert.assertEquals(alertText,"You selected a context menu");
        driver.switchTo().alert().accept();
    }
}