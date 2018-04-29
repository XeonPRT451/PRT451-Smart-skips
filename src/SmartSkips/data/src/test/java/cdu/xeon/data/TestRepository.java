package cdu.xeon.data;
import org.junit.Test;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.repository.Repository;

public class TestRepository {

    @Test
    public void testGetDriver(){
        System.out.println(Repository.getDriverDetails(App.getContext()));
    }

    @Test
    public void testGetSkip(){
        System.out.println(Repository.getSkip());
    }

    @Test
    public void testUpdateDriver(){
        Driver d= new Driver(2,"abc","admin2@admin.com","1121");
        System.out.println(Repository.updateDriver(d,2));
    }

}
