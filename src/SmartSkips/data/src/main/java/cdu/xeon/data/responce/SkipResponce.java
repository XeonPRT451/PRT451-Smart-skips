package cdu.xeon.data.responce;

import java.util.function.ToDoubleBiFunction;

import cdu.xeon.data.bean.Driver;
import cdu.xeon.data.bean.Skip;

/**
 * Created by Administrator on 3/04/2018.
 */

public class SkipResponce {
    private String name;
    private String location;
    private int full;
    private int type;
    private double capacity;
    private double currentCapacity;
    private String driverId;

    public Skip wrapper(){   //转化成自己的model

        Skip skip=new Skip();
        skip.setName(name);
        skip.setLocation(location);
        skip.setFull(full);
        skip.setType(type);
        skip.setCapacity(capacity);
        skip.setCurrentCapacity(currentCapacity);
        //TODO
        return skip;
    }


}
