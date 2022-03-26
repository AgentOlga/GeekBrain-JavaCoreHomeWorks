package ru.geekbrains.lesson1;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


public class CounterApp extends JFrame {

    private int value;

    public static void main(String[] args) {
        new CounterApp(0);
    }
    CounterApp(final int intialValue) {
        setTitle("Simple Counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        Font font = new Font("Arial", Font.BOLD, 42);

        value = intialValue;

        JLabel counterValueView = new JLabel();
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterValueView, BorderLayout.CENTER);

        counterValueView.setText(String.valueOf(value));

        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value--;
                counterValueView.setText(String.valueOf(value));
            }
        });
        add(decrementButton, BorderLayout.WEST);

        JButton incrementButton = new JButton(">");
        incrementButton.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent actionEvent) {
            value++;
            counterValueView.setText(String.valueOf(value));
        }
    });
        incrementButton.setFont(font);
        add(incrementButton, BorderLayout.EAST);

        setVisible(true);

    }
}
