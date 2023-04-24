package com.example.carrent.model;

import com.example.carrent.utilities.IdGenerator;
import jakarta.inject.Named;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

public class Client implements Serializable {
    private String nickname;
    private String password;
    private Integer Id;

    public Client(String nickname, String password, Integer id) {
        this.nickname = nickname;
        this.password = password;
        this.Id= id;
    }

    public Client(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }



    public Client(){

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id){
        Id=id;
    }

}
