package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.dao.AddressDao;
import com.lillink.parsefourtype.dao.PersonDao;
import com.lillink.parsefourtype.model.Address;
import com.lillink.parsefourtype.model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PersonServlet extends HttpServlet {
    private PersonDao baseDao = new PersonDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> personList = baseDao.findAll();

        req.setAttribute("person", personList);
        req.getRequestDispatcher("/WEB-INF/person.jsp").forward(req, resp);
    }
}
