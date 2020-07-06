package edu.na.pojos;

import edu.na.utilities.ConfigReader;

public class Student {

    public String username= ConfigReader.getKey("username");
    public String password=ConfigReader.getKey("password");

}
