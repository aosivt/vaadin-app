package aosivt.UI;

import aosivt.Entity.ViewProtocol;
import aosivt.util.HibernateUtil;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by oshchepkovayu on 19.10.16.
 */
public class ComboBoxViewProtocol extends ComboBox {

    public ComboBoxViewProtocol()
    {
        this.setCaption("Вид протокола");

        this.setContainerDataSource(this.getBeanViewProtocol());
        this.setRequired(true);
        this.setImmediate(true);
        this.setFilteringMode(FilteringMode.CONTAINS);
        this.setImmediate(true);
        this.setNullSelectionAllowed(false);
        this.addValueChangeListener(e -> Notification.show("Value changed:",
                String.valueOf(((ViewProtocol)(e.getProperty().getValue())).getView_protocol_id()),
                Notification.Type.TRAY_NOTIFICATION));

    }

    public BeanItemContainer<ViewProtocol> getBeanViewProtocol()
    {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("From ViewProtocol");
        BeanItemContainer<ViewProtocol> itemContainer = new BeanItemContainer<ViewProtocol>(ViewProtocol.class);

        List<ViewProtocol> resultlist = q.list();
        for (ViewProtocol next : resultlist) {
            itemContainer.
                    //addContainerProperty(next.getView_protocol_id(),ViewProtocol.class,next);
                    addBean(next);
        }
        session.close();
        return itemContainer;

    }
}
