package aosivt.UI.Menu;

import aosivt.Entity.ViewProtocol;
import aosivt.util.HibernateUtil;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        this.createDB();
    }

    private void createDB()
    {
        ViewProtocol viewProtocol_resolution = new ViewProtocol();
        ViewProtocol viewProtocol_damage = new ViewProtocol();
        ViewProtocol viewProtocol_more = new ViewProtocol();

        viewProtocol_resolution.setView_protocol_id(Long.parseLong("1"));
        viewProtocol_resolution.setView_protocol("Постановление");
        viewProtocol_damage.setView_protocol_id(Long.parseLong("2"));
        viewProtocol_damage.setView_protocol("Ущерб");
        viewProtocol_more.setView_protocol_id(Long.parseLong("3"));
        viewProtocol_more.setView_protocol("Другое");


        insertIntoDBProtocolView(viewProtocol_resolution);
        insertIntoDBProtocolView(viewProtocol_damage);
        insertIntoDBProtocolView(viewProtocol_more);

    }
    private void insertIntoDBProtocolView(ViewProtocol _new_protocol_view)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.setHibernateFlushMode(FlushMode.MANUAL);
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(_new_protocol_view);
        session.flush();
        transaction.commit();

        session.close();
    }
}
