package e_commerce.algorithm3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) throws IOException {
		
		/*List<Boolean> x = new ArrayList<Boolean>(){};
		x.add(false);
		x.add(false);
		x.add(true);
		x.add(false);
		x.add(false);
		x.add(true);
		x.add(false);
		x.add(false);
		x.add(false);
		x.add(true);
		x.add(false);x.add(true);x.add(false);x.add(true);x.add(true);
		
		new TrueAndFalse(x).run(0);*/
		
		if(args.length != 1){
			logger.error("params:file path required!\r\n");
			return;
		}
		
		String filePath = args[0];
		logger.info("----------------------------------------\r\n");
		logger.info("start scanning {} ...\r\n", filePath);
		logger.info("----------------------------------------\r\n");
		InputStreamReader read = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		List<List<TrueAndFalse>> totalResult = new ArrayList<List<TrueAndFalse>>();
		int maxCountOfTaf = 0;
		while ((lineTxt = bufferedReader.readLine()) != null) {
			
			String source = lineTxt.trim();
			if(source.length() == 0){
				logger.info("skip row : {}\r\n", source);
				continue;
			}
			
			SourceRow sRow = new SourceRow(source);
			sRow.print();
			Row row = sRow.run();
			List<TrueAndFalse> rtn = row.run();
			int countOfTaf = 0;
			for(TrueAndFalse taf : rtn){
				countOfTaf ++ ;
				taf.print();
				taf.run(0);
			}
			if(countOfTaf > maxCountOfTaf)
				maxCountOfTaf = countOfTaf;
			totalResult.add(rtn);
			
		}
		read.close();
		
		logger.info("--------------------------------------------------\r\n");
		logger.info("---------------------整个文件汇总-------------------\r\n");
		for(int i=0; i<maxCountOfTaf; i++){
			int sum = 0, max = 0;
			int countTrue = 0, countFalse = 0;
			for(List<TrueAndFalse> list : totalResult){
				if(list.size() > i){
					TrueAndFalse taf = list.get(i);
					
					sum += taf.getSum();
					countTrue += taf.getCountTrue();
					countFalse += taf.getCountFalse();
					if(max < taf.getMax())
						max = taf.getMax();
				}	
			}
			logger.info("第{}段 [ SUM:{}, MAX:{}, x:{}({}%), o:{}({}%) ]\r\n", i+1, max, sum, 
					countFalse, (float)countFalse*100/(float)(countFalse+countTrue),
					countTrue, (float)countTrue*100/(float)(countFalse+countTrue));
		}
		logger.info("--------------------------------------------------\r\n");
		
		//String source = "AABBAAABBBBAABABAAABAABAAAABAABBBAAAB";
		//SourceRow sRow = new SourceRow(source);
		//sRow.print();
		//Row row = sRow.run();
		//List<TrueAndFalse> rtn = row.run();
		//for(TrueAndFalse taf : rtn){
		//	taf.print();
		//	taf.run(0);
		//}
	}
}
