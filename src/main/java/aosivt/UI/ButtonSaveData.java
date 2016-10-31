package aosivt.UI;

import aosivt.AppData.SaveAppData;
import aosivt.Entity.*;
import aosivt.util.HibernateUtil;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by oshchepkovayu on 20.10.16.
 */
public class ButtonSaveData extends Button {
    public ButtonSaveData()
    {
        this.setCaption("Сохранить данные");
        this.addClickListener(e -> this.saveData());

    }

    public void saveData()
    {
        String id_protocol = MainLayout.id_protocol.getValue().toString().replace("/","");

        SaveAppData.setOrganization(((Organization)MainLayout.organization_name.getValue()));

        SaveAppData.setViewProtocol(((ViewProtocol)MainLayout.view_protocol.getValue()));

        SaveAppData.setDocument(this.createDocument(MainLayout.id_protocol_doc.getValue().toString(),id_protocol));

        SaveAppData.setReason(this.createReason(MainLayout.reason.getValue().toString(),id_protocol));

        SaveAppData.setReview(this.createReview(MainLayout.review.getValue().toString(),id_protocol));

        SaveAppData.setDate_open((MainLayout.date_open.getValue()));

        SaveAppData.setDate_close((MainLayout.date_close.getValue()));

        SaveAppData.setSum(Double.valueOf(MainLayout.sum.getValue()));

        saveDataToDB();
    }
    private void saveDataToDB()
    {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Document document = SaveAppData.getDocument();
        session.save(document);

        Organization organization= SaveAppData.getOrganization();
//        session.save(organization);

        Reason reason = SaveAppData.getReason();
        session.save(reason);

        Review review = SaveAppData.getReview();
        session.save(review);

        PivotTableProtocol tableProtocol = new PivotTableProtocol();
        tableProtocol.setProtocol_id(SaveAppData.getDocument().getProtocol_id());

        tableProtocol.setDate_in(SaveAppData.getDate_open());
        tableProtocol.setDate_out(SaveAppData.getDate_close());
        tableProtocol.setSum(SaveAppData.getSum());
        tableProtocol.setOrganization_id(organization.getOrganization_id());
        tableProtocol.setView_protocol_id(SaveAppData.getViewProtocol().getView_protocol_id());
        tableProtocol.setOrganization(organization);
        tableProtocol.setReview(review);
        tableProtocol.setReason(reason);

        session.save(tableProtocol);
        transaction.commit();




        session.clear();
        session.close();

        MainLayout.search_grid = null;
        MainLayout.search_grid = new SearchGrid();

        this.clearAllTextField();


//        HibernateUtil.shutdown();
        Notification.show("Value changed:",
                String.valueOf(SaveAppData.getDocument().getProtocol_id().toString()

                ),
                Notification.Type.TRAY_NOTIFICATION);
    }

    public Document createDocument(String _name_documnet, String _id_protocol)
    {
        Document document = new Document();
        document.setName_document(_name_documnet);
        document.setProtocol_id(Long.parseLong(_id_protocol));
        return document;
    }
    public Reason createReason(String _text_reason, String _id_protocol)
    {
        Reason reason = new Reason();
        reason.setText_reason(_text_reason);
        reason.setProtocol_id(Long.parseLong(_id_protocol));
        return reason;
    }
    public Review createReview(String _text_reason, String _id_protocol)
    {
        Review review = new Review();
        review.setText_review(_text_reason);
        review.setProtocol_id(Long.parseLong(_id_protocol));
        return review;
    }

    public void clearAllTextField()
    {
        MainLayout.reason.setValue("");
        MainLayout.review.setValue("");
        MainLayout.id_protocol.setValue("");
        MainLayout.id_protocol_doc.setValue("");
        MainLayout.sum.setValue("");
    }
}
