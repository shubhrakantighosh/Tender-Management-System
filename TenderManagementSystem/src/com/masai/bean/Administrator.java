package com.masai.bean;

public class Administrator {
    private String Username;
    private String Password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Administrator(String username, String password) {
        Username = username;
        Password = password;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public Administrator() {

    }
}
