package cdu.xeon.data.repository;

import android.content.Context;
import android.renderscript.ScriptGroup;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import cdu.xeon.data.App;
import cdu.xeon.data.R;
import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.bean.Landfill;
import cdu.xeon.data.bean.Operator;
import cdu.xeon.data.bean.Pager;
import cdu.xeon.data.bean.Skip;
import cdu.xeon.data.db.BaseDao;
import cdu.xeon.data.db.SSDao;
import cdu.xeon.data.network.service.WebServiceGet;
import cdu.xeon.data.utils.JsonUtil;

public class Repository {

    private static BaseDao<Skip,Integer> skipDao;
    private static BaseDao<Driver,Integer> driverDao;
    private static BaseDao<Operator,Integer> operatorDao;
    private static BaseDao<Landfill,Integer> landfillDao;
    public static void main(String[] args) {


        //System.out.println(getSkip().toString());
    }

    private static String txt2string(String filePath) {
        BufferedReader br = null;
        StringBuffer sb = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
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

        String data = new String(sb);
       return data;


    }


    private static String txt2string(InputStream input){

           BufferedReader br = null;
           StringBuffer sb = null;
           try {
               br = new BufferedReader(new InputStreamReader(input));
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


   public static Driver login(Context context,String username, String password) {
       driverDao=new SSDao<>(context,Driver.class);
       if ("admin1".equals(username) && "123".equals(password)) {
           InputStream input = context.getResources().openRawResource(R.raw.driver);
       String json=txt2string(input);
   Driver d = (Driver) JsonUtil.json2obj(json,Driver.class);
           try {
               driverDao.save(d);
               Driver dn=driverDao.queryById(d.getId());
               return  dn;
           } catch (SQLException e) {
               e.printStackTrace();
           }

       }


//       String command = "/smartskips/driver/mobileLogin?username="+username+"&password="+password;
//       String json= WebServiceGet.executeHttpGet(command);
//       System.out.println(json);
//       Driver d = (Driver) JsonUtil.json2obj(json,Driver.class);


       return null;
   }

   public static Driver getDriverDetails(Context context){
       Driver d= null;
       try {
           d = driverDao.queryById(1);
           return d;

       } catch (SQLException e) {
           e.printStackTrace();
       }
       // String command = "/smartskips/driver/mobileLogin?username=admin1&password=123";
       //String json= WebServiceGet.executeHttpGet(command);
       //System.out.println(json);

       //String json = txt2string("F:/AndroidProjects/PRT451-Smart-skips/src/SmartSkips/json/driver.txt");
//        InputStream input = context.getResources().openRawResource(R.raw.driver);
//       String json=txt2string(input);
//       Driver d = (Driver) JsonUtil.json2obj(json,Driver.class);
       return null;
   }


   public static Pager<Landfill> getLandfill(Context context){
       /**String command = "/smartskips/landfill/mobileList";
       String json= WebServiceGet.executeHttpGet(command);
       System.out.println(json);
        **/
       InputStream input = context.getResources().openRawResource(R.raw.landfill);
       String json=txt2string(input);

       Pager<Landfill> pl=(Pager<Landfill>)JsonUtil.json2obj(json,Pager.class);
       return pl;
   }

    public static Pager<Operator> getOperator(Context context,int lid){
        /**String command = "/smartskips/operator/mobileList?lid="+lid;
         String json= WebServiceGet.executeHttpGet(command);
         System.out.println(json);
         **/
        if(lid==1) {
            //String json = txt2string("F:/AndroidProjects/PRT451-Smart-skips/src/SmartSkips/json/operator.txt");
            InputStream input = context.getResources().openRawResource(R.raw.operator);
            String json=txt2string(input);
            Pager<Operator> po = (Pager<Operator>) JsonUtil.json2obj(json, Pager.class);
            return po;
        }
        return null;
    }

    public static List<Skip> getSkip(Context context){
        /**  String command = "/smartskips/skip/mobileList";
         String json= WebServiceGet.executeHttpGet(command);
         System.out.println(json);

         **/


      // String json = txt2string("F:/AndroidProjects/PRT451-Smart-skips/src/SmartSkips/json/skip.txt");
        InputStream input = context.getResources().openRawResource(R.raw.skip);
        String json=txt2string(input);

        Pager<Skip> ps=(Pager<Skip>)JsonUtil.json2obj(json,Pager.class);
        List<Skip> ls=ps.getDatas();
        return ls;
    }

    public static String updateDriver(Driver d){
        String dj=JsonUtil.obj2json(d);
        String command="/smartskips/driver/mobileUpdate?driver="+dj;
      System.out.println(command);
        String result= WebServiceGet.executeHttpGet(command);
        result=(String) JsonUtil.json2obj(result, String.class);
        return  result;
    }

    public static String pickupSkip(int did,int sid){
        String command="/smartskips/driver/mobilePickupSkip?did="+did+"&sid="+sid;
        System.out.println(command);
        String result= WebServiceGet.executeHttpGet(command);
        result=(String) JsonUtil.json2obj(result, String.class);
        return  result;
    }

    public static String emptySkip(int did, int lid){

        String command="/smartskips/driver/mobileEmptySkip?did="+did+"&lid="+lid;
        System.out.println(command);
        String result= WebServiceGet.executeHttpGet(command);
        result=(String) JsonUtil.json2obj(result, String.class);
        return  result;
    }

    public static String updatePwd(int did,String oldPwd, String newPwd){
        String command="/smartskips/driver/mobileUpdatePwd?did="+did+"&oldPwd="+oldPwd+"&newPwd="+newPwd;
        String result= WebServiceGet.executeHttpGet(command);
        result=(String) JsonUtil.json2obj(result, String.class);
        return  result;
    }

}


