package com.lillink.parsefourtype.controller;

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
            String addressesHtmlString = HtmlMappingUtil.mapContactToTable(contactService.getAll());

        req.setAttribute("contacts", addressesHtmlString);
        req.getRequestDispatcher("/WEB-INF/contacts.jsp").forward(req, resp);
    }
}
