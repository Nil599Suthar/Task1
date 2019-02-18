package com.example.sutharnil.task1;

public class Student_info {

    private  String s_name ,s_address ;
    private  String s_enroll,s_gender;
    private int ID;

    public  Student_info(){}

    public  Student_info(int id,String s_name ,String s_address ,String s_enroll,String s_gender){
        this.ID=id;
        this.s_name =s_name;
        this.s_address =s_address;
        this.s_enroll =s_enroll;
        this.s_gender=s_gender;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public void setS_enroll(String  s_enroll)
    {
        this.s_enroll = s_enroll;
    }

    public void setS_gender(String s_gender) {
        this.s_gender = s_gender;
    }

    public String getS_gender() {
        return s_gender;
    }

    public String getS_name() {
        return s_name;
    }

    public String getS_address() {
        return s_address;
    }

    public String  getS_enroll() {
        return s_enroll;
    }
}
