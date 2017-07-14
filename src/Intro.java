import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Intro {

	public static final char[] buffer = new char[132];
	public static final actor hero;
	
	public void intro()
	{
		char answer;
		Scanner scan = new Scanner(System.in);
		System.out.print("\n\n\n\n");
		System.out.print("  You approach a ruined dwarven mine, ");
		System.out.print("  rummored to be filled with lost treasure, \n");
		System.out.print("  but guarded by ");
		System.out.print("monsters dangerous and most foul.\n\n");
		System.out.print("   None but the brave dare enterh.\n\n");
		
		System.out.println(" Do you wish to continue? (y or n) ");
	    answer = scan.next(".").charAt(0);
	    buffer[0] = answer;
	    
	    if (buffer[0] != 'y' && buffer[0] != 'Y')
	    {
	    	System.out.println("  You turn tail and run.  ");
	    	System.out.println("  From the trees around you, wood nymphs giggle derisively. \n\n");
	    	System.out.println("  In your panic, you step on a bear trap and die.\n");
	    	hero.hitPoints = 0;
	    	//hero name now becomes coward TODO 
	    }
	    else
	    {
	    	int flag = 1;
	    	System.out.println("  Spoken like a true Hero!.  ");
	    	while (flag == 1)// loop for name length
	    	{
	    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    	System.out.println("  Enter your name, Hero: ");
		        for(int i = 0; i<buffer.length; i++) 
		        {
		            buffer[i] = (char) br.read();//puts char into each index
		            
		        }
		        if ( buffer[4] == '\0')// == null 
		        {
		        	System.out.println("  You call *that* a name for a Hero? Try again: ");
		        	br.close();
		        }
		        else
		        {
		        	System.out.println("\n Now *thats* a Heroic name\n");
		        }
	    		
	    	}
	    	
	    	
	        
	        
	    }
		
		
	}

}
