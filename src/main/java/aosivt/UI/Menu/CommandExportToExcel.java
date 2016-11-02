package aosivt.UI.Menu;

import aosivt.WorkingWithExcel.ReportExcel;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import jxl.write.WriteException;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

    private void getDataFromSearchGrid()
    {
        ReportExcel reportExcel = new ReportExcel();
        SimpleDateFormat format = new SimpleDateFormat("ddMyyyy");
        reportExcel.setOutputFile((format.format(new Date()) +"Отчет.xls"));
        try {
            reportExcel.write();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}
