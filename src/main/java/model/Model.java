package model;

public class Model {
    private static String password;
    private int id;
    private String  userName;
    private String  nic;
    private String  mobileNumber;
    private String  gender;


    public Model() {
    }

    public Model(int id, String userName, String nic, String mobileNumber, String gender, String password) {
        this.id = id;
        this.userName = userName;
        this.nic = nic;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getNic() {
        return nic;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getGender() {
        return gender;
    }

    public static String getPassword() {
        return password;
    }
}
