package Activity.PhonebookAdderActivity;

import Activity.AppActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class PhonebookAdderActivity extends AppActivity {
    private static  final String APK_NAME = "contact-creater";
    private static  final String WAIT_ACTIVITY = "dot.application.phonebookadder.MainActivity";

    private static final String JSON_PHONE_INPUT = "new UiSelector().resourceId(\"dot.application.phonebookadder:id/editText3\")";
    private static final String ADD_CONTACT_BUTTON = "new UiSelector().resourceId(\"dot.application.phonebookadder:id/button\")";

    private static final String LABEL_RESULT_WEB_XPATH = "//android.widget.TextView[@resource-id=\"dot.application.phonebookadder:id/textView\"]/@text";
    private static final String ADD_CONTACTS_STRING = "Json length:";

    public boolean initEmulator() throws MalformedURLException {
        runEmulator(APK_NAME, WAIT_ACTIVITY,"4.4","emulator-5554");
        return true;
    }

    public void addPhones(String[] phones){
        Gson gson = new GsonBuilder().create();
        String jsonArray = gson.toJson(phones);
        setTextInJsonPhoneInput(jsonArray);
        clickOnAddContactButton();
        checkAddContactGood();
    }

    private void setTextInJsonPhoneInput(String jsonText){
        findUiAutomatorElementAndSendKeys(JSON_PHONE_INPUT,jsonText);
    }


    private void clickOnAddContactButton(){
        findUiAutomatorAndTap(ADD_CONTACT_BUTTON);
    }

    private void checkAddContactGood()  {
        String text = findWebXpathElementAndGetTextNode(LABEL_RESULT_WEB_XPATH);
        if(!text.contains(ADD_CONTACTS_STRING)){
            try {
                throw new Exception("Contacts not be added. Text error: "+text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
