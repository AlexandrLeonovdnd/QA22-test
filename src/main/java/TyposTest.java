import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TyposTest extends BaseTest {
    @Test
    public void verifyText() {
        driver.get("https://the-internet.herokuapp.com/typos");
        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        String firstParagraph = "This example demonstrates a typo being introduced. It does it randomly on each page load.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(paragraphs.get(0).getText(), firstParagraph);
        String secondParagraph = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(paragraphs.get(1).getText(), secondParagraph);
    }
}