package pers.machimedes.DataNavi.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;


@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "account")
    private String account;
    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(long id, String account, String password) {
        this.id = id;
        this.account = account;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
