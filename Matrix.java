public class Matrix 
{
	int rows;
	int columns;
	int[][] data;
	
	public Matrix()
	{
		rows = 9;
		columns =9;
		data = new int[][]{ {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		{5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		{0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		{0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		{9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		{0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		{1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		{0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		{0, 0, 5, 2, 0, 6, 3, 0, 0} };
	}
	
	public void print_matrix()
	{
		for(int i = 0; i<data.length; i++)
		{
			for(int j=0;j<data[i].length; j++)
			{
				if(data[i][j] != 0)
					System.out.print(data[i][j] + " "); 
				else 
					System.out.print(" " + " ");
            }
            System.out.print("\n");
		}
		System.out.println("\n");
    }

    public int verify_matrix()
    {
		int counter = 0;
		for(int i = 0; i< data.length;i++)
		{
			for(int j = 0; j<data[i].length; j++)
			{
				if(data[i][j] == 0)
				{
					counter++;
					break;
				}
			}
		}
		if(counter != 0)
		{
			return 0;
		}
		else 
		{return 1;}
	}
	
	public boolean goodposition(int r, int c, int n)
	{
		for(int i = 0; i< data.length; i++)
		{
			if(data[r][i] == n)
			{
				return false;
			}
		}	

		for(int j = 0; j< data.length; j++)
		{
			if(data[j][c] == n)
			{
				return false;
			}
		}  
		
		
		return true;
	}
    
    public boolean solve_matrix()
    {

		print_matrix();

		int row = -1;
		int col = -1;
		boolean isempty = true;
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<data[i].length; j++)
            {
                if(data[i][j] == 0)
                {
					row = i;
					col = j;

					isempty = false;
					break;
				}
			}
			if(!isempty)
			{
				break;
			}
		}
			
		if(isempty)
		{
			return true;
		}

		for(int number = 1; number <=data.length; number++)
		{
			if(goodposition(row, col, number))
			{
				data[row][col] = number;
				if(solve_matrix())
				{
					return true;
				}
				else
				{
					data[row][col] =0;
				}	
			}
		}
	return false;
    }
}