package com.lillink.parsefourtype.service.parser;

import com.lillink.parsefourtype.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TxtCompanyParser {
    /*public TxtCompanyParser(String path){
        super(path);
    }

    @Override
    public Optional<Company> parse(){
            try {
                return this.deserializeTxt(path);
            }catch (IOException e){
                e.printStackTrace();
                return Optional.empty();
            }
    }

    private Optional<Company> deserializeTxt(List<String> line) throws IOException{
        Job job = new Job();
        Person person = new Person();
        List<Job> jobList = new ArrayList<>();
        for (String word : line){
            if (word.startsWith("id"))
                person.setId(Long.valueOf(word.substring(4)));
            if (word.startsWith("first")){
                person.setFirstName(word.substring(6));
            }else if (word.startsWith("last")){
                person.setLastName(word.substring(10));
            }else if (word.startsWith("birth")){
                person.setBirthDate(LocalDate.parse(word.substring(14), DateTimeFormatter.ISO_LOCAL_DATE));
            }else if (word.startsWith("address")){
                Address address = new Address();
                String[] strings = word.split("\\W\\s");
                for (int j = 0;j < strings.length; j++){
                    if (strings[j].startsWith("id")){
                        address.setId(Long.valueOf(strings[j + 1]));
                    }else if (strings[j].startsWith("country")){
                        address.setCountry(strings[j + 1]);
                    }else if (strings[j].startsWith("city")){
                        address.setCity(strings[j + 1]);
                    }else if (strings[j].startsWith("street")){
                        address.setStreet(strings[j + 1]);
                    }
                }
                person.setAddress(address);
            }
            else if (word.startsWith("contact")){
                List<Contact> contactList = new ArrayList<>();
                Contact contact = new Contact();
                String[] strings = word.split("\\W\\s");
                for (int j = 0;j < strings.length; j++){
                    if (strings[j].startsWith("id")){
                        contact.setId(Long.valueOf(strings[j +1]));
                    }else if (strings[j].startsWith("email")){
                        contact.setEmail(strings[j + 1]);
                    }else if (strings[j].startsWith("number")){
                        contact.setNumber(strings[j + 1]);
                    }
                }
                contactList.add(contact);
                person.setContacts(contactList);
            }
            else if (word.startsWith("job")){
                String[] strings = word.split("\\W\\s");
                for (int j = 0;j < strings.length; j++){
                    if (strings[j].startsWith("id")){
                        job.setId(Long.valueOf(strings[j + 1]));
                    }else  if (strings[j].startsWith("begin")){
                        job.setBeginWork(LocalDate.parse(strings[j + 1], DateTimeFormatter.ISO_LOCAL_DATE));
                    }else if (strings[j].startsWith("company")){
                        job.setJobCompany(strings[j + 1]);
                    }else if (strings[j].startsWith("skill")){
                        job.setSkill(strings[j + 1]);
                    }else if (strings[j].startsWith("position")){
                        job.setPosition(strings[j + 1]);
                    }else if (strings[j].startsWith("end")){
                        job.setEndWork(LocalDate.parse(strings[j + 1], DateTimeFormatter.ISO_LOCAL_DATE));
                    }
                }
                jobList.add(job);
                person.setJobs(jobList);
            }
        }
        return Optional.of(person);
    }*/
}
