package cdu.xeon.data.bean;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Administrator on 2/04/2018.
 */

@DatabaseTable(tableName = "tb_landfill")
public class Landfill implements Serializable {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "address")
    private String address;

    @DatabaseField(columnName = "gwcapacity")
    private double GWCapacity;

    @DatabaseField(columnName = "current_GWCapacity")
    private double currentGWCapacity;

    @DatabaseField(columnName = "cwcapacity")
    private double CWCapacity;

    @DatabaseField(columnName = "current_CWCapacity")
    private double currentCWCapacity;

    @DatabaseField(columnName = "status")
    private int status;

    public Landfill() {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Landfill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", GWCapacity=" + GWCapacity +
                ", currentGWCapacity=" + currentGWCapacity +
                ", CWCapacity=" + CWCapacity +
                ", currentCWCapacity=" + currentCWCapacity +
                ", status=" + status +
                '}';
    }
}
