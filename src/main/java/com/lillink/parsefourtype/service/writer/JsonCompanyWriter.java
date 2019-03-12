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
    public int write(Company company){
        try {
            return this.serializeJson(company);
        }
        catch (IOException e){
            e.printStackTrace();
            return 0;
        }
    }

    public int serializeJson(Company company) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocaleDateAdapterJson()).create();

        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(gson.toJson(company));
        fileWriter.close();
        return 0;
    }
}
