package com.lillink.parsefourtype.service.parser;

import com.lillink.parsefourtype.model.Company;
import com.lillink.parsefourtype.service.Parser;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class YamlCompanyParser extends Parser<Company> {

    public YamlCompanyParser(String path) {
        super(path);
    }

    @Override
    public Optional<Company> parse() {
        try {
            return this.deserializeYAML(path);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Company> deserializeYAML(String path) throws IOException {
        Yaml yaml = new Yaml(new Constructor(Company.class));
        InputStream inputStream = new FileInputStream(new File(path));
        return Optional.of((yaml.loadAs(inputStream, Company.class)));
    }
}
