package massfantasystarredux;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MassFantasyStarRedux extends JFrame{
    
    //GUI components
    Container contents;
    public JButton c1,c2,c3,c4,quit,con,reset;
    public JTextArea message;
    
    //constructor
    public MassFantasyStarRedux()
    {
        //call JFrame constructor with title bar text
        super("Mass Fantasy Star Redux");
        setUndecorated(true);
        
        //get container for components
        contents=getContentPane();
        
        //set layout manager
        contents.setLayout(new BorderLayout());
        
        //instantiate GUI components and other instance variables
        
    }

    public static void main(String[] args) {
    
    }
    
}
