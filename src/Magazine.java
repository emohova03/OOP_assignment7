import javax.swing.*;

class Magazine extends LibraryItem {
    public Magazine(int id) {
        super(id);
    }

    @Override
    public void borrowItem() {
        if (isAvailable()) {
            int dueDays = 14;
            setDueInDays(dueDays);
            setAvailability(false);
            JOptionPane.showMessageDialog(null, "Magazine with ID " + getId() + " borrowed. Due in " + getDueInDays() + " days.");
        } else {
            JOptionPane.showMessageDialog(null, "Magazine with ID " + getId() + " is not available.");
        }
    }
}
