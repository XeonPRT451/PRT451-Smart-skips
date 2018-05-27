package cdu.xeon.data;
import junit.framework.Assert;

import org.junit.Test;

import java.util.List;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.bean.Skip;
import cdu.xeon.data.repository.Repository;

public class TestRepository {

    @Test
    public void testLogin(){
     Driver da=Repository.login("admin1","123456" );
     Driver dr=new Driver();
     dr.setPhone("0410454232");
        Assert.assertEquals(da.getPhone(),dr.getPhone());
    }
//
//    @Test
//    public void testGetSkip(){
//        List<Skip> ls=Repository.getSkip();
//
//        Assert.assertEquals(-12.37707,ls.get(1).getLatitude());
//    }
//
//    @Test
//    public void testUpdateDriver(){
//       Driver d= new Driver(2,"abc","admin2@admin.com","0410666666");
//        Assert.assertEquals("success",Repository.updateDriver(d));
//    }
//
//    @Test
//    public void testPickupSkip(){
//        Assert.assertEquals("success",Repository.pickupSkip(1,1));
//
//    }
//
//    @Test
//    public void testEmptySkip(){
//
//
//        Assert.assertEquals("success",Repository.emptySkip(1,1));
//    }

//    @Test
//    public void testUpdatePwd(){
//
//        System.out.println(Repository.updatePwd(2,"123","321"));
//    }
//

    //    @Test
//    public void testGetDriver(){
//        System.out.println(Repository.getDriverDetails(App.getContext()));
//    }

//    @Test
//    public void testGetSkip(){
//        System.out.println(Repository.getSkip());
//    }
}
