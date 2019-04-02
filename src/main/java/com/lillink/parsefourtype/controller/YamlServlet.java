package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.model.Address;
import com.lillink.parsefourtype.model.Contact;
import com.lillink.parsefourtype.model.Job;
import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.dao.AddressService;
import com.lillink.parsefourtype.service.dao.ContactService;
import com.lillink.parsefourtype.service.dao.JobService;
import com.lillink.parsefourtype.service.dao.PersonService;
import org.apache.commons.compress.utils.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.lillink.parsefourtype.service.writer.YamlCompanyWriter.exportObjectToYaml;

@WebServlet(urlPatterns = "/convertToYaml")
public class YamlServlet extends HttpServlet {
    private static final String PATH = "/WEB-INF/views/";
    private PersonService personService;
    private AddressService addressService;
    private JobService jobService;
    private ContactService contactService;
    private Person person;
    private Address address;
    private Job job;
    private Contact contact;
    private List<Contact> contacts = new ArrayList<>();
    private List<Job> jobs = new ArrayList<>();

    @Override
    public void init() {
        personService = new PersonService();
        addressService = new AddressService();
        jobService = new JobService();
        contactService = new ContactService();
        address = new Address();
        job = new Job();
        contact = new Contact();
        person = new Person();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("person", personService.getById(id));
        person = personService.getById(id);
        address = addressService.getByPersonId(id);
        contact = contactService.getByPersonId(id);
        job = jobService.getByPersonId(id);

        jobs.add(job);
        person.setJob(jobs);
        contacts.add(contact);
        person.setContacts(contacts);
        person.setAddress(address);

        req.setAttribute("contacts", contact);
        req.setAttribute("address", address);
        req.setAttribute("jobs", job);

        File dir = new File(getServletContext().getRealPath("/cv_files"));
        dir.mkdirs();
        File file = new File(dir.getAbsolutePath() + File.separator + person.getFirstName() + person.getLastName() + ".yaml");
        exportObjectToYaml(file, person);

        resp.addHeader("Content-Disposition", "attachment;filename=" + file.getName());

        ServletOutputStream out = resp.getOutputStream();
        FileInputStream stream = new FileInputStream(file);

        IOUtils.copy(stream, out);
        out.close();

        file.deleteOnExit();
        req.getRequestDispatcher(PATH + "person_all.jsp").forward(req, resp);
    }

}
