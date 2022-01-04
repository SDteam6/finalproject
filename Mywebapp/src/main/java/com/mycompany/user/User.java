package com.mycompany.user;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("ALL")
@Entity
@Table(name = "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 5, nullable = false, name = "firstName")
    private String firstName;
    private String userid;
    private String password;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;      //生日
    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getuserid() {
        return userid;
    }
    public void setuserid(String userid) {
        this.userid = userid;
    }

    public String getpassword() {return password;}
    public void setpassword(String password) {this.password = password;}

    public String getaddress() {return address;}
    public void setaddress(String address) {this.address = address;}

    public Date getBirthday() {
        return birthday;
     }
    public void setBirthday(Date birthday) {
      this.birthday = birthday;
    }

    public boolean checkEmail(){
        String format = "\\p{Alpha}\\w{2,15}[@][a-z0-9]{3,}[.]\\p{Lower}{2,}";
        String email = this.userid;
        System.out.println(email);
        if (email.matches(format)){
            return true;// 郵箱名合法，返回true
        }else{
            return false;// 郵箱名不合法，返回false
        }
    }

    public User() {
    }

    public User( String firstName, String userid, String password, String address) {
        this.firstName = firstName;
        this.userid = userid;
        this.password = password;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", userid='" + getuserid() + '\'' +
                ", password='" + getpassword() + '\'' +
                ", address='" + getaddress() + '\'' +
                ", birthday=" + birthday +
                '}';
    }

}

