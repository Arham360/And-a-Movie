package com.example.arhamakbar.andamovie.Models;

public class UserProfile {

    public String firstName;
    public String lastName;
    public String gender;
    public Integer age;
    public String zipCode;
    public String nameOfMovie;
    public String fandangoEmail;
    public String fandangoPassword;

    // Constructor
    public UserProfile( String firstName,
                        String lastName,
                        String gender,
                        Integer age,
                        String zipCode,
                        String nameOfMovie,
                        String fandangoEmail,
                        String fandangoPassword) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.zipCode = zipCode;
        this.nameOfMovie = nameOfMovie;
        this.fandangoEmail = fandangoEmail;
        this.fandangoPassword = fandangoPassword;
    }

    public String getmFirstName() { return firstName; }
    public String getmLastName() {
        return lastName;
    }
    public String getmGender() {
        return gender;
    }
    public Integer getmAge() { return age; }
    public String getmZipCode() { return zipCode; }
    public String getNameOfMovie() { return nameOfMovie; }
    public String getmFandangoEmail() { return fandangoEmail; }
    public String getmFandangoPassword() { return fandangoPassword; }


}