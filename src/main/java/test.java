import Activity.MessagerActivity.WhatsApp.WhatsappActivity;
import Activity.PhoneActivity.CorePhoneActivity;
import Activity.PhonebookAdderActivity.PhonebookAdderActivity;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.*;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.rmi.Remote;
import java.util.Date;
import java.util.List;

public class test {

// adb

    public static void main(String[] args) throws MalformedURLException {
        PhonebookAdderActivity phonebookAdderActivity = new PhonebookAdderActivity();
        phonebookAdderActivity.initEmulator("emulator-5554");
        AndroidDriver driver = phonebookAdderActivity.getDriver();
        //        String[] phones = {"123", "321"};
//        phonebookAdderActivity.addPhones(phones);

        CorePhoneActivity corePhoneActivity = new CorePhoneActivity();
        corePhoneActivity.setDriver(driver);
        corePhoneActivity.pressHomeSystemButton();
        corePhoneActivity.pressAppsIcon();

        try {
            corePhoneActivity.clickIconAppInAppsWindow(WhatsappActivity.NAME_APPLICATION);
        } catch (Exception e) {
            e.printStackTrace();
        }

        WhatsappActivity whatsappActivity = new WhatsappActivity();
        whatsappActivity.setDriver(corePhoneActivity.getDriver());
        System.out.println(new Date().toString());
        waitCodeFromFile();

        if (whatsappActivity.checkIsWelcomeScreen()) {
            whatsappActivity.tapOnAgreeAndContinueButton();
            System.out.println("SET CODE PHONE NUMBER");
            whatsappActivity.setCodePhoneNumber("375");
            System.out.println("SET PHONE NUMBER");
            whatsappActivity.setPhoneNumber("256233528");
            whatsappActivity.tabNextButton();
            sleep(25);
            whatsappActivity.tapOkModalButton();
            String passcode = waitCodeFromFile();
            System.out.println("PASS CODE: "+passcode);
            whatsappActivity.setSmsPasscodeInput(passcode);
            sleep(10);
            whatsappActivity.tapSkipModalButton();

            whatsappActivity.setRegistrationName("meldon");
//            whatsappActivity.setRegistrationName("meldon");
        }else {
            System.out.println("Yo. Thi is not welcome screen");
        }

    }

    private static String waitCodeFromFile() {
        while (true) {
            String everything = null;
            try {
                FileInputStream inputStream = new FileInputStream("src/main/resources/files/code-number-whatsapp");
                everything = IOUtils.toString(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(!everything.equals("")){
                return everything;
            }

            try {
                System.out.println(new Date().toString());
                System.out.println("NOT FOUND");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mainGg(String[] args) throws IOException, InterruptedException {
//        File file = new File("src/main/resources/apk/whatsapp-messenger-2-17-369.apk");
        File file = new File("src/main/resources/apk/contact-creater.apk");
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
        System.out.println("1");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        System.out.println("2");
        List els = driver.findElements(By.id("com.whatsapp:id/eula_accept"));
        System.out.println("3");
        driver.pressKeyCode(AndroidKeyCode.HOME);
        driver.pressKeyCode(AndroidKeyCode.HOME);
        System.out.println("4");

//        System.out.println(driver.getPageSource());
//        driver.findElement(By.xpath(".//*[@ text=\"Gallery\"]"));
        System.out.println("5");

//        List elements = driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"Gallery\")");
        List elements = driver.findElementsByAndroidUIAutomator("new UiSelector().description(\"Apps\")");
        driver.performTouchAction(new TouchAction(driver).tap((RemoteWebElement) elements.get(0)));
//        System.out.println("SIZE "+ elements.size());
//        System.out.println(elements.get(0).getClass());

//        System.out.println("Click eula accept");
//        WebElement element = driver.findElement(By.id("com.whatsapp:id/eula_accept"));
//        element.click();
//
        System.out.println("6");
//        ((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.HOME);

//        System.out.println("Gallery");
//        element = driver.findElementByName("Gallery");
//        element.click();

//
//        System.out.println(driver.get);


        driver.quit();

    }
}


