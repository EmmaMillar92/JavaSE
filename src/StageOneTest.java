//import java.util.Random;


public class StageOneTest {
	 public static void main(String[] args) {
		 
			 int[][] board = new int[3][3]; //board length 3x3
		      int[][] ships = new int[1][1]; // 1ship?
		
	        initBoard(board);
	        showBoard(board);
	       // initShips(ships);
	        
	        
	        System.out.println();	 	
	
		 
	 }
	 
	 public static void initBoard(int[][] board){ //initialise board method
	        for(int row=0 ; row < board.length ; row++ )
	            for(int column=0 ; column < board.length ; column++ )
	                board[row][column]=-1;
	    }
	    
	    public static void showBoard(int[][] board){ // show board

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
	    public static void initShip(int[][] ship){
	    	
	    	
	    }
	    //set location of ship and show  
}

// randomise location of one ship

	 //board layout
	 //initialise ships
	 //
// 3x3
//one ship that is two pieces long
