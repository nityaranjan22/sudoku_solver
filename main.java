import java.util.*;

public class main {

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nWelcome to the sudoku solver");
		System.out.println("\nWhat sudoku do you want to see solved :\\n1.3*3\\n2.4*4");
		int option = input.nextInt();
		System.out.println("\nGenerating Matrix....");
		Matrix mat = new Matrix();
        mat.print_matrix();
		if(mat.solve_matrix()== true)
		{
			mat.print_matrix();
		}
		else 
		{
			System.out.println("The Matrix Cannot be solved");
		}
	}
}