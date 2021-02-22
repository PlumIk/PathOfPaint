package Windows;

import javax.swing.*;
import java.awt.*;


public class WindowExample extends JFrame {
    private JMenuBar menuBar;
    private JToolBar toolBar;

    public WindowExample ()
    {
        this.setMinimumSize(new Dimension(640, 480));
        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException ignored) {}
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuBar=new JMenuBar();
        toolBar = new JToolBar("Main toolbar");
    }

    protected void AddMenu(JMenuBar InMenu){
        menuBar=InMenu;
        setJMenuBar(menuBar);
    }

    protected void AddTools(JToolBar InTools){
        toolBar=InTools;
        toolBar.setRollover(true);
        add(toolBar, BorderLayout.PAGE_START);
    }

}
