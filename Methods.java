package com.mycompany.easykanbanapp1;

public class Methods {
    String firstName, surname, userName, password, enteredUserName, enteredPassword;

    public String registerUser() {
        return "User registered successfully!";
    }

    public boolean checkUsername() {
        return userName.length() >= 5;
    }

    public boolean checkPasswordComplexity() {
        return password.length() >= 8;
    }

    public boolean loginUser() {
        return enteredUserName.equals(userName) && enteredPassword.equals(password);
    }

    public String returnLoginStatus() {
        return loginUser() ? "Login Successful!" : "Invalid Login!";
    }
}
