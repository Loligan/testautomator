package Activity;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AppActivity {

    private AndroidDriver driver;

    public abstract boolean initEmulator(String deviceName) throws MalformedURLException;

    public void setDriver(AndroidDriver driver) {
        this.driver = driver;
    }

    public AndroidDriver getDriver() {
        return this.driver;
    }
    public void closeDriver() {
         this.driver.close();
    }

    protected void runEmulator(String apkName, String mainActivity, String platformVersion, String deviceName) throws MalformedURLException {
        File file = new File("src/main/resources/apk/" + apkName + ".apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//        long timeout = 30*60*1000;
        long timeout = 0;
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, timeout);
        desiredCapabilities.setCapability("TIMEOUT",timeout);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
        desiredCapabilities.setCapability("appWaitActivity", mainActivity);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
    }

    protected void findUiAutomatorAndTap(String uiAutomatorPath) {
        List elements = driver.findElementsByAndroidUIAutomator(uiAutomatorPath);
        driver.performTouchAction(new TouchAction(driver).tap((RemoteWebElement) elements.get(0)));
    }

    protected void findUiAutomatorElementAndSendKeys(String uiAutomatorPath, String data) {
        findUiAutomatorAndTap(uiAutomatorPath);
        driver.getKeyboard().sendKeys(data);
        driver.hideKeyboard();
    }

    protected String findWebXpathElementAndGetTextNode(String webXpath) {
        System.out.println(driver.getPageSource());
        InputSource source = new InputSource(new StringReader(driver.getPageSource()));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            assert db != null;
            document = db.parse(source);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        String msg = null;
        try {
            msg = xpath.evaluate(webXpath, document);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return msg;

    }

    protected void pressSystemButton(int androidKeyCode){
        driver.pressKeyCode(androidKeyCode);
    }

    protected void swipe(){
        driver.swipe(300,150,50,150,500);
    }

    protected boolean checkFindElement(String uiAutomatorPath){
        List elements = driver.findElementsByAndroidUIAutomator(uiAutomatorPath);
        if(elements.size()>0){
            return true;
        }
        return false;
    }


}
