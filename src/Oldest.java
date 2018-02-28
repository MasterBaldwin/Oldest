import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Oldest {
// Written by: Mike Baldwin
// Project 5 - Part 1 - Finding the Oldest
// Determines the oldest person from a list of people and ages

public static void main(String[] args) {
    List<Person> members;
    JPanel panel;
    JTextField nameField, ageField;

    members = new ArrayList<>();
    panel = new JPanel();
    nameField = new JTextField(8);
    ageField = new JTextField(3);
    panel.add(new JLabel("Name:")); panel.add(nameField);
    panel.add(Box.createHorizontalStrut(15));
    panel.add(new JLabel("Age:")); panel.add(ageField);

    while (!nameField.getText().equals("quit")) {
        nameField.setText("");
        ageField.setText("0");
        JOptionPane.showConfirmDialog(null, panel, "Finding the Oldest", JOptionPane.DEFAULT_OPTION);
        members.add(new Person(nameField.getText(), ageField.getText().isEmpty() ? 0 : Integer.parseInt(ageField.getText())));
    }

    members.sort(Comparator.comparingInt(o -> o.age));
    JOptionPane.showMessageDialog(null, "The oldest person is " + members.get(members.size() - 1).name);
}
}
