public class KnightBoard{

    public int[][] board;

    public KnightBoard(int size){
	board = new int[size+4][size+4];
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board[row].length; col++){
		if (row < 2 || row > size+1 ||
		    col < 2 || col > size+ 1){
		    board[row][col] = -1;
		}
	    }
	}
    }

    public KnightBoard(){
	this(4);
    }

    public String toString(){
	String retString = "";
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board[row].length; col++){
		retString += board[row][col] + "\t";
	    }
	    retString += "\n";
	}
	return retString;
    }
    
    public static void main (String[] args){
	
	KnightBoard b = new KnightBoard(4);
	System.out.println(b);
    }

}
