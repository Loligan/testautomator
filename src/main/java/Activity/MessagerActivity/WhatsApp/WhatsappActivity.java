package Activity.MessagerActivity.WhatsApp;

import Activity.MessagerActivity.MessagerActivity;

import java.lang.reflect.Array;

public class WhatsappActivity implements MessagerActivity{

    public boolean openApplication() {
        return false;
    }

    public boolean sendMessage(String message) {
        return false;
    }

    public boolean auth(Array data) {
        return false;
    }

    public boolean checkAuth() {
        return false;
    }
}
