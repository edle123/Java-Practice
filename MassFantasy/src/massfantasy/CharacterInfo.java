package massfantasy;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class CharacterInfo {
    //Character stats
    public static int maxHP=12;
    public static int maxMana=16;
    public static int currentHP=maxHP;
    public static int currentMana=maxMana;
    public static int exp;
    public static int[] invVal=new int[6];
    public static String[] invName=new String[6];
    
    //Constructor Clss
    public CharacterInfo()
    {
        currentHP=12;
        currentMana=16;
        exp=0;
        for(int i=0;i<=5;i++)
        {
            invVal[i]=1;
        }
        invName[0]="Thundershock Spellbook";
        invName[1]="Laser Rifle";
        invName[2]="Unlock Door Spellbook";
        invName[3]="Longbow";
        invName[4]="Charm Creature Spellbook";
        invName[5]="Meteor Swarm Spellbook";
        
    }
    //Retrieves currentHP
    public static int getHP()
    {
        return currentHP;
    }
    //retrieves currentMana
    public static int getMana()
    {
        return currentMana;
    }
    //retrieves current exp
    public static int getExp()
    {
        return exp;
    }

    //Changes HP value
    public static void setHP(int newHP)
    {
        currentHP = newHP;
    }
    //Changes ana value
    public static void setMana(int newMana)
    {
        currentMana=newMana;
    }
    //Changes exp value
    public static void setExp(int newExp)
    {
        exp=newExp;
    }
    
    public static int getInvVal(int x)
    {
        return invVal[x];
    }
    public static void setInvVal(int num)
    {
        invVal[num]=1;
    }
    
    public static void printInvName()
    {
        String list="Sword";
        MassFantasy inv=new MassFantasy();
        inv.contents.removeAll();
        //inv.contents.revalidate();
        
        for(int i=0;i<=5;i++)
        {
            if(invVal[i]==1)
            {
                list+="\n"+invName[i];
            }
        }
        JPanel panel=new JPanel();
        inv.message.setText(list);
        panel.add(inv.message);
        panel.add(inv.con);
        panel.setBackground(Color.black);
        inv.contents.add(panel,BorderLayout.CENTER);
        inv.contents.add(inv.quit,BorderLayout.SOUTH);
    }
    public static void removeInv(int x)
    {
        invVal[x]=0;
    }
}