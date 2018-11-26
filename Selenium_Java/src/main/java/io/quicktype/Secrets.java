package io.quicktype;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Secrets {
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String yearofbirth;
    private String dayofbirth;
    private String monthofbirth;

    @JsonProperty("email")
    public String getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(String value) { this.email = value; }

    @JsonProperty("firstname")
    public String getFirstname() { return firstname; }
    @JsonProperty("firstname")
    public void setFirstname(String value) { this.firstname = value; }

    @JsonProperty("lastname")
    public String getLastname() { return lastname; }
    @JsonProperty("lastname")
    public void setLastname(String value) { this.lastname = value; }

    @JsonProperty("password")
    public String getPassword() { return password; }
    @JsonProperty("password")
    public void setPassword(String value) { this.password = value; }

    @JsonProperty("yearofbirth")
    public String getYearofbirth() { return yearofbirth; }
    @JsonProperty("yearofbirth")
    public void setYearofbirth(String value) { this.yearofbirth = value; }

    @JsonProperty("dayofbirth")
    public String getDayofbirth() { return dayofbirth; }
    @JsonProperty("dayofbirth")
    public void setDayofbirth(String value) { this.dayofbirth = value; }

    @JsonProperty("monthofbirth")
    public String getMonthofbirth() { return monthofbirth; }
    @JsonProperty("monthofbirth")
    public void setMonthofbirth(String value) { this.monthofbirth = value; }
}
