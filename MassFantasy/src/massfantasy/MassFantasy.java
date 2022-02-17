package massfantasy;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MassFantasy extends JFrame
{
    // GUI components
    Container contents;
    public JButton choice1,choice2,choice3,choice4,quit,con,reset;
    public JTextArea message;
    
    //constructor
    public MassFantasy()
    {
        //call JFrame constructor with title bar text
        super("Mass Fantasy");
        setUndecorated(true);
        
        //get container for components
        contents=getContentPane();
        
        //set layout manager
        contents.setLayout(new BorderLayout());
        
        //instantiate GUI components and other instance variables
        
        message=new JTextArea("HP: "+CharacterInfo.getHP()+"\nMana: "
        +CharacterInfo.getMana()+"\nExp: "+CharacterInfo.getExp());
        message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        choice1=new JButton("Wilds");
        choice2=new JButton("Civilization");
        choice3=new JButton("Boss");
        if (CharacterInfo.exp<3)
            choice3.setVisible(false);
        choice4=new JButton("Inventory");
        con=new JButton("Continue");
        quit=new JButton("Quit");
        reset=new JButton("Reset");
        JPanel buttonPanel=new JPanel(new GridLayout(5,1,0,5));
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        buttonPanel.add(message);
        buttonPanel.add(choice1);
        buttonPanel.add(choice2);
        buttonPanel.add(choice3);
        buttonPanel.add(choice4);
        end.add(quit);
        end.add(reset);
        
        message.setEditable(false);
        
        setBackground(Color.black);
        buttonPanel.setBackground(Color.black);
        message.setBackground(Color.black);
        message.setForeground(Color.white);
        choice1.setBackground(Color.BLACK);
        choice1.setForeground(Color.WHITE);
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        quit.setBackground(Color.black);
        quit.setForeground(Color.white);
        con.setBackground(Color.black);
        con.setForeground(Color.white);
        reset.setBackground(Color.black);
        reset.setForeground(Color.white);
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        
        //add GUI components to the content pane
        contents.add(buttonPanel,BorderLayout.CENTER);
        contents.add(end,BorderLayout.SOUTH);
        
        //instantiate the buttonhandler
        ButtonHandler bh = new ButtonHandler();
        
        choice1.addActionListener(bh);
        choice2.addActionListener(bh);
        choice3.addActionListener(bh);
        choice4.addActionListener(bh);
        quit.addActionListener(bh);
        con.addActionListener(bh);
        reset.addActionListener(bh);
        
        //set original size of window
        setExtendedState(MAXIMIZED_BOTH);
        
        //make window visible
        setVisible(true);
    }//end MassFantasy constructor
    
    //private inner class event handler
    private class ButtonHandler implements ActionListener
    {
        WildernessQuests wq=new WildernessQuests();
        CivilizationQuests cq=new CivilizationQuests();
        Ending e=new Ending();
        public void actionPerformed(ActionEvent ae)
        {
            if (ae.getSource()==choice1)
            {
                dispose();
                wq.Scenario6();
            }//end WildsCurrents
            else if(ae.getSource()==choice2)
            {
                dispose();
                cq.QuestSelect();
            }//end CivQuests
            else if(ae.getSource()==choice3)
            {
                dispose();
                e.InfiltrateTheKeep();
            }//end Boss
            else if(ae.getSource()==choice4)
            {
                CharacterInfo ci=new CharacterInfo();
                dispose();
                CharacterInfo.printInvName();
                //inventory
            }// end Inventory

            else if(ae.getSource()==con)
            {
                dispose();
                MassFantasy mf=new MassFantasy();
            }// end Continue
            else if(ae.getSource()==quit)
            {
                System.exit(0);
            }//end quit
            else if(ae.getSource()==reset)
            {
                Reset();
            }
        }//end actionPerformed
    }//end ButtonHandler
    
    public static void main(String[] args) {
        MassFantasy basicGui=new MassFantasy();
        basicGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end main method
    
    public void Reset()
    {
        dispose();
        revalidate();
        CharacterInfo.currentHP=CharacterInfo.maxHP;
        CharacterInfo.currentMana=CharacterInfo.maxMana;
        CharacterInfo.exp=0;
        for(int i=0;i<=5;i++)
        {
            CharacterInfo.invVal[i]=0;
        }
        MassFantasy mf=new MassFantasy();
    }
    public void Death()
    {
        String death = "You fought hard and valiantly, but in the end it was not\n"
                + " enough. You succomb to your wounds and everything fades. \n"
                + "into black.\nGame Over...";
        contents.removeAll();
        contents.revalidate();
        contents.removeAll();
        contents.setLayout(new BorderLayout());
        JPanel over=new JPanel();
        message.setText(death);
        reset.setText("Restart");
        over.add(message);
        over.add(reset);
        contents.add(message,BorderLayout.CENTER);
        contents.add(reset,BorderLayout.SOUTH);
    }
}//end MassFantasy class