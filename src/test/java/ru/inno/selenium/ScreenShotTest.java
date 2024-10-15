package ru.inno.selenium;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.comparison.ImageMarkupPolicy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(SeleniumJupiter.class)
public class ScreenShotTest {

    @Test
    public void test(ChromeDriver driver) throws IOException {
        driver.get("https://labirint.ru");
        WebElement header = driver.findElement(By.cssSelector(".b-header__top-part"));

        ;//        header.getScreenshotAs(OutputType.FILE).renameTo(Path.of("tobe.png").toFile());
        byte[] screenshotAsIs = header.getScreenshotAs(OutputType.BYTES);
        byte[] screenshotToBe = Files.readAllBytes(Path.of("tobe.png"));

        assertArrayEquals(screenshotToBe, screenshotAsIs);
    }


    @Test
    public void ashotTest(ChromeDriver driver) throws IOException, InterruptedException {

        driver.get("https://labirint.ru");
        driver.manage().window().maximize();


        WebElement header = driver.findElement(By.cssSelector(".b-header__top-part"));

//        BufferedImage image = new AShot().takeScreenshot(driver, header).getImage();
//        ImageIO.write(image, "png", Path.of("tobe1.png").toFile());

        BufferedImage asIs = new AShot().takeScreenshot(driver, header).getImage();
        BufferedImage toBe = ImageIO.read(Path.of("tobe1.png").toFile());

        ImageDiff imageDiff = new ImageDiffer().makeDiff(toBe, asIs);

        if (imageDiff.hasDiff()) {
            ImageIO.write(imageDiff.getMarkedImage(), "png", Path.of("marked.png").toFile());
            ImageIO.write(imageDiff.getDiffImage(), "png", Path.of("diff.png").toFile());
            ImageIO.write(imageDiff.getTransparentMarkedImage(), "png", Path.of("trans.png").toFile());
            System.out.println(imageDiff.getDiffSize());
        }

    }
}
