package com.lillink.parsefourtype.service.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lillink.parsefourtype.adapter.LocaleDateAdapterJson;
import com.lillink.parsefourtype.model.Person;
import com.lillink.parsefourtype.service.Parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class JsonCompanyParser extends Parser<Person> {

    public JsonCompanyParser(String path){
        super(path);
    }

    @Override
    public Optional<Person> parse(){
        try {
            return this.deserializeJson(path);
        }
        catch (IOException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Person> deserializeJson(String path) throws IOException{
        File file = new File(path);
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocaleDateAdapterJson()).create();
        return Optional.of((gson.fromJson(new FileReader(file),Person.class)));
    }
}
