import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagementGUI().createAndShowGUI());
    }
}

class LibraryManagementGUI {
    private Book book;
    private Magazine magazine;

    public LibraryManagementGUI() {
        book = new Book(101);
        magazine = new Magazine(201);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JLabel bookLabel = new JLabel("Book (ID: 101) - Status: Available");
        JLabel magazineLabel = new JLabel("Magazine (ID: 201) - Status: Available");

        JButton borrowBookButton = new JButton("Borrow Book");
        JButton returnBookButton = new JButton("Return Book");
        JButton borrowMagazineButton = new JButton("Borrow Magazine");
        JButton returnMagazineButton = new JButton("Return Magazine");

        borrowBookButton.addActionListener(e -> {
            book.borrowItem();
            updateLabel(book, bookLabel);
        });

        returnBookButton.addActionListener(e -> {
            book.returnItem();
            updateLabel(book, bookLabel);
        });

        borrowMagazineButton.addActionListener(e -> {
            magazine.borrowItem();
            updateLabel(magazine, magazineLabel);
        });

        returnMagazineButton.addActionListener(e -> {
            magazine.returnItem();
            updateLabel(magazine, magazineLabel);
        });

        panel.add(bookLabel);
        panel.add(borrowBookButton);
        panel.add(returnBookButton);
        panel.add(magazineLabel);
        panel.add(borrowMagazineButton);
        panel.add(returnMagazineButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateLabel(LibraryItem item, JLabel label) {
        if (item.isAvailable()) {
            label.setText(item instanceof Book ? "Book (ID: " + item.getId() + ") - Status: Available"
                    : "Magazine (ID: " + item.getId() + ") - Status: Available");
        } else {
            label.setText(item instanceof Book ? "Book (ID: " + item.getId() + ") - Status: Borrowed, Due in " + item.getDueInDays() + " days"
                    : "Magazine (ID: " + item.getId() + ") - Status: Borrowed, Due in " + item.getDueInDays() + " days");
        }
    }
}

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

abstract class LibraryItem {
    private int id;
    private boolean availability;
    private int dueInDays;

    public LibraryItem(int id) {
        this.id = id;
        this.availability = true;
        this.dueInDays = -1;
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
