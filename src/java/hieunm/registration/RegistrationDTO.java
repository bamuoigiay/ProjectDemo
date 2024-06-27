/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieunm.registration;

/**
 *
 * @author LENOVO
 */
public class RegistrationDTO {
    // Class dung de chua du lieu tu db tra ve
    private String userName;
    private String password;
    private String lastName;
    private boolean isAdmin;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String userName, String password, String lastName, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
}
