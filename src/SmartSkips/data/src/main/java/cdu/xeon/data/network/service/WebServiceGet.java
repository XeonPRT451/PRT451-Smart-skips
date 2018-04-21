package cdu.xeon.data.network.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import cdu.xeon.data.repository.Repository;

public class WebServiceGet {

    public static void main(String[] args) {



        System.out.println(executeHttpGet("/smartskips/driver/mobileLogin?username=admin1&password=123"));

    }


    private static String IP = "127.0.0.1:8888";


    public static String executeHttpGet(String command) {

        HttpURLConnection conn = null;
        InputStream is = null;

        try {


            //String path = + "/smartskips/skip/mobileList";
            String path =  "http://" + IP + command;


            conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Charset", "UTF-8");

            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
                return parseInfo(is);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (conn != null) {
                conn.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }


    private static String parseInfo(InputStream inStream) throws Exception {
        byte[] data = read(inStream);

        return new String(data, "UTF-8");
    }


    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }
}
