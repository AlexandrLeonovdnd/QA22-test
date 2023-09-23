import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest{

    @Test
    public void verifyFileUploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys("C:/Users/Hanna_Ivanova/Projects/herokuapp/src/test/resources/Test document.docx");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String fileName = driver.findElement(By.xpath("//div[@id='uploaded-files']")).getText();
        Assert.assertEquals(fileName, "Test document.docx");
    }
}