package by.akatomakhin.trade.bot.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JsonConverter {
    private ObjectMapper objectMapper;

    public JsonConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String convertTo (Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object convertFrom (String str, Class cl) {
        try {
            return objectMapper.readValue(str, cl);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object readValue (String path, Class type){
        try {
            return objectMapper.readValue(new File(path), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T readValue (String path, TypeReference<T> type){
        try {
            return objectMapper.readValue(new File(path), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeValue (String path, Object obj) {
        try {
            objectMapper.writeValue(new File(path), obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
