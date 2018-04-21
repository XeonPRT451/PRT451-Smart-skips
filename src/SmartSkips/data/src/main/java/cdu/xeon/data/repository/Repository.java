package cdu.xeon.data.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.network.service.WebServiceGet;
import cdu.xeon.data.utils.JsonUtil;

public class Repository {

    public static void main(String[] args) {



        System.out.println(Repository.getDriverDetails().toString());
    }

    public static String txt2string(String filePath) {
        BufferedReader br = null;
        StringBuffer sb = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath))); //这里可以控制编码
            sb = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String data = new String(sb); //StringBuffer ==> String
       return data;


    }


   public static Driver getDriverDetails(){
       /**String command = "/smartskips/driver/mobileLogin?username=admin1&password=123";
       String json= WebServiceGet.executeHttpGet(command);
       System.out.println(json);
        **/
       String json = txt2string("F:/AndroidProjects/PRT451-Smart-skips/src/SmartSkips/data/src/main/res/json/driver.txt");
       Driver d = (Driver) JsonUtil.json2obj(json,Driver.class);
       return d;
   }
}
