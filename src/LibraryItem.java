import javax.swing.*;

abstract class LibraryItem {
    private int id;
    private boolean availability;
    private int dueInDays;

    public LibraryItem(int id) {
        this.id = id;
        this.availability = true;
        this.dueInDays = -1;//indicates availability(default number if available)
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getDueInDays() {
        return dueInDays;
    }

    public void setDueInDays(int dueInDays) {
        this.dueInDays = dueInDays;
    }

    public abstract void borrowItem();

    public void returnItem() {
        setAvailability(true);
        setDueInDays(-1);
        JOptionPane.showMessageDialog(null, "Item with ID " + id + " has been returned.");
    }
}
