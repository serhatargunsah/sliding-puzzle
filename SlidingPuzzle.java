package argunsah.ai.slidingpuzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sac.graph.GraphState;
import sac.graph.GraphStateImpl;

public class SlidingPuzzle extends GraphStateImpl {
	public static final Random random=new Random(555);
	private static final String[] directions= {"U","D","R", "L"};
	public static final int n=3;
	public static final int UP=0;
	public static final int DOWN=1;
	public static final int RIGHT=2;
	public static final int LEFT=3;
	private byte[][] board;
	private int zeroRow;
	private int zeroColumn;
	public SlidingPuzzle() {
		board=new byte[n][n];
		zeroRow=0;
		zeroColumn=0;
		byte k=0;
		for(int i=0;i<n;i++) 
			for(int j=0; j<n; j++)
				board[i][j]= k++;
				
	}
	public SlidingPuzzle(SlidingPuzzle parent) {
		this.board=new byte[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				this.board[i][j]=parent.board[i][j];
			}
		}
		zeroRow = parent.zeroRow;
		zeroColumn =parent.zeroColumn;
	}
	public boolean move (int dir) {
		switch(dir) {
		case DOWN:
			if(zeroRow<n-1) {
				board[zeroRow][zeroColumn]=board[zeroRow+1][zeroColumn];
				board[zeroRow+1][zeroColumn]=0;
				zeroRow++;
				return true;
			}
		
		
		break;
		case UP:
			if(zeroRow>0) {
				board[zeroRow][zeroColumn]=board[zeroRow-1][zeroColumn];
				board[zeroRow-1][zeroColumn]=0;
				zeroRow--;
				return true;
			}
		break;
		case RIGHT:
			if(zeroColumn<n-1) {
				board[zeroRow][zeroColumn]=board[zeroRow][zeroColumn+1];
				board[zeroRow][zeroColumn+1]=0;
				zeroColumn++;
				return true;
			}
		break;
		case LEFT:
			if(zeroColumn>0) {
				board[zeroRow][zeroColumn]=board[zeroRow][zeroColumn-1];
				board[zeroRow][zeroColumn-1]=0;
				zeroColumn--;
				return true;
			}
		}
		return false;
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder txt=new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				txt.append(board[i][j]);
				txt.append(",");
			}
			txt.append("\n");
		}
		
		return txt.toString();
	}
	public void shuffle(int howManyMoves) {
		for(int i=0; i<howManyMoves; i++)
			if(!move(random.nextInt(4)))
				i--;
	}
	@Override
	
	public List<GraphState> generateChildren() {
		List <GraphState> children=new  ArrayList();
		for (int i=0; i<4; i++) {
			SlidingPuzzle child=new SlidingPuzzle(this);
			if(child.move(i)) {
				children.add(child);
				child.setMoveName(directions[i]);
			}
		}
		return children;
	}
	public byte[][]getBoard(){
		return board;
	}
	
	@Override
	public boolean isSolution() {
		int k=0;
		for(int i=0; i<n;i++)
			for(int j=0; j<n; j++) {
				if(board[i][j]!=k++)
					return false;
			}
		return true;
	}
}