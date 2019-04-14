package karate.chops.test;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		List<List<Integer>> pascalsTriangle = drawPascalsTriangle(5);

		for (List<Integer> row : pascalsTriangle) {
			for (int col : row)
				System.out.print(col + " ");
			System.out.println("");
		}
	}

//	private static List<List<Integer>> drawPascalsTriangle(int rows) {
//		List<List<Integer>> pascal = new ArrayList<>();
//		
//		for(int i = 0; i<rows;i++) {
//			List<Integer> row = new ArrayList<>(i+1);
//			for(int j = 0; j<=i;j++) {
//				if(j==0 || j == i)
//					row.add(1);
//				else
//					row.add(pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j));
//				
//			}
//			pascal.add(row);
//		}
//		
//		return pascal;
//	}

	private static List<List<Integer>> drawPascalsTriangle(int rows) {
		if(rows==0)
			return null;
		List<List<Integer>> pascal = new ArrayList<List<Integer>>();
		for(int i=0;i<rows;i++){
			List<Integer> intermediate = new ArrayList<Integer>();
			for(int j=0;j<=i;j++){
				if(i==0)
					intermediate.add(1);
				else if(j==0 || j==i)
					intermediate.add(1);
				else
					intermediate.add(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j));
			}
			pascal.add(intermediate);
		}
		return pascal;		
	}
}
