public class Test {
    
    private static char[][] board = new char[10][10];
    private static int[] shipLengths = { 2, 4, 5, 5, 6 }; 
    private static void init() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = 'O';
            }
        }
    } 
    private static void addShips() {
        for(int ship: shipLengths) {
            System.out.println("Adding ship " + ship);
            boolean added = false;
            while(!added) {
                int x = (int)(board.length * Math.random());
                int y = (int)(board[0].length * Math.random());
                boolean horizontal = ((int)(10 * Math.random())) % 2 == 0;
                if(horizontal) {
                    // Check for vertical space
                    boolean hasSpace = true;
                    for(int i = 0; i < ship; i++) {
                        if(y + i >= board[0].length) {
                            hasSpace = false;
                            break;
                        }
                        if(board[x][y+i] != 'O') {
                            hasSpace = false;
                            break;
                        }
                    }
                    if(!hasSpace) {
                        // No room there, check again
                        continue;
                    }
                    for(int i = 0; i < ship; i++) {
                        board[x][y+i] = '-';
                    }
                    added = true;
                } else {
                    // Check for horizontal space
                    boolean hasSpace = true;
                    for(int i = 0; i < ship; i++) {
                        if(x + i >= board.length) {
                            hasSpace = false;
                            break;
                        }
                        if(board[x+i][y] != 'O') {
                            hasSpace = false;
                            break;
                        }
                    }
                    if(!hasSpace) {
                        // No room there, check again
                        continue;
                    }
                    for(int i = 0; i < ship; i++) {
                        board[x+i][y] = '|';
                    }
                    added = true;
                }
            }
        }
    } 
    private static void print() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(""+board[i][j]);
            }
            System.out.println("");
        }
    } 
    public static void main(String[] args) {
        init();
        print();
        addShips();
        print();
    }
}