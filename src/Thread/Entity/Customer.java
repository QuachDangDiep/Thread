package Thread.Entity;

public class Customer extends Entity<Integer>{
    private String Customername;
    private String Customeraddress;
    private String Customerphone;
    private String Customeremail;

    public Customer(Integer id) {
        super(id);
    }

    public Customer(Integer id, String customername, String customeraddress, String customerphone, String customeremail) {
        super(id);
        Customername = customername;
        Customeraddress = customeraddress;
        Customerphone = customerphone;
        Customeremail = customeremail;
    }

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String customername) {
        Customername = customername;
    }

    public String getCustomeraddress() {
        return Customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        Customeraddress = customeraddress;
    }

    public String getCustomerphone() {
        return Customerphone;
    }

    public void setCustomerphone(String customerphone) {
        Customerphone = customerphone;
    }

    public String getCustomeremail() {
        return Customeremail;
    }

    public void setCustomeremail(String customeremail) {
        Customeremail = customeremail;
    }

    public String getAddress() {
        return getAddress();
    }

    public String getName() {
        return getName();
    }

    public String getPhone() {
        return getPhone();
    }

    public String getEmail() {
        return getEmail();
    }
}
