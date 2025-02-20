package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup. SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    /**
     * The port number assigned to the running application during test execution.
     * Set automatically during each test run by Spring Framework's test context. */
    @LocalServerPort
    private int serverPort;
    /**
     * The base URL for testing. Default to {@code http://localhost}.
     */
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;
    private String baseUrl;
    @BeforeEach
    void setupTest() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
    }

    @Test
    void createProductPage_isCorrect (ChromeDriver driver) {
        driver.get(baseUrl + "/product/create");

        WebElement productNameField = driver.findElement(By.id("product-name"));
        productNameField.clear();
        productNameField.sendKeys("Test");

        WebElement productQuantityField = driver.findElement(By.id("product-quantity"));
        productQuantityField.clear();
        productQuantityField.sendKeys("5");

        WebElement submitButton = driver.findElement(By.id("submit-button"));
        submitButton.click();

        String pageTitle = driver.getTitle();
        assertEquals("Product List", pageTitle);

        String productName = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
        String productQuantity = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();

        assertEquals("Test", productName);
        assertEquals("5", productQuantity);
    }
}
