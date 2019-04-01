package com.lillink.parsefourtype.service.writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lillink.parsefourtype.adapter.LocaleDateAdapterJson;
import com.lillink.parsefourtype.model.Company;
import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class JsonCompanyWriter extends Writer<Person> {

    public JsonCompanyWriter(String path){
        super(path);
    }

    @Override
    public void write(Person person){
        try {
            this.serializeJson(person);
        }
        catch (IOException e){
            e.printStackTrace();

        }
    }

    public void serializeJson(Person person) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocaleDateAdapterJson()).create();

        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(gson.toJson(person));
        fileWriter.close();
    }
}
