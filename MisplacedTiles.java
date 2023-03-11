package argunsah.ai.slidingpuzzle;

import sac.State;
import sac.StateFunction;

public class MisplacedTiles extends StateFunction {
	public double calculate(State state) {
		int h=0;
		SlidingPuzzle sp=(SlidingPuzzle) state;
		int k =0;
		for (int i=0; i<SlidingPuzzle.n; i++)
			for(int j=0; j<SlidingPuzzle.n;j++) {
				if((sp.getBoard()[i][j]!=k) && (sp.getBoard()[i][j]!=0))
					h++;
				k++;	
			}
		return h;
	}
	
}
