package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.dao.AddressDao;
import com.lillink.parsefourtype.model.Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/address")
public class AddressServlet extends HttpServlet{

        private AddressDao baseDao = new AddressDao();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Address> addressList = baseDao.findAll();

            req.setAttribute("address", addressList);
            req.getRequestDispatcher("/WEB-INF/address.jsp").forward(req,resp);
        }
}
