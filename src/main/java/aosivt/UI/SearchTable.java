package aosivt.UI;

import aosivt.AppData.GetAppData;
import aosivt.Entity.PivotTableProtocol;
import aosivt.Entity.ViewProtocol;
import aosivt.util.HibernateUtil;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by oshchepkovayu on 20.10.16.
 */
public class SearchTable extends Table {

    public SearchTable()
    {
        //final Container container = getBeanViewProtocol();


        //this.setContainerDataSource(container);
        this.setCaption("Сводная таблица");

//        this.setWidthUndefined();


        this.setWidth(100, Unit.PERCENTAGE);

//        final Action actionMark = new Action("Mark");
//        final Action actionUnmark = new Action("Unmark");

//        this.addActionHandler(new Action.Handler() {
//            @Override
//            public Action[] getActions(final Object target, final Object sender) {
//                if (markedRows.contains(target)) {
//                    return new Action[] { actionUnmark };
//                } else {
//                    return new Action[] { actionMark };
//                }
//            }
//
//            @Override
//            public void handleAction(final Action action, final Object sender,
//                                     final Object target) {
//                if (actionMark == action) {
//                    markedRows.add(target);
//                } else if (actionUnmark == action) {
//                    markedRows.remove(target);
//                }
//                this.markAsDirtyRecursive();
//                Notification.show("Marked rows: " + markedRows,
//                        Notification.Type.TRAY_NOTIFICATION);
//            }
//
//        });
//
//        this.setCellStyleGenerator(new CellStyleGenerator() {
//            @Override
//            public String getStyle(final Table source, final Object itemId,
//                                   final Object propertyId) {
//                String style = null;
//                if (propertyId == null && markedRows.contains(itemId)) {
//                    // no propertyId, styling a row
//                    style = "marked";
//                }
//                return style;
//            }
//
//        });
//
//        this.setCellStyleGenerator(new CellStyleGenerator() {
//            @Override
//            public String getStyle(final Table source, final Object itemId,
//                                   final Object propertyId) {
//                String style = null;
//                if (propertyId == null && markedRows.contains(itemId)) {
//                    // no propertyId, styling a row
//                    style = "marked";
//                }
//                return style;
//            }
//
//        });



        this.addValueChangeListener(e -> Notification.show("Value changed:",
                String.valueOf(e.getProperty().getValue()
//                        + ((ViewProtocol)e.getProperty().getValue()).getView_protocol_id().toString()
                ),
                Notification.Type.TRAY_NOTIFICATION));
//        this.setCaption("Вид протокола");
//
//        this.setContainerDataSource(this.getBeanViewProtocol());
//        this.setRequired(true);
//        this.setImmediate(true);
////        this.setFilteringMode(FilteringMode.CONTAINS);
//        this.setImmediate(true);
//        this.setNullSelectionAllowed(false);
//        this.addValueChangeListener(e -> Notification.show("Value changed:",
//                String.valueOf(((ViewProtocol)(e.getProperty().getValue())).getView_protocol_id()),
//                Notification.Type.TRAY_NOTIFICATION));
    }


    public BeanItemContainer<GetAppData> getBeanGetAppData()
    {

        BeanItemContainer<GetAppData> itemContainer = new BeanItemContainer<GetAppData>(GetAppData.class);
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query q = session.createQuery("From PivotTableProtocol");

        List<PivotTableProtocol> resultlist = q.list();
        GetAppData appData;
        for (PivotTableProtocol next : resultlist) {
            appData = new GetAppData();
            appData.setSum(next.getSum());
            appData.setDate_in(next.getDate_in()==null?"Не определена":next.getDate_in().toString());
            appData.setDate_out(next.getDate_out()==null?"Не определена":next.getDate_out().toString());
            appData.setId_protocol(next.getProtocol_id());
            appData.setName_organization(next.getOrganization()==null?"Не определена":next.getOrganization().getName_organization());
            appData.setReason(next.getReason()==null?"Не определена":next.getReason().getText_reason());
            appData.setReview(next.getReview()==null?"Не определена":next.getReview().getText_review());
            itemContainer.addBean(appData);
        }
        session.close();

        return itemContainer;
    }

    public BeanItemContainer<ViewProtocol> getBeanViewProtocol()
    {
//
//        Session session = HibernateUtil.getSessionFactory().openSession();

//        Query q = session.createQuery("From ViewProtocol");
        BeanItemContainer<ViewProtocol> itemContainer = new BeanItemContainer<ViewProtocol>(ViewProtocol.class);

        ViewProtocol sample1 = new ViewProtocol();
        ViewProtocol sample2 = new ViewProtocol();

        sample1.setView_protocol("2345345");
        sample2.setView_protocol("gdfhdfghdfgh");

        Number tmp = 5;
        Long l1 = tmp.longValue();


        sample1.setView_protocol_id(l1);
        tmp = 5 + 1;
        l1 = tmp.longValue();
        sample2.setView_protocol_id(l1);

        itemContainer.addBean(sample1);
        itemContainer.addBean(sample2);


//        List<ViewProtocol> resultlist = q.list();
//        for (ViewProtocol next : resultlist) {
//            itemContainer.
//                    addContainerProperty(next.getView_protocol_id(),ViewProtocol.class,next);
//                            addBean(next);
//        }
//        session.close();
        return itemContainer;

    }

    public BeanItemContainer<ViewProtocol> getrebaseBeanViewProtocol(BeanItemContainer<ViewProtocol> temp)
    {

        BeanItemContainer<ViewProtocol> itemContainer = new BeanItemContainer<ViewProtocol>(ViewProtocol.class);


        for (ViewProtocol next : temp.getItemIds()) {

            ViewProtocol iter_temp = new ViewProtocol();
            iter_temp.setView_protocol_id(next.getView_protocol_id());
            iter_temp.setView_protocol(next.getView_protocol());
            itemContainer.
                    //addContainerProperty(next.getView_protocol_id(),ViewProtocol.class,next);
                            addBean(iter_temp);
        }
        return itemContainer;

    }
}
