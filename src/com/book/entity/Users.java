package com.book.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Users", schema = "dbo", catalog = "BookShopPlus")
public class Users {
    private int id;
    private String loginId;
    private String loginPwd;
    private String name;
    private String address;
    private String phone;
    private String mail;
    private Timestamp birthday;
    private int userRoleId;
    private int userStateId;
    private String registerIp;
    private Timestamp registerTime;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "LoginId", nullable = false, length = 50)
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "LoginPwd", nullable = false, length = 50)
    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Address", nullable = false, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Phone", nullable = false, length = 100)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Mail", nullable = false, length = 100)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "Birthday", nullable = true)
    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "UserRoleId", nullable = false)
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Basic
    @Column(name = "UserStateId", nullable = false)
    public int getUserStateId() {
        return userStateId;
    }

    public void setUserStateId(int userStateId) {
        this.userStateId = userStateId;
    }

    @Basic
    @Column(name = "RegisterIp", nullable = true, length = 50)
    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    @Basic
    @Column(name = "RegisterTime", nullable = true)
    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (userRoleId != users.userRoleId) return false;
        if (userStateId != users.userStateId) return false;
        if (loginId != null ? !loginId.equals(users.loginId) : users.loginId != null) return false;
        if (loginPwd != null ? !loginPwd.equals(users.loginPwd) : users.loginPwd != null) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (address != null ? !address.equals(users.address) : users.address != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (mail != null ? !mail.equals(users.mail) : users.mail != null) return false;
        if (birthday != null ? !birthday.equals(users.birthday) : users.birthday != null) return false;
        if (registerIp != null ? !registerIp.equals(users.registerIp) : users.registerIp != null) return false;
        if (registerTime != null ? !registerTime.equals(users.registerTime) : users.registerTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (loginId != null ? loginId.hashCode() : 0);
        result = 31 * result + (loginPwd != null ? loginPwd.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + userRoleId;
        result = 31 * result + userStateId;
        result = 31 * result + (registerIp != null ? registerIp.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        return result;
    }
}
