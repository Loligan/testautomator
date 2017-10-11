import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.*;
import java.net.URL;
import java.util.List;

public class test {

// adb

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("src/main/resources/apk/whatsapp-messenger-2-17-369.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");


        desiredCapabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
        desiredCapabilities.setCapability("appWaitActivity", "com.whatsapp.registration.EULA");
//
//        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1);
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        List els = driver.findElements(By.id("com.whatsapp:id/eula_accept"));
        driver.pressKeyCode(AndroidKeyCode.HOME);

//        System.out.println(driver.getPageSource());
//        driver.findElement(By.xpath(".//*[@ text=\"Gallery\"]"));

        List elements = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"Gallery\")");
        System.out.println(elements.getClass());

//        System.out.println("Click eula accept");
//        WebElement element = driver.findElement(By.id("com.whatsapp:id/eula_accept"));
//        element.click();
//
//        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);

//        System.out.println("Gallery");
//        element = driver.findElementByName("Gallery");
//        element.click();

//
//        System.out.println(driver.get);


        driver.quit();

    }
}


