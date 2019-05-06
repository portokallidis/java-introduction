package main;

import addressbook.AddressBookUI;
import addressbook.AddressBook;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        AddressBookUI.init(addressBook);
    }
}
