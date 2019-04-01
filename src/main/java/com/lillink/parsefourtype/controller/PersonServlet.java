package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.model.Address;
import com.lillink.parsefourtype.model.Contact;
import com.lillink.parsefourtype.model.Job;
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
import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        Person person = new Person();

        person.setId(Long.valueOf(req.getParameter("id")));
        person.setFirstName(req.getParameter("first"));
        person.setLastName(req.getParameter("last"));
        person.setBirthDate(LocalDate.parse(req.getParameter("date")));

        Address address = new Address();

        address.setCountry(req.getParameter("country"));
        address.setCity(req.getParameter("city"));
        address.setStreet(req.getParameter("street"));

        person.setAddress(address);

        String[] email = req.getParameterValues("email");
        String[] number = req.getParameterValues("number");
        if (email != null){
            for (int i = 0; i < email.length; i++) {
                Contact contact = new Contact();

                contact.setEmail(email[i]);
                contact.setNumber(number[i]);

                person.getContacts().add(contact);
            }
        }


        String[] begin = req.getParameterValues("begin");
        String[] end = req.getParameterValues("end");
        String[] company = req.getParameterValues("company");
        String[] position = req.getParameterValues("position");
        String[] skill = req.getParameterValues("skill");

        if (begin != null){
            for (int i = 0; i < begin.length; i++){
                Job job = new Job();

                job.setBeginWork(LocalDate.parse(begin[i]));
                job.setJobCompany(company[i]);
                job.setSkill(skill[i]);
                job.setPosition(position[i]);
                job.setEndWork(LocalDate.parse(end[i]));

                person.getJob().add(job);
            }
        }

        personService.save(person,null);

        List<Person> all = personService.getAll();
        all.sort(Comparator.comparing(Person::getId).reversed());
        addressService.save(address, all.get(0).getId());
        for(Job job : person.getJob()) {
            jobService.save(job, all.get(0).getId());
        }
        for (Contact contact : person.getContacts()){
            contactService.save(contact, all.get(0).getId());
        }

        req.setAttribute("person", person);
        req.setAttribute("contacts", person.getContacts());
        req.setAttribute("address", person.getAddress());
        req.setAttribute("job", person.getJob());

        req.getRequestDispatcher("/WEB-INF/views/person_add.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        personService.delete(Long.parseLong(req.getParameter("id")));
    }


}
