import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatLauncher {

    JFrame launcherFrame;
    JTextField nameField;

    public static void main(String[] args) {
        new SimpleChatLauncher().go();
    }

    public void go() {
        launcherFrame = new JFrame("Simple Chat Launcher");

        JPanel mainPanel = new JPanel();

        JLabel label = new JLabel("Write a Username:");

        nameField = new JTextField(10);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartSimpleChatListener());

        mainPanel.add(label);
        mainPanel.add(nameField);
        mainPanel.add(startButton);

        launcherFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        launcherFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        launcherFrame.setSize(300,300);
        launcherFrame.setVisible(true);
    }

    public class StartSimpleChatListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name;

            name = nameField.getText();

            SimpleChatClient client = new SimpleChatClient(name);
            client.go();

            launcherFrame.setVisible(false);
        }
    }
}
