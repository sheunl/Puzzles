/************
This is a code based solution to a problem on adding square boxes 
of an n x n matrix.
eg.
A 4 x 4 matrix : 
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16

will have:
1  2  3  4
5        8 
9        12
13 14 15 16

and

6  7
10 11

with sums of 102 & 34 respectively.

Have fun..
*********/

import java.util.Scanner;

/**
 *
 * @author Oluwasheun
 */
public class CenterClass {
    
   
public static int summer(int x, int m, int n, int tarray[][])
{
	int total_sum=0;

	
	//top additions
	int top_sum=0;
	for(int i=x;i<x+1;i++)
	{
		for(int j=x;j<(m-x)+1;j++)
		{
		  top_sum+=tarray[i][j];
		 // System.out.print(tarray[i][j]+" \n");
		}
	}
	
	//System.out.print("Top Border "+top_sum+" \n");
        
        //right additions
	int right_sum=0;
        
	for(int i=x+1;i<(m-x)+1;i++)
	{
		for(int j=m-x;j<(m-x)+1;j++)
		{
		  right_sum+=tarray[i][j];
		//  System.out.print(tarray[i][j]+" \n");
		}
	}
	
	//System.out.print("Right Border "+right_sum+" \n");
        
        //left additions
	int left_sum=0;
        
	for(int i=x+1;i<(m-x)+1;i++)
	{
		for(int j=x;j<x+1;j++)
		{
		  left_sum+=tarray[i][j];
		  //System.out.print(tarray[i][j]+" \n");
		}
	}
	
	//System.out.print("Left Border "+left_sum+" \n");
        
        //bottom additions
	int bottom_sum=0;
        
	for(int i=m-x;i<(m-x)+1;i++)
	{
		for(int j=x+1;j<m-x;j++)
		{
		  bottom_sum+=tarray[i][j];
		//  System.out.print(tarray[i][j]+" \n");
		}
	}
	
	//System.out.print("Bottom Border "+bottom_sum+" \n");
        
        total_sum = top_sum + left_sum + right_sum + bottom_sum;
        
        return total_sum;
}

public static void main(String args[])
{
  
    String options[] = {"ordered","manual"};
    Scanner in = new Scanner (System.in);
    
    
    System.out.print("!---Welcome To Square Matrix Box Summer---!\n\n");
    System.out.print("Please, input the size of the matrix:\n");
	int sizeNum = in.nextInt();
    System.out.print("Please, select the method of createing the matrix: \n1) Auto (By order) \n 2) Manual \n");
	int methodNum = in.nextInt();
	int square_matrix[][] = square_matrix_generator(sizeNum,options[methodNum-1]);
        
        
    System.out.printf("\n\n The Generated %d by %d Matrix:\n\n",sizeNum,sizeNum);
        
        for(int i=0;i<square_matrix.length;i++)
        {
            for(int j=0;j<square_matrix.length;j++)
            {
                System.out.print(" "+square_matrix[i][j]+" ");
                
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        
        int n = square_matrix.length;
	int m=n-1;
	int box_num = n/2;
        int boxes[]=new int[box_num];
	
	System.out.print("This is length of the 2darray "+n+"\n");
	
	for (int i=0;i<box_num;i++)
	{
		boxes[i]=summer(i,m,n,square_matrix);
	}
      
        for (int i=0;i<boxes.length;i++)
        {
            System.out.println("!------------------------! All SUMS !------------------------!");
            System.out.print(i+": "+boxes[i]+" \n");
            System.out.println("!------------------------! All SUMS !------------------------!");
        }
        if (n%2==1){
            System.out.println("!------------------------! All SUMS !------------------------!");
            System.out.print((boxes.length+1)+": "+square_matrix[n/2][n/2]+" \n");
            System.out.println("!------------------------! All SUMS !------------------------!");
            
        }
}

public static int[][] square_matrix_generator(int size,String mode)
{
    int x[][]= new int[size][size];
    
    if (mode.equals("ordered"))
    { 
        int count=1;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                x[i][j]=count;
                count++;
            }
        }
    }
    else if(mode.equals("manual"))
    {
        Scanner manual_input = new Scanner(System.in);
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                System.out.printf("Input the number for Row %d | Column %d->",i,j);
                x[i][j]=manual_input.nextInt();
          
            }
        }
        
        System.out.println();
    }
    else 
    {
      System.out.println("Wrong Input, Enter 1 or 2. Exiting...");
      System.exit(0);
    }
    
    
return x;    
}

}
