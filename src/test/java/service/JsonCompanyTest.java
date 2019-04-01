package service;

import com.lillink.parsefourtype.model.*;
import com.lillink.parsefourtype.service.*;
import com.lillink.parsefourtype.service.parser.JsonCompanyParser;
import com.lillink.parsefourtype.service.writer.JsonCompanyWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JsonCompanyTest {

    @Test
    public void serializeTest(){

        String path = "F:\\IDEA Projects\\ParserFourType\\src\\main\\resources\\resume.json";
        Writer<Person> writer = new JsonCompanyWriter(path);

        List<Person> personList = new ArrayList<Person>();
        Person person = new Person();
        person.setFirstName("Vadym");
        person.setLastName("Ptitsyn");
        person.setBirthDate(LocalDate.parse("2000-08-07"));

        Address address = new Address();
        address.setCountry("Ukraine");
        address.setCity("Chernivtsi");
        address.setStreet("afg");
        person.setAddress(address);

        List<Job> jobList = new ArrayList<>();
        Job job = new Job();
        job.setBeginWork(LocalDate.parse("2019-03-04"));
        job.setJobCompany("SS");
        job.setPosition("Student");
        job.setSkill("Python");
        job.setEndWork(LocalDate.parse("2019-06-04"));
        jobList.add(job);
        person.setJob(jobList);

        List<Contact> contactList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setEmail("lillinkwrk@gmail.com");
        contact.setNumber("+38 095 464 46 95");
        contactList.add(contact);
        person.setContacts(contactList);

        personList.add(person);
        writer.write(person);

        Parser<Person> parser = new JsonCompanyParser(path);
        Person company1 = parser.parse().orElseThrow(RuntimeException::new);

        System.out.println(company1);
        Assert.assertEquals(person.toString().trim(),company1.toString().trim());
    }
}
