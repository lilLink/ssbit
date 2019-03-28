package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.model.Address;
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
        if (req.getParameter("updateId") != null){
            this.handleUpdate(req,resp);
        }else {
            String addressesHtmlString = HtmlMappingUtil.mapAddressToTable(addressService.getAll());
            req.setAttribute("address", addressesHtmlString);
            req.getRequestDispatcher("/WEB-INF/views/address.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Address address = addressService.getById(id);
        address.setCountry(req.getParameter("country"));
        address.setCity(req.getParameter("city"));
        address.setStreet(req.getParameter("street"));
        addressService.save(address, null);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        addressService.delete(Long.parseLong(req.getParameter("id")));
    }

    private void handleUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("updateId"));
        Address address = addressService.getById(id);
        String resultHtml = HtmlMappingUtil.mapAddressToUpdateForm(address);
        req.setAttribute("address", resultHtml);

        req.getRequestDispatcher("/WEB-INF/views/address_update.jsp").forward(req, resp);
    }
}
