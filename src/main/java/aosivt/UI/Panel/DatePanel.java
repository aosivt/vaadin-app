package aosivt.UI.Panel;

import aosivt.UI.MainLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;

/**
 * Created by oshchepkovayu on 21.10.16.
 */
public class DatePanel extends Panel {
    public DatePanel()
    {
        final HorizontalLayout datePanelLayout = new HorizontalLayout(MainLayout.date_open,MainLayout.date_close,MainLayout.sum);
        datePanelLayout.setSpacing(true);
        datePanelLayout.setSizeFull();
        this.setCaption("Регистрационные даты(Открытия/Закрытия)");
        this.setContent(datePanelLayout);


    }
}
