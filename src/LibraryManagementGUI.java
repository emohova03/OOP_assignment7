import javax.swing.*;
import java.awt.*;

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
