package addressbook;

public class Contact {

    private String name;
    private String phone;
    private String email;
    private String address;

    public Contact( String n, String p, String e, String a) {
        this.name = n;
        this.phone = p;
        this.email = e;
        this.address = a;
    }

    public String show () {
        return this.name + " " + this.phone + " " + this.email + " " + this.address;
    }
    public String getPhone () {
        return this.phone;
    }
    public String getName () {
        return this.name;
    }


    public void editName (String data) {
        this.name = data;
    }
    public void editPhone (String data) {
        this.phone = data;
    }
    public void editEmail (String data) {
        this.email = data;
    }
    public void editAddress (String data) {
        this.address = data;
    }

}
