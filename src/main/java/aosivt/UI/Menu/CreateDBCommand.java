package aosivt.UI.Menu;

import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;

/**
 * Created by oshchepkovayu on 28.10.16.
 */
public class CreateDBCommand implements  MenuBar.Command {
    public CreateDBCommand()
    {

    }

    @Override
    public void menuSelected(MenuBar.MenuItem menuItem) {
        Notification.show("Action " + menuItem.getText(),
                Notification.Type.TRAY_NOTIFICATION);
    }
}
