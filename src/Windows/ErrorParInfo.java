package Windows;

import javax.swing.*;
import java.awt.*;

public class ErrorParInfo extends WindowExample{

    public ErrorParInfo(int what){
        super();
        this.setSize(300,400);

        Container container= getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridy   = 0  ;
        constraints.gridx = 0;
        if(what==1){
            container.add(new JLabel("Bad size. Need be more than 0"), constraints);
        }
        else if(what==2){
            container.add(new JLabel("Bad coal. Need be between 0 and 360"), constraints);
        }
        else if(what==3){
            container.add(new JLabel("Bad coal num. Need be more than 0 and less then 100"), constraints);
        }
        else {
            container.add(new JLabel("Ha-ha"), constraints);
        }
        constraints.gridy   = 1  ;
        container.add(new JLabel(" "), constraints);
        constraints.gridy   = 2  ;
        JButton Ok=new JButton("Ok");
        container.add(Ok,constraints);
        Ok.addActionListener(e -> {setVisible(false);});

        this.setVisible(true);
    }
}
