package edu.ser222.m01_02;

/**
 * An implementation of the Matrix ADT. Provides four basic operations over an immutable type.
 * 
 * Last updated 8/17/2022.
 * 
 * @author (Lorenzo Stewart), Ruben Acuna
 * @01 (01)
 */

 public class CompletedMatrix implements Matrix{
	
 private final int rowCount;
 private final int colCount;
 private final int[][] Matrix;  	
 
    public CompletedMatrix(int[][] matrix) 
    {
    	
    	if ( matrix == null)
    	{
    		throw new java.lang.IllegalArgumentException("Null!");
    	}
    	else if  (matrix.length == 0)
    	{
    		rowCount = 0;
    		colCount = 0;;
    	}  
    	else 
    	{
    		rowCount = matrix.length;
    		colCount = matrix[0].length;
    		
    	}
    	
    		Matrix = new int[rowCount][colCount];
    		for (int t = 0; t < rowCount; t++)
    		{
    			for (int o = 0; o < colCount;o++)
    			{
    				Matrix[t][o] = matrix[t][o];
    			}	
    		}
    
    	  
    }

    @Override
    public int getElement(int y, int x) 
    {
    	
    	return Matrix[y][x];
    	
    }

    @Override
    public int getRows() 
    {
    	return rowCount;
    }

    @Override
    public int getColumns() 
    {
    	return colCount;
    }

    @Override
    public Matrix scale(int scalar) 
    {
    	
    	int newScaledMatrix [][] = new int[getRows()][(getColumns())];
    	for(int x = 0; x < rowCount ; x ++)
    	{
    		for(int z = 0 ; z < colCount ; z++)
    		{
    		   int newValue = (getElement(x,z) * scalar)  ;
    			newScaledMatrix[x][z] = newValue;
    		}
    	}
    	Matrix HoldingMatrix = new CompletedMatrix(newScaledMatrix);
    	return HoldingMatrix;
    }

    @Override
    public Matrix plus(Matrix other) 
    {
    	int AdditionMatrix [][] = new int[getRows()][getColumns()];
    	
    	if (other == null)
    	{
    		throw new java.lang.IllegalArgumentException("Null!");

    	}
    	
    	else if (( this.getRows() != other.getRows() || ( this.getColumns() != other.getColumns())))
    	{
    		throw new java.lang.RuntimeException("Mismatched Dimensions!");
    	}
    	else if (( this.getRows() == other.getRows() && ( this.getColumns() == other.getColumns())))
    	{
    		for(int a = 0 ; a < other.getRows(); a++)
    		{
    			for (int b = 0 ; b < other.getColumns(); b++)
    			{
    				AdditionMatrix[a][b] = (this.getElement(a,b) + other.getElement(a,b));
    			}
    		}
      
    		
    	}
    	Matrix FinalMatrix = new CompletedMatrix(AdditionMatrix);
      	return FinalMatrix;

    }

    @Override
    public Matrix minus(Matrix other) 
    {
    	int SubtractionMatrix [][] = new int[getRows()][getColumns()];
    	
    	if (other == null)
    	{
    		throw new java.lang.IllegalArgumentException("Null!");

    	}
    	
    	else if (( this.getRows() != other.getRows() || ( this.getColumns() != other.getColumns())))
    	{
    		throw new java.lang.RuntimeException("Mismatched Dimensions!");
    	}
    	else if (( this.getRows() == other.getRows() && ( this.getColumns() == other.getColumns())))
    	{
    		for(int a = 0 ; a < other.getRows(); a++)
    		{
    			for (int b = 0 ; b < other.getColumns(); b++)
    			{
    				SubtractionMatrix[a][b] = (this.getElement(a,b) - other.getElement(a,b));
    			}
    		}
     
    	}
    	Matrix FinalMatrix = new CompletedMatrix(SubtractionMatrix);
      	return FinalMatrix;
    }

    @Override
    public Matrix multiply(Matrix other) 
    {
   	 int PlaceHolderMatrix [][] = new int[getRows()][getColumns()];	

    	
    	if (other == null || this == null) 
    	{
    		throw new java.lang.IllegalArgumentException("Null!");

    	}
    	
    	 if  ( this.getColumns() != other.getRows())
    	{
    		throw new java.lang.RuntimeException("Mismatched Dimensions!");
    	}
    		
    	
    	if   ( this.getColumns() == other.getRows())
    	{
    	 int MultiplicationMatrixV2 [][] = new int[this.getRows()][other.getColumns()];									
    		for(int a = 0 ; a < this.getRows(); a++)
    		{
    			for (int b = 0 ; b < other.getColumns(); b++)
    			{  int  sum = 0 ;
    				for (int c = 0 ; c < this.getColumns(); c++)
    				{
    					 // MultiplicationMatrix [a][b] = (this.getElement(a,c) * other.getElement(c,b));
    					sum += (this.getElement(a,c) * other.getElement(c,b));
    				}
    				MultiplicationMatrixV2[a][b] = sum;
    			}
    		}
    		Matrix FinalMatrixV2 = new CompletedMatrix(MultiplicationMatrixV2);
    		return FinalMatrixV2;
    	}
    	 
      	 Matrix FinalMatrix = new CompletedMatrix(PlaceHolderMatrix);
    	 return FinalMatrix;
    	
    }
    @Override
    public int hashCode() {
        return (int) rowCount * Matrix.hashCode() * colCount;
    }

    @Override
    public boolean equals(Object other)
    {
    	
			if(this == other && (this.hashCode() == other.hashCode()))
			{
				return true;
			
			}
			
			else
			{
				return false;
			}
		 
    }
   
    	
    /**
     * Returns a string representation of this matrix. A new line character will
     * separate each row, while a space will separate each column.
     * @return string representation
     */
    @Override
    public String toString()
    {
    	String StringMatrix="";
    	for (int a = 0 ; a < getRows(); a++)
		{
			for (int b = 0 ; b < getColumns(); b++)
			{
				StringMatrix += String.format( "%d", this.Matrix[a][b]);
				StringMatrix += " ";
				
			}
			StringMatrix+="\n";
		}
    	return StringMatrix;  	
    }
    
    
    /**
     * Entry point for matrix testing.
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //These tests show sample usage of the matrix, and some basic ideas for testing. They are not comprehensive.

        int[][] data1 = new int[0][0];
        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] data4 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] data5 = {{1, 4, 7}, {2, 5, 8}};

        Matrix m1 = new CompletedMatrix(data1);
        Matrix m2 = new CompletedMatrix(data2);
        Matrix m3 = new CompletedMatrix(data3);
        Matrix m4 = new CompletedMatrix(data4);
        Matrix m5 = new CompletedMatrix(data5);

        System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns());
        System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns());
        System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns());

        //check for reference issues
        System.out.println("m2 -->\n" + m2);
        data2[1][1] = 101;
        System.out.println("m2 -->\n" + m2);

        //test equals
        System.out.println("m2==null: " + m2.equals(null));             //false
        System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
        System.out.println("m2==m1: " + m2.equals(m1));                 //false
        System.out.println("m2==m2: " + m2.equals(m2));                 //true
        System.out.println("m2==m3: " + m2.equals(m3));                 //false
        System.out.println("m3==m4: " + m3.equals(m4));                 //true

        //test operations (valid)
        System.out.println("m1 + m1:\n" + m1.plus(m1));
        System.out.println("m1 + m1:\n" + m1.plus(m1));
        System.out.println("2 * m2:\n" + m2.scale(2));
        System.out.println("m2 + m3:\n" + m2.plus(m3));
        System.out.println("m2 - m3:\n" + m2.minus(m3));
        System.out.println("3 * m5:\n" + m5.scale(3));

        //not tested... multiply(). you know what to do.

        //test operations (invalid)
        //System.out.println("m1 + m2" + m1.plus(m2));
        //System.out.println("m1 + m5" + m1.plus(m5));
        //System.out.println("m1 - m2" + m1.minus(m2));
    }
}
