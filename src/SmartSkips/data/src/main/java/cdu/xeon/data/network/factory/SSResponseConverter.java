package cdu.xeon.data.network.factory;

import com.google.gson.Gson;


import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class SSResponseConverter<T> implements Converter<ResponseBody, T>
 {
     private Type type;
     Gson gson = new Gson();

     public SSResponseConverter(Type type) {
         this.type = type;
     }

     @Override
     public T convert(ResponseBody responseBody) throws IOException {
         String result = responseBody.string();
         T ssobjects = gson.fromJson(result, type);
         return ssobjects;
     }

 }
