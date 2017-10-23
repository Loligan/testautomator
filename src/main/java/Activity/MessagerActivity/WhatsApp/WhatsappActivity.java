package Activity.MessagerActivity.WhatsApp;

import Activity.AppActivity;

import java.lang.reflect.Array;
import java.net.MalformedURLException;

public class WhatsappActivity extends AppActivity  {

    public static final String NAME_APPLICATION = "WhatsApp";
    private static final  String AGREE_AND_CONTINUE_BUTTON = "new UiSelector().resourceId(\"com.whatsapp:id/eula_accept\")";

    private static final String CODE_NUMBER_INPUT = "new UiSelector().resourceId(\"com.whatsapp:id/registration_cc\")";
    private static final String NUMBER_INPUT = "new UiSelector().resourceId(\"com.whatsapp:id/registration_phone\")";
    private static final String NEXT_BUTTON = "new UiSelector().resourceId(\"com.whatsapp:id/registration_submit\")";
    private static final String OK_MODAL_BUTTON = "new UiSelector().resourceId(\"android:id/button1\")";
    private static final String SKIP_MODAL_BUTTON = "new UiSelector().resourceId(\"android:id/button2\")";
    private static final String SMS_PASSCODE_INPUT = "new UiSelector().resourceId(\"com.whatsapp:id/verify_sms_code_input\")";
    private static final String RESEND_SMS = "new UiSelector().resourceId(\"com.whatsapp:id/resend_sms_btn\")";

    private static final String YOUR_NAME_PROFILE_INFO_INPUT = "new UiSelector().resourceId(\"com.whatsapp:id/registration_name\")";

    public boolean sendMessage(String message) {
        return false;
    }

    public boolean auth(Array data) {
        return false;
    }


    public boolean initEmulator(String deviceName) throws MalformedURLException {
        return false;
    }

    public boolean checkIsWelcomeScreen(){
        return checkFindElement(AGREE_AND_CONTINUE_BUTTON);
    }

    public void tapOnAgreeAndContinueButton(){
        findUiAutomatorAndTap(AGREE_AND_CONTINUE_BUTTON);
    }

    public void setCodePhoneNumber(String codePhoneNumber){
        findUiAutomatorElementAndSendKeys(CODE_NUMBER_INPUT,codePhoneNumber);
    }

    public void setPhoneNumber(String phoneNumber){
        findUiAutomatorElementAndSendKeys(NUMBER_INPUT,phoneNumber);
    }

    public void tabNextButton(){
        findUiAutomatorAndTap(NEXT_BUTTON);
    }

    public void tapOkModalButton(){
        findUiAutomatorAndTap(OK_MODAL_BUTTON);
    }
    public void tapSkipModalButton(){
        findUiAutomatorAndTap(SKIP_MODAL_BUTTON);
    }

    public void setSmsPasscodeInput(String passcode){
        findUiAutomatorElementAndSendKeys(SMS_PASSCODE_INPUT,passcode);
    }

    public void setRegistrationName(String name){
        findUiAutomatorElementAndSendKeys(YOUR_NAME_PROFILE_INFO_INPUT,name);
    }

}
