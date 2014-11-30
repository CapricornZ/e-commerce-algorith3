package e_commerce.algorithm3.patterns.pattern2;

import java.util.List;

/***
 * match pattern ooo
 */
public class TripleTrue implements IPattern {

	@Override
	public boolean shouldStop(List<Boolean> result) {
		
		int length = result.size();
		if( length < 3)
			return false;
		
		if(result.get(length-1) && result.get(length-2) && result.get(length-3))
			return true;

		return false;
	}

}
