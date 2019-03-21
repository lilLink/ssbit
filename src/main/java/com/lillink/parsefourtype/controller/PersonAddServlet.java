package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.dao.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/person_add")
public class PersonAddServlet extends HttpServlet {
    private PersonService personService = new PersonService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/person_add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        Person person = new Person();
        person.setFirstName(req.getParameter("inputFirstName4"));
        person.setLastName(req.getParameter("inputLastName4"));
        person.setBirthDate(LocalDate.parse(req.getParameter("inputBirthDate4")));
        personService.add(person);
        resp.sendRedirect("/person");
    }
}
