package aosivt.UI;

import aosivt.AppData.SaveAppData;
import aosivt.ProjectEntityManager.ProEntityManager;
import com.vaadin.ui.*;

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
    public static TextField coment;

    public static DateField date_open;
    public static DateField date_close;
    public static ComboBoxViewProtocol view_protocol;
    public static SearchTable search_table;

    public MainLayout()
    {
        ProEntityManager manager = new ProEntityManager();


        id_protocol = new TextField("Индетификатор протокола");
        id_protocol_doc = new TextField("ИП документ");
        id_protocol_doc.setValue("1");



        organization_name = new ComboBoxOrganizations();

        sum = new TextField("Сумма");
        sum.setValue("1");
        reason = new TextField("Причина");
        reason.setValue("1");

        coment = new TextField("Коментарий");
        coment.setValue("1");

        date_open = new DateField("Дата открытия");
        date_open.setValue(new Date());

        date_close = new DateField("Дата закрытия");
        date_close.setValue(new Date());

        view_protocol = new ComboBoxViewProtocol();
        view_protocol.setContainerDataSource(manager.getProtocol_list());


        search_table = new SearchTable();
        search_table.setContainerDataSource(search_table.getBeanGetAppData());
//        search_table.setContainerDataSource(search_table.getrebaseBeanViewProtocol(view_protocol.getBeanViewProtocol()));

        ButtonSaveData save_data = new ButtonSaveData();
        save_data.addClickListener(e -> SaveAppData.setComment(sum.getValue())
        );
//        Button save_data = new Button();
        this.addComponent(new HorizontalLayout(id_protocol));

        this.addComponent(new HorizontalLayout(date_open));

        this.addComponent(new HorizontalLayout(id_protocol_doc,view_protocol));

        this.addComponent(organization_name);

        this.addComponent(new HorizontalLayout(reason,coment));

        this.addComponent(new HorizontalLayout(date_close));



        this.addComponent(sum);
        this.addComponent(save_data);
        this.addComponent(search_table);

    }

//    public MainLayout(Layout _layout)
//    {
//        this.layout = _layout;
//        TextField Id_protocol = new TextField("Привет");
//        this.layout.addComponents(Id_protocol);
//
//    }

}
