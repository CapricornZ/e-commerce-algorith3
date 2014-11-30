package e_commerce.algorithm3.patterns.pattern2;

import java.util.List;

/***
 * match pattern oo ... oo
 */
public class DoubleTrueOnBothSide implements IPattern {

	@Override
	public boolean shouldStop(List<Boolean> result) {
		
		int len = result.size();
		if(len < 5)
			return false;
		if(result.get(len-1) && result.get(len-2))
			for(int i=len-3; i>0; i--){
				if(result.get(i) && result.get(i-1))
					return true;
			}
		return false;
	}

}
