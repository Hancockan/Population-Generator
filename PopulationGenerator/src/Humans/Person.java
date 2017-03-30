package Humans;

public class Person {
	
	private String fullName;
	private boolean college;
	private String collegeAttendence;
	private int age;
	private String[] firstAndLastName;
	private String firstName;
	private String lastName;
	private char gender; 
	private int personNumber; //used to index population. number is sent with constructor.
	
	/*
	 * constructor that takes the index of the person 
	 * as the the only parameter. starts at 1.
	 */
	public Person(int personIndexNumber){
		fullName = (nameGen() + " " + nameGen());
		nameSeperation(); //puts first and last name into a string array
		age = ageGen();
		college = toCollege();
		personNumber = personIndexNumber;
		gender = decideGender();
	}
	
	/*
	 * generates the name in a vowel-consonant pattern with
	 * a random length of 3 - 8 letters.
	 */
	public String nameGen(){
		
		String Consonants = "bcdfghjklmnpqrstvwxzy";
		char LastLetter = 'v';
		char NewLetter = 'v';
		int PassTest = 99;
		
		String name = "";
		char randomLetter = 0;
		int randomLength = 3 + (int)((Math.random()) * 6.0);
		int randomLetterDecimalNumber = 0;
		
		for(int i = 0;i < randomLength;i++){
			do{
			randomLetterDecimalNumber = 97 + (int)(Math.random() * 26.0);
			randomLetter = (char)(randomLetterDecimalNumber);
			
				if(i == 0){
				
					if(Consonants.indexOf(randomLetter) != -1){
						LastLetter = 'c';
					}else{
						LastLetter = 'v';
					}
				
				}
				
				if(i > 0){
					if(Consonants.indexOf(randomLetter) != -1){
						NewLetter = 'c';
					}else{
						NewLetter = 'v';
					}
				}
				
				if(NewLetter != LastLetter){
					PassTest = 1;
					if(i > 0)LastLetter = NewLetter;
				}else{
					PassTest = 0;
				}
			
			}while((PassTest == 0));
		name = name + randomLetter;
			if(i == 0){
				name = name.toUpperCase();
			}
		}
		return name;
	}
	
	/*
	 * prints full name of person.
	 */
	public void printName(){
		
		System.out.println(fullName);
		
	}
	
	/*
	 * prints full name formatted.
	 */
	
	public void printNameFormatted(){
		System.out.println(lastName + ", " + firstName);
	}
	
	/*
	 * generates a random integer age for each person between 0 and 95.
	 */
	public int ageGen(){
		
		int age = (int)(Math.random() * 96.0);
		
		return age;
	}
	
	/*
	 * prints out specified information for each person 
	 */
	public void printInfo(){
		
		System.out.println(lastName + ", " + firstName + " #" + personNumber
				+ " Gender: " + gender + "\nCollege: " + collegeAttendence + ", Age: " + 
				age);
		
	}
	
	/*
	 * randomly decides whether each person goes to college or not partially
	 * based off of age. each person about 22 has what i think is a 60% chance to 
	 * attend college
	 */
	public boolean toCollege(){
		
		if(age <= 22){
			college = false;
			collegeAttendence = "Too young";
		}else if(age > 22){
			int chance = (int)(Math.random() * 11.0);
			if(chance < 7){
				college = true;
				collegeAttendence = "Attended";
			}else{
				college = false;
				collegeAttendence = "Did not attend";
			}
		}
		return college;	
	}
	
	/*
	 * returns age of the person.
	 */
	public int returnAge(){
		return age;
	}
	
	/*
	 *Separates names into first and last names.
	 */
	public void nameSeperation(){
		firstAndLastName = fullName.split(" ");
		firstName = firstAndLastName[0];
		lastName = firstAndLastName[1];
	}
	
	/*
	 * returns first name
	 */
	public String returnFirstName(){
		return firstName;
	}
	
	/*
	 * returns last name
	 */
	public String returnLastName(){
		return lastName;
	}
	
	/*
	 * returns person number. used to index population and number people
	 */
	public int returnPersonNumber(){
		return personNumber;
	}
	
	/*
	 * randomly determines gender
	 */
	public char decideGender(){
		char mOrF = 0;
		int random = (int)(Math.random() * 2);
		if(random == 1){
			mOrF = 'F';
		}else{
			mOrF = 'M';
		}
		return mOrF;
	}
	
	/*
	 * returns gender
	 */
	public char returnGender(){
		return gender;
	}
	
}

















