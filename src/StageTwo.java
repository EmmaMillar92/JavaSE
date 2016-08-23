import java.util.Random;
import java.util.Scanner;

//control i formats
public class StageTwo {
	public static void main(String[] args) {

		int[][] board = new int[3][3]; //board length
		int[][] ships = new int[2][2]; // first number is number of ships 

		initBoard(board);
		showBoard(board);
		initShips(ships);


		System.out.println();	 	


	}

	public static void initBoard(int[][] board){ //initialise board method
		for(int row=0 ; row < board.length ; row++ )
			for(int column=0 ; column < board.length ; column++ )
				board[row][column]=-1;
	}

	public static void showBoard(int[][] board){

		System.out.println("\t1 \t2 \t3 ");
		System.out.println(); // extra line

		for(int row=0 ; row < board.length ; row++ ){
			System.out.print((row+1)+"");
			for(int column=0 ; column < board.length ; column++ ){
				if(board[row][column]==-1){
					System.out.print("\t"+"-"); //t is a tab
				}else if(board[row][column]==0){
					System.out.print("\t"+"+"); //guess
				}else if(board[row][column]==1){ 
					System.out.print("\t"+"S"); //ship
				}	 	              	 
			}
			System.out.println(); //correctly formats
		}
	}   

	public static void initShips(int[][] ships)
	{
		Random random = new Random();
		Scanner s = new Scanner(System.in);

		for(int ship = 0 ; ship < ships.length ; ship++) //ships.length is number of ships 
		{
			do
			{
				System.out.println("Enter Row: ");
				ships[ship][0] = s.nextInt() - 1; //set to one to work in previous else if loop
			}
			while (ships[ship][0] < 0 || ships[ship][0] > 2); //2 is end of the grid 
			do
			{
				System.out.println("Enter Column: ");
				ships[ship][1] = s.nextInt() - 1; //the -1 puts into the array bounds properly as array is 0,1,2 
			}
			while (ships[ship][1] < 0 || ships[ship][1] > 2);

			for(int last = 0 ; last < ship ; last++) //for loop is for shooting
			{
				if( (ships[ship][0] == ships[last][0]) && (ships[ship][1] == ships[last][1]) ) //for shooting
				{
					do
					{
						ships[ship][0] = random.nextInt(5);
						ships[ship][1] = random.nextInt(5);
					}
					while( (ships[ship][0] == ships[last][0]) && (ships[ship][1] == ships[last][1]) );
				} 
			}



		}
		//how to stop ships being placed in same location? if loop

	} 

}

// randomise location of one ship

//board layout
//initialise ships
//
// 3x3
//one ship that is two pieces long

//get user to enter row and column
//place on grid 


//legal placement
//placing in same place breaks code
