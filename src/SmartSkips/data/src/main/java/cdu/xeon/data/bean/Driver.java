package cdu.xeon.data.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2/04/2018.
 */


@DatabaseTable(tableName = "tb_driver")
public class Driver {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "name")
    private String name;
    public static final int MALE =0;
    public static final int FEMALE =1;
    //male:0   female:1
    @DatabaseField(columnName = "gender")
    private int gender;

    @DatabaseField(columnName = "location")
    private String location;

    @DatabaseField(canBeNull = true, foreign = true, columnName = "skip_id")
    private Skip skip;

    public Driver() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Skip getSkip() {
        return skip;
    }

    public void setSkip(Skip skip) {
        this.skip = skip;
    }
}
