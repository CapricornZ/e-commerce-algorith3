package e_commerce.algorithm3.patterns.pattern2;

import java.util.List;

/***
 * match pattern oo ... oxoxo
 */
public class Pattern2_4 implements IPattern {

	@Override
	public boolean shouldStop(List<Boolean> result) {
		
		int length = result.size();
		if( length < 7)
			return false;
		if(result.get(length-1) && !result.get(length-2) && result.get(length-3) && !result.get(length-4) && result.get(length-5))
			for(int i=length-6; i>0; i--){
				if(result.get(i) && result.get(i-1))
					return true;
			}
		return false;
	}

}
