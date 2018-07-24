package com.flamezz.homefitness;

public class User {

     String name;
    private String email;
    private String password;
    private String cnpassword;
    private String phone;

    User(String name,String email,String password,String cnpassword,String phone)
    {
        this.name=name;
        this.email=email;
        this.password=password;
        this.cnpassword=cnpassword;
        this.phone=phone;
    }
User()
{

}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnpassword() {
        return cnpassword;
    }

    public void setCnpassword(String cnpassword) {
        this.cnpassword = cnpassword;
    }
}
