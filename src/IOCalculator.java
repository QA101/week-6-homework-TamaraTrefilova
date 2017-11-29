package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOCalculator {
	Scanner input;
	File f;
	FileWriter writer;
	PrintWriter pw;
	
	public static void main(String[] args)  {
//		for(String s:args) {
//			System.out.println("Arg:"+s);
//		}
		IOCalculator ui;
		try {
			ui = new IOCalculator(args);
			ui.ReadInput();
			ui.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Constructor to build the user interface based on the arguments passed in from the command line.
	 * 
	 * If NULL, will use the console for writing to and from the console
	 * args[0] - input file
	 * args[1] - output file
	 * args[2] - Boolean on when to append to the output file
	 * 
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public IOCalculator(String[] args) throws IOException, FileNotFoundException {
		switch(args.length) {
		
			case 0:
				input = new Scanner(System.in);
				writer = new FileWriter("temp.txt");
				break;
				
			case 1:
				f = new File(args[0]);
				input = new Scanner(f);
				writer = new FileWriter("temp.txt");
				break;
				
			case 2:
				f = new File(args[0]);
				input = new Scanner(f);
				writer = new FileWriter(args[1]);
				break;
			case 3:
				f = new File(args[0]);
				input = new Scanner(f);
				writer = new FileWriter(args[1], Boolean.parseBoolean(args[2]));
				break;
			default:
				System.exit(0);
				break;
		}
		pw = new PrintWriter(writer);
	}
	
	
	/**
	 * Reads the input stream or input file until no input is found
	 * 
	 * If the program reads from the console and if the user enters "END", then the program will exit
	 */
	public void ReadInput() {
		String inputString = "";
		while(input.hasNextLine()) {
			inputString = input.nextLine();
			if(!inputString.toUpperCase().equals("END")) {
				String[] InputStringArray = inputString.split(" ");

				try {
					pw.println(""+Calculate(Integer.parseInt(InputStringArray[0]), Integer.parseInt(InputStringArray[2]), InputStringArray[1]));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				break;
			}
		}
		
	}
	
	/**
	 * Attempts to perform a calculation on an input expression and return the result
	 * 
	 * @param first
	 * @param second
	 * @param operator
	 * @return
	 * @throws Exception - throws an exception if the operator isn't valid
	 */
	public double Calculate(int first, int second, String operator) throws Exception{
		switch(operator) {
			case "+":
				return first + second;
			case "/":
				/*
				 * There is a bug here!!!! Lose of data caused by using ints.
				 * Found the bug by doing unit testing 
				 */
				return (double)(first )/ second;
			case "-":
				return  first - second;
			case "*":
				return   first * second;
			default:
				throw new Exception();
		}
	}

}
