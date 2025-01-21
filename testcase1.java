package bookings.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase1 {

    // Capture trending destinations
    public static void captureTrendingDestinations(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> destinations = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='d65598d5f9']")));

            System.out.println("Trending destinations:");
            for (WebElement dest : destinations) {
                System.out.println(dest.getText());
            }
        } catch (Exception e) {
            System.err.println("Error while capturing trending destinations: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Initialize WebDriver
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Navigate to Booking.com
            driver.get("https://www.booking.com/?aid=355028");

            // Capture trending destinations
            captureTrendingDestinations(driver);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Ensure browser closure
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
