package com.mycompany.user;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name = "users_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45, nullable = false, name = "firstName")
    private String firstName;
    private String userid;
    private String password;
    private String gender;
    private String address;

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

    public String getgender() {return gender;}
    public void setgender(String gender) {this.gender = gender;}

    public String getaddress() {return address;}
    public void setaddress(String address) {this.address = address;}

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", userid='" + getuserid() + '\'' +
                ", password='" + getpassword() + '\'' +
                ", gender='" + getgender() + '\'' +
                ", address='" + getaddress() + '\'' +
                '}';
    }

}
