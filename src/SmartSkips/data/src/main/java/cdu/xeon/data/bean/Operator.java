package cdu.xeon.data.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2/04/2018.
 */


@DatabaseTable(tableName = "tb_operator")
public class Operator {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "name")
    private String name;
    public static final int MALE =0;
    public static final int FEMALE =1;
    //male:0   female:1
    @DatabaseField(columnName = "gender")
    private int gender;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true,columnName = "landfill_id")
    private Landfill landfill;

    public Operator() {
    }

    public Operator(String name, Landfill landfill) {
        this.name = name;
        this.landfill = landfill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Landfill getLandfill() {
        return landfill;
    }

    public void setLandfill(Landfill landfill) {
        this.landfill = landfill;
    }
}
