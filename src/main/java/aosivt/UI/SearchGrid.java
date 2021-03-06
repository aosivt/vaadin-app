package aosivt.UI;

import aosivt.AppData.GetAppData;
import aosivt.Entity.PivotTableProtocol;
import aosivt.util.HibernateUtil;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by oshchepkovayu on 21.10.16.
 */
public class SearchGrid extends Grid {

    public  SearchGrid()
    {

//        this.setCaption("Сводная таблица");

        this.setWidth(100, Unit.PERCENTAGE);

        BeanItemContainer<GetAppData> grid = this.getBeanGetAppData();

        this.setContainerDataSource(grid);

        this.setFilterGrid(grid);

        this.setColumnReorderingAllowed(true);

        this.setHeight(50.0f,Unit.PICAS);
//        this.setWidth(100.0f,Unit.PICAS);

        this.getColumn(this.getColumns().get(1).getPropertyId()).setHeaderCaption("Наименование организации");



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
    //Method to add a filter on grid
    public void setFilterGrid(BeanItemContainer<?> beanType) {
        //This create a HeaderRow to add filter fields
        HeaderRow filterRow = this.appendHeaderRow();
        for (Column column : getColumns()) {
            //For each column from the grid
            HeaderCell cellFilter = filterRow.getCell(column.getPropertyId());
            //Add a textfield
            cellFilter.setComponent(createFieldFilter(beanType, column));
        }
    }

    //This create a TextField to filter the information
    private TextField createFieldFilter(final BeanItemContainer<?> container, final Column column) {
        TextField filter = new TextField();
        filter.setImmediate(true);
        filter.addTextChangeListener(new FieldEvents.TextChangeListener(){
            @Override
            public void textChange(FieldEvents.TextChangeEvent event) {
                String newValue = event.getText();
                //Remove the previous filter
                container.removeContainerFilters(column.getPropertyId());
                if (newValue != null && !newValue.isEmpty()) {
                    //Filter the information
                    container.addContainerFilter(new SimpleStringFilter(column.getPropertyId(), newValue, true, false));
                }
                recalculateColumnWidths();
            }
        });
        return filter;
    }
}
