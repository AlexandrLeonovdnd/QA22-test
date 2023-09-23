import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;


public class СheckboxesTest extends BaseTest {
    @Test
    public void verifyFirstCheckboxUnchecked() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        int index = 0;
        boolean firstCheckboxStatus = driver.findElements(By.cssSelector("[type=checkbox]")).get(index).isSelected();
        Assert.assertFalse(firstCheckboxStatus);
    }

    @Test
    public void verifyFirstCheckboxChecked() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        int index = 0;
        driver.findElements(By.cssSelector("[type=checkbox]")).get(index).click();
        boolean firstCheckboxStatus = driver.findElements(By.cssSelector("[type=checkbox]")).get(index).isSelected();
        Assert.assertTrue(firstCheckboxStatus);
    }

    @Test
    public void verifySecondCheckboxChecked() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        int index = 1;
        boolean secondCheckboxStatus = driver.findElements(By.cssSelector("[type=checkbox]")).get(index).isSelected();
        Assert.assertTrue(secondCheckboxStatus);
    }

    @Test
    public void verifySecondCheckboxUnchecked() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        int index = 1;
        driver.findElements(By.cssSelector("[type=checkbox]")).get(index).click();
        boolean secondCheckboxStatus = driver.findElements(By.cssSelector("[type=checkbox]")).get(1).isSelected();
        Assert.assertFalse(secondCheckboxStatus);
    }
}