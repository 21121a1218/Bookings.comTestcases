package bookings.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testcase2 {

    // Method to search and select a hotel
    public static void selectAHotel() {
        // Initialize WebDriver
        ChromeDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.booking.com/?aid=355028");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Enter destination
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':rh:']")));
            searchBox.sendKeys("Cochin");

            // Select check-in date
            WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fcd9eec8fb d3cfe3ade8 d24fc26e73 c696a7d242']//*[name()='svg']")));
            date.click();
            WebElement checkIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='20 January 2025']")));
            checkIn.click();

            // Select check-out date
            WebElement checkOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='25 January 2025']")));
            checkOut.click();

            // Adjust guest count
            WebElement guestCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fcd9eec8fb a6a399739a d24fc26e73 c696a7d242']//*[name()='svg']")));
            guestCount.click();
            WebElement adultIncrease = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@tabindex='-1']")));
            adultIncrease.click();

            // Click search
            WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Search']")));
            searchButton.click();

            // Get search results
            List<WebElement> searchResults = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='list']//div//div//div//div//div//div//div//div//div//a//div[@class='f6431b446c a15b38c233']")));

            System.out.println("Search results:");
            for (int i = 0; i < Math.min(10, searchResults.size()); i++) {
                System.out.println(searchResults.get(i).getText());
                if (searchResults.get(i).getText().contains("Treebo The Qasr")) {
                    searchResults.get(i).click();
                    break;
                }
            }

            // Switch to the new window (if applicable)
            String parentWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            WebElement reserve = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='hp_book_now_button']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reserve);
            reserve.click();
            // Wait for the "I’ll reserve" button and click it
            WebElement reserveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='b_tt_holder_1']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reserveButton);
            reserveButton.click();
            System.out.println("Reserved successfully.");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            //driver.quit();
        }
    }

    // Main method to execute the test case
    public static void main(String[] args) {
        selectAHotel();
    }
}
