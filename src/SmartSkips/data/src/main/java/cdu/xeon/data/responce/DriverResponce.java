package cdu.xeon.data.responce;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.bean.Skip;

/**
 * Created by Administrator on 3/04/2018.
 */

public class DriverResponce {
    private String name;
    private int gender;
    private String location;
    private Skip skip;

    public Driver wrapper(){   //转化成自己的model

        Driver driver=new Driver();
        driver.setUsername(name);

        //TODO
        return driver;
    }

}
