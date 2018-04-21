package cdu.xeon.data.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Administrator on 2/04/2018.
 */


@DatabaseTable(tableName = "tb_driver")
public class Driver {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "username")
    private String username;

    @DatabaseField(columnName = "password")
    private String password;

   /** public static final int MALE =0;
    public static final int FEMALE =1;
    //male:0   female:1
    @DatabaseField(columnName = "gender")
    private int gender;
**/
   @DatabaseField(columnName = "nickname")
    private String nickname;
    @DatabaseField(columnName = "email")
    private String email;
    @DatabaseField(columnName = "phone")
    private String phone;
    @DatabaseField(columnName = "status")
    private int status;
    @DatabaseField(columnName = "create_date")
    private Date createDate;

    @DatabaseField(canBeNull = true, foreign = true, columnName = "sid")
    private Skip skip;

    private String sname;

    public Driver() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public Skip getSkip() {
        return skip;
    }

    public void setSkip(Skip skip) {
        this.skip = skip;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", skip=" + skip +
                ", sname='" + sname + '\'' +
                '}';
    }
}
