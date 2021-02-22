package Windows;

import Also.Base.CustomColorBase;
import Screen.ExamplePanel;

import javax.swing.*;
import java.awt.*;

public class CustomColor extends WindowExample{
    public JSlider RedSlider=new JSlider(0,255,255);
    public JSlider GreenSlider=new JSlider(0,255,255);
    public JSlider BlueSlider=new JSlider(0,255,255);
    public ExamplePanel Example=new ExamplePanel();
    public boolean end=false;
    public boolean err=false;

    public CustomColor(){
        JLabel RedText=new JLabel("Red");
        JLabel GreenText=new JLabel("Green");
        JLabel BlueText=new JLabel("Blue");
        JButton Ok=new JButton("Ok");
        JButton CancelB = new JButton("Cancel");

        Container container= getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridy = 0;
        constraints.gridx = 0;

        container.add(RedText,constraints);
        constraints.gridx = 2;
        container.add(RedSlider,constraints);
        constraints.gridy = 1;
        constraints.gridx = 0;
        container.add(GreenText,constraints);
        constraints.gridx = 2;
        container.add(GreenSlider,constraints);
        constraints.gridy = 2;
        constraints.gridx = 0;
        container.add(BlueText,constraints);
        constraints.gridx = 2;
        container.add(BlueSlider,constraints);
        constraints.gridy = 3;
        constraints.gridx = 1;
        container.add(Example,constraints);
        constraints.gridy = 4;
        container.add(Ok,constraints);
        constraints.gridy = 5;
        container.add(CancelB, constraints);

        CancelB.addActionListener(e -> {
            end=true;
            err=true;
        });
        Ok.addActionListener(e -> {
            end=true;
        });
    }
}
