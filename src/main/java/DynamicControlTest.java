import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicControlTest extends BaseTest {
    @Test
    public void verifyDynamicContols() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[@id='checkbox-example']/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        int checkboxCount = driver.findElements(By.id("checkbox")).size();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(checkboxCount, 0, "CheckBox is exist");
        WebElement input = driver.findElement(By.xpath("//*[@id='input-example']/input"));
        softAssert.assertTrue(input.isDisplayed(), "Input is not displayed");
        driver.findElement(By.xpath("//*[@id='input-example']/button")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='message']")));
        softAssert.assertTrue(input.isEnabled(), "Input is not Enabled");
        softAssert.assertAll();
    }
}