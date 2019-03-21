package com.lillink.parsefourtype.utility;

import com.lillink.parsefourtype.model.Address;
import com.lillink.parsefourtype.model.Contact;
import com.lillink.parsefourtype.model.Job;

import java.util.List;

public class HtmlMappingUtil {

    public static String mapContactToTable(Contact contact) {
        StringBuilder result = new StringBuilder();
        result.append("<tr>")
                .append("<td>").append(contact.getId()).append("</td>")
                .append("<td>").append(contact.getEmail()).append("</td>")
                .append("<td>").append(contact.getNumber()).append("</td>")
         .append("</tr>");
        return result.toString();
    }

    public static String mapContactToTable(List<Contact> contacts) {
        StringBuilder result = new StringBuilder();
        contacts.forEach(x -> result.append(mapContactToTable(x)));
        return result.toString();
    }

    public static String mapJobToTable (Job job){
        StringBuilder result = new StringBuilder();
        result.append("<tr>")
                .append("<td>").append(job.getId()).append("</td>")
                .append("<td>").append(job.getBeginWork()).append("</td>")
                .append("<td>").append(job.getJobCompany()).append("</td>")
                .append("<td>").append(job.getSkill()).append("</td>")
                .append("<td>").append(job.getPosition()).append("</td>")
                .append("<td>").append(job.getEndWork()).append("</td>")
         .append("</tr>");
        return result.toString();
    }

    public static String mapJobToTable (List<Job> jobs){
        StringBuilder result = new StringBuilder();
        jobs.forEach(x -> result.append(mapJobToTable(x)));
        return result.toString();
    }

    public static String mapAddressToTable (Address address){
        StringBuilder result = new StringBuilder();
        result.append("<tr>")
                .append("<td>").append(address.getId()).append("</td>")
                .append("<td>").append(address.getCountry()).append("</td>")
                .append("<td>").append(address.getCity()).append("</td>")
                .append("<td>").append(address.getStreet()).append("</td>")
                .append("</tr>");
        return result.toString();
    }

    public static String mapAddressToTable(List<Address> addresses){
        StringBuilder result = new StringBuilder();
        addresses.forEach(x -> result.append(mapAddressToTable(x)));
        return result.toString();
    }
}
