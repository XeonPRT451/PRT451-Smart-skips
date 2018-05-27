package cdu.xeon.data.network.service;

import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpURLConnectionPost {

    public static void main(String[] args) {



        System.out.println(doJsonPost("http://192.168.253.1:8888/smartskips/driver/mobileLogin"));
    }


    public static String doJsonPost(String urlPath) {
        String result = "";
        BufferedReader reader = null;
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");

            //conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");

            //conn.setRequestProperty("accept","*/*")
            conn.setRequestProperty("accept","application/json");

            /**if (Json != null && !TextUtils.isEmpty(Json)) {
                byte[] writebytes = Json.getBytes();

                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                OutputStream outwritestream = conn.getOutputStream();
                outwritestream.write(Json.getBytes());
                outwritestream.flush();
                outwritestream.close();**/

            String params = "username=admin1&password=123";
                        OutputStream os = conn.getOutputStream();
                        os.write(params.getBytes());
                        os.flush();
                        os.close();


        if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                result = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    public static String PostLogin(String username,String password) {
        String result = "";
        BufferedReader reader = null;
        try {
            URL url=new URL("http://192.168.253.1:8888/smartskips/driver/mobileLogin");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");

            //conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");

            //conn.setRequestProperty("accept","*/*")
            conn.setRequestProperty("accept","application/json");

            /**if (Json != null && !TextUtils.isEmpty(Json)) {
             byte[] writebytes = Json.getBytes();

             conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
             OutputStream outwritestream = conn.getOutputStream();
             outwritestream.write(Json.getBytes());
             outwritestream.flush();
             outwritestream.close();**/

            String params = "username="+username+"&password="+password;
            OutputStream os = conn.getOutputStream();
            os.write(params.getBytes());
            os.flush();
            os.close();


            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                result = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


}
