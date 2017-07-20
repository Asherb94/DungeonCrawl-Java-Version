package Dungeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

//|  A fight between the hero and a  monster
//|
//|  The fight continues until one contestant is dead or
//|  the hero runs away.
public class sortie
{
    //char[] buffer = new char[132];
    Random random = new Random();
    DungeonCrawl obj = new DungeonCrawl();
    
    Scanner scan = new Scanner(System. in );
  
    public sortie(Hero hero, Monster monster) throws IOException
    {
        int monsterThrow = random.nextInt(monster.getStrength());
        int heroThrow;
        int bothAlive = 1;
        int runAway = 0;
        int hit = 0;
        int runAwayMonster = 0;


        while (bothAlive == 1 && runAway == 0 && runAwayMonster == 0)
        {
        	BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        	 
        	System.out.print("\n\n\tWhat do you wish to do? (f fight, r run away, d duck): ");
        	System.out.println();
            String answer = input.readLine();
    	    
            //Hero Fights the Monster
            if (answer.equals("f") || answer.equals("F"))
            {
                System.out.print("\n\n\tYou attack the " + monster.getName()+"\n\n");
                
               
                heroThrow = random.nextInt(hero.getStrength()+1);//no +1
                
                if (heroThrow == monsterThrow)
                {
                    System.out.print("\tYou swing and miss.\n");
                    System.out.println("\tThe " + monster.getName() + " swings and misses.\n\n");
                }
                else if (heroThrow > monsterThrow + 2)
                {
                    System.out.print("\tWHAMO!! You hit the monster hard.\n");
                    System.out.print("\tThe " + monster.getName() + " looses two hit points.\n\n");
                    monster.setHitPoints(monster.getHitPoints()-2);
                }
                else if (heroThrow > monsterThrow)
                {
                    System.out.print("\tBAM!! You swing and hit.\n");
                    System.out.print("\tThe " + monster.getName() + " looses a hit point.\n\n");
                    monster.setHitPoints(monster.getHitPoints()-1);
                }
                else if (heroThrow < monsterThrow - 1)//2
                {
                    System.out.print("\tOUCH OUCH OUCH!! The " + monster.getName() + " hits you.\n");
                    System.out.print("\tYou loose two hit point.\n\n");
                    hero.setHitPoints(hero.getHitPoints()-1);
                }
                else
                {
                    System.out.print("\tOOF!! The " + monster.getName() + " hits you.\n");
                    System.out.print("\tYou loose a hit point.\n\n");
                    hero.setHitPoints(hero.getHitPoints()-1);
                }
            }
                
               
                //Hero Runs Away
                else if (answer.equals("r")|| answer.equals("R"))
                {
                	
                    System.out.print("\n\tYou run away from the " + monster.getName());
                    System.out.print("\tThe " + monster.getName() + "throws a shurikin at your back!!\n");
                    monsterThrow = (int)(Math.random() * 4) + 1;
                    //monsterThrow = 4;
                    if (monsterThrow > 3 )
                    {
                    	//int x =0;
                        System.out.print("\tIt hits! You lose a hit point\n");
                        hero.setHitPoints(hero.getHitPoints()-1);
                      
                    }
                    else 
                    {
                    	System.out.print("\tIt misses.\n");
                    	 runAway = 1; 
                    }   
                }
                else
                {
                	System.out.print("\n\n\tYou duck from the monster's blow.\n");
                    monsterThrow = random.nextInt(monster.getStrength());
                    heroThrow = random.nextInt(hero.getStrength());
                    if (hero.getHitPoints() < hero.getMaxHitPoints() && heroThrow > 3 * monsterThrow / 4)
                    {
                        System.out.print("\tThe " + monster.getName() + " misses.\n\n");
                        System.out.print("\tYour tricky move gains you a hit point!!!\n");
                        hero.setHitPoints(hero.getHitPoints()+1);
                    }
                    else if (heroThrow > monsterThrow / 2)
                    {
                        System.out.print("\tThe " + monster.getName() + " misses.\n\n");
                    }
                    else
                    {
                        System.out.print("\tThe " + monster.getName() + " hits you anyway.\n");
                        System.out.print("\tYou loose a hit point!\n\n");
                        hero.setHitPoints(hero.getHitPoints()-1);
                    }
                }  
          //Determine the outcome of this exchange of blows
            if (hero.getHitPoints() <= 0)
            {
                System.out.print("\n\t\t\tYou moan... and die...\n\n");
                bothAlive = 0;
            }
            else if (monster.getHitPoints() <= 0)
            {
                System.out.print("\tThe " + monster.getName() + " drops dead.\n\n");
                bothAlive = 0;
            }
            obj.heroSummary();//obj is the call to hero class 
            monster.Summary();
            
            //The monster hears its mommy calling
            if (monster.getHitPoints() > 0 && monster.getHitPoints() < hero.getHitPoints() && (int)(Math.random() * 10) + 1 == 1)
            {
            	runAwayMonster = 1;
                System.out.print("\n\t\tThe " + monster.getName() + " turns tail and runs away!\n\n");
                System.out.print("\n\t\tQuick! Now's your chance to chase it and kill it\n\n");
                System.out.print("\n\nWhat do you do? [A]: Chase \t [B}: Don't Chase");
                String answerSub1 = inputSub.readLine();
                
            }
            //end while
        }
        //runAway = 1;//to turn on runAway 
        //Final Result of the Sortie
        
        if (runAway == 0 && hero.getHitPoints() > 0) 
        {
            System.out.print("\n\n\tYou gain strength and health from your experience\n");
            hero.setMaxHitPoints(hero.getMaxHitPoints()+1);
            hero.setHitPoints(hero.getHitPoints()+1);
            
            hero.setMaxStrength(hero.getMaxStrength()+1);
            hero.setStrength(hero.getStrength()+1);
           
            obj.heroSummary();
            System.out.print("\n");
        }
        
        if (runAway == 1) 
        {
            System.out.print("\n\n\tYou run away from the battle....coward\n");
           
            obj.heroSummary();
            System.out.print("\n");
        }
        
    }
}