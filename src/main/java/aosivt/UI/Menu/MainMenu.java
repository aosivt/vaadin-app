package aosivt.UI.Menu;

import com.vaadin.ui.MenuBar;

/**
 * Created by oshchepkovayu on 28.10.16.
 */
public class MainMenu extends MenuBar {

    public MainMenu()
    {
        this.setWidth(100.0f,Unit.PERCENTAGE);

//        this.addItem("Администрирование", new MenuItem("Установка БД", new CreateDBCommand()));
        this.createAdminMenuItem();
    }

    private void createAdminMenuItem()
    {
        MenuItem colds = this.addItem("Администрирование", null, null);
        colds.addItem("Пересоздать БД", null, new CreateDBCommand());
        return ;
    }
}
