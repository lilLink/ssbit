package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.model.Contact;
import com.lillink.parsefourtype.service.dao.ContactService;
import com.lillink.parsefourtype.utility.HtmlMappingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/contacts")
public class ContactServlet extends HttpServlet {
    private ContactService contactService = new ContactService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("updateId") != null) {
            this.handleUpdate(req, resp);
        } else {
            String addressesHtmlString = HtmlMappingUtil.mapContactToTable(contactService.getAll());
            req.setAttribute("contacts", addressesHtmlString);
            req.getRequestDispatcher("/WEB-INF/views/contacts.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("id"));
        Contact contact = contactService.getById(id);
        contact.setEmail(req.getParameter("email"));
        contact.setNumber(req.getParameter("number"));
        contactService.save(contact,null);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        contactService.delete(Long.parseLong(req.getParameter("id")));
    }

    private void handleUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("updateId"));
        Contact contact = contactService.getById(id);
        String resultHtml = HtmlMappingUtil.mapContactToUpdateForm(contact);
        req.setAttribute("contact", resultHtml);

        req.getRequestDispatcher("/WEB-INF/views/contacts_update.jsp").forward(req, resp);
    }
}
