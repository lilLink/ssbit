import com.lillink.parsefourtype.model.*;
import com.lillink.parsefourtype.service.Parser;
import com.lillink.parsefourtype.service.Writer;
import com.lillink.parsefourtype.service.parser.YamlCompanyParser;
import com.lillink.parsefourtype.service.writer.YamlCompanyWriter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class YamlCompanyTest {

    String path = "resume.yaml";

    YamlCompanyParser yamlCompanyParser = new YamlCompanyParser(path);

    @Test
    public void serializeTest() {
        Writer<Company> writer = new YamlCompanyWriter(path);

        List<Person> personList = new ArrayList<Person>();
        Person person = new Person();
        person.setFirstName("Vadym");
        person.setLastName("Ptitsyn");
        person.setBirthDateAsString("2000-08-07");

        List<Job> jobList = new ArrayList<>();
        Job job = new Job();
        job.setBeginWork("2019-03-04");
        job.setPosition("Student");
        job.setEndWork("2019-06-04");
        person.setJobs(jobList);

        List<Contact> contactList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setEmail("lillinkwrk@gmail.com");
        contact.setNumber("+38 095 464 46 95");
        person.setContacts(contactList);

        Address address = new Address();
        address.setCountry("Ukraine");
        address.setCity("Chernivtsi");
        address.setStreet("afg");
        person.setAddress(address);

        personList.add(person);

        Company company = new  Company();
        company.setNameCompany("SoftServe");
        company.setPersonList(personList);

        writer.write(company);

        String path = "resume.yaml";
        Parser<Company> parser = new YamlCompanyParser(path);
        Company company1 = parser.parse().orElseThrow(RuntimeException::new);

        Assert.assertEquals(company.toString().trim(),company1.toString().trim());
    }

//    @Test
//    public void deserializeTest() {
//        String path = "resume.yaml";
//        Parser<Company> parser = new YamlCompanyParser(path);
//        Company company = parser.parse().orElseThrow(RuntimeException::new);
//        System.out.println(company);
//    }
}
