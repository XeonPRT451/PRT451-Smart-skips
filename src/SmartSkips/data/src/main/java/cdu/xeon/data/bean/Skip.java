package cdu.xeon.data.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Administrator on 2/04/2018.
 */



 @DatabaseTable(tableName = "tb_skip")
public class Skip implements Serializable {
      @DatabaseField(generatedId = true)
 private int id;
        @DatabaseField(columnName = "name")
 private String name;
          @DatabaseField(columnName = "location")
   private String location;

     public static final int EMPTY =0;
     public static final int FULL =1;
          // 0:empty    1:full
     @DatabaseField(columnName = "full")
    private int full;

    @DatabaseField(columnName = "status")
     private int status;

     public static final int GENERAL_WASTE =0;
     public static final int CONSTRUCTION_WASTE =1;
     //  0:general waste 1:construction waste
     @DatabaseField(columnName = "type")
     private int type;

    @DatabaseField(columnName = "capacity")
     private double capacity;

    @DatabaseField(columnName = "current_capacity")
    private double currentCapacity;

    @DatabaseField(columnName = "longitudes")
    private double longitude;

    @DatabaseField(columnName = "latitude")
    private double latitude;


     public Skip()
     {
     }

     public Skip(String name, String location)
     {
         this.name = name;
         this.location = location;
     }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(double currentCapacity) {
        this.currentCapacity = currentCapacity;
    }


     public int getFull() {
         return full;
     }

     public void setFull(int full) {
         this.full = full;
     }

     public int getType() {
         return type;
     }

     public void setType(int type) {
         this.type = type;
     }



            public int getId()
            {
                return id;
           }

            public void setId(int id)
           {
                this.id = id;
            }

            public String getName()
            {
                return name;
            }

            public void setName(String name)
            {
                this.name = name;
            }

            public String getLocation()
            {
                return location;
            }

           public void setLocation(String location)
          {
                this.location = location;
            }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }



}
