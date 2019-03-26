package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.model.Address;
import com.lillink.parsefourtype.model.Contact;
import com.lillink.parsefourtype.model.Job;
import com.lillink.parsefourtype.model.Person;
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
import java.time.LocalDate;

@WebServlet(urlPatterns = "/person")
public class PersonServlet extends HttpServlet {
    private PersonService personService = new PersonService();
    private ContactService contactService = new ContactService();
    private AddressService addressService = new AddressService();
    private JobService jobService = new JobService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            req.getRequestDispatcher("/WEB-INF/views/person_add.jsp").forward(req, resp);
        } else {
            String addressesHtmlString = HtmlMappingUtil.mapPersonToTable(personService.getAll());
            req.setAttribute("person", addressesHtmlString);
            req.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Person person = new Person();
        person.setFirstName(req.getParameter("inputFirstName4"));
        person.setLastName(req.getParameter("inputLastName4"));
        person.setBirthDate(LocalDate.parse(req.getParameter("inputBirthDate4")));
        personService.add(person);

        Contact contact = new Contact();
        contact.setEmail(req.getParameter("inputEmail4"));
        contact.setNumber(req.getParameter("inputNumber4"));
        contactService.add(contact);

        Address address = new Address();
        address.setCountry(req.getParameter("inputCountry4"));
        address.setCity(req.getParameter("inputCity4"));
        address.setStreet(req.getParameter("inputStreet4"));
        addressService.add(address);

        Job job = new Job();
        job.setBeginWork(LocalDate.parse(req.getParameter("inputBeginWork4")));
        job.setJobCompany(req.getParameter("inputJobCompany4"));
        job.setSkill(req.getParameter("inputSkill4"));
        job.setPosition(req.getParameter("inputPosition4"));
        job.setEndWork(LocalDate.parse(req.getParameter("inputEndWork4")));
        jobService.add(job);

        resp.sendRedirect("/person");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        personService.remove(Long.parseLong(req.getParameter("id")));
    }
}
