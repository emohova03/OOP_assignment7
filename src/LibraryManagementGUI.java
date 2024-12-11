import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class LibraryManagementGUI {
    private Member currentMember;
    private List<LibraryItem> libraryItems;

    public LibraryManagementGUI() {
        libraryItems = new ArrayList<>();
        libraryItems.add(new Book(101));
        libraryItems.add(new Book(102));
        libraryItems.add(new Magazine(201));
    }
    private void updateDropdown(JComboBox<String> dropdown) {
        dropdown.removeAllItems();
        for (LibraryItem item : libraryItems) {
            dropdown.addItem("Item ID: " + item.getId() + " (Available: " + item.isAvailable() + ")");
        }
    }
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel memberLabel = new JLabel("Select a Member:");
        JButton facultyButton = new JButton("Faculty Member");
        JButton studentButton = new JButton("Student Member");
        JButton guestButton = new JButton("Guest Member");

        JLabel itemLabel = new JLabel("Select an Item:");
        JComboBox<String> itemDropdown = new JComboBox<>(
                libraryItems.stream().map(item -> "Item ID: " + item.getId() + " (Available: " + item.isAvailable() + ")").toArray(String[]::new)
        );
        JButton borrowButton = new JButton("Borrow Item");
        JButton returnButton = new JButton("Return Item");

        JLabel statusLabel = new JLabel("Status: No member selected.");

        facultyButton.addActionListener(e -> {
            currentMember = new FacultyMember("F001", "Dr. Smith");
            statusLabel.setText("Current Member: Faculty - Dr. Smith");
        });

        studentButton.addActionListener(e -> {
            currentMember = new StudentMember("S001", "Alice");
            statusLabel.setText("Current Member: Student - Alice");
        });

        guestButton.addActionListener(e -> {
            currentMember = new GuestMember("G001", "Bob");
            statusLabel.setText("Current Member: Guest - Bob");
        });
        borrowButton.addActionListener(e -> {
            if (currentMember == null) {
                JOptionPane.showMessageDialog(frame, "Please select a member first.");
                return;
            }
            int selectedIndex = itemDropdown.getSelectedIndex();
            if (selectedIndex >= 0) {
                currentMember.borrowItem(libraryItems.get(selectedIndex));
                updateDropdown(itemDropdown);
            }
        });

        returnButton.addActionListener(e -> {
            if (currentMember == null) {
                JOptionPane.showMessageDialog(frame, "Please select a member first.");
                return;
            }
            int selectedIndex = itemDropdown.getSelectedIndex();
            if (selectedIndex >= 0) {
                currentMember.returnItem(libraryItems.get(selectedIndex));
                updateDropdown(itemDropdown);
            }
        });
        panel.add(memberLabel);
        panel.add(facultyButton);
        panel.add(studentButton);
        panel.add(guestButton);
        panel.add(itemLabel);
        panel.add(itemDropdown);
        panel.add(borrowButton);
        panel.add(returnButton);
        panel.add(statusLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
