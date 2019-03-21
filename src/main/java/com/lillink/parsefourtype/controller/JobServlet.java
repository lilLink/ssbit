package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.service.dao.JobService;
import com.lillink.parsefourtype.utility.HtmlMappingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/job")
public class JobServlet extends HttpServlet {
    private JobService jobService = new JobService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String addressesHtmlString = HtmlMappingUtil.mapJobToTable(jobService.getAll());

        req.setAttribute("jobs", addressesHtmlString);
        req.getRequestDispatcher("/WEB-INF/job.jsp").forward(req, resp);
    }
}
