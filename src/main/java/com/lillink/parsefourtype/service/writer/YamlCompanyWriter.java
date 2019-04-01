package com.lillink.parsefourtype.service.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.Writer;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class YamlCompanyWriter extends Writer<Person> {

    public YamlCompanyWriter(String path) {
        super(path);
    }

    @Override
   public void write(Person person) {
        try {
            this.serializeYAML(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializeYAML(Person person) throws IOException {
        Yaml yaml = new Yaml();
        FileWriter fileWriter = new FileWriter(path);
        yaml.dump(person,fileWriter);
    }

    public static void exportObjectToYaml(File file, Person employees) {
        ObjectMapper mapper = new ObjectMapper(new YAMLMapper().getFactory());
        try {
            mapper.writeValue(file, employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
