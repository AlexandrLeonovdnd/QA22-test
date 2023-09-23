import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class DownloadTest extends BaseTest {
    @Test
    public void verifyDownload() {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[@id='content']/div/a[17]")).click();
        String filePath = System.getProperty("user.dir") + "/src/test/resources/" + "sample.png";
        File folder = new File(System.getProperty("E:/"));

        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches("sample.png")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
    }
}