package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.service.dao.AddressService;
import com.lillink.parsefourtype.service.dao.ContactService;
import com.lillink.parsefourtype.service.dao.JobService;
import com.lillink.parsefourtype.service.dao.PersonService;
import com.lillink.parsefourtype.utility.HtmlMappingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/person_all")
public class PersonAllServlet extends HttpServlet {

    private PersonService personService = new PersonService();
    private AddressService addressService = new AddressService();
    private ContactService contactService = new ContactService();
    private JobService jobService = new JobService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addressesHtmlString = HtmlMappingUtil.mapPersonToTable(personService.getAll());
        req.setAttribute("person", addressesHtmlString);
        addressesHtmlString = HtmlMappingUtil.mapAddressToTable(addressService.getAll());
        req.setAttribute("address", addressesHtmlString);
        addressesHtmlString = HtmlMappingUtil.mapContactToTable(contactService.getAll());
        req.setAttribute("contacts", addressesHtmlString);
        addressesHtmlString = HtmlMappingUtil.mapJobToTable(jobService.getAll());
        req.setAttribute("jobs", addressesHtmlString);
        req.getRequestDispatcher("/WEB-INF/views/person_all.jsp").forward(req, resp);
    }
}
