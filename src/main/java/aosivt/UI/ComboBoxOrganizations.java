package aosivt.UI;

import aosivt.Entity.Organization;
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
public class ComboBoxOrganizations extends ComboBox{

    public ComboBoxOrganizations()
    {
        this.setCaption("Наименование организации");
        this.setContainerDataSource(this.getBeanOrganization());
//        this.setRequired(true);
        this.setImmediate(true);
        this.setFilteringMode(FilteringMode.CONTAINS);

        this.setNullSelectionAllowed(false);

        this.addValueChangeListener(e -> Notification.show("Value changed:",
                String.valueOf(((Organization)(e.getProperty().getValue())).getOrganization_id()),
                Notification.Type.TRAY_NOTIFICATION));
        this.addDetachListener (e -> Notification.show("Value changed:!!!!!11111",
        String.valueOf(e.toString()),
        Notification.Type.TRAY_NOTIFICATION));




    }

    public BeanItemContainer<Organization> getBeanOrganization()
    {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("From Organization");
        BeanItemContainer<Organization> itemContainer = new BeanItemContainer<Organization>(Organization.class);

        List<Organization> resultlist = q.list();
        for (Organization next : resultlist) {
            itemContainer.
                    //addContainerProperty(next.getView_protocol_id(),ViewProtocol.class,next);
                            addBean(next);
        }
        session.close();
        return itemContainer;

    }

}
