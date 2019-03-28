package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.model.Job;
import com.lillink.parsefourtype.service.dao.JobService;
import com.lillink.parsefourtype.utility.HtmlMappingUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/job")
public class JobServlet extends HttpServlet {
    private JobService jobService = new JobService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("updateId") != null){
            this.handleUpdate(req,resp);
        }else {
            String addressesHtmlString = HtmlMappingUtil.mapJobToTable(jobService.getAll());
            req.setAttribute("jobs", addressesHtmlString);
            req.getRequestDispatcher("/WEB-INF/views/job.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Job job = jobService.getById(id);
        job.setBeginWork(LocalDate.parse(req.getParameter("begin")));
        job.setJobCompany(req.getParameter("company"));
        job.setSkill(req.getParameter("skill"));
        job.setPosition(req.getParameter("position"));
        job.setEndWork(LocalDate.parse(req.getParameter("end")));
        jobService.save(job,null);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        jobService.delete(Long.parseLong(req.getParameter("id")));
    }

    private void handleUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("updateId"));
        Job job = jobService.getById(id);
        String resultHtml = HtmlMappingUtil.mapJobToUpdateForm(job);
        req.setAttribute("job", resultHtml);

        req.getRequestDispatcher("/WEB-INF/views/job_update.jsp").forward(req, resp);
    }
}
