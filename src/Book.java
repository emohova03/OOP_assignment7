import javax.swing.*;

class Book extends LibraryItem {
    public Book(int id) {
        super(id);
    }

    @Override
    public void borrowItem() {
        if (isAvailable()) {
            int dueDays = 28;
            setDueInDays(dueDays);
            setAvailability(false);
            JOptionPane.showMessageDialog(null, "Book with ID " + getId() + " borrowed. Due in " + getDueInDays() + " days.");
        } else {
            JOptionPane.showMessageDialog(null, "Book with ID " + getId() + " is not available.");
        }
    }
}