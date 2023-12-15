package cn.edu.swu.user.model;

public class UserData {

    private Integer userId;
    private String account;
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String introduce;

    public UserData() {

    }

    public UserData(Integer userId, String account, String nickname, String email, String phone, String firstName, String lastName, String address, String city, String country, String introduce) {
        this.userId = userId;
        this.account = account;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.introduce = introduce;
    }

    public UserData(Integer userId, String nickname, String email, String address, String city, String country, String introduce) {
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.country = country;
        this.introduce = introduce;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
