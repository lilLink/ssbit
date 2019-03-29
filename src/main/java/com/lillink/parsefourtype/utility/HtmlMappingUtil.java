package com.lillink.parsefourtype.utility;

import com.lillink.parsefourtype.model.Address;
import com.lillink.parsefourtype.model.Contact;
import com.lillink.parsefourtype.model.Job;
import com.lillink.parsefourtype.model.Person;

import java.util.List;

public class HtmlMappingUtil {

    public static String mapContactToTable(Contact contact) {
        StringBuilder result = new StringBuilder();
        result.append("<tr>")
                .append("<td>").append(contact.getEmail()).append("</td>")
                .append("<td>").append(contact.getNumber()).append("</td>")
                .append("<td><button onClick = handleUpdate(").append(contact.getId()).append(")>Update</button></td>")
                .append("<td><button onClick = handleDelete(").append(contact.getId()).append(")>Delete</button></td>")
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
                .append("<td>").append(job.getBeginWork()).append("</td>")
                .append("<td>").append(job.getJobCompany()).append("</td>")
                .append("<td>").append(job.getSkill()).append("</td>")
                .append("<td>").append(job.getPosition()).append("</td>")
                .append("<td>").append(job.getEndWork()).append("</td>")
                .append("<td><button onClick = handleUpdate(").append(job.getId()).append(")>Update</button></td>")
                .append("<td><button onClick = handleDelete(").append(job.getId()).append(")>Delete</button></td>")
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
                .append("<td>").append(address.getCountry()).append("</td>")
                .append("<td>").append(address.getCity()).append("</td>")
                .append("<td>").append(address.getStreet()).append("</td>")
                .append("<td><button onClick = handleUpdate(").append(address.getId()).append(")>Update</button></td>")
                .append("<td><button onClick = handleDelete(").append(address.getId()).append(")>Delete</button></td>")
                .append("</tr>");
        return result.toString();
    }

    public static String mapAddressToTable(List<Address> addresses){
        StringBuilder result = new StringBuilder();
        addresses.forEach(x -> result.append(mapAddressToTable(x)));
        return result.toString();
    }

    public static String mapPersonToTable(Person person){
        StringBuilder result = new StringBuilder();
        result.append("<tr>")
                .append("<td>").append(person.getFirstName()).append("</td>")
                .append("<td>").append(person.getLastName()).append("</td>")
                .append("<td>").append(person.getBirthDate()).append("</td>")
                .append("<td><a href = '").append("person_all?id=").append(person.getId()).append("'").append(" class = 'btn btn-success'> Get More Info </a></td>")
                .append("<td><button onClick = handleDelete(").append(person.getId()).append(">Delete</button></td>")
                .append("</tr>");
        return result.toString();
    }

    public static String mapPersonToTable(List<Person> people){
        StringBuilder result = new StringBuilder();
        people.forEach(x -> result.append(mapPersonToTable(x)));
        return result.toString();
    }

    public static String mapContactToUpdateForm(Contact contact) {
        StringBuilder result = new StringBuilder();
                result.append(" Email: ").append(contact.getEmail()).append(" New:  <input id='email_").append(contact.getId()).append("'>").append("<hr>")
                .append(" Number: ").append(contact.getNumber()).append(" New: <input id='number_").append(contact.getId()).append("'>").append("<hr>")
                .append(" <button onClick = handleUpdate(").append(contact.getId()).append(")>Save</button>").append("<hr>");
        return result.toString();
    }

    public static String mapAddressToUpdateForm(Address address){
        StringBuilder result = new StringBuilder();
                result.append(" Country: ").append(address.getCountry()).append(" New:  <input id='country_").append(address.getId()).append("'>").append("<hr>")
                        .append(" City: ").append(address.getCity()).append(" New: <input id='city_").append(address.getId()).append("'>").append("<hr>")
                        .append(" Street: ").append(address.getStreet()).append(" New: <input id='street_").append(address.getId()).append("'>").append("<hr>")
                        .append(" <button onClick = handleUpdate(").append(address.getId()).append(")>Save</button>").append("<hr>");
        return result.toString();
    }

    public static String mapJobToUpdateForm(Job job){
        StringBuilder result = new StringBuilder();
                result.append(" Begin Work: ").append(job.getBeginWork()).append(" New: <input type='date' id='begin_").append(job.getId()).append("'>").append("<hr>")
                        .append(" Company Name: ").append(job.getJobCompany()).append(" New: <input id='company_").append(job.getId()).append("'>").append("<hr>")
                        .append(" Skill: ").append(job.getSkill()).append(" New: <input id='skill_").append(job.getId()).append("'>").append("<hr>")
                        .append(" Position: ").append(job.getPosition()).append(" New: <input id='position_").append(job.getId()).append("'>").append("<hr>")
                        .append(" End Work: ").append(job.getEndWork()).append(" New: <input type='date' id='end_").append(job.getId()).append("'>").append("<hr>")
                        .append(" <button onClick = handleUpdate(").append(job.getId()).append(")>Save</button>").append("<hr>");
        return result.toString();
    }
}
