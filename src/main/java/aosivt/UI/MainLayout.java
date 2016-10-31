package aosivt.UI;

import aosivt.ProjectEntityManager.ProEntityManager;
import aosivt.UI.Menu.MainMenu;
import com.vaadin.ui.DateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.util.Date;

/**
 * Created by oshchepkovayu on 20.10.16.
 */
public class MainLayout extends VerticalLayout{

//    protected Layout layout;

    public static TextField sum;
    public static TextField id_protocol;
    public static TextField id_protocol_doc;

    public static ComboBoxOrganizations organization_name;
    public static TextField reason;
    public static TextField review;

    public static DateField date_open;
    public static DateField date_close;
    public static ComboBoxViewProtocol view_protocol;
    public static SearchTable search_table;
    public static SearchGrid search_grid;

    public MainLayout()
    {

        this.init_all_field();

        this.addComponent(new MainMenu());

        this.addComponent(new EditLayout());

        this.addComponent(new SearchLayout());



    }
    public void init_all_field()
        {
            ProEntityManager manager = new ProEntityManager();
            id_protocol = new TextField("Индетификатор протокола");
            id_protocol.setSizeFull();
            id_protocol.setId("protocol");
            id_protocol_doc = new TextField("ИП документ");
            id_protocol_doc.setValue("1");
            id_protocol_doc.setSizeFull();


            view_protocol = new ComboBoxViewProtocol();
            view_protocol.setContainerDataSource(manager.getProtocol_list());
            view_protocol.setSizeFull();

            organization_name = new ComboBoxOrganizations();
            organization_name.setSizeFull();

            sum = new TextField("Сумма");
            sum.setValue("1");
            sum.setSizeFull();

            reason = new TextField("Причина");
            reason.setValue("1");
            reason.setSizeFull();

            review = new TextField("Коментарий");
            review.setValue("1");
            review.setSizeFull();


            date_open = new DateField("Дата открытия");
            date_open.setValue(new Date());

            date_close = new DateField("Дата закрытия");
            date_close.setValue(new Date());



//        search_table = new SearchTable();
            search_grid = new SearchGrid();


        }

}
