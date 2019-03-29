package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.dao.AddressService;
import com.lillink.parsefourtype.service.dao.ContactService;
import com.lillink.parsefourtype.service.dao.JobService;
import com.lillink.parsefourtype.service.dao.PersonService;
import com.lillink.parsefourtype.service.writer.PdfCompanyWriter;
import com.lillink.parsefourtype.utility.HtmlMappingUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/person_all")
public class PersonAllServlet extends HttpServlet {

    private PersonService personService = new PersonService();
    private Person person;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("person", personService.getById(Long.valueOf(req.getParameter("id"))));
        person = personService.getById(Long.valueOf((req.getParameter("id"))));
        req.setAttribute("contacts", person.getContacts());
        req.setAttribute("address", person.getAddress());
        req.setAttribute("jobs", person.getJob());
        req.getRequestDispatcher("/WEB-INF/views/person_all.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");

        if ("submit".equals(action)) {
            resp.setContentType("application/pdf;charset=UTF-8");
            resp.addHeader("Content-Disposition", "inline; filename=" + "employee.pdf");
            ServletOutputStream out = resp.getOutputStream();
            ByteArrayOutputStream baos = PdfCompanyWriter.getPdfFile(person);
            baos.writeTo(out);
        }
    }
}
