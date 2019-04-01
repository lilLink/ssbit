package com.lillink.parsefourtype.controller;

import com.lillink.parsefourtype.model.Contact;
import com.lillink.parsefourtype.model.Job;
import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.dao.AddressService;
import com.lillink.parsefourtype.service.dao.ContactService;
import com.lillink.parsefourtype.service.dao.JobService;
import com.lillink.parsefourtype.service.dao.PersonService;
import com.lillink.parsefourtype.service.parser.CompanyParser;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@WebServlet("/uploadFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadServlet extends HttpServlet {

    private static final String REDIRECT = "/";
    private CompanyParser companyParser = new CompanyParser();
    private PersonService personService = new PersonService();
    private AddressService addressService = new AddressService();
    private ContactService contactService = new  ContactService();
    private JobService jobService = new JobService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(req)) {
            try {
                Person person = new Person();
                List<Person> persons = new ArrayList<>();
                DiskFileItemFactory factory = new DiskFileItemFactory();
                List<FileItem> multiparts = new ServletFileUpload(factory).parseRequest(req);
                for(FileItem item : multiparts) {
                    if(!item.isFormField()) {
                        String filename = new File(item.getName()).getName();
                        if(!item.getName().equals("")) {
                            Random random = new Random();
                            File file;
                            do {
                                int r = Math.abs(random.nextInt());
                                String path = getServletContext().getRealPath("/cv_files");
                                File dir = new File(path);
                                dir.mkdirs();
                                file = new File(path + File.separator + r + filename);
                            } while (file.exists());
                            item.write(file);

                            person = companyParser.searchOneEmployeeInSingleFile(file.getAbsolutePath());
                            personService.save(person,null);
                            List<Person> all = personService.getAll();
                            all.sort(Comparator.comparing(Person::getId).reversed());
                            for (Job place : person.getJob()) {
                                jobService.save(place, all.get(0).getId());
                            }
                            addressService.save(person.getAddress(), all.get(0).getId());
                            for (Contact contact : person.getContacts()) {
                                contactService.save(contact, all.get(0).getId());

                            }

                            resp.sendRedirect("/parser-resume/changePerson?id=" + person.getId());

                            file.deleteOnExit();

                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {

            Person person = new Person();
            List<Person> persons = new ArrayList<>();
            String appPath = req.getServletContext().getRealPath("");
            appPath = appPath.replace('\\', '/');
            String fullSavePath;
            if (appPath.endsWith("/")) {
                fullSavePath = getServletContext().getRealPath("/files");
            } else {
                fullSavePath = "/" + getServletContext().getRealPath("/files");
            }
            File fileSaveDir = new File(fullSavePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            for (Part part : req.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    String filePath = fullSavePath + File.separator + fileName;
                    System.out.println("Write attachment to file: " + filePath);
                        person = companyParser.searchOneEmployeeInSingleFile(filePath);
                        personService.save(person,null);
                        List<Person> all = personService.getAll();
                        all.sort(Comparator.comparing(Person::getId).reversed());
                        for (Job place : person.getJob()) {
                            jobService.save(place, all.get(0).getId());
                        }
                        addressService.save(person.getAddress(), all.get(0).getId());
                        for (Contact contact : person.getContacts()) {
                            contactService.save(contact, all.get(0).getId());

                    }
                }
            }
            resp.sendRedirect(REDIRECT + "person");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
            dispatcher.forward(req, resp);
        }
    }
        private String extractFileName(Part part) {
            String contentDisp = part.getHeader("content-disposition");
            String[] items = contentDisp.split(";");
            for (String s : items) {
                if (s.trim().startsWith("filename")) {
                    String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                    clientFileName = clientFileName.replace("\\", "/");
                    int i = clientFileName.lastIndexOf('/');
                    return clientFileName.substring(i + 1);
                }
            }
            return null;
        }
}
