package e_commerce.algorithm3.patterns.pattern2;

import java.util.List;

public class Pattern2 implements IPattern {
	
	private static IPattern[] patterns;
	static{
		patterns = new IPattern[5];
		
		patterns[0] = new TripleTrue();
		patterns[1] = new DoubleTrueOnBothSide();
		patterns[2] = new Pattern2_3();
		patterns[3] = new Pattern2_4();
		patterns[4] = new Pattern2_5();
	}
	
	@Override
	public boolean shouldStop(List<Boolean> result) {
		
		boolean shouldStop = false;
		for(int i=0; i<patterns.length && !shouldStop; i++)
			shouldStop = patterns[i].shouldStop(result);
		return shouldStop;
	}
}
