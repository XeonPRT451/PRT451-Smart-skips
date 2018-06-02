package cdu.xeon.data.responce;

import cdu.xeon.data.bean.Landfill;
import cdu.xeon.data.bean.Operator;

/**
 * Created by Administrator on 3/04/2018.
 */

public class OperatorResponce {
    private String name;
    private int gender;
    private Landfill landfill;

    public Operator wrapper(){   //转化成自己的model

        Operator operator=new Operator();


        //TODO
        return operator;
    }
}
