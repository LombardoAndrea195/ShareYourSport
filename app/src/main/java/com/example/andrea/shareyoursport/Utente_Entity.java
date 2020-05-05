package com.example.andrea.shareyoursport;

import android.graphics.Bitmap;

import java.util.Date;

public class Utente_Entity {
    private Date birthday;
    private String Name;
    private String Surname;
    private String Email;
    private String Sex;
    private String password;
    private String City;
    private Bitmap Uri;

    public Utente_Entity(Date birthday, String name, String surname, String email, String sex, String password, String city) {
        this.birthday = birthday;
        Name = name;
        Surname = surname;
        Email = email;
        Sex = sex;
        this.password = password;
        City = city;
    }

    public Utente_Entity(Date birthday, String name, String surname, String email, String sex, String password, String city, Bitmap uri) {
        this.birthday = birthday;
        Name = name;
        Surname = surname;
        Email = email;
        Sex = sex;
        this.password = password;
        City = city;
        Uri = uri;
    }

    public Bitmap getUri() {
        return Uri;
    }

    public void setUri(Bitmap uri) {
        Uri = uri;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCity(String city) {
        City = city;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getEmail() {
        return Email;
    }

    public String getSex() {
        return Sex;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return City;
    }
}
