//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("punched");
		nouns.add("Wal-Mart");
		adjectives.add("massive");
		story = "I punched Wal-Mart in a massive way.";
	}

	public MadLib(String fileName)
	{
		String next = "";

		//load stuff
		loadNouns();
		loadAdjectives();
		loadVerbs();
		try
		{
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			Scanner reader = new Scanner(new File(fileName));
			
			String ogStory = reader.nextLine();

			//While there is more of the story, read in the word/symbol
			Scanner chopper = new Scanner(ogStory);

		//Chop up the string
			while(chopper.hasNext()){
				next = chopper.next();
				if(new String(next).equals("#")){
					story += " " + getRandomNoun();

				}

				else if(new String(next).equals("&")){
					story += " " + getRandomAdjective();

				}

				else if(new String(next).equals("@")){
					story += " " + getRandomVerb();

				}
				else{
					story += " " + next;

				}
			}
				//If what was read in is one of the symbols, find a random
				//word to replace it.
			


		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			Scanner reader = new Scanner(new File("nouns.dat"));

			while(reader.hasNext()){
				nouns.add(reader.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
		try
		{
			Scanner reader = new Scanner(new File("verbs.dat"));

			while(reader.hasNext()){
				verbs.add(reader.next());

						}
			}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner reader = new Scanner(new File("adjectives.dat"));

			while(reader.hasNext()){
				adjectives.add(reader.next());
		}
	}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		loadVerbs();
		int verb = (int)(Math.random()*13);
		
		return verbs.get(verb);
	}

	public String getRandomNoun()
	{
		loadNouns();
		int noun = (int)(Math.random()*21);
		
		return nouns.get(noun);
	}

	public String getRandomAdjective()
	{
		loadAdjectives();
		int adjective = (int)(Math.random()*16);
		
		return adjectives.get(adjective);
	}

	public String toString()
	{
		return "" + story;
	}
}