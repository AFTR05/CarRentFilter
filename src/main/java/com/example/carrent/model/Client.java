package com.example.carrent.model;

import com.example.carrent.utilities.IdGenerator;

public class Client {
    private String nickname;
    private String password;
    private Integer Id;

    public Client(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
        this.Id= IdGenerator.id++;
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
