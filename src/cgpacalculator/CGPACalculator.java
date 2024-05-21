
package cgpacalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CGPACalculator extends JFrame implements ActionListener {

    JTextField tfCIT, tfCCE, tfPHY, tfMATH, tfENG, tfEEE;
    JButton calculateButton;
    JLabel resultLabel, averageLabel;

    CGPACalculator() {
        setTitle("CGPA Calculator");
        setSize(600, 400); // Increased the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(new GridLayout(8, 2, 10, 10));

        // Labels for subjects
        JLabel labelCIT = new JLabel("CIT:");
        JLabel labelCCE = new JLabel("CCE:");
        JLabel labelPHY = new JLabel("PHY:");
        JLabel labelMATH = new JLabel("MATH:");
        JLabel labelENG = new JLabel("ENG:");
        JLabel labelEEE = new JLabel("EEE:");

        // TextFields for entering marks
        tfCIT = new JTextField();
        tfCCE = new JTextField();
        tfPHY = new JTextField();
        tfMATH = new JTextField();
        tfENG = new JTextField();
        tfEEE = new JTextField();

        // Button to calculate CGPA
        calculateButton = new JButton("Calculate CGPA");
        calculateButton.addActionListener(this);

        // Labels to display result and average CGPA
        resultLabel = new JLabel("");
        averageLabel = new JLabel("");

        // Add components to the frame
        add(labelCIT);
        add(tfCIT);
        add(labelCCE);
        add(tfCCE);
        add(labelPHY);
        add(tfPHY);
        add(labelMATH);
        add(tfMATH);
        add(labelENG);
        add(tfENG);
        add(labelEEE);
        add(tfEEE);
        add(calculateButton);
        add(resultLabel);
        add(averageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            // Get marks from text fields
            double cit = Double.parseDouble(tfCIT.getText());
            double cce = Double.parseDouble(tfCCE.getText());
            double phy = Double.parseDouble(tfPHY.getText());
            double math = Double.parseDouble(tfMATH.getText());
            double eng = Double.parseDouble(tfENG.getText());
            double eee = Double.parseDouble(tfEEE.getText());

            // Check if any subject has marks below 40
            if (cit < 40 || cce < 40 || phy < 40 || math < 40 || eng < 40 || eee < 40) {
                resultLabel.setText("FAIL");
                averageLabel.setText("");
            } else {
                // Calculate average CGPA
                double averageCGPA = calculateAverageCGPA(cit, cce, phy, math, eng, eee);

                // Display the result and average CGPA
                resultLabel.setText("PASSED");
                averageLabel.setText("Average CGPA: " + averageCGPA);
            }
        }
    }

    private double calculateAverageCGPA(double cit, double cce, double phy, double math, double eng, double eee) {
        return (calculateCGPA(cit) + calculateCGPA(cce) + calculateCGPA(phy) +
                calculateCGPA(math) + calculateCGPA(eng) + calculateCGPA(eee)) / 6;
    }

    private double calculateCGPA(double marks) {
        if (marks >= 80) {
            return 4.0;
        } else if (marks >= 75) {
            return 3.75;
        } else if (marks >= 70) {
            return 3.5;
        } else if (marks >= 65) {
            return 3.25;
        } else if (marks >= 60) {
            return 3.0;
        } else if (marks >= 55) {
            return 2.75;
        } else if (marks >= 50) {
            return 2.5;
        } else if (marks >= 45) {
            return 2.25;
        } else {
            return 2.0; // Assuming the minimum passing marks are 40
        }
    }

    public static void main(String[] args) {
        new CGPACalculator();
    }
}

