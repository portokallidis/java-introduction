package addressbook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AddressBook {
    /* Create hash map for fast lookups when searching by name
    *
    * <ContactName, ContactObject>
    * */
    private Map<String, Contact> contacts = new HashMap<String, Contact>();

    /* In the second map keep only the key of the root hashmap store
    *
    * <ContactPhone, ContactName>
    *  */
    private Map<String, String> contactsByPhone = new HashMap<String, String>();

    public AddressBook() {
//        Sample Data
        this.addContact("Rob", "6943929211", "rob@stark.com", ",Winterfell graveyard BT30 7BA");
        this.addContact("Sansa", "6943929222", "sansa@stark.com", "Winterfell castle BT30 7BA");
        this.addContact("Arya", "6943929233", "arya@stark.com", "Bravos MFG 5032");
        this.addContact("Bran", "6943929244", "bran@stark.com", "Beyond the wall 3ER 245");
    }

    public boolean hasContact(String name) {
        return this.contacts.containsKey(name);
    }

    public boolean hasContactByPhone(String phone) {
        return this.contactsByPhone.containsKey(phone);
    }

    public void addContact(String name, String phone, String email, String address) {
        Contact a = new Contact(name, phone, email, address);
        this.contacts.put(name, a);
        this.contactsByPhone.put(phone, name);
    }

    public Contact editContactName(String oldName, String newName) {
        Contact a = this.getContact(oldName);
        if (a != null) {
            String phone = a.getPhone();
            a.editName(newName);
            //  first remove the old one from the dictionaries
            this.contactsByPhone.remove(phone);
            this.contacts.remove(oldName);
            //  then add the contact under a new name
            this.contacts.put(newName, a);
            this.contactsByPhone.put(phone, newName);

            return this.getContact(newName);
        } else return null;
    }

    public void editContactPhone(String oldPhone, String newPhone) {
        Contact a = this.getContactByPhone(oldPhone);
        if (a != null) {
            a.editPhone(newPhone);
            this.contactsByPhone.remove(oldPhone);
            this.contactsByPhone.put(newPhone, a.getName());
        }
    }

    public boolean deleteContact(String name) {
        Contact a = this.getContact(name);
        if (a != null) {
            String phone = a.getPhone();
            this.contactsByPhone.remove(phone);
            this.contacts.remove(name);
            return true;
        } else return false;

    }

    public Contact getContact(String name) {
        if (this.contacts.containsKey(name)) {
            return this.contacts.get(name);
        } else this.handleError("Contact with name <" + name + "> doesn't exist");
        return null;
    }

    public Contact getContactByPhone(String phone) {
        if (this.contactsByPhone.containsKey(phone)) {
            String name = this.contactsByPhone.get(phone);
            return this.getContact(name);
        } else this.handleError("Contact with phone <" + phone + "> doesn't exist");
        return null;
    }

    public Iterator<Contact> getAllContacts() {
        return this.contacts.values().iterator();
    }

    private void handleError(String s) {
        System.out.println("Error: " + s);
    }

}