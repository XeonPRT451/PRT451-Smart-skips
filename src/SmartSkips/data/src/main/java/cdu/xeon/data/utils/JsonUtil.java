package cdu.xeon.data.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
    private static JsonUtil ju;

    public static JsonUtil getInstance() {
        if (ju == null) ju = new JsonUtil();
        return ju;
    }

    private static Gson getGson(){
        GsonBuilder builder = new GsonBuilder();

        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>(){
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        Gson gson = builder.create();
                return gson;
    }

    public static Object json2obj(String json, Class<?> tClass) {

        try {
            Gson gson = getGson();
            return gson.fromJson(json, tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public String obj2json(Object obj) {
        try{

                         Gson gson = new Gson();
                         return gson.toJson(obj);
                    }catch(Exception e){
                        e.printStackTrace();

                    }
                return null;

    }

    public String toJson(String key ,Object obj) {
               try{
                        Map map = new HashMap();
                         map.put(key, obj);
                          Gson gson = new Gson();
                          return gson.toJson(map);
                    }catch(Exception e){
                        e.printStackTrace();

                    }
               return null;
            }


}