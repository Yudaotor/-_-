package com.laurie.pojo;

/**
 * User
 * @author Laurie
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String cellphone;

    public User() {

    }

    public User(Integer id, String username, String password, String email, String cellphone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.cellphone = cellphone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {this.cellphone = cellphone;}

}
