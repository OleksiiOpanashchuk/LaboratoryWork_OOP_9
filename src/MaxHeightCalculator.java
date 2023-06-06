import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaxHeightCalculator extends JFrame {
    private JTextField initialVelocityField;
    private JTextField angleField;
    private JLabel resultLabel;

    public MaxHeightCalculator() {
        setTitle("Max Height Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel initialVelocityLabel = new JLabel("Початкова швидкість (v0):");
        initialVelocityField = new JTextField(10);

        JLabel angleLabel = new JLabel("Кут (0 < a < 90):");
        angleField = new JTextField(10);

        JButton calculateButton = new JButton("Обчислити максимальну висоту");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMaxHeight();
            }
        });

        resultLabel = new JLabel();

        add(initialVelocityLabel);
        add(initialVelocityField);
        add(angleLabel);
        add(angleField);
        add(calculateButton);
        add(resultLabel);

        setVisible(true);
    }

    private void calculateMaxHeight() {
        try {
            double initialVelocity = Double.parseDouble(initialVelocityField.getText());
            double angle = Double.parseDouble(angleField.getText());
            double gravity = 9.8; // Прискорення вільного падіння (приклад)

            double sinAngle = Math.sin(Math.toRadians(angle));
            double maxHeight = (Math.pow(initialVelocity * sinAngle, 2)) / (2 * gravity);

            resultLabel.setText("Максимальна висота: " + maxHeight + " м");
        } catch (NumberFormatException e) {
            resultLabel.setText("Помилка: некоректні значення швидкості або кута");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MaxHeightCalculator();
            }
        });
    }
}
