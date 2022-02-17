package massfantasy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Ending 
{
    public void InfiltrateTheKeep()
    {
        String questField;
        questField = "After the body numbing, five hour climb up a sheer cliff, you have finally reached the abandoned castle.\n"
                + " Long ago, it was said to be the home of a powerful dragon. \nRumors tell of the halls of gold and treasure that"
                + " lie inside. \nYou approach the gate, where a pedestal stands with the text, \"Entrance through sacrifice\"";
        
        String option1, option2, option3, option4;
        option1 = "Pay for entrance with blood.";
        option2 = "Pay for entrance with mana. (-6 mana)";
        option3 = "Strike the pedestal with your magic infused weapon. (-3 mana)";
        option4 = "Sacrifice your Unlock Door spell book.";
        
        String result1, result2, result3, result4;
        result1 = "You retrieve a small knife from the pedestal and cut your open palm. \nBlood drips onto the pedestal and the gate falls "
                + "open. You feel your strength abandon you. (-6 hp)"; //-6hp
        result2 = "You collect a tremendous amount of magical energy in your hand. \nYou press the energy against the pedestal and the gate falls open. "
                + "(-6 mana)";
        result3 = "You infuse your weapon with your magical energy and smash the pedestal. \nThe gate crumbles revealing the entrance. The shards "
                + "of the pedestal attach to your body like leeches and sap your strength. (-3 hp, -3 mana)";
        result4 = "You place your magic tome on the pedestal. \nThe book spontaneously catches fire and burns up. \nA magic symbol appears on the gate "
                + "that reads \"Unlock.\" The symbol fades and the gate opens. (Lose Unlock Door Spell Book)";
        
//death endings beside generic
        String resultA, resultC;
        resultA = "You retrieve a small knife from the pedestal and cut your open palm. Blood drips onto the pedestal and the gate falls "
                + "open. You feel your strength abandon you. It's too much and you collapse onto the ground, dead.          Game Over...";
        resultC = "You infuse your weapon with your magical energy and smash the pedestal. The gate crumbles revealing the entrance. The shards "
                + "of the pedestal attach to your body like leeches and sap your strength. You collapse as the stones leech the what remaining life "
                + "you had, killing you.            Game Over...";
        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
        if(CharacterInfo.getMana()<6)
            mf.choice2.setVisible(false);
        mf.choice3=new JButton(option3);
        if(CharacterInfo.getMana()<3)
            mf.choice3.setVisible(false);
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
            CharacterInfo.currentHP-=6;
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
            //-6hp
            TheStalwartGuardians();
            }
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.currentMana-=6;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-6 Mana
            TheStalwartGuardians();
        }
        });//end button 2
        
        mf.choice3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.exp+=1;
            CharacterInfo.currentHP-=3;
            CharacterInfo.setHP(CharacterInfo.getHP());
            if(CharacterInfo.getHP()<=0)
                mf.Death();
            CharacterInfo.currentMana-=3;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result3);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-3hp,-3 mana
            TheStalwartGuardians();
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
            TheStalwartGuardians();
        }
        });//end button 4
    }
    
    public void TheStalwartGuardians()
    {
        String questField;
        questField = "As you enter the castle courtyard, you take notice of stray coins laying across the ground and gold embroidald banners adjourning the walls. \n"
                + "As you reach the center of the courtyard, three hollow suits of armor approach. \nOne carries a claymore and the others weild a sword "
                + "and shield. \nThe armor and weapons are coated with a thin slime.";
        
        String option1, option2, option3, option4;
        option1 = "Confront the suits of armor head-on.";
        option2 = "Cast frost to slow and freeze the armor. (-4 mana)";
        option3 = "Cast charm creature.";
        option4 = "Use longbow";
        
        String result1, result2, result3, result4;
        result1 = "The claymore wielding suit of armor charges and is taken down with a quick sidestep followed by a slash through the abdoman. \nYou parry the "
                + "second and cut the armor at its elbows, disarming it. \nAs it collapses onto the ground, you fail to block te last suit of armor's "
                + "attack and are struck across the arm before slicing the armor down the middle. \nYou continue indoors. (-3 hp)"; //-3hp
        result2 = "The armor suits slow then stop as the air around them encroaches freezing temperature. \nYou swiftly shatter the enemy "
                + "suits of armor where they stand. You quickly continue indoors. (-4 mana)"; //-4mp
        result3 = "You quickly pull out your charm creature spell book, only to have it burst into a blue flame. \nThe blue flame washes over the suits of armor. "
                + "All three kneel whilst a vapor leaves the suits and the armor becomes unmovable. \nYou try to comand the armor, but fail. You "
                + "continue indoors. (Lose Charm Creature Spell Book)"; //lose charm creature
        result4 = "You grab a lit torch off the wall and light your last arrow on fire.  \nYou fire the arrow and it lodges into the shield of one of the suits"
                + " of armor and ignites it. \nThe fire travels down the armor onto the floor and up the legs of the other suits of armor. They collapse onto the floor, metal melting. "
                + "You drop the bow and empty quiver before continuing indoors. (Lose Longbow)";
        
        //death results generic
        String resultA;
        resultA = "The claymore wielding suit of armor charges and is taken down with a quick sidestep followed by a slash through the abdoman. \nYou parry the "
                + "second and cut the armor at its elbows, disarming it. \nAs it collapses onto the ground, you fail to block te last suit of armor's "
                + "attack and are struck above the shoulder, killing you.           Game Over...";
                      
       MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
        if(CharacterInfo.getMana()<4)
            mf.choice2.setVisible(false);
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
            CharacterInfo.currentHP-=6;
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
            //-3hp
            TheDragon();
            }
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.currentMana-=4;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-4 Mana
            TheDragon();
        }
        });//end button 2
        
        mf.choice3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
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
            TheDragon();
        }
        });//end button 3
                                
        mf.choice4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
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
            TheDragon();
        }
        });//end button 4
    }
    
    public void TheDragon()
    {
        String questField;
        questField = "You take a few steps into the throne room and take in the unnatural glowing from the gold piled throughout the room. \n"
                + "Your steps echo through the hall. \nNear the base of the throne, an amber red dragon sits staring intensly at you. \n"
                + "The dragon then starts pacing back and forth in front of the throne, observing your actions. \n"
                + "As you slow your pace, the dragon begins sprinting towards you.";
        
        String option1, option2, option3, option4;
        option1 = "Use your sword and dodge behind a pillar.";
        option2 = "Cast frost on the ground in front of you. (-5 mana)";
        option3 = "Use Thundershock Spell Book";
        option4 = "Use laser rifle";
        
        String result1, result2, result3, result4;
        result1 = "As the dragon brings down its claw, you dodge to the side and bring your sword up, wounding the dragon's arm. \n"
                + "As you run along the right side of the room, the dragon's tail catches the small of your back. (-4 Hp)"; //-4hp
        result2 = "You quickly bring your palms down on the floor in front of you nd freeze it. \n"
                + "You dodge to the side and run along the right side of the room. \n"
                + "The dragon slides into the wall whilst turning towards you. (-5 mana)"; //-5mp
        result3 = "You gather a tremendous ball of lightning in your hands in your hands and unleash it upon the dragon. \n"
                + "The bolt pierces the shoulder at the base of the left wing. \n"
                + "The dragon faulters while you run along the right wall of the throne room.";
        result4 = "As you dodge to your right you fire your laser rifle at the dragon's legs.\n "
                + "The laser pierces the dragon's front right leg, preventing it from turning towards you and crashes into a wall.\n "
                + "You rush along the right wall.";
        
        //death results genereic
        String resultA;
        resultA = "As the dragon brings down its claw, you dodge to the side and bring your sword up, wounding the dragon's arm. "
                + "As you run along the right side of the room, the dragon's tail catches you, crushing you against the wall, killing you."
                + "             Game Over...";
               MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
        if(CharacterInfo.getMana()<5)
            mf.choice2.setVisible(false);
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
            CharacterInfo.currentHP-=4;
            CharacterInfo.setHP(CharacterInfo.getHP());
            if (CharacterInfo.getHP()<=0)
                mf.Death();
            else
            {
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result1);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-3hp
            TheWin();
            }
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.currentMana-=5;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            panel.add(mf.message);
            panel.add(mf.con);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-4 Mana
            TheWin();
        }
        });//end button 2
        
        mf.choice3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            
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
            TheWin();
        }
        });//end button 3
                                
        mf.choice4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
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
            TheWin();
        }
        });//end button 4
    }
    
    public void TheWin()
    {
        String questField;
        questField = "You are now standing beside the throne. The dragon has recovered and seems to be shrugging of the pain.\n "
                + "Your efforts are not in vain, the dragon appears to be reluctant to advance towards you again like before.\n "
                + "The dragon is rearing its head, fire driping between the teeth in its mouth.\n "
                + "This will be your final chance to kill the dragon.";
        
        String option1, option2, option3, option4;
        option1 = "Use your sword.";
        option2 = "Use  a frost spear. (-6 mana)";
        option3 = "Wait for the dragon's attack. (-4 mana)";
        option4 = "Use Meteor Storm.";
        
        String result1, result2, result3, result4;
        result1 = "You charge the dragon. Fire erupts from its mouth, washing over the floor and burning your legs.\n "
                + "You push through and leap, grabing onto the scaly armor along the dragon's neck.\n "
                + "Your sword pierces the dragon's neck, slaying the beast. "
                + "The treasure is yours!         You Win!"; //-4hp
        result2 = "Yoiu shape an ice spear in your hands while the dragon advances. \n"
                + "You dodge the dragon's fire while throwing the spear. The ice spear pierces he dragon's neck. \nThe dragon flails, "
                + "crushing a pillar, before collapsing onto the ground. \nThe dragon lays dead. The treasure is yours!           You Win!"; //-6mp
        result3 = "As the dragon's fire approaches, you use your magic to enhance your physical abilities. \nYou leap upwards, dodging the fire, "
                + "but slaming into the ceiling. \nYou land on the dragon's back and pierce the dragon's neck with your sword. The dragon crumbles onto the floor, "
                + "dead. The treasure is yours!             You Win!"; //-4hp -4mp
        result4 = "You amass a condensed ball of earth, which you set on fire with a blue flame. \nYou throw the condensed rock into the air above the dragon, "
                + "whilest dodging the dragon's fire. \nThe condensed rock explodes apart, raining flaming rock down upon the dragon, burning the dragon "
                + "alive. Its flaming corpse collapses onto the ground, dead. \nThe treasure is yours!            You Win!";
        
        //death reuslts generic
        String resultA, resultC;
        resultA = "You charge the dragon. Fire erupts from its mouth, washing over the floor, burning your legs. You collapse from the pain, "
                + "allowing the dragon to pick you up in its mouth. It then crushes you in its teeth, killing you.          Game Over...";
        resultC = "As the dragon's fire approaches, you use your magic to enhance your physical abilities. You leap upwards, dodging the fire, "
                + "but slaming into the ceiling, rendering you unconscious. You limply fall onto the dragon's back. The dragon picks you up and throws "
                + "you into a wall, killing you.            Game Over...";
        MassFantasy mf=new MassFantasy();
        mf.contents.removeAll();
        mf.contents.setLayout(new BorderLayout());
        mf.contents.setBackground(Color.black); 
       mf.message.setText(questField);
        mf.choice1=new JButton(option1);
        mf.choice2=new JButton(option2);
        if(CharacterInfo.getMana()<4)
            mf.choice2.setVisible(false);
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
            CharacterInfo.currentHP-=4;
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
            mf.reset.setText("Restart");
            panel.add(mf.message);
            panel.add(mf.reset);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-3hp
            }
        }
        });//end button 1
        
        mf.choice2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.currentMana-=6;
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result2);
            mf.reset.setText("Restart");
            panel.add(mf.message);
            panel.add(mf.reset);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //-4 Mana
        }
        });//end button 2
        
        mf.choice3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            CharacterInfo.currentHP-=4;
            CharacterInfo.currentMana-=4;
            CharacterInfo.setHP(CharacterInfo.getHP());
            if (CharacterInfo.getHP()<=0)
                mf.Death();
            else{
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result3);
            mf.reset.setText("Restart");
            panel.add(mf.message);
            panel.add(mf.reset);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //nothing
        }
        }
        });//end button 3
                                
        mf.choice4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            mf.contents.removeAll();
            mf.contents.revalidate();
            JPanel panel=new JPanel();
            mf.message.setText(result4);
            mf.reset.setText("Restart");
            panel.add(mf.message);
            panel.add(mf.reset);
            panel.setBackground(Color.black);
            mf.contents.add(panel,BorderLayout.CENTER);
            mf.contents.add(mf.quit,BorderLayout.SOUTH);
            //nothing
        }
        });//end button 4
    }
}
