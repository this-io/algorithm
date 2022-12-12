package implementation.interview;

public class DetectServerMicrosoftInternal {

	public static void main(String[] args) {
		DetectServerMicrosoftInternal d = new DetectServerMicrosoftInternal();
		int[][] matrix = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
		d.print(matrix);
		d.countServers(matrix);
		//d.countBits(2);
	}

	public int print(int[][] grid) {
		for(int row = 0; row < grid.length; row ++) {
			for(int col = 0; col < grid[row].length; col++) {
				System.out.print(grid[row][col]+ "  ");
			}
			System.out.print("\n");
		}
		return 0;
	}

	public int countServers(int[][] grid) {
		int result = 0;
		for(int row = 0; row < grid.length; row ++) {
			for(int col = 0; col < grid[row].length; col++) {
				if(row == col) {

				}
			}
		}
		return 0;
	}

	private void dfs(int row, int col) {

	}

}
