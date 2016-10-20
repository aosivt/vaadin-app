package aosivt.AppData;

import aosivt.Entity.ViewProtocol;
import com.vaadin.data.util.BeanItemContainer;

/**
 * Created by alex on 20.10.16.
 */
public class ListAppData extends BeanItemContainer<ViewProtocol> {
    public ListAppData(Class<? super ViewProtocol> type) throws IllegalArgumentException {
        super(type);
    }
}
