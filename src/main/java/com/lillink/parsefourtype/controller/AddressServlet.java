package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.service.dao.AddressService;
import com.lillink.parsefourtype.utility.HtmlMappingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/address")
public class AddressServlet extends HttpServlet{
    private AddressService addressService = new AddressService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addressesHtmlString = HtmlMappingUtil.mapAddressToTable(addressService.getAll());

        req.setAttribute("address", addressesHtmlString);
        req.getRequestDispatcher("/WEB-INF/address.jsp").forward(req,resp);
    }
}
