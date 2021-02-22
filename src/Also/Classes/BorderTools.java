package Also.Classes;

import javax.swing.*;
import java.awt.*;

public class BorderTools {
    public JButton ChBottomAk=null;
    public JButton ChBottomCo=null;

    public void NewCol(JButton NewBot){
        ChBottomCo.setSelected(false);
        ChBottomCo=NewBot;
        ChBottomCo.setSelected(true);
    }

    public void NewAk(JButton NewBot){
        if (ChBottomAk != null) {
            ChBottomAk.setSelected(false);
        }
        ChBottomAk=NewBot;
        ChBottomAk.setSelected(true);
    }
}
