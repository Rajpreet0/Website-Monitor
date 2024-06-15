public class User {

    private String userId;
    private String email;
    private String phoneNumber;

    public User(String userId, String email, String phoneNumber) {
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter Methods
    public String getUserId(){
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter methods
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
