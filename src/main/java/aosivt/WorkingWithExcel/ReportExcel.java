package aosivt.WorkingWithExcel;

import aosivt.AppData.GetAppData;
import aosivt.UI.MainLayout;
import com.vaadin.data.util.BeanItemContainer;
import jxl.Cell;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.CellFormat;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by alex on 01.11.16.
 */
public class ReportExcel {
    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private String inputFile;

    public void setOutputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void write() throws IOException, WriteException {
        File file = new File(inputFile);
        file.createNewFile();
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("ru", "RU"));

        WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
        workbook.createSheet("Report", 0);
        WritableSheet excelSheet = workbook.getSheet(0);
        createLabel(excelSheet);
        createContent(excelSheet);

        workbook.write();
        workbook.close();
    }

    private void createLabel(WritableSheet sheet)
            throws WriteException {
        // Lets create a times font
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        times.setWrap(true);

        // create create a bold font with unterlines
        WritableFont times10ptBoldUnderline = new WritableFont(
                WritableFont.TIMES, 10, WritableFont.BOLD, false,
                UnderlineStyle.SINGLE);
        timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
        // Lets automatically wrap the cells
        timesBoldUnderline.setWrap(true);

        CellView cv = new CellView();
        cv.setFormat(times);
        cv.setFormat(timesBoldUnderline);

        //cv.setSize(cv.getFormat().);

        // Write a few headers
        addCaption(sheet, 0, 0, "Header 1");
        addCaption(sheet, 1, 0, "This is another header");
    }
    private void createContent(WritableSheet sheet) throws WriteException,
            RowsExceededException {
        // Write a few number
        Iterator  _temp = (((BeanItemContainer)MainLayout.search_grid.getContainerDataSource())).getItemIds().iterator();

//        ((BeanItemContainer)MainLayout.search_grid.getContainerDataSource()).getFilteredItemIds();

        this.createHeaderFile(sheet);

        GetAppData appData = null;
        int i = 1;
        while (_temp.hasNext())
        {
            appData = ((GetAppData)_temp.next());
            this.addLabel(sheet, 0, i, appData.getId_protocol().toString());

            this.addLabel(sheet, 1, i, appData.getName_organization());

            this.addLabel(sheet, 2, i, appData.getDate_in());
            this.addLabel(sheet, 3, i, appData.getDate_out());

            this.addLabel(sheet, 4, i, Double.valueOf(appData.getSum()).isNaN() ?
                                       "Не заполненно":
                                       String.valueOf(appData.getSum()));
            this.addLabel(sheet, 5, i, appData.getDocument() == null ?
                    "Не заполненно":
                    appData.getDocument().getName_document());
            this.addLabel(sheet, 6, i, appData.getReason() == null ?
                    "Не заполненно":
                    appData.getReason().getText_reason());
            this.addLabel(sheet, 7, i, appData.getReview() == null ?
                    "Не заполненно":
                    appData.getReview().getText_review());

            this.addLabel(sheet, 8, i, appData.getDocument().getPivotTableProtocol().getViewProtocol() == null ?
                                        "Не заполненно":
                                       appData.getDocument().getPivotTableProtocol().getViewProtocol().getView_protocol());

            i++;
        }
//        StringBuffer buf = new StringBuffer();
//        buf.append("SUM(A2:A10)");
//        Formula f = new Formula(0, 10, buf.toString());
//        sheet.addCell(f);
//        buf = new StringBuffer();
//        buf.append("SUM(B2:B10)");
//        f = new Formula(1, 10, buf.toString());
//        sheet.addCell(f);

        // now a bit of text
//        for (int i = 12; i < 20; i++) {
//            // First column
//            addLabel(sheet, 0, i, "Boring text " + i);
//            // Second column
//            addLabel(sheet, 1, i, "Another text");
//        }
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s)
            throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s, timesBoldUnderline);
        sheet.addCell(label);
    }

    private void addNumber(WritableSheet sheet, int column, int row,
                           Double integer) throws WriteException, RowsExceededException {
        Number number;
        number = new Number(column, row, integer, times);
        sheet.addCell(number);
    }

    private void addLabel(WritableSheet sheet, int column, int row, String s)
            throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        CellFormat cellFormat = label.getCellFormat();

        sheet.addCell(label);
        CellView cell=sheet.getColumnView(0);
        if (s.length()<30 & s.length()>256)
        {
            cell.setSize(s.length()*256 +100);
        }
        else {cell.setSize(30*256 +100);}
        sheet.setColumnView(column,cell);

    }
    private void createHeaderFile(WritableSheet sheet)
    {

        try {
            this.addLabel(sheet, 0, 0, "Номер ИП");
            this.addLabel(sheet, 1, 0, "Наименование организации");
            this.addLabel(sheet, 2, 0, "Дата возбуждения");
            this.addLabel(sheet, 3, 0, "Дата закрытия");
            this.addLabel(sheet, 4, 0, "Сумма");
            this.addLabel(sheet, 5, 0, "Документ по ИП");
            this.addLabel(sheet, 6, 0, "Причина");
            this.addLabel(sheet, 7, 0, "Коментарий");
            this.addLabel(sheet, 8, 0, "Вид документа по ИП");
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}
