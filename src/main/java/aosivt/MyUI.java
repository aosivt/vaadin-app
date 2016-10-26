package aosivt;

import aosivt.Entity.ViewProtocol;
import aosivt.UI.MainLayout;
import aosivt.util.HibernateUtil;
import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */

@Theme("mytheme")
@JavaScript({
        "vaadin://jquery-3.1.1.js",

        "vaadin://test_con.js"
})
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

//        test_insert();
        final VerticalLayout layout = new MainLayout();
        com.vaadin.ui.JavaScript.getCurrent().execute(
                "var field = document.getElementById('protocol').onkeyup = test_con();"
//                 "field.dispatchEvent(new Event('change'));"
        );

        
        setContent(layout);
    }



    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)

    public static class MyUIServlet extends VaadinServlet {
    }
    public static String getInfoHiber()

    {
        String s = "";


        Session session = HibernateUtil.getSessionFactory().openSession();

        ViewProtocol viewProtocol = new ViewProtocol();
        viewProtocol.setView_protocol("Постановление");
        session.save(viewProtocol);


//        Query q = session.createQuery("From ViewProtocol");

//
//        List<ViewProtocol> resultlist = q.list();
//        for (ViewProtocol next : resultlist) {
//            System.out.println("next employee: " + next.getView_protocol().toString());
//
//                s+=next.getView_protocol().toString() + "|||";
//
//        }

        session.getTransaction().commit();
//        session.clear();
//        session.close();
//        Department department = new Department("java");
//        session.save(department);

//        session.save(new Employee("Jakab Gipsz",department));
//        session.save(new Employee("Captain Nemo",department));
//
//        session.getTransaction().commit();


//        Query q = session.createQuery("From Person");
//int i = 0;
//        List<Person> resultList = q.list();
//        System.out.println("num of employess:" + resultList.size());
//        for (Person next : resultList) {
//            System.out.println("next employee: " + next.getPerson_id().toString());
//
//            if (i<10)
//            {
//                i++;
//                s+=next.getPerson_id().toString() + "|||";
//
//            }
//            else{break;}
//
//        }

        return s;
    }
    public static void test_insert()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
//
        ViewProtocol viewProtocol = new ViewProtocol();
        viewProtocol.setView_protocol_id(Long.getLong("1"));
        viewProtocol.setView_protocol("Постановление");
        session.save(viewProtocol);
        transaction.commit();
    }
}
//        final TextField name = new TextFieldIdentityProtocol(new TextField());


//        String s = "";
//
//        name.setCaption("Type your name here:");
//
//        ComboBox viewprotocol = new ComboBoxViewProtocol().getComboBoxViewProtocol();
//
//        Button button = new Button("Click Me");

//        File file = new File("/home/oshchepkovayu/data/geoserver_data/temp_hdfs/user/alex");

//        try {
//            Configuration conf = new Configuration();
//            FileSystem fileSystem = FileSystem.get(conf);
//            Path path = new Path(dirName);
//            if (fileSystem.exists(path)) {
//                layout.addComponent(new Label("Thanks " + dirName +  ", it works!"));
//            }
//            fileSystem.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

//
//        button.addClickListener( e ->
//        {


//            String dirName = "hdfs://172.17.0.3:8020/user/alex";


//            layout.addComponent(new Label("Thanks " + file.exists() + ", it works!"));

//            layout.addComponent(new Label("Thanks " + name.getValue()  + ", it works!"));
//            layout.addComponent(new Label("Thanks " + System.getProperty("user.dir") + ", it works!"));
//            layout.addComponent(new Label("Thanks " + getInfoHiber().toString() + ", it works!"));
//
//        });
//
//        layout.addComponents(name, button);
//        layout.addComponents(viewprotocol);
//        layout.setMargin(true);
//        layout.setSpacing(true);