# Bookings.comTestcases
Booking.com Test Automation

This project demonstrates automation of test cases for the Booking.com website using Selenium WebDriver in Java. These test cases include:

Searching and selecting a hotel in Cochin.

Navigating through the hotel reservation process.

Reserving the selected hotel and handling page redirections.

**Table of Contents**
Technologies Used
Setup Instructions
Test Case Details
Execution Instructions

**1.Technologies Used**
Java (JDK 8 or later)
Selenium WebDriver (v4.0+)
Google Chrome (latest version)
ChromeDriver (compatible with your Chrome version)

**2.Setup Instructions**
Clone the repository:
git clone https://github.com/your-repo/booking-test-automation.git
cd booking-test-automation
Install the required libraries by adding the Selenium dependency to your pom.xml if using Maven:
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.1.2</version>
</dependency>
Download the latest version of ChromeDriver and ensure it is accessible from your system's PATH or configure its path in your code.
Set up the Booking.com project in your IDE (e.g., IntelliJ IDEA, Eclipse).

**3.Test Case Details**
1. Searching and Selecting a Hotel
This test case navigates to the Booking.com homepage, searches for hotels in Cochin, and selects a specific hotel.
Method: selectAHotel
Key Steps:
Open the Booking.com homepage.
Search for hotels in Cochin with specified check-in and check-out dates.
Adjust the number of guests.
Retrieve and display search results.
2. Navigating Through the Hotel Reservation Process
This test case clicks on a specific hotel and handles page redirection to focus on the correct browser window.
Method: handleRedirection
Key Steps:
Click on the desired hotel.
Switch focus to the newly opened browser tab/window.
3. Reserving the Selected Hotel
This test case completes the reservation process for the selected hotel.
Method: reserveHotel
Key Steps:
Click the "I will reserve" button on the redirected page.
Validate that the reservation process is initiated successfully.
   4Execution Instructions**
Run the test cases using the main method in testcase2.java. Each test case is invoked sequentially.
Main Method:
public static void main(String[] args) {
    selectAHotel(); // Search and select a hotel
    handleRedirection(); // Navigate through redirection
    reserveHotel(); // Complete the reservation
}
**Expected Outputs:**
Success messages for hotel search and selection.
Confirmation of page redirection handling.
Successful initiation of the reservation process.

