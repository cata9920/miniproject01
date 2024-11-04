import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.oer.its.etsi102941.Url;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions fo = new FirefoxOptions();
       // fo.addArguments("--headless");
      //  fo.addArguments("--disable-gpu");
      //  fo.addArguments("--window-size=500,100");

        WebDriver driver = new FirefoxDriver(fo);
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(50));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofHours(50));
        driver.manage().timeouts().scriptTimeout(Duration.ofHours(20));

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));



        driver.get("https://football-balls.com/balls");


        List<WebElement> jpgImages = driver.findElements(By.xpath("//img[contains(@src, '.png')]"));

        List<String> adresses = new ArrayList<>();
        String imgurl;

        // Print the src attributes of each image found
        for (WebElement image : jpgImages) {
            //System.out.println(image.getAttribute("src"));
            imgurl = image.getAttribute("src");
            adresses.add(imgurl);

        }

        int c = 0;

      for (String name : adresses ) {
          URL url = new URL(name);
          BufferedImage bi = ImageIO.read(url);
          ImageIO.write(bi,"png",new File("/home/$Your$User$Name/Desktop/FootbalBalls/ramo"+c));
          c++;
      }

        driver.quit();
    }
}