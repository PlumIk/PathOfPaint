package Windows;

import Also.Base.MainWindowBase;
import Also.Classes.StarPar;
import Screen.MyPanel;

import javax.swing.*;
import java.awt.*;

public class ChoseWindow extends  WindowExample{
    public ChoseWindow(MainWindowBase InBase, int MyType, MyPanel inPanel){
        super();
        this.setSize(300,400);

        Container container= getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridy = 0;
        constraints.gridx = 0;
        JButton AcceptB = new JButton("Accept");
        JButton CancelB = new JButton("Cancel");
        JTextArea CoalArea = new JTextArea("0");
        JTextArea SizeArea = new JTextArea("20");
        JSlider ThicknessSlider=new JSlider(1,3,1);
        JTextArea CoalNumArea=new JTextArea("8");
        if (MyType!=1) {

            container.add(new JLabel("Size: "), constraints);
            constraints.gridx = 2;
            container.add(SizeArea, constraints);
            constraints.gridy = 1;
            constraints.gridx = 0;
            container.add(new JLabel("Coal: "), constraints);
            constraints.gridx = 2;
            container.add(CoalArea, constraints);
            constraints.gridy = 2;
            constraints.gridx = 1;
            container.add(new JLabel(" "), constraints);

        }
        if(MyType==8){
            constraints.gridy = 4;
            constraints.gridx = 0;
            container.add(new JLabel("Coal Num: "), constraints);
            constraints.gridx = 2;
            container.add(CoalNumArea,constraints);
        }
        constraints.gridy = 3;
        constraints.gridx = 0;
        container.add(new JLabel("Thickness: "), constraints);
        constraints.gridx = 2;
        container.add(ThicknessSlider,constraints);
        constraints.gridy = 5;
        constraints.gridx = 1;
        container.add(AcceptB, constraints);
        constraints.gridy = 6;
        constraints.gridx = 1;
        container.add(CancelB, constraints);

        CancelB.addActionListener(e -> setVisible(false));
        AcceptB.addActionListener(e->{
            if(MyType!=1) {
                switch (InBase.createStar(isInt(CoalArea.getText()), isInt(SizeArea.getText()), MyType, ThicknessSlider.getValue())) {
                    case (1):
                        setVisible(false);
                        new ErrorParInfo(1);
                        break;
                    case (2):
                        setVisible(false);
                        new ErrorParInfo(2);
                        break;
                    default:
                        if(MyType==8){
                            if(InBase.AboutStar.SetN(isInt(CoalNumArea.getText()))==0){
                                setVisible(false);
                                new ErrorParInfo(3);
                            }
                        }
                        break;
                }
            }
            else {
                InBase.createStar(2, 2, MyType, ThicknessSlider.getValue());
            }
            InBase.AcceptFig();
            this.setVisible(false);
        });

        this.setVisible(true);
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
