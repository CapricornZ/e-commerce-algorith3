package e_commerce.algorithm3;

import java.util.List;

public class App {
	public static void main(String[] args) {
		String source = "AABBAAABBBBAABABAAABAABAAAABAABBBAAAB";
		SourceRow sRow = new SourceRow(source);
		sRow.print();
		Row row = sRow.run();
		List<TrueAndFalse> rtn = row.run();
		for(TrueAndFalse taf : rtn){
			taf.print();
			taf.run(0);
		}
	}
}
