import java.io.*;

	class Lab2_Q4 extends File
	{
		Lab2_Q4(String filename)
		{
			super(filename);
		}

		public static void main(String [] ar) throws Exception
		{
			Lab2_Q4 myfile = new Lab2_Q4("Welcome.txt");
			if(myfile.exists())
			{
				System.out.println("File Exists!");
			}
			else
			{
				System.out.println("File does not exist! Try another file name");
			}
		}

	}