package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.service.dao.PersonService;
import com.lillink.parsefourtype.utility.HtmlMappingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/person")
public class PersonServlet extends HttpServlet {
    private PersonService personService = new PersonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addressesHtmlString = HtmlMappingUtil.mapPersonToTable(personService.getAll());

        req.setAttribute("person", addressesHtmlString);
        req.getRequestDispatcher("/WEB-INF/person.jsp").forward(req, resp);
    }
}
