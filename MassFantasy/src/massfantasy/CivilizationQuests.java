package massfantasy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CivilizationQuests 
{
    Random randNum = new Random();
    
    public void QuestSelect()
    {
        Random randNum = new Random();
        int randInt = randNum.nextInt(11) + 1;
        
        switch(randInt)
        {
            case 1: Scenario1();
                break;
            case 2: Scenario2();
                break;
            case 3: Scenario3();
                break;
            case 4: Scenario4();
                break;
            case 5: Scenario5();
                break;
            case 6: Scenario6();
                break;
            case 7: Scenario7();
                break;
            case 8: Scenario8();
                break;    
            case 9: Scenario9();
                break;  
            case 10: AmbushInTheSewers();
                break;
            case 11: DVG();
                break;

        }
    }
    //append lizardmen
    public void AmbushInTheSewers()
    {
        String questField;
        questField = "You slide a manhole cover aside before dropping into the repulsive smelling sewer "
                + "system.Several corridors have collasped, leaving one path to follow.\nAfter several "
                + "twists and turns, you find yourself entering a resevoir with running water all "
                + "traveling toward a single gate.\n You hear a multitude of footsteps approaching behind "
                + "you. You sprint toward the grate, only to realize that magic has sealed the way out! "
                + "It's an ambush!\nAs you turn you take in the sight of five lizardmen.What could only "
                + "be the leader shouts, \n\"If you want t'e leave dis place alive, fork over some of ur "
                + "weapons!\" ";
        
        
        String option1, option2, option3, option4;
        option1 = "Quickly draw your sword to cut down the lizards."; //-2hp +3mp
        option2 = "Throw a series of fireballs. (-3 mana)"; //-3 mana
        option3 = "Create a distraction using magic. (-1 mana)"; //-1mp
       /*secret*/ option4 = "Use \"Unlock Door\" spell book. (-2 mana)"; //-2 mana
        
       
       
       String result1 = "You cleave through two lizards with one swing.\nAs you raise your weapon to kill a third lizard, "
                + "the smaller of the remaining enemies cuts you in the abdomen with a small dagger, \nbefore "
                + "running away with the remaining survivors.\nFind a mana potion on a fallen enemy. (-2 hp, +3 mana)"; //-2 hp (+3 mana)
       String result2 = "Three of your five fireballs hit their targets burning the bodies to a crisp.\nBefore "
                + "you can react, an arrow loosed from one of the retreating lizards cuts your right "
                + "arm.\nSearching the remains reveald a minor health potion. (+4 hp, -3 mana)"; //-3 mana; gain 4 hp
       String result3 = "Before any of the lizardmen could react, you throw a bit of unstable magic into the air, creating flashing lights.\n"
                + "You flee the room and back up and out of the manhole just as you start to here running footsteps!\nYou escape! (-1 mana)";
        //Secret
       String result4 = "You spin quickly casting your unlock door spell on the sealed gate.\nAs the grate falls, you "
                + "dive through narrowly escaping several sword swings.\nRelief, the tunnel is too small for the lizards "
                + "to give chase.\nAt the end of the tunnel you find another manhole cover with a logbow and quiver "
                + "of arrows laying against the wall. (Gain longbow, -2 mana)"; //-2 mana; gain longbow
        //Send QuesstField
        //Send Option numbers
              
       MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
        if(CharacterInfo.getMana()<3)
            mf.choice2.setVisible(false);
        mf.choice3=new JButton(option3);
        if(CharacterInfo.getMana()<1)
            mf.choice3.setVisible(false);
        mf.choice4=new JButton(option4);
        if(CharacterInfo.getInvVal(2)==1&&CharacterInfo.getMana()>=2)
            mf.choice4.setVisible(true);
        else
            mf.choice4.setVisible(false);
        
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        stuff.add(mf.choice3);
        stuff.add(mf.choice4);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.choice3.setBackground(Color.black);
        mf.choice3.setForeground(Color.white);
        mf.choice4.setBackground(Color.black);
        mf.choice4.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentHP-=2;
            CharacterInfo.setHP(CharacterInfo.getHP());
            if (CharacterInfo.getHP()<=0)
                mf.Death();
            else
            {
            CharacterInfo.currentMana+=3;
            if (CharacterInfo.getMana()>=CharacterInfo.maxMana)
                CharacterInfo.setMana(CharacterInfo.maxMana);
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-2 hp,+3 mana
            }
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentMana-=3;
            CharacterInfo.currentHP+=4;
            CharacterInfo.setHP(CharacterInfo.getHP());
            if(CharacterInfo.currentHP>=CharacterInfo.maxHP)
                CharacterInfo.setHP(CharacterInfo.maxHP);
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-3Mana,+4HP
        }
        });//end button 2
        
        mf.choice3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentMana-=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result3);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-1 mana
        }
        });//end button 3
                                
        mf.choice4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentMana-=2;
            CharacterInfo.setMana(CharacterInfo.getMana());
            CharacterInfo.setInvVal(3);
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result4);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-2 mana; gain longbow
        }
        });//end button 4
    }
    
    public void DVG()
    {
       String questField;
       questField = "You enter what seems to be a regular village market only to find all of te merchant stalls "
               + "empty. A crowd seems to be gathered around the center of town where a 10ft tall\n human is mandhandling a dwarven merchant. "
               + "\"I require my weekly tribute, dwarf,\" bellows the human! \"I paid you already tis week,\" cries the dwarf!";
       String option1, option2, option3, option4;
       option1 = "Charge the human with your sword.";
       option2 = "Cast shock on the human. (-3 mana)";
       option3 = "Use laser rifle.";
       option4 = "Use longbow.";
       
       
       String result1 = "The human was not expecting this and after a few, well placed slashes, the human falls.\nOn the way down, you are struck by the human's "
               + "heavy fist. \nThe dwarf is relieved to be saved and rewards you with a minor mana potion for your assistance. (-2 hp, +3 mana)"; //-2hp +3mp
       String result2 = "Your electric attack impacts the human in the chest. \nThe human jitters in place before falling foward, dead, onto the ground. Unfortunatly "
               + "the dwarf did not escape your attack. \nWith singed hair and slightly burnt skin, the dwarf grudgingly gives you a reward. A worthless, minor "
               + "healing potion (+1 hp, -3 mana)"; //+1hp -3mp
       String result3 = "You take aim to avoid accidental friendly fire. \n"
               + "You pull the trigger. The laser beam hits its mark and the human goes down. \nThe dwarf recovers "
               + "and rewards you with a decent mana potion. (+6 mana)"; //+6mp
       String result4 = "You quickly draw two arrows and let them loose. \nThe first pierces the arm holding the dwarf and the second hits the human's heart. \n"
               + "The giant collapses onto the ground, dead. \"Thank you,\" cries the dwarf! The dwarf rewards you with a decent healing potion. (+5 hp)"; //+5hp
        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
        mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
        if(CharacterInfo.getMana()<3)
            mf.choice2.setVisible(false);
        mf.choice3=new JButton(option3);
        mf.choice4=new JButton(option4);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        if(CharacterInfo.getMana()<3)
            mf.choice2.setVisible(false);
        stuff.add(mf.choice3);
        stuff.add(mf.choice4);
        if(CharacterInfo.getInvVal(3)==0)
            mf.choice4.setVisible(false);
        
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.choice3.setBackground(Color.black);
        mf.choice3.setForeground(Color.white);
        mf.choice4.setBackground(Color.black);
        mf.choice4.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentHP-=2;
            if(CharacterInfo.getHP()<=0)
                    mf.Death();
            else
            {
            CharacterInfo.setHP(CharacterInfo.getHP());
            CharacterInfo.currentMana+=3;
            if (CharacterInfo.getMana()>=CharacterInfo.maxMana)
                CharacterInfo.setMana(CharacterInfo.maxMana);
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //(-2 hp, +3 mana)
            }
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentHP+=1;
            if (CharacterInfo.getHP()>=CharacterInfo.maxHP)
                CharacterInfo.setHP(CharacterInfo.maxHP);
            CharacterInfo.setHP(CharacterInfo.getHP());
            CharacterInfo.currentMana-=3;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //+1hp -3mp
        }
        });//end button 2
        
        mf.choice3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentMana+=6;
            CharacterInfo.setMana(CharacterInfo.getMana());
            if(CharacterInfo.getMana()>=CharacterInfo.maxMana)
                CharacterInfo.setMana(CharacterInfo.maxMana);
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result3);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //+6mp
        }
        });//end button 3
                                
        mf.choice4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentHP+=5;
            CharacterInfo.setHP(CharacterInfo.getHP());
            if (CharacterInfo.getHP()>=CharacterInfo.maxHP)
                CharacterInfo.setHP(CharacterInfo.maxHP);
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result4);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //+5hp
        }
        });//+5hp
    }
    
    public void Scenario1()
    {
        String questField;
        questField = "You are walking down the street when someone bumps"
                + " into you, almost knocking you down.  After a hasty apology,"
                + " the stranger runs off.  You instinctively check your\n pockets"
                + " and realize something is missing.  It must’ve been a"
                + " pickpocket! What do you do?";
        
        
        String option1, option2, option3, option4, result1, result2, result3, result4;
        option1 = "Chase them down"; 
        option2 = "Let them go";
        option3 = "Call for help";
       /*secret*/ option4 = "Use a weapon to intimidate the thief";
        
        result1 = "You give chase to the pickpocket, but they prove to be "
                + "quick on their feet.  \nThe chase leads you through back "
                + "alleys, up a fire escape, and jumping across rooftops before"
                + " you corner the thief. \nWith nowhere left to run, he "
                + "surrenders the item to you.  However, the chase took its "
                + "toll on you."; //-3 health
        
        result2 = "You decide that the stolen item isn’t worth your effort and"
                + " go on with your day."; //lose random item
        
        result3 = "You call out to the people around you for help, and they"
                + " quickly respond.  \nThe pickpocket is tackled, and the item is"
                + " quickly returned to you."; //nothing happens
        
        result4 = "The thief surrenders at the sight of your weapon and quickly"
                + " returns your item before running off with his tail between"
                + " his legs."; //nothing happens
        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
        mf.choice3=new JButton(option3);
        mf.choice4=new JButton(option4);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        stuff.add(mf.choice3);
        stuff.add(mf.choice4);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.choice3.setBackground(Color.black);
        mf.choice3.setForeground(Color.white);
        mf.choice4.setBackground(Color.black);
        mf.choice4.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
        
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentHP-=3;
            CharacterInfo.setHP(CharacterInfo.getHP());
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-3 health
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            int k=0;
            for(int i=0;i<5;i++)
            {
                k+=CharacterInfo.getInvVal(i);
            }
            if(k!=0)
            {
                Random x=new Random();
                int randInt = x.nextInt(5);
                CharacterInfo.removeInv(randInt);
            }
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //lose random item
        }
        });//end button 2
        
        mf.choice3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result3);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //nothing
        }
        });//end button 3
                                
        mf.choice4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result4);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //nothing
        }
        });//end button 4
    }
    
    public void Scenario2()
    {
        String questField;
        questField = "While wandering the city, you find yourself in a shady "
                + "part of town.  In truth, it's not much more than a "
                + "shantytown.  You come across a shop, and upon entering you"
                + " are \ngreeted by an old man who simply asks “Buying or"
                + " leaving?”  What do you do?";
        
        
        String option1, option2, option3, result1, result2, result3;
        option1 = "Buy something";
        option2 = "leave";
        /*secret*/option3 = "Rob the store";
 

        result1 = "You respond “Buying” and the old man grins.  After a short "
                + "time bartering, you leave the shop with you new item.";//Gain random item

        
        result2 = "You respond “Leaving” and dart out the door before the old man"
                + " responds.";//nothing happens
        
        result3 = "You pull out your weapon and demand the shopkeeper hand over"
                + " anything valuable.  \nHe pales at the sight of the weapon and"
                + " without saying a word, hands over an item.  \nSatisfied, you"
                + " leave before anyone shows up to stop you."; //gain random item
        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
        mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
        mf.choice3=new JButton(option3);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        stuff.add(mf.choice3);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.choice3.setBackground(Color.black);
        mf.choice3.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH); 
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo ci=new CharacterInfo();
            Random x=new Random();
            int randInt = x.nextInt(5);
            CharacterInfo.setInvVal(randInt);
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //gain random item
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //nothing
        }
        });//end button 2
        
        mf.choice3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            Random x=new Random();
            int randInt = x.nextInt(5);
            CharacterInfo.setInvVal(randInt);
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result3);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //gain random item
        }
        });//end button 3
                                
    }
    
    public void Scenario3()
    {
        String questField;
        questField = "While exploring the city, a large crowd catches your eye."
                + "Upon closer inspection, you can make out police cars "
                + "through the crowd.  \nYou make your way to the front of the "
                + "crowd and realize there is a hostage situation in the "
                + "building just past the police.  What do you do?";
        
        
        String option1, option2, option3, result1, result2, result3;
        option1 = "Sneak in to help the hostages"; 
        option2 = "Leave";
        /*secret*/option3 = "Sneak in the back way";
 
        result1 = "When nobody's looking, you slip past the police and into the"
                + "building.  \nThe building is small enough for you to find the"
                + "hostages and the two gunmen all in the same room without"
                + "them realizing your presence.  \nYou take the gunmen by"
                + "surprise, knocking one out before taking his gun to threaten"
                + "his partner, who promptly surrenders.  \nWhen you exit the"
                + "building with the hostages in tow, you are hailed as a hero."
                + "\nOne of the hostages slips you an item afterwards as a"
                + "show of gratitude.";//gain random item
        
        result2 = "You decide it's not your job to intervene and spend the rest"
                + "of your day elsewhere.";//Nothing happens
        
        result3 = "You go around the building where it is easier to sneak past"
                + "the smaller police force.  \nUpon unlocking the door, you"
                + "manage to quickly ambush the gunmen who had their sights on"
                + "the front of the building.  \nWhen you exit the building with"
                + "the hostages in tow, you are hailed as a hero.  \nOne of the"
                + "hostages slips you an item afterwards as a show of gratitude.";//Gain random item
        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
        mf.choice3=new JButton(option3);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        stuff.add(mf.choice3);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.choice3.setBackground(Color.black);
        mf.choice3.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            Random x=new Random();
            int randInt =x.nextInt(5);
            CharacterInfo.setInvVal(randInt);
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //gain random item
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //nothing
        }
        });//end button 2
        
        mf.choice3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            Random x=new Random();
            int randInt = x.nextInt(5);
            CharacterInfo.setInvVal(randInt);
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result3);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //gain random item
        }
        });//end button 3
                                
    }
    
    public void Scenario4()
    {
        String questField;
        questField = "You are walking down the street.  It's near sundown and "
                + "you are on your way home.  \nYou are passing an alleyway when "
                + "someone steps out and puts a gun to your head, telling you "
                + "to hand over any valuables.  \nWhat do you do?";
        
        
        String option1, option2, result1, result2;
        option1 = "Hand them over"; 
        option2 = "Attempt to disarm the attacker";
 
        result1 = "You don’t want to mess with this guy, so you follow his "
                + "orders.  \nHe takes what you give and disappears back into the"
                + "alley.";//lose random item
        
         result2 = "You knock the gun out of your assailants hand, who promptly"
                 + " surrenders.  \nNow that the tables have turned, he gives you"
                 + " his valuables before running away.";//gain random item   

        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
            mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            int k=0;
            for(int i=0;i<5;i++)
            {
                k+=CharacterInfo.getInvVal(i);
            }
            if(k!=0)
            {
                Random x=new Random();
                int randInt = x.nextInt(5);
                CharacterInfo.removeInv(randInt);
            }
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //lose random item
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            Random x=new Random();
            int randInt = x.nextInt(5);
            CharacterInfo.setInvVal(randInt);
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //gain random item
        }
        });//end button 2
    }
    
    public void Scenario5()
    {
        String questField;
        questField = "You are eating lunch in a local cafe when a man in a cheap"
                + "business suit sits down across from you. \n“Looking for a job?”"
                + "he asks. “I’ve got a big reward for a quick bit of work if "
                + "you’re up for it.  \nAll you gotta do is interrupt a drug deal"
                + "that's going down right now.”  \nWhat do you do?";
        
        
        String option1, option2, result1, result2;
        option1 = "Take the job";
        option2 = "Refuse the job";
 
        result1 = "You go to the given location and see what you assume is the "
                + "drug deal that was described.  \nUpon making your presence "
                + "known, the criminals scramble away, leaving their merchandise"
                + "behind. \n Suddenly, the shady business is behind you,"
                + "congratulating you on a job well done.  He give you your "
                + "reward and tells you to leave and that he never spoke to you.";//gain random item
        result2 = "You tell the man you aren’t interested and he quietly leaves,"
                + "likely to find someone else to do the job.  \nThe rest of the"
                + "day is uneventful.";//nothing happens
       
        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            Random x=new Random();
            int randInt = x.nextInt(5);
            CharacterInfo.setInvVal(randInt);
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            mf.message.setText(result1);
            JPanel panel=new JPanel();
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //gain random item
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
        }//nothing
        });//end button2
    }
    
    public void Scenario6()
    {
        String questField;
        questField = "You’re walking around at night when someone approaches you."
                + "\nHe tells you about an underground fighting ring, and they’re "
                + "one guy short, wanting to know if you’re interested.  \nWhat do"
                + "you do?";
        
        
        String option1, option2, result1, result2;
        
        option1 = "Participate in the tournament";
        option2 = "Decline the invitation";
 
        result1 = "You decide to fight in the tournament, where you find"
                + "yourself the winner after a few rounds.  \nYou accept your "
                + "reward, and head home for the day.";
        
        result2 = "The guy replies “Maybe next time then” before slinking back off"
        + "into the night.";//nothing happens
       
       MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.choice3.setBackground(Color.black);
        mf.choice3.setForeground(Color.white);
        mf.choice4.setBackground(Color.black);
        mf.choice4.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            Random x=new Random();
            int randInt = x.nextInt(5);
            CharacterInfo.setInvVal(randInt);
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //gain random item
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
        }//nothing
        });//end button2
    }
    
    public void Scenario7()
    {
        String questField;
        questField = "You are enjoying your day in the city when you see smoke.\n"
                + " You realize a nearby building is on fire, and with the "
                + "amount of screaming you are hearing, you assume there are "
                + "people inside.  \nWhat do you do?";
        
        
        String option1, option2, result1, result2;
        option1 = "Try to save people"; 
        option2 = "Don’t go in";

        result1 = "You run into the burning building where you manage to guide"
                + "the trapped residents out before the fire overwhelms anyone."
                + "\nWhile the people you saved have nothing to give you, the good"
                + "feeling from helping them energizes you.";//gain 5 MP
       
       result2 = "You decide it isn’t your  job to help people and leave, going"
               + "on with your day.";//nothing happens
       MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentMana+=4;
            CharacterInfo.setHP(CharacterInfo.getMana());
            if(CharacterInfo.getMana()>=CharacterInfo.maxMana)
                CharacterInfo.setMana(CharacterInfo.maxMana);
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //gain 5 Mana
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            //mf.choice1.addActionListener(new ActionListener(){
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
        }//nothing
        });//end button2
    }
    
    public void Scenario8()
    {
        String questField;
        questField = "While exploring the city, you hear a commotion in an "
                + "alleyway.  You realize someone is being robbed.  "
                + "What do you do?";
        
        
        String option1, option2, result1, result2;
        option1 = "help them";
        option2 = "Do nothing";
 
        result1 = "You attack the mugger, who you quickly subdue.  The victim"
                + "takes this time to run away without even a thank you.\n"
                + "Afterwards, you help yourself to the muggers valuables.";//Gain random item
       
       
       result2 = "You ignore the crime, going on with the rest of your day.";//nothing happens
        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            Random x=new Random();
            int randInt = x.nextInt(5);
            CharacterInfo.setInvVal(randInt);
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //gain random item
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            //mf.choice1.addActionListener(new ActionListener(){
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
        }//nothing
        });//end button2
    }
    
    public void Scenario9()
    {
        String questField;
        questField = "You are walking down the street when you hear cars"
                + "honking.  You turn to see the cause of the commotion only to"
                + "find out it's a car coming straight at you.  \nYou jump out of"
                + "its path only for its driver to step out with a gun and open"
                + "fire at you.  \nWhat do you do?";      
        
        String option1, option2, result1, result2;
        option1 = "Run";
        option2 = "Take cover";
       
        result1 = "You run away making an easy escape into a nearby building."
                + "You are lucky the driver was a terrible shot.";//nothing happens
        
        result2 = "You take cover behind some parked cars.  Luckily for you,"
                + "there's a few police officers nearby who take out the"
                + "would-be assassin while you slip away";//nothing happens

        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
       
        JPanel stuff=new JPanel(new GridLayout(5,1,0,5));
        stuff.add(mf.message);
        stuff.add(mf.choice1);
        stuff.add(mf.choice2);
        
        stuff.setBackground(Color.black);
        mf.message.setBackground(Color.black);
        mf.message.setForeground(Color.white);
        mf.message.setFont(new Font("Times New Roman",Font.PLAIN,20));
        mf.choice1.setBackground(Color.BLACK);
        mf.choice1.setForeground(Color.WHITE);
        mf.choice2.setBackground(Color.black);
        mf.choice2.setForeground(Color.white);
        mf.quit.setBackground(Color.black);
        mf.quit.setForeground(Color.white);
              
        JPanel end=new JPanel(new GridLayout(1,2,10,0));
        end.setBackground(Color.black);
        end.setForeground(Color.white);
        end.add(mf.quit);
        end.add(mf.reset);
        mf.reset.setBackground(Color.black);
        mf.reset.setForeground(Color.white);
        
        mf.contents.add(stuff,BorderLayout.CENTER);
        mf.contents.add(end,BorderLayout.SOUTH);
       
        mf.choice1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //nothing
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            //mf.choice1.addActionListener(new ActionListener(){
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
        }//nothing
        });//end button2
    }
}