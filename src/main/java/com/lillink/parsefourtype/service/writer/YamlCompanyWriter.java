package com.lillink.parsefourtype.service.writer;

import com.lillink.parsefourtype.model.Company;
import com.lillink.parsefourtype.service.Writer;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;

public class YamlCompanyWriter extends Writer<Company> {

    public YamlCompanyWriter(String path) {
        super(path);
    }

    @Override
   public void write(Company company) {
        try {
            this.serializeYAML(company);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void   serializeYAML(Company company) throws IOException {
        Yaml yaml = new Yaml();
        FileWriter fileWriter = new FileWriter(path);
        yaml.dump(company,fileWriter);
    }
}
