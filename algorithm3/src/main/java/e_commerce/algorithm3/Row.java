package e_commerce.algorithm3;

import java.util.ArrayList;
import java.util.List;

public class Row {
	
	private List<Integer> source;
	public Row(List<Integer> source){
		this.source = source;
	}

	public List<TrueAndFalse> run(){
		
		List<TrueAndFalse> rtn = new ArrayList<TrueAndFalse>();
		
		int i=2;
		while(i<source.size()){
			
			int num = source.get(i-2)*100 + source.get(i-1)*10 + source.get(i);
			if(num == 222){
				
				List<Boolean> result = new ArrayList<Boolean>();
				boolean shouldStop = false;
				int index=0;
				for(; !shouldStop && i+index+1<source.size(); index++){
					
					result.add(source.get(i+index+1) == 3);
					shouldStop = new e_commerce.algorithm3.patterns.pattern2.Pattern2().shouldStop(result);
				}
				i += index+3;
				rtn.add(new TrueAndFalse(result));
				continue;

			} else if(num == 333){
				
				List<Boolean> result = new ArrayList<Boolean>();
				boolean shouldStop = false;
				int index=0;
				for(; !shouldStop && i+index+1<source.size(); index++){
					
					result.add(source.get(i+index+1) == 2);
					shouldStop = new e_commerce.algorithm3.patterns.pattern2.Pattern2().shouldStop(result);
				}
				i += index+3;
				rtn.add(new TrueAndFalse(result));
				continue;

			} else
				i ++ ;
		}
		return rtn;
	}

}
