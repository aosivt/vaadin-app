package aosivt.UI.Menu;

import aosivt.UI.MainLayout;
import aosivt.WorkingWithExcel.ReportExcel;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.Date;

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
        MainLayout.search_grid.getContainerDataSource();
        ((BeanItemContainer)MainLayout.search_grid.getContainerDataSource()).getContainerFilters().size();
        ReportExcel reportExcel = new ReportExcel();
        reportExcel.setOutputFile(
                (new Date().toString().substring(0,10).replace(":","")) +
                "exit_report.xsl");
        try {
            reportExcel.write();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}
