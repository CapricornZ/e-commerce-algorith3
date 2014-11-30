package e_commerce.algorithm3.patterns.pattern2;

import java.util.List;

/***
 * match pattern oxoxo ... oo
 */
public class Pattern2_3 implements IPattern {

	@Override
	public boolean shouldStop(List<Boolean> result) {;
		int length = result.size();
		if(length < 7)
			return false;
		
		if(result.get(length-1) && result.get(length-2))
			for(int i=length - 3; i>3; i--){
				if(result.get(i) && !result.get(i-1) && result.get(i-2) && !result.get(i-3) && result.get(i-4))
					return false;
			}
		return false;
	}

}
