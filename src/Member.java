import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

abstract class Member implements MemberInterface {

    protected String id;
    protected String name;
    protected List<LibraryItem> borrowedItems;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedItems = new ArrayList<>();

}

@Override
public String getId() {
    return id;
}
@Override
public String getInfo() {
    return "Member ID: " + id + ", Name: " + name + ", Borrowed Items: " + borrowedItems.size();
}

@Override
public void returnItem(LibraryItem item) {
    if (borrowedItems.remove(item)) {
        item.setAvailability(true);
        JOptionPane.showMessageDialog(null, name + " returned item with ID " + item.getId());
    } else {
        JOptionPane.showMessageDialog(null, name + " does not have this item borrowed.");
    }
}

protected abstract int getBorrowLimit();
@Override
public boolean borrowItem(LibraryItem item) {
    if (borrowedItems.size() >= getBorrowLimit()) {
        JOptionPane.showMessageDialog(null, name + " has reached the borrowing limit of " + getBorrowLimit() + " items.");
        return false;
    }

    if (item.isAvailable()) {
        borrowedItems.add(item);
        item.setAvailability(false);
        JOptionPane.showMessageDialog(null, name + " borrowed item with ID " + item.getId());
        return true;
    } else {
        JOptionPane.showMessageDialog(null, "Item with ID " + item.getId() + " is not available.");
        return false;
    }
   }
}
