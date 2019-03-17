package com.lillink.parsefourtype.service.writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lillink.parsefourtype.adapter.LocaleDateAdapterJson;
import com.lillink.parsefourtype.model.Company;
import com.lillink.parsefourtype.service.Writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class JsonCompanyWriter extends Writer<Company> {

    public JsonCompanyWriter(String path){
        super(path);
    }

    @Override
    public void write(Company company){
        try {
            this.serializeJson(company);
        }
        catch (IOException e){
            e.printStackTrace();

        }
    }

    public void serializeJson(Company company) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocaleDateAdapterJson()).create();

        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(gson.toJson(company));
        fileWriter.close();
    }
}
