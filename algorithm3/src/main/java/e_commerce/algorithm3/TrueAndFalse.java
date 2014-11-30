package e_commerce.algorithm3;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrueAndFalse {
	
	private static final Logger logger = LoggerFactory.getLogger(TrueAndFalse.class);
	private static int[] metaData = new int[] { 1, 2, 3, 5, 8, 13, 21, 34,
		55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946,
		17711, 28657, 46368 };
	
	private List<Boolean> result;
	public TrueAndFalse(List<Boolean> result){
		this.result = result;
	}
	
	public void print(){
		
		StringBuilder sBuild = new StringBuilder();
		int countTrue = 0, countFalse = 0;
		for(Boolean o:this.result){
			if(o){
				countTrue ++;
				sBuild.append("o");
			} else {
				countFalse ++;
				sBuild.append("x");
			}
		}
		logger.info("{}", sBuild);
		
		logger.info(" [ x:{} ({}%), o:{} ({}%) ]\r\n", 
				countFalse, ((float)countFalse*100/(float)(countFalse+countTrue)), 
				countTrue, ((float)countTrue*100/(float)(countFalse+countTrue)));
	}
	
	public void run(int offset){
		
		int max = 0;
		int sum = 0;
		int indexSourceStep3 = 0;
		for (int indexSource = offset; indexSource < result.size(); indexSource++) {
			
			if(max < metaData[indexSourceStep3])
				max = metaData[indexSourceStep3];
			
			if (result.get(indexSource)) {
				sum += metaData[indexSourceStep3];
				logger.info("+{}", metaData[indexSourceStep3]);
				if (indexSourceStep3 != 0)
					indexSourceStep3 -= 1;
			} else {
				sum -= metaData[indexSourceStep3];
				logger.info("-{}", metaData[indexSourceStep3]);
				indexSourceStep3 += 1;
			}
		}
		logger.info(" = {} [ MAX: {} ]\r\n", sum, max);
	}

}
