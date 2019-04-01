package com.lillink.parsefourtype.service.writer;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.dao.AddressService;
import com.lillink.parsefourtype.service.dao.ContactService;
import com.lillink.parsefourtype.service.dao.JobService;


import java.io.ByteArrayOutputStream;

public class PdfCompanyWriter {

    private static PdfPTable table = new PdfPTable(2);

    public static ByteArrayOutputStream getPdfFile(Person person, AddressService addressService, ContactService contactService, JobService jobService, Long id) {

        table.setWidthPercentage(60);

        putInTable("Name", person.getFirstName());

        putInTable("Last name", person.getLastName());

        putInTable("Contact", String.valueOf(contactService.getById(id)));

        putInTable("Date of birth", String.valueOf(person.getBirthDate()));

        putInTable("Address", String.valueOf(addressService.getById(id)));

        putInTable("Jobs", String.valueOf(jobService.getById(id)));

        return writeToDocument();
    }

    private static void putInTable(String firstCol, String secondCol) {
        table.addCell(retrieveTable(firstCol, true));
        table.addCell(retrieveTable(secondCol, false));
    }

    private static PdfPCell retrieveTable(String colName, boolean headCell) {
        PdfPCell cell = (headCell) ? new PdfPCell(new Phrase(colName, FontFactory.getFont(FontFactory.HELVETICA_BOLD)))
                                   : new PdfPCell(new Phrase(colName));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        if (headCell) {
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setPaddingRight(5);
        }
        return cell;
    }

    private static ByteArrayOutputStream writeToDocument() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            Document document = new Document();

            PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(table);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return outputStream;
    }
}
