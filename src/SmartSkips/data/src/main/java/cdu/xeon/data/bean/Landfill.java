package cdu.xeon.data.bean;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2/04/2018.
 */

@DatabaseTable(tableName = "tb_landfill")
public class Landfill {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "address")
    private String address;

    @DatabaseField(columnName = "gwcapacity")
    private double GWCapacity;

    @DatabaseField(columnName = "current_gwcapacity")
    private double currentGWCapacity;

    @DatabaseField(columnName = "cwcapacity")
    private double CWCapacity;

    @DatabaseField(columnName = "current_cwcapacity")
    private double currentCWCapacity;

    @ForeignCollectionField(eager = false)
    private ForeignCollection<Operator> operators;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGWCapacity() {
        return GWCapacity;
    }

    public void setGWCapacity(double GWCapacity) {
        this.GWCapacity = GWCapacity;
    }

    public double getCurrentGWCapacity() {
        return currentGWCapacity;
    }

    public void setCurrentGWCapacity(double currentGWCapacity) {
        this.currentGWCapacity = currentGWCapacity;
    }

    public double getCWCapacity() {
        return CWCapacity;
    }

    public void setCWCapacity(double CWCapacity) {
        this.CWCapacity = CWCapacity;
    }

    public double getCurrentCWCapacity() {
        return currentCWCapacity;
    }

    public void setCurrentCWCapacity(double currentCWCapacity) {
        this.currentCWCapacity = currentCWCapacity;
    }

    public ForeignCollection<Operator> getOperators() {
        return operators;
    }

    public void setOperators(ForeignCollection<Operator> operators) {
        this.operators = operators;
    }
}
