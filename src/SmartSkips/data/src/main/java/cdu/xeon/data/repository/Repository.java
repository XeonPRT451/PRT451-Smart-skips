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
import cdu.xeon.data.bean.SmartskipsException;
import cdu.xeon.data.db.BaseDao;
import cdu.xeon.data.db.SSDao;
import cdu.xeon.data.network.service.HttpURLConnectionPost;
import cdu.xeon.data.network.service.WebServiceGet;
import cdu.xeon.data.utils.JsonUtil;
import cdu.xeon.data.utils.NetUtil;

import static java.lang.Boolean.TRUE;

public class Repository {

    private static BaseDao<Skip, Integer> skipDao;
    private static BaseDao<Driver, Integer> driverDao;
    private static BaseDao<Operator, Integer> operatorDao;
    private static BaseDao<Landfill, Integer> landfillDao;

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


    private static String txt2string(InputStream input) {

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


    public static Driver login(String username, String password) {
        //driverDao=new SSDao<>(context,Driver.class);
        //if(NetUtil.isNetworkAvailable(context)==TRUE) {
        //String command = "/smartskips/driver/mobileLogin?username="+username+"&password="+password;
        String json = HttpURLConnectionPost.PostLogin(username, password);

        //if ("admin1".equals(username) && "sdsdgcCcDFKsd.77578.sdfkd".equals(password)) {
//           InputStream input = context.getResources().openRawResource(R.raw.driver);
//       String json=txt2string(input);
        Driver dn = (Driver) JsonUtil.json2obj(json, Driver.class);
        try {
            driverDao.deleteById(1);
            driverDao.save(dn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dn;
    }
////        else {
////           try {
////
////               Driver dn = driverDao.queryById(id);
////               return dn;
////           } catch (SQLException e) {
////               e.printStackTrace();
////           }

//       String command = "/smartskips/driver/mobileLogin?username="+username+"&password="+password;
    // String json= HttpURLConnectionPost.PostLogin(username, password);
//       String json= WebServiceGet.executeHttpGet(command);
//       System.out.println(json);
//       Driver d = (Driver) JsonUtil.json2obj(json,Driver.class);




   public static Driver getDriverDetails(Context context, int id){
       driverDao=new SSDao<>(context,Driver.class);
       Driver d= null;
       try {
           d = driverDao.queryById(id);
           return d;

       } catch (SQLException e) {
           e.printStackTrace();
       }
        //String command = "/smartskips/driver/mobileLogin?username=admin1&password=123";
       //String json= WebServiceGet.executeHttpGet(command);
       //System.out.println(json);

       //String json = txt2string("F:/AndroidProjects/PRT451-Smart-skips/src/SmartSkips/json/driver.txt");
//        InputStream input = context.getResources().openRawResource(R.raw.driver);
//       String json=txt2string(input);
//       Driver d = (Driver) JsonUtil.json2obj(json,Driver.class);
       return null;
   }


   public static List<Landfill> getLandfill(Context context){
       landfillDao=new SSDao<>(context,Landfill.class);
       if(NetUtil.isNetworkAvailable(context)==TRUE) {
           String command = "/smartskips/landfill/mobileList";
           String json = WebServiceGet.executeHttpGet(command);


//       InputStream input = context.getResources().openRawResource(R.raw.landfill);
//       String json=txt2string(input);

           List<Landfill> ll = (List<Landfill>) JsonUtil.jsonToBeanList(json, Landfill.class);
           for (Landfill l : ll) {
               try {
                   landfillDao.save(l);
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           return ll;
       }
       else{
           try {
               List<Landfill> ll=landfillDao.queryAll();
               return  ll;
           } catch (SQLException e) {
               e.printStackTrace();
           }


       }
       return null;
   }

    public static List<Operator> getOperator(Context context, int lid){
        operatorDao=new SSDao<>(context,Operator.class);
        if(NetUtil.isNetworkAvailable(context)==TRUE) {
        String command = "/smartskips/operator/mobileList?lid="+lid;
         String json= WebServiceGet.executeHttpGet(command);


//        if(lid==1) {
//            //String json = txt2string("F:/AndroidProjects/PRT451-Smart-skips/src/SmartSkips/json/operator.txt");
//            InputStream input = context.getResources().openRawResource(R.raw.operator);
//            String json=txt2string(input);
            List<Operator> lo=(List<Operator>)JsonUtil.jsonToBeanList(json,Operator.class);
            for(Operator o:lo){
                try {
                    operatorDao.save(o);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return lo;
        }
        else{
            try {
                List<Operator> lo=operatorDao.query("lid",Integer.toString(lid));
                return lo;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public static List<Skip> getSkip(Context context){
        skipDao=new SSDao<>(context,Skip.class);
        if(NetUtil.isNetworkAvailable(context)==TRUE) {
            String command = "/smartskips/skip/mobileList";
            String json = WebServiceGet.executeHttpGet(command);


            //String json = txt2string("F:/AndroidProjects/PRT451-Smart-skips/src/SmartSkips/json/skip.txt");
            //InputStream input = context.getResources().openRawResource(R.raw.skip);
            //String json=txt2string(input);

            List<Skip> ls = (List<Skip>) JsonUtil.jsonToBeanList(json, Skip.class);


        try {
            Skip s=ls.get(1);
            skipDao.save(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//            for (Skip s : ls) {
//                try {
//                    skipDao.save(s);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }

            return ls;
        }
        else{
            try {
                List<Skip> ls = skipDao.queryAll();
                return ls;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }

    public static String updateDriver(Context context,Driver d) {
        driverDao = new SSDao<>(context, Driver.class);

        if (NetUtil.isNetworkAvailable(context) == TRUE) {

            String dj = JsonUtil.obj2json(d);
            String command = "/smartskips/driver/mobileUpdate?driver=" + dj;
            String result = WebServiceGet.executeHttpGet(command);
            result = (String) JsonUtil.json2obj(result, String.class);
            return result;
        }
        return "failure";
    }
//      else
//          return "failure";
////        Driver od= null;
////        try {
////            od = driverDao.queryById(d.getId());
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        od.setEmail(d.getEmail());
////        od.setPhone(d.getPhone());
////        od.setNickname(d.getNickname());
////        try {
////            driverDao.update(od);
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////          return "success";
//
//    }

    public static String pickupSkip(Context context, int did,int sid){

       if(NetUtil.isNetworkAvailable(context)==TRUE){
            String command="/smartskips/driver/mobilePickupSkip?did="+did+"&sid="+sid;

           String result= WebServiceGet.executeHttpGet(command);
           result=(String) JsonUtil.json2obj(result, String.class);
            return  result;
        }


            return "failure";
//
////        driverDao=new SSDao<>(context,Driver.class);
////        skipDao=new SSDao<>(context,Skip.class);
////        try {
////        Driver d = driverDao.queryById(did);
////        if(d.getLoaded()==1) {
////            throw new SmartskipsException("This truck already loaded skip");
////
////        }
////        d.setLoaded(1);
////        Skip s=skipDao.queryById(sid);
////        if(s.getFull()==0) {
////            throw new SmartskipsException("This skip is not full");
////        }
////
////        s.setFull(0);
////        d.setType(s.getType());
////        d.setTrashamount(s.getCapacity()-s.getCurrentCapacity());
////        s.setCurrentCapacity(s.getCapacity());
////        driverDao.update(d);
////
////            skipDao.update(s);
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////        return "success";
//
   }

    public static String emptySkip(Context context,int did, int lid){
//        driverDao=new SSDao<>(context,Driver.class);
//        landfillDao=new SSDao<>(context,Landfill.class);
//        try {
//        Driver d=driverDao.queryById(did);
//        Landfill l=landfillDao.queryById(lid);
//        if(d.getType()==2 || d.getTrashamount()==0 || d.getLoaded()==0) {
//            throw new SmartskipsException("The truck is empty");
//        }
//        if(d.getType()==1) {
//            l.setCurrentCWCapacity(l.getCurrentCWCapacity()-d.getTrashamount());
//        }
//        if(d.getType()==0) {
//            l.setCurrentGWCapacity(l.getCurrentGWCapacity()-d.getTrashamount());
//        }
//        d.setType(2);
//        d.setTrashamount(0.0);
//        d.setLoaded(0);
//        driverDao.update(d);
//        landfillDao.update(l);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    return "success";
        if(NetUtil.isNetworkAvailable(context)==TRUE) {
            String command = "/smartskips/driver/mobileEmptySkip?did=" + did + "&lid=" + lid;
            System.out.println(command);
            String result = WebServiceGet.executeHttpGet(command);
            result = (String) JsonUtil.json2obj(result, String.class);
            return result;
        }
        return  "failure";
    }


    public static String updatePwd(int did,String oldPwd, String newPwd){
        String command="/smartskips/driver/mobileUpdatePwd?did="+did+"&oldPwd="+oldPwd+"&newPwd="+newPwd;
        String result= WebServiceGet.executeHttpGet(command);
        result=(String) JsonUtil.json2obj(result, String.class);
        return  result;
    }

}


