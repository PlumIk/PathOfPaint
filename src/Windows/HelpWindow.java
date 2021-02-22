package Windows;

import javax.swing.*;
import java.awt.*;

public class HelpWindow extends WindowExample {

    public HelpWindow(){

        super();
        this.setSize(300,400);

        Container container= getContentPane();
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        constraints.gridy   = 0  ;
        constraints.gridx = 0;

        JButton OK=new JButton("OK");
        OK.addActionListener(e->{ this.setVisible(false); });
        JLabel AboutMeOne=new JLabel("Creator:");
        JLabel AboutMeTwo=new JLabel("Alexandr Chemagin (PlumIk), group 18209");
        JLabel AboutProg=new JLabel("This program is a paint approval");
        container.add(AboutMeOne,constraints);
        constraints.gridy++;
        container.add(AboutMeTwo,constraints);
        constraints.gridy++;
        container.add(new JLabel(" "),constraints);
        constraints.gridy++;
        container.add(AboutProg,constraints);
        constraints.gridy++;
        container.add(new JLabel(" "),constraints);
        constraints.gridy++;
        container.add(OK,constraints);
        this.setVisible(true);

    }

}
