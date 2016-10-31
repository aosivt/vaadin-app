package aosivt.UI;

import aosivt.Entity.PivotTableProtocol;
import aosivt.util.HibernateUtil;
import com.vaadin.ui.Button;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;

/**
 * Created by alex on 31.10.16.
 */
public class ButtonDeleteData extends Button {
    public ButtonDeleteData()
    {
        this.setCaption("Удалить данные");
        this.setSizeFull();
        this.addClickListener(e -> this.deleteData());
    }
    public void deleteData()
    {
        String protocol_id = MainLayout.id_protocol.getValue();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

//        PivotTableProtocol pivotTableProtocol = session.get(PivotTableProtocol.class,protocol_id);
        session.createQuery("delete PivotTableProtocol where protocol_id = " + protocol_id).executeUpdate();

//        q.executeUpdate();
//        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
//        entityManager.createQuery()
        transaction.commit();
        session.clear();
        session.close();

        this.clearAllTextField();
    }

    public void clearAllTextField()
    {
        MainLayout.reason.setValue("");
        MainLayout.review.setValue("");
        MainLayout.id_protocol.setValue("");
        MainLayout.id_protocol_doc.setValue("");
        MainLayout.sum.setValue("");
        MainLayout.search_grid = null;
        MainLayout.search_grid = new SearchGrid();

    }
}
