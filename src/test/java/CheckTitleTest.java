import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckTitleTest {

    private Logger logger = LogManager.getLogger(CheckTitleTest.class);
    protected static WebDriver driver;
    ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    @Before
    public void startTests() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("Browser opened");
    }

    @After
    public void endTests() {
        if (driver != null)
            driver.quit();
        logger.info("Browser closed");
    }

    @Test
    public void testCheckTitle() {
        driver.get(cfg.hostname());
        logger.info("Page opened");
        var title = driver.getTitle();
        logger.info("Получен title: {}" + title);
        Assert.assertEquals(title, "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям");


    }
}
