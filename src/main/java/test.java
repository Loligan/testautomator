import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class test {

// adb

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1);
            System.out.println("NEW ANDROID DRIVER");
            AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
            System.out.println("Close app");
            driver.closeApp();
            System.out.println("Get page sourcr");
            String source = driver.getPageSource();
            System.out.println("quit");
            driver.quit();
//            System.out.println("MANAGE");
//        driver.manage();
//            System.out.println("GET IS LOCKER");
//        driver.isLocked();

    }
}


