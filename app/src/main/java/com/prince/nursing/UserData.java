package com.prince.nursing;

public class UserData {
    String userName;
    String descp;
    String number;

    public UserData(String userName, String descp, String number) {
        this.userName = userName;
        this.descp = descp;
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
