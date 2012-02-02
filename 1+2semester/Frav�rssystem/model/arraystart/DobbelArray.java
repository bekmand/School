package model.arraystart;

/**
 * @author mad
 * 
 */
public class DobbelArray {
	public void udskrivArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	public void udskrivArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++)
				System.out.print(array[row][col] + "  ");
			System.out.println();
		}
	}

	public void udskrivArray2(int[][] array) {
		int row = 0;
		while (row < array.length) {
			int col = 0;
			while (col < array[row].length) {
				System.out.print(array[row][col] + "  ");
				col++;
			}
			System.out.println();
			row++;
		}

	}

}
