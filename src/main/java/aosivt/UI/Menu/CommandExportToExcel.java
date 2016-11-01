package aosivt.UI.Menu;

import aosivt.UI.MainLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;

/**
 * Created by oshchepkovayu on 01.11.16.
 */
public class CommandExportToExcel implements  MenuBar.Command  {
    public CommandExportToExcel()
    {

    }

    @Override
    public void menuSelected(MenuBar.MenuItem menuItem) {
        Notification.show("Action " + menuItem.getText(),
                Notification.Type.TRAY_NOTIFICATION);
        this.getDataFromSearchGrid();
    }

    public void getDataFromSearchGrid()
    {
        MainLayout.search_grid.getColumns().get(0).toString();
        MainLayout.search_grid.getHeaderRowCount();
        MainLayout.search_grid.getHeaderRow(1).getCell("id_protocol").toString();
    }
}
