package cdu.xeon.data.responce;

import com.j256.ormlite.dao.ForeignCollection;

import cdu.xeon.data.bean.Landfill;
import cdu.xeon.data.bean.Operator;

/**
 * Created by Administrator on 3/04/2018.
 */

public class LandfillResponce {


    private String name;
    private String address;
    private double GWCapacity;
    private double currentGWCapacity;
    private double CWCapacity;
    private double currentCWCapacity;
    private ForeignCollection<Operator> operators;

    public Landfill wrapper(){   //转化成自己的model

        Landfill landfill=new Landfill();
        landfill.setName(name);
        landfill.setAddress(address);
        landfill.setGWCapacity(GWCapacity);
        landfill.setCurrentGWCapacity(currentGWCapacity);
        landfill.setCWCapacity(CWCapacity);
        landfill.setCurrentCWCapacity(currentCWCapacity);

        //TODO
        return landfill;
    }

}
