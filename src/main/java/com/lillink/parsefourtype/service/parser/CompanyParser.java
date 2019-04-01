package com.lillink.parsefourtype.service.parser;

import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompanyParser {
    private static List<Person> personsFromFile = new ArrayList<>();
    private static Person employee = new Person();

    public static List<Person> getPersonsFromFile() {
        return personsFromFile;
    }

    public static void setPersonsFromFile(List<Person> personsFromFile) {
        CompanyParser.personsFromFile = personsFromFile;
    }
    public Person searchOneEmployeeInSingleFile(String fileName) throws IOException {
        String flag = findFormat(fileName);
        switch (flag) {
            case "xml":
                Parser<Person> xml = new XmlCompanyParser(fileName);
                employee = xml.parse().orElseThrow(RuntimeException::new);
                break;
            case "json":
                Parser<Person> json = new JsonCompanyParser(fileName);
                employee = json.parse().orElseThrow(RuntimeException::new);
                break;
            default:
                break;
        }
        return employee;
    }

    private static String findFormat(String path) throws IOException {
        String result = "";
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);
        while(scanner.hasNextLine())
        {
            String str = scanner.nextLine();
            if(str.contains("<person>"))
            {
                result = "xml";
                break;
            }
            if(str.contains("\"job\":["))
            {
                result = "json";
                break;
            }
        }
        fileReader.close();
        return result;
    }
}
