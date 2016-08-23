import java.util.Random;
import java.util.Scanner;

//control i formats
public class StageThreeTest {
	public static void main(String[] args) {

		int[][] board = new int[3][3];
		int[][] board2=new int [3][3];//board length
		int[][] ships = new int[2][2]; // first number is number of ships 
		int[][] ships2 = new int[2][2];
		int[] shoot = new int[2];
		int attempts=0,
				shotHit=0;
		int attempts2=0,
				shotHit2=0;


		initBoard(board);
		showBoard(board);
		initShips(ships);
		initBoard2(board2);
		showBoard2(board2);
		initShips2(ships2);
		System.out.println();	 	


		do{//player one hits player two first
			System.out.print("Player One get ready to guess ");
			showBoard2(board2);
			shoot(shoot);
			attempts2++;

			if(hit(shoot,ships2)){
				hint(shoot,ships2,attempts2);
				shotHit2++;
			}                
			else
				hint(shoot,ships2,attempts2);

			changeboard(shoot,ships2,board2);


		}while(shotHit2!=2);

		System.out.println("\n\n\nBattleship Java game finished! You hit 2 ships in "+attempts2+" attempts");
		//showBoard(board);
	
	
	do{ //then player two hits board one
		System.out.println("Player Two's Turn to guess ");
		showBoard(board);
		shoot(shoot);
		attempts++;

		if(hit(shoot,ships)){
			hint(shoot,ships,attempts);
			shotHit++;
		}                
		else
			hint(shoot,ships,attempts);

		changeboard(shoot,ships,board);


	}while(shotHit!=2);

	System.out.println("\n\n\nBattleship Java game finished! You hit 2 ships in "+attempts+" attempts");
	//showBoard(board);


	if (attempts <attempts2) {
		System.out.println("Player Two Wins");
	    
	}else if (attempts2 < attempts){
		System.out.println("Player One Wins");
	}else
		System.out.println("No Winner");
	
	}


	public static void initBoard(int[][] board){ //initialise board method
		for(int row=0 ; row < board.length ; row++ )
			for(int column=0 ; column < board.length ; column++ )
				board[row][column]=-1;
	}

	public static void initBoard2(int[][] board){ //initialise board method
		for(int row=0 ; row < board.length ; row++ )
			for(int column=0 ; column < board.length ; column++ )
				board[row][column]=-1;
	}
	public static void showBoard(int[][] board){
		System.out.println("Board One");
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
			int ship2 = ship +1 ;
			do
			{
				System.out.println("Enter Row Position of Ship " + ship2 + ":");
				ships[ship][0] = s.nextInt() - 1; //set to one to work in previous else if loop
				
				
			}
			while (ships[ship][0] < 0 || ships[ship][0] > 2); //2 is end of the grid 
			do
			{
				System.out.println("Enter Column Position of Ship " + ship2 + ":");
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
	} // End of initShips

	public static void showBoard2(int[][] board){
		System.out.println("Board Two");
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

	public static void initShips2(int[][] ships)
	{
		Random random = new Random();
		Scanner s = new Scanner(System.in);

		for(int ship = 0 ; ship < ships.length ; ship++) //ships.length is number of ships 
		{
			int ship2 = ship +1 ;
			do
			{
				System.out.println("Enter Row Position of Ship " + ship2 + ":");
				ships[ship][0] = s.nextInt() - 1; //set to one to work in previous else if loop
			}
			while (ships[ship][0] < 0 || ships[ship][0] > 2); //2 is end of the grid 
			do
			{
				System.out.println("Enter Column Position of Ship " + ship2 + ":");
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
	} // End of initShips

	public static void shoot(int[] shoot){
		Scanner input = new Scanner(System.in);

		System.out.print("Row: ");
		shoot[0] = input.nextInt();
		shoot[0]--;

		System.out.print("Column: ");
		shoot[1] = input.nextInt();
		shoot[1]--;

	}

	public static boolean hit(int[] shoot, int[][] ships){

		for(int ship=0 ; ship<ships.length ; ship++){
			if( shoot[0]==ships[ship][0] && shoot[1]==ships[ship][1]){
				System.out.printf("You hit a ship located in (%d,%d)\n",shoot[0]+1,shoot[1]+1);
				return true;
			}
		}
		return false;
	}

	public static void hint(int[] shoot, int[][] ships, int attempt){
		int row=0,
				column=0;

		for(int line=0 ; line < ships.length ; line++){
			if(ships[line][0]==shoot[0])
				row++;
			if(ships[line][1]==shoot[1])
				column++;
		}

		System.out.printf("\nHint %d: \nRow %d -> %d ships\n" +
				"Column %d -> %d ships\n",attempt,shoot[0]+1,row,shoot[1]+1,column);
	}

	public static void changeboard(int[] shoot, int[][] ships, int[][] board){
		if(hit(shoot,ships))
			board[shoot[0]][shoot[1]]=1;
		else
			board[shoot[0]][shoot[1]]=0;
	}
}

//take in turns to shoot board and board2
//player one will take shots at board two
//player two will take shots at board one
//clear user input so other player does not see
//check code after lunch - playing against wrong board?
