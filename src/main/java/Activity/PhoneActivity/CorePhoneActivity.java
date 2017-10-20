package Activity.PhoneActivity;

import Activity.AppActivity;
import io.appium.java_client.android.AndroidKeyCode;

import java.net.MalformedURLException;

public class CorePhoneActivity extends AppActivity {
    private static final String APPS_ICON = "new UiSelector().description(\"Apps\")";
    private static final String CELL_APP_BY_NAME = "new UiSelector().text(\"NAME_APP\")";
    private static final String APPS_TAB = "new UiSelector().text(\"Apps\").selected(true)";

    public boolean openMainApplicationScreen() {
        return false;
    }

    public boolean runEmulator() {
        return false;
    }


    public boolean initEmulator(String deviceName) throws MalformedURLException {
        return false;
    }

    public void pressHomeSystemButton() {
        pressSystemButton(AndroidKeyCode.HOME);
    }

    public void pressAppsIcon() {
        findUiAutomatorAndTap(APPS_ICON);
    }

    public void clickIconAppInAppsWindow(String nameApp) throws Exception {
        String xpathAppCell = CELL_APP_BY_NAME.replace("NAME_APP", nameApp);
        while (checkFindElement(APPS_TAB)) {
            if (checkFindElement(xpathAppCell)) {
                findUiAutomatorAndTap(xpathAppCell);
                return;
            }
            swipe();

        }
        throw new Exception("Apps" + nameApp + " not found");
    }
}
