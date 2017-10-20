package MessagerActivity;

import java.lang.reflect.Array;

public interface MessagerActivity {
    public boolean openApplication();
    public boolean sendMessage(String message);
    public boolean auth(Array data);
    public boolean checkAuth();
}
