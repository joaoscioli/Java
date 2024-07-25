package ContactList;

public class Contact {
    public String name;
    public String phone;
    public Contact next;

    public Contact() {
        this.name = null;
        this.phone = null;
        this.next = null;
    }
}
