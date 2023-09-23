import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest extends BaseTest {
    @Test
    public void verifyAllElements() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        int countElements = new Select(driver.findElement(By.id("dropdown"))).getOptions().size();
        Assert.assertEquals(countElements, 3);
    }

    @Test
    public void verifyFirstElement() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropdownElements = select.getOptions();
        select.selectByValue("1");
        Assert.assertTrue(dropdownElements.get(1).isSelected());
    }

    @Test
    public void verifySecondElement() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropdownElements = select.getOptions();
        select.selectByVisibleText("Option 2");
        Assert.assertTrue(dropdownElements.get(2).isSelected());
    }
}