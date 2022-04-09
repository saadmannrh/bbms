public class PendingDonors {
    String name;
    String bg;
    String address;
    String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PendingDonors(String name, String bg, String address, String phone)
    {
        this.name = name;
        this.bg = bg;
        this.address = address;
        this.phone = phone;
    }
}
