import java.util.Scanner;
public class lab_Q3 {

	public static void main(String[] args) 
	{
		Scanner in= new Scanner(System.in);
		
		System.out.println("How many mark you want to insert");
		int mark = in.nextInt();
		int totalMark = 0;
		
		for (int i= 1; i<=mark; i++) {
			System.out.println("Please enter mark" +i);
			int marks = in.nextInt();
			totalMark += marks;
			System.out.println("Mark: "+ marks + " has been inserted");
		}
		
		System.out.println("Total mark is: " + totalMark);
		
		// TODO Auto-generated method stub

	}

}
