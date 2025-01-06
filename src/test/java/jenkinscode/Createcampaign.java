package jenkinscode;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Test
public class Createcampaign {
    EdgeDriver driver = new EdgeDriver();

    public void createcampign() throws InterruptedException {
        try {
            // Maximize window
            driver.manage().window().maximize();
            // Open swan application
            driver.get("https://app.swan.cx/login");
            // Enter email address
            driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
            // Enter password
            driver.findElement(By.id("pass")).sendKeys("Divya@123456");
            // Click on Login Button
            driver.findElement(By.xpath("//button[@id='btn']")).click();
            // Explicit wait for the Create Campaigns element to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement createCampaignButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Create Campaigns']")));
            // Use JavaScript to click the button
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", createCampaignButton);
            // Wait for the page to load
            Thread.sleep(3500);
            // Click on the create button
            driver.findElement(By.xpath("//div[@class='campaign_button ant-col ant-col-3']//button[@id='createBtn']")).click();
            // Enter campaign name
            driver.findElement(By.xpath("//input[@placeholder='name']")).sendKeys("Divyatest11S");
            // Select campaign subtype
            WebElement clicksubtype = driver.findElement(By.cssSelector("div[unselectable='unselectable']"));
            clicksubtype.click();
            WebElement selectoption = driver.findElement(By.cssSelector("li[class='ant-select-dropdown-menu-item ng-star-inserted']:nth-child(1)"));
            selectoption.click();
            // Click the Next button
            WebElement clicknextbutton = driver.findElement(By.cssSelector("button[class='next pull-right ant-btn ng-star-inserted ant-btn-default']"));
            clicknextbutton.click();
         // Select date type
	        WebElement selectdatetype = driver.findElement(By.xpath("//div[text()='Select date Type']"));
	        selectdatetype.click();
	        WebElement Selectoption = driver.findElement(By.cssSelector("li[class='ant-select-dropdown-menu-item ng-star-inserted']:nth-child(2)"));
	        Selectoption.click();
            // Select dynamic date period
            Thread.sleep(2500);
            WebElement clickdynamicoption = driver.findElement(By.xpath("//div[text()='Select Dynamic Date period']"));
            clickdynamicoption.click();
            WebElement Selectoptionofdynamicddown = driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][1]"));
            Selectoptionofdynamicddown.click();
            // Enter start and end dates
            WebElement Enterstartdate = driver.findElement(By.id("campaignArray.validFrom"));
            Enterstartdate.sendKeys("2");
            WebElement Enterenddate = driver.findElement(By.xpath("//input[@formcontrolname='validTo']"));
            Enterenddate.sendKeys("3");
            // Click the All Days checkbox
            WebElement Alldayscheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
            Alldayscheckbox.click();
            Actions a = new Actions(driver);
            a.moveToElement(driver.findElement(By.xpath("//input[@formcontrolname='allStores']"))).build().perform();

         // Click on start time using JavaScript if overlay persists
	        WebElement clickselectelecttime = driver.findElement(By.xpath("(//input[@placeholder='Select time'])[1]"));
	        JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        js1.executeScript("arguments[0].click();", clickselectelecttime);
	         // Select start time from the dropdown using JavaScript to avoid overlay issues
	        WebElement selectstarttime = driver.findElement(By.xpath("(//li[@class='ant-time-picker-panel-select-option-selected ng-star-inserted'])[1]"));
	         js1.executeScript("arguments[0].click();", selectstarttime);
	         Thread.sleep(200);
	        
	         a.moveToElement(driver.findElement(By.xpath("//label[text()='End Time ']"))).click().build().perform();
	         driver.findElement(By.xpath("(//input[@placeholder='Select time'])[2]")).click();
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("(//li[@class='ant-time-picker-panel-select-option-selected ng-star-inserted'])[1]")).click();
	         Thread.sleep(2000);
	        
	         a.moveToElement(driver.findElement(By.xpath("//label[text()='End Time ']"))).click().build().perform();
	        driver.findElement(By.xpath("//input[@formcontrolname='allStores']")).click();
	          Thread.sleep(2000);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@formcontrolname='allProducts']")).click();
            driver.findElement(By.xpath("//button[@class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
            // Click on offer type
            driver.findElement(By.xpath("//nz-select[@formcontrolname='couponType']")).click();
            // Click on percent option
            driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][1]")).click();
            // Enter discount, threshold, and max discount
            driver.findElement(By.xpath("//input[@onkeypress='return event.charCode >= 48']")).sendKeys("10");
            driver.findElement(By.xpath("//input[@formcontrolname='threshold']")).sendKeys("100");
            driver.findElement(By.xpath("//input[@formcontrolname='maxDiscount']")).sendKeys("50");
            // Click checkbox for not valid for discounted items
            driver.findElement(By.xpath("//input[@formcontrolname='fullPrice']")).click();
            // Next steps
            driver.findElement(By.xpath("//button[@class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
            driver.findElement(By.xpath("//input[@placeholder='Enter Coupon Label']")).sendKeys("Coupon2024");
            driver.findElement(By.xpath("//textarea[@nzplaceholder='Enter Campaign Description...']")).sendKeys("This is a special campaign description");
            driver.findElement(By.xpath("//textarea[@formcontrolname='termsAndConditions']")).sendKeys("Terms and conditions apply");
            driver.findElement(By.xpath("//button[@class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
            driver.findElement(By.xpath("//button[@class='button pull-right ant-btn ng-star-inserted ant-btn-default']")).click();

            System.out.println("Campaign created successfully!");
            sendNotificationToSlack("Campaign 'Divya' created successfully in Swan application!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred during campaign creation.");
        } finally {
            //driver.quit();
        }
    }

    public void sendNotificationToSlack(String message) {
        try {
            // Replace with your Slack Webhook URL
            String webhookURL = "https://join.slack.com/share/enQtODIyNzUwMTI2NzU3Mi05ZTA2MzllNmQ2OTQ2MmI1Y2Q5ZmI4MzkxYWMxZWQwNjk1MjdlYzUwNmNjYThhZWFmNjNhZjQzZWEwMzM5ODhi";

            // Prepare payload
            String payload = "{\"text\":\"" + message + "\"}";

            // Open connection
            URL url = new URL(webhookURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            // Send payload
            try (OutputStream os = connection.getOutputStream()) {
                os.write(payload.getBytes("UTF-8"));
                os.flush();
            }

            // Check response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Notification sent to Slack successfully.");
            } else {
                System.out.println("Failed to send notification to Slack. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while sending notification to Slack.");
        }
    }
}
