import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddElementsTest extends BaseTest {
    @Test
    public void verifyAddElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        driver.findElement(By.xpath("//button[@class='added-manually']")).click();
        int countElements = driver.findElements(By.xpath("//button[@onclick='addElement()']")).size();
        Assert.assertEquals(countElements, 1);
    }
}