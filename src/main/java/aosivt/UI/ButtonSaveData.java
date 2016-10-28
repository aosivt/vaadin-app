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

        this.addClickListener(e -> this.saveData(e.getButton().getCaption()));
    }

    public void saveData(String row_message)
    {
        SaveAppData.setId_protocol(Long.parseLong(MainLayout.id_protocol.getValue()));

        SaveAppData.setId_view_protocol(((ViewProtocol)MainLayout.view_protocol.getValue()).getView_protocol_id());

//        String _name_org = ((Organization)MainLayout.organization_name.getValue()).getName_organization()==null?
//                    ((Organization)MainLayout.organization_name.getValue()).getName_organization():
//                    MainLayout.organization_name.getValue().toString();
        SaveAppData.setName_organization((MainLayout.review.getValue()));



        SaveAppData.setReview((MainLayout.review.getValue()));
        SaveAppData.setReason((MainLayout.reason.getValue()));
        SaveAppData.setReason((MainLayout.review.getValue()));

        SaveAppData.setDate_in((MainLayout.date_open.getValue()));
        SaveAppData.setDate_out((MainLayout.date_close.getValue()));


        SaveAppData.setSum(Double.valueOf(MainLayout.sum.getValue()));

        saveDataToDB();
    }
    private void saveDataToDB()
    {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

//
        Document document = new Document();
        document.setProtocol_id(SaveAppData.getId_protocol());
        document.setName_document(SaveAppData.getName_organization());
        session.save(document);
//        transaction.commit();

        Organization organization= new Organization();
        organization.setName_organization(SaveAppData.getName_organization());
        session.save(organization);

        //        transaction.commit();

        Reason reason = new Reason();
        reason.setProtocol_id(SaveAppData.getId_protocol());
        reason.setText_reason(SaveAppData.getReason());
        session.save(reason);
//        transaction.commit();

        Review review = new Review();
        review.setProtocol_id(SaveAppData.getId_protocol());
        review.setText_review(SaveAppData.getReview());
        session.save(review);



        PivotTableProtocol tableProtocol = new PivotTableProtocol();
        tableProtocol.setProtocol_id(SaveAppData.getId_protocol());

        tableProtocol.setDate_in(
//                (new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)).parse(SaveAppData.getDate_in().toString())
                SaveAppData.getDate_in()
        );
        tableProtocol.setDate_out(SaveAppData.getDate_out());
        tableProtocol.setSum(SaveAppData.getSum());
        tableProtocol.setOrganization_id(organization.getOrganization_id());
        tableProtocol.setView_protocol_id(SaveAppData.getId_view_protocol());
        tableProtocol.setOrganization(organization);
        tableProtocol.setReview(review);
        tableProtocol.setReason(reason);

        session.save(tableProtocol);
        transaction.commit();
//        transaction.commit();


        MainLayout.search_grid.setContainerDataSource(MainLayout.search_grid.getBeanGetAppData());

        session.clear();
        session.close();



//        HibernateUtil.shutdown();
        Notification.show("Value changed:",
                String.valueOf(SaveAppData.getId_protocol()
//                        + ((ViewProtocol)e.getProperty().getValue()).getView_protocol_id().toString()
                ),
                Notification.Type.TRAY_NOTIFICATION);
    }
}
