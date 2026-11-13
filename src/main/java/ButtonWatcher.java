import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ButtonWatcher {
    public static volatile boolean running = false;
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        running = true;

        driver = new ChromeDriver();
        try {
            driver.get("https://wsp.kbtu.kz/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ROOT-2521314 > div > div.v-verticallayout.v-layout.v-vertical.v-widget.card.v-verticallayout-card.v-scrollable-important.v-verticallayout-v-scrollable-important.v-login-content.v-verticallayout-v-login-content.v-has-width.v-has-height > div > div:nth-child(2) > div > div.v-slot.v-align-right > div > div > div > span")));
            try {
                driver.findElement(By.cssSelector("#ROOT-2521314 > div > div.v-verticallayout.v-layout.v-vertical.v-widget.card.v-verticallayout-card.v-scrollable-important.v-verticallayout-v-scrollable-important.v-login-content.v-verticallayout-v-login-content.v-has-width.v-has-height > div > div:nth-child(2) > div > div.v-slot.v-align-right > div > div > div > span")).click();
            } catch (Exception e) {
                System.out.println("ne poluchilos");
            }
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gwt-uid-4")));


            try {
                driver.findElement(By.cssSelector("#gwt-uid-4")).click();
                new Actions(driver).sendKeys(args[0]).perform();
            } catch (Exception e) {
                System.out.println("Failed to pass the login");
            }
            Thread.sleep(1000);
            try {
                driver.findElement(By.cssSelector("#gwt-uid-6")).click();
                new Actions(driver).sendKeys(args[1]).perform();
            } catch (Exception e) {
                System.out.println("Failed to pass the password");
            }


            try {
                driver.findElement(By.cssSelector("#ROOT-2521314 > div > div.v-verticallayout.v-layout.v-vertical.v-widget.card.v-verticallayout-card.v-scrollable-important.v-verticallayout-v-scrollable-important.v-has-width.v-has-height > div > div:nth-child(2) > div > div > div > div > div > div > div > div > div.v-panel-content.v-scrollable > div > table > tbody > tr.v-formlayout-row.v-formlayout-lastrow > td.v-formlayout-contentcell > div")).click();
            } catch (Exception e) {
                System.out.println("yoo");
            }
            Thread.sleep(2000);

            try {
                driver.findElement(By.cssSelector("#RegistrationOnline-1674962804 > div > div.v-verticallayout.v-layout.v-vertical.v-widget.card.v-verticallayout-card.v-scrollable-important.v-verticallayout-v-scrollable-important.v-has-width.v-has-height > div > div.v-slot.v-slot-v-panel-caption > div > div > div:nth-child(3) > div > div:nth-child(3) > div")).click();
            } catch (Exception e) {
                System.out.println("COULD NOT CHANGE THE LANGUAGE TO RUSSIAN");
            }

            Thread.sleep(2000);
            driver.get("https://wsp.kbtu.kz/RegistrationOnline");
            Thread.sleep(2000);
            try {
                driver.findElement(By.cssSelector("#ROOT-2521314 > div > div.v-verticallayout.v-layout.v-vertical.v-widget.card.v-verticallayout-card.v-scrollable-important.v-verticallayout-v-scrollable-important.v-login-content.v-verticallayout-v-login-content.v-has-width.v-has-height > div > div.v-slot.v-slot-v-panel-caption > div > div > div:nth-child(3) > div > div:nth-child(3) > div > span")).click();
            } catch (Exception e) {
                System.out.println("COULD NOT CHANGE THE LANGUAGE TO RUSSIAN");
            }
            int clickedCount = 0;
            while (running) {// Contains a bunch of failsafes, if linktext fails, then everything is up to css selectors.
                // The first css selector is the one where there's only 1 button on a page
                // The second and third css selectors are when there's 2 buttons, check the nth child notation at the end of them
                for (int i = 0; i < 200 && running; i++) {
                    Thread.sleep(100);
                }
                if (!running) break;

                try {
                    driver.findElement(By.linkText("Отметиться")).click();
                    System.out.println("BUTTON CLICKED!(LINKTEXT)");
                    clickedCount++;
                } catch (Exception e) {
                    System.out.println("Button not found yet...");
                }

                try {
                    driver.findElement(By.cssSelector("#RegistrationOnline-1674962804 > div > div.v-verticallayout.v-layout.v-vertical.v-widget.card.v-verticallayout-card.v-scrollable-important.v-verticallayout-v-scrollable-important.v-has-width.v-has-height > div > div:nth-child(2) > div > div > div > div > div > div > div.v-slot.v-slot-primary.v-align-right > div")).click();
                    System.out.println("BUTTON CLICKED!(1)");
                    clickedCount++;
                } catch (Exception e) {
                    System.out.println("Button not found yet...(1)");
                }

                try {
                    driver.findElement(By.cssSelector("#RegistrationOnline-1674962804 > div > div.v-verticallayout.v-layout.v-vertical.v-widget.card.v-verticallayout-card.v-scrollable-important.v-verticallayout-v-scrollable-important.v-has-width.v-has-height > div > div:nth-child(2) > div > div > div > div > div:nth-child(1) > div > div.v-slot.v-slot-primary.v-align-right > div")).click();
                    System.out.println("BUTTON CLICKED!(2)");
                    clickedCount++;
                } catch (Exception e) {
                    System.out.println("Button not found yet...(2)");
                }

                try {
                    driver.findElement(By.cssSelector("#RegistrationOnline-1674962804 > div > div.v-verticallayout.v-layout.v-vertical.v-widget.card.v-verticallayout-card.v-scrollable-important.v-verticallayout-v-scrollable-important.v-has-width.v-has-height > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div.v-slot.v-slot-primary.v-align-right > div")).click();
                    System.out.println("BUTTON CLICKED(3)!");
                    clickedCount++;
                } catch (Exception e) {
                    System.out.println("Button not found yet...(3)");
                }
                driver.navigate().refresh();
            }
        } finally {
            running = false;

            if (driver != null){
                driver.quit();
                driver = null;
            }
        }
    }
}