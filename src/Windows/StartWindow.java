package Windows;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends WindowExample {

    public StartWindow(){
        super();
        Label label1=new Label("Width:");
        JTextArea text1=new JTextArea("640  ");
        Label label2=new Label("High:");
        JTextArea text2=new JTextArea("480  ");
        JButton Ok=new JButton("Ok");

        Container container= getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridy = 0;
        constraints.gridx = 0;

        container.add(label1,constraints);
        constraints.gridx = 2;
        container.add(text1,constraints);
        constraints.gridx = 0;
        constraints.gridy = 1;
        container.add(label2,constraints);
        constraints.gridx = 2;
        container.add(text2,constraints);
        constraints.gridx = 1;
        constraints.gridy = 3;
        container.add(Ok,constraints);

        Ok.addActionListener(e -> {
            String width=text1.getText();
            width=width.split(" ")[0];
            String high=text2.getText();
            high=high.split(" ")[0];
            new MainWindow(isInt(width),isInt(high));
            setVisible(false);
        });
        setVisible(true);
    }

    private int isInt(String InString){
        try {
            Integer.parseInt(InString);
            return Integer.parseInt(InString);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
