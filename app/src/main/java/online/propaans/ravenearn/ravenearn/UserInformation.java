package online.propaans.ravenearn.ravenearn;

public class UserInformation {

    private String name;
    private String email;
    private String phone;
    private String amount;

    public UserInformation(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone_num(String phone) {
        this.phone = phone;
    }
}
