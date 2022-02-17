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

public class WildernessQuests {
    Random randNum = new Random();
    int oneOrTwo = 0;
    //oneOrTwo is used at the start of each scenario to randomize success or
    //fails for individual outcomes
    public void QuestSelect()
    {       
        int randInt = randNum.nextInt(8) + 1;        
        
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
            case 8: Reward();
                break;
            case 9: Magma();
                break;
        }
    }
    public void Scenario1()
    {
        oneOrTwo = randNum.nextInt(2) + 1;
        String questField;
        questField = "While exploring the woods, you come across what appears"
                + "to be an abandoned cabin, what do you do?";
        
        
        String option1, option2, result1, result2;
        option1 = "Search the cabin";
        option2 = "Leave";
 
       if(oneOrTwo == 1)
       {
        result1 = "You enter the cabin and find no one there.  You do find a "
                + "valuable item however.  You hope no one will miss it.";//Gain random item
       }
       else
       {
        result1 = "You enter the cabin only to find yourself further into the"
                + "woods.  The cabin must’ve been warded against intruders, and"
                + "the spell used your energy to fling you away.";//Lose 3 MP
       }
       result2 = "You ignore the cabin and continue your day.";//nothing happens
        
    }
    
    public void Scenario2()
    {
        oneOrTwo = randNum.nextInt(2) + 1;
        String questField;
        questField = "You are out in the woods when the weather turns bad."
                + "Looking for shelter from the rain, you enter a small cave. "
                + "You realize there is light deeper within, and upon going to "
                + "investigate, find an old man living there.  He tells you he "
                + "can see the future and knew you were coming.";
        
        
        String option1, option2, result1, result2;
        option1 = "Ask him to see into your future"; 
        option2 = "Leave";
 
       if(oneOrTwo == 1)
       {
        result1 = "He tells you that you will soon find a valuable item when"
                + "leaving the cave if you “look to the sky.”  unsure of what"
                + "this means, you leave the cave when the weather clears. "
                + "While walking through the forest again, you look up and do"
                + "indeed see something in the trees.  An animal appears to have"
                + "stashed some shiny items in its next. And you confiscate the"
                + "only valuable thing you find";//gain random item
       }
       else
       {
        result1 = "The man seems offended by this, and casts a spell on you. "
                + " You blackout, and wake up at the edge of the woods, feeling "
                + "drained.";
       }
       result2 = "No need to spend time with this clearly insane old man."
               + "  You decide the rain is better than listening to him ramble.";//nothing happens
    }
    
    public void Scenario3()
    {
        oneOrTwo = randNum.nextInt(2) + 1;
        String questField;
        questField = "While hiking through the woods, someone approaches you."
                + "They tell you they are lost and ask for directions.";
        
        
        String option1, option2, result1, result2;
        option1 = "Help them";
        option2 = "Attempt to mug them";
 
       
        result1 = "You point them to the nearest town, and they thank you.";//nothing happens
        
        if(oneOrTwo == 1)
        {
            result2 = "You intimidate the traveller into giving you their"
                    + "valuables before they run off into the woods. ";// Gain random item
        }
        else
        {
            result2 = "The traveller fights back, knocking you out in the"
                    + " ensuing fight.  You later wake up with your pockets"
                    + " feeling lighter…";//lose 2 HP and a random item
        }
        
    }
    
    public void Scenario4()
    {
        oneOrTwo = randNum.nextInt(2) + 1;
        String questField;
        questField = "While wandering in the woods, you fall into a deep hole "
                + "only to quickly realize it's some sort of ancient temple."
                + "There is a large locked door in front of you, and a nearby"
                + "passageway.  What do you do? ";
        
        
        String option1, option2, option3, result1, result2, result3;
        option1 = "Go out through the hole you fell through"; 
        option2 = "Explore the temple";
        /*secret*/option3 = "Unlock the door";
 
       
        result1 = "You use a bit of magic to jump high enough to go out through"
                + " where you fell in.";//lose 2 MP
        if(oneOrTwo == 1)
        {
            result2 = "You explore the temple and while you don’t find anything"
                    + " interesting upon finding the exit, you feel energized.";//gain 2 MP
        }
        else
        {
            result2 = "You explore the temple and find nothing of note";//nothing happens
        }
        result3 = "You unlock the door, finding some valuables you take with you"
                + "when you leave.";//gain random item, lose 3 MP
        
    }
    
    public void Scenario5()
    {
        oneOrTwo = randNum.nextInt(2) + 1;
        String questField;
        questField = "While exploring the woods, you come across a glowing pond."
                + "You realize it must be enchanted with powers."
                + "What do you do?";
        
        
        String option1, option2, result1, result2;
        option1 = "Drink from the pond";
        option2 = "Leave";
 
       if(oneOrTwo == 1)
       {
        result1 = "You feel energized with magical energy after drinking.";//Gain 4 MP
       }
       else
       {
        result1 = "You feel weakened after drinking from the pond.";//lose 3 MP
       }
       result2 = "You decide drinking from a random pond may not be a smart idea.";
        
    }
    
    public void Scenario6()
    {
        oneOrTwo = randNum.nextInt(2) + 1;
        String questField;
        questField = "You come across an empty campsite.  From the looks of it,"
                + "the last residents left in a hurry, and recently too. "
                + "What do you do?";
        
        
        String option1, option2, result1, result2;
        option1 = "Investigate more"; 
        option2 = "Leave";
       
        result1 = "Upon getting closer, you find no signs of a struggle, only to"
                + "turn and find a pack of wolves.  You hide in a tent and wait"
                + "for the wolves to leave.  Luckily, the wolves leave you "
                + "alone after a while.";//nothing happens
        result2 = "If the last residents left in a hurry, you don’t want to"
                + "stick around and see why";//nothing happens
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
        
    }
    
    public void Scenario7()
    {
        oneOrTwo = randNum.nextInt(2) + 1;
        String questField;
        questField = "While exploring the woods, you notice a strange marking on"
                + "a tree.  You notice other nearby trees have similar markings"
                + "and come to the conclusion you've stumbled across some sort"
                + "of ritual circle.  What do you do?";
        
        
        String option1, option2, option3, result1, result2, result3;
        option1 = "Meditate";
        option2 = "Rest";
        option3 = "Leave";
 
       if(oneOrTwo == 1)
       {
        result1 = "You try to call on the powers of the circle.  You assume"
                + "you’ve succeeded when an item appears in front of you.";//lose 2 MP, gain random item
       }
       else
       {
        result1 = "You try to call on the powers of the circle.  You can’t seem "
                + "to get it to work, and just end up tired.";//lose 5 MP    
       }
       result2 = "While you don’t want to call on the powers of the circle, it "
               + "can’t be that bad of a spot for a nap.  Afterwards, you wake "
               + "up refreshed.";//Gain 5 MP
       result3 = "You don’t want to mess with powers you don’t understand, so "
               + "you leave.";//noting happens
        
    }
    public void Reward()
    {
        String questField;
        questField = "On your way back to camp, you notice a runed-automaton wolf circling an abandoned building surrounded "
                + "by collapsed wooden fencing. As you approach, the wolf notices you and turns to face you. The wolf has an expecting expression on its face. "
                + "You recal that utility automaton await commands...";
        
        String option1, option2, option3, option4;
        option1 = "Create small flames in your palm. (-1 mana)";
        option2 = "Hold your sword towards the wolf";
        option3 = "Show the wolf some bandages";
        option4 = "Cast Charm Creature on the automaton wolf. (-3 mana)";
        
        String result1, result2, result3, result4;
        result1 = "The automaton wolf beckons you follow. You pass several rooms before reaching a room with a massive book adjorning a pedestal. "
                + "The wolf retreives the book and sets it in your hands. As the wolf scampers off, you read the book. (Gain Thunderschock Spell Book)"; //gain <-
        result2 = "The automaton wolf races into a cellar under the building. Cautiously, you follow the wolf into the cellar and past several "
                + "corridors to a romm with a laser rife laying across a table. As you pick up the rifle, the wolf swiftly runs back towards the entrance of "
                + "the cellar. (Gain Laser Rifle)"; //<-
        result3 = "The automaton wolf quickly turns and scales the crumbling building. After several moments, the wolf's head peers over the edge of the "
                + "roof for a few seconds and drops a package. Upon further inspection, you realize that the case contains health and mana potions! "
                + "(Gain Full Health and Mana)"; //<-
        result4 = "The charmed automaton wolf sits down next to you obediantly waiting. \"Lead me to the treasure.\" You"
                + "command the wolf sternly. The wolf barks and leads you into the building and up severl staircases. You arrive in what appears to be an "
                + "alchemical store room. In it you find a book titled Unlock Door. (Gain Unlock Door Spell Book)"; //<-
    }
    
    public void Magma()
    {
        String questField;
        questField = "You have reached the base of the volcano, where a tunnel into the mountain has opened. You reach the center of the mountain you "
                + "find a book, laying on a pedestal, at the center of a platform above a sea of magma. "
                + "A large, molten rock starts to move and takes the shape of a stone dragon. With molten lava dripping from its mouth, the elemental "
                + "dragon roars! You notice a crystal in the elementals chest.";
        
        String option1, option2, option3;
        option1 = "Use your sword";
        option2 = "Use an icicle shard attack. (-3 mana)";
        option3 = "Use jet boots";
        
        String result1, result2, result3;
        result1 = "You react on instincts. As the elemental fires magma, you dive down towards the enemy. Some magma hits your back, "
                + "but you emerge relatively safe. Before the elemental can react, you throw your sword at the crystal. "
                + "The crystal shatters and the elemental falls apart, along with the platform the was on! The treasure is lost!";
        result2 = "You create a small icicle shard and shoot it at the elemental before it can attack. The elemental starts to "
        + "freeze, but the magma quickly melts the ice. Unfortunantly, the ice weakend the elementals legs and it collapses, taking the platform with it"
                + ", into the volcano. The book is lost. (-3 mana)";
        result3 = "The elemental shoots magma at you, but you dodge vertically into the air. Before the elemental can respond, you fly behind the "
                + "elemental and grab the book. The elemental tries to hit you, but misses and loses balance, faling into the magma below. The book "
                + "is yours! (Gain Meteor Storm)"; //<-
    }
}