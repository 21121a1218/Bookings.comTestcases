package bookings.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
            WebElement checkIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='23 February 2025']")));
            checkIn.click();

            // Select check-out date
            WebElement checkOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='25 February 2025']")));
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
                if (i==0) {
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
            WebElement reserveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hp_book_now_button\"]/span[2]")));
            reserveButton.click();
            // Fill booking details
            WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':rq:']")));
            firstname.sendKeys("Calveen");

            WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':rr:']")));
            lastname.sendKeys("Stephene");

            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':rs:']")));
            email.sendKeys("vk@gmail.com");

            Select countrySelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id=':r12:']"))));
            countrySelect.selectByVisibleText("India");

           WebElement code=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[normalize-space()='Albania +355']")));
           code.click();           
            WebElement number = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\":r14:\"]")));
            number.sendKeys("6300370135");

            WebElement confirmation = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='a53cbfa6de ac9267e216 d8eb520c4e']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmation);

            WebElement bookingFor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Booking is for someone else')]")));
            bookingFor.click();

            WebElement fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='guest_name_852765801_400593686_1_2_0_35441']")));
            fullname.sendKeys("Calveen Stephene");

            // Print booking info
            List<WebElement> info = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//form[@name='bookForm']//div//section")));
            System.out.println("Booking Info:");
            for (WebElement detail : info) {
                System.out.println(detail.getText());
            }

            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='book']")));
            nextButton.click();


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

