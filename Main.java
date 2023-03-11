package argunsah.ai.slidingpuzzle;

import sac.graph.AStar;
import sac.graph.GraphSearchAlgorithm;
import sac.graph.GraphState;

//import java.util.Random;
public class Main {
	public static void main(String[] args) {
		
		//Random rand = new Random();
		
		SlidingPuzzle puzzle=new SlidingPuzzle();
		System.out.println(puzzle);
		System.out.println(puzzle.isSolution());
		puzzle.shuffle(50);
		System.out.println(puzzle);
		System.out.println(puzzle.isSolution());
		//System.out.println(puzzle.generateChildren());
		GraphSearchAlgorithm algo= new AStar(puzzle);
		SlidingPuzzle.setHFunction(new MisplacedTiles());
		algo.execute();
		GraphState solution=algo.getSolutions().get(0);
		System.out.println(solution);
		System.out.println("PATH: "+solution.getMovesAlongPath());
		System.out.println("CLOSED: "+algo.getClosedStatesCount());
		
		//int s=0;
		//int re;
		//int sum;
		//for(s=0; s<1000; s++) {
			//puzzle.move(rand.nextInt(4));
			//int rand_int1 = rand.nextInt(4);
			//sum=s+rand_int1;
			//re=sum%4;
			/*switch (re) {
			  case 0:
				puzzle.move(SlidingPuzzle.DOWN);
			    break;
			  case 1:
				 puzzle.move(SlidingPuzzle.UP);
			    break;
			  case 2:
				puzzle.move(SlidingPuzzle.LEFT);
			    break;
			  case 3:
				puzzle.move(SlidingPuzzle.RIGHT);
			    break;
		}*/
		}
		//System.out.println(puzzle);
		/*puzzle.move(SlidingPuzzle.DOWN);
		System.out.println(puzzle);
		puzzle.move(SlidingPuzzle.RIGHT);
		System.out.println(puzzle);
		puzzle.move(SlidingPuzzle.RIGHT);
		System.out.println(puzzle);
		puzzle.move(SlidingPuzzle.UP);
		System.out.println(puzzle);
		puzzle.move(SlidingPuzzle.UP);
		System.out.println(puzzle);
		puzzle.move(SlidingPuzzle.UP);
		System.out.println(puzzle);
		puzzle.move(SlidingPuzzle.RIGHT);
		System.out.println(puzzle);*/
	}



