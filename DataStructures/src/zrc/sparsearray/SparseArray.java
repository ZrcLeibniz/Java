package zrc.sparsearray;

public class SparseArray {
	public static void main(String[] args) {
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;
		System.out.println("原始数组如下所示:");
		for(int i = 0;i < 11;i++) {
			for(int j = 0;j < 11;j++) {
				System.out.printf("%d\t",chessArr1[i][j]);
			}
			System.out.println();
		}
		int sum = 0;
		for(int i = 0;i < chessArr1.length;i++) {
			for(int j = 0;j < chessArr1[1].length;j++) {
				if(chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
//		System.out.println(sum);
		int sparseArr[][] = new int[sum + 1][3];
		sparseArr[0][0] = chessArr1.length;
		sparseArr[0][1] = chessArr1[1].length;
		sparseArr[0][2] = sum;
		int count = 0;
		for(int i = 0;i < chessArr1.length;i++) {
			for(int j = 0;j < chessArr1[1].length;j++) {
				if(chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}
		System.out.println("对原始数组进行稀疏处理后的稀疏数组如下所示:");
		for(int i = 0;i < sparseArr.length;i++) {
			for(int j = 0;j < sparseArr[1].length;j++) {
				System.out.printf("%d\t",sparseArr[i][j]);
			}
			System.out.println();
		}
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		for(int i = 1; i<sparseArr.length;i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		System.out.println("由稀疏数组恢复后的原始数组如下所示:");
		for(int i = 0;i < chessArr2.length;i++) {
			for(int j = 0;j < chessArr2.length;j++) {
				System.out.printf("%d\t",chessArr2[i][j]);
			}
			System.out.println();
		}
	}
}