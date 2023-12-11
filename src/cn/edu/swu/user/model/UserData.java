package cn.edu.swu.user.model;

public class UserData {

    private Integer userId;
    private String account;
    private String password;
    private String nickname;
    private String email;
    private String address;
    private String city;
    private String country;
    private String introduce;

    public UserData() {

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
}
