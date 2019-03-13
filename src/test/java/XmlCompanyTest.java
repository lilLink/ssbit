import com.lillink.parsefourtype.model.*;
import com.lillink.parsefourtype.service.*;
import com.lillink.parsefourtype.service.parser.XmlCompanyParser;
import com.lillink.parsefourtype.service.writer.XmlCompanyWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class XmlCompanyTest {

    @Test
    public void serializeTest(){
        String path = "resume.xml";
        Writer<Company> writer = new XmlCompanyWriter(path);

        List<Person> personList = new ArrayList<Person>();
        Person person = new Person();
        person.setFirstName("Vadym");
        person.setLastName("Ptitsyn");
        person.setBirthDate("2000-08-07");

        Address address = new Address();
        address.setCountry("Ukraine");
        address.setCity("Chernivtsi");
        address.setStreet("afg");
        person.setAddress(address);

        List<Job> jobList = new ArrayList<>();
        Job job = new Job();
        job.setBeginWork("2019-03-04");
        job.setPosition("Student");
        job.setEndWork("2019-06-04");
        person.setJobs(jobList);

        List<Contact> contactList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setEmail("lillinkwrk@gmail.com");
        contact.setValue("+38 095 464 46 95");
        person.setContacts(contactList);

        personList.add(person);
        Company company = new  Company();
        company.setNameCompany("SoftServe");
        company.setPersonList(personList);
        writer.write(company);

        Parser<Company> parser = new XmlCompanyParser(path);
        Company company1 = parser.parse().orElseThrow(RuntimeException::new);

        Assert.assertEquals(company.toString().trim(),company1.toString().trim());
    }

    public void deserializeTest(){
        String path = "resume.xml";
        Parser<Company> parser = new XmlCompanyParser(path);
        Company company = parser.parse().orElseThrow(RuntimeException::new);
        System.out.println(company);
    }
}
