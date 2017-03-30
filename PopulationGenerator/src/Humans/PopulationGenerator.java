package Humans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PopulationGenerator {
	
	public static int populationSize = 100;
	public static ArrayList<Person> people = new ArrayList<Person>();
	public static ArrayList<Person> peopleByLastName = new ArrayList<Person>();
	public static Scanner Input = new Scanner(System.in);
	
	//////////main_method///////////////////////////////////
	public static void main(String[] args){
		createPopulation();
		//nameFrequency();
		alphabetizeLastNames();
		for(int i = 0;i < populationSize;i++){
			System.out.print(i + 1 + " ");
			peopleByLastName.get(i).printNameFormatted();
		}
	}
	////////////////////////////////////////////////////////
	public static double avgAge(){
		double avg = 0.0;
		int sum = 0;
		for(int i = 0;i < populationSize;i++){
			sum = sum + people.get(i).returnAge();
		}
		avg = (double)sum/populationSize;
		return avg;
	}
	
	/*
	 * creates a population of populationSize.
	 * Generates all information about the person.
	 */
	public static void createPopulation(){
		
		for(int i = 0;i < populationSize;i++){
			people.add(new Person(i + 1));
		}
		
	}
	
	/*
	 * Takes an input string as the name it is trying to find the 
	 * frequency of. Asks the user if they want to see the data from
	 * each of the people matching the inquired name. If no they
	 * will only see the number of times the name appears. If yes
	 * they will see all the info from the printInfo function
	 * about each person.
	 */
	public static void nameFrequency(){
		//take a name as input.
		System.out.print("Enter a name you'd \nlike inquiry: ");
		//assign it to a string to use to search the list.
		String nameToInquire = Input.nextLine();
		//changes all letters to correct cases.
		nameToInquire = nameToInquire.substring(0,1).toUpperCase() 
				+ nameToInquire.substring(1).toLowerCase();
		System.out.println("Indexing " + nameToInquire + "...");
		boolean showData = false;
		System.out.print("Would you like to display information \n"
				+ "for each person matching your inquiry? \n"
				+ "Enter Y or N: ");
		
		String Answer = Input.nextLine();
		Answer = Answer.substring(0, 1).toUpperCase();
		if(Answer.compareTo("Y") == 0){
			System.out.println("Showing data for all matching names...\n");
			showData = true;
		}else if(Answer.compareTo("N") != 0){
			System.out.println("Must enter either Y or N.\nEnding program...");
			System.exit(0);
		}
		//integer counting matching names.
		int totalMatches = 0;
		
		for(int i = 0;i < populationSize;i++){
			if((nameToInquire.compareTo(people.get(i).returnFirstName()) == 0) 
					|| (nameToInquire.compareTo(people.get(i).returnLastName()) == 0)){
				totalMatches++;
				//displays info if user wanted it.
				if(showData == true){
					people.get(i).printInfo();
					System.out.println();
				}
			}
		}
		
		System.out.println("The name " + nameToInquire + " appeared " +
		totalMatches + " times");
		
	}
	
	/*
	 * generates an array list of people in order of last name alphabetized
	 */
	public static void alphabetizeLastNames(){
		peopleByLastName = people; //initializes new array list so it can be manipulated instead of old one. 
		int swaps = 0;
		int totalSwaps = 0;
		int iterations = 0;
		String Letter1;
		String Letter2;
		String CheckedLetter1;
		String CheckedLetter2;
		boolean pass = false;
		int j = 0;
		
		for(int w = 0;w < 2;w++){
		
		j = 0; //rechecks for swaps equaling 0 twice again each for loop iteration
		iterations = 0; // sets the number of times the for loop has ran for the current indexed letter to 0
		pass = false;
		
			do{ //checks current letter until pass == true
				swaps = 0; //set to 0 so that the do while loop doesn't run endlessly
				
				for(int i = (iterations % 2);i < (populationSize - 1);i+=2){           
					
					Letter1 = peopleByLastName.get(i).returnLastName().substring(0, 1);
					Letter2 = peopleByLastName.get(i + 1).returnLastName().substring(0, 1);
					CheckedLetter1 = peopleByLastName.get(i).returnLastName().substring(0 + w, 1 + w);
					CheckedLetter2 = peopleByLastName.get(i + 1).returnLastName().substring(0 + w, 1 + w);
				
					/*
					 * for the first iteration of the for loop
					 */
					if(w == 0){
					
						if((CheckedLetter1.compareTo(CheckedLetter2)) > 0){
							Collections.swap(peopleByLastName ,i, i+1);
							totalSwaps++;
							swaps++;
						}
					
					}
					
					/*
					 * for the second iteration of the for loop
					 */
					if(w == 1){
						if(Letter1.compareTo(Letter2) == 0){ //checks first letter to make sure its equal
							if(CheckedLetter1.compareTo(CheckedLetter2) > 0){ // checks second letter to see if they need to be swapped
								
								//System.out.println(peopleByLastName.get(i).returnLastName() + " needs to be swapped with " + peopleByLastName.get(i + 1).returnLastName());
								
								Collections.swap(peopleByLastName, i, i + 1); //swaps names if first letter is equal and second needs to be swapped
								totalSwaps++;
								swaps++;
							}
						}
					}
				}
			
				iterations++;
			
				/*
				 * the following if statement makes sure that the check loop runs twice that so that
				 * the checker can start at 0 and 1 and make sure swaps are 0. Therefore checking everything.
				 */
				if(swaps == 0){
					j++;
					if(j == 2){			
					pass = true;
					}
				}
			}while(pass == false);
		
		}	
			
		System.out.println("swaps: " + totalSwaps);
		
	}
	
	
}











