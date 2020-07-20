package lab;

public class MarcoPolo {
	
	private int[][] graph;
	
	//only vertical and horizontal
	//private static final int[][] DIRECTIONS = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
	
	// all neighbors
	private static final int[][] DIRECTIONS = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,-1},{-1,1},{1,1}};
	
	private int rows;
	
	private int columns;
	
	public MarcoPolo(int[][] graph) {
		this.rows = size(graph, (byte) 0);
		this.columns = size(graph, (byte) 1);
		this.graph = graph;
	}
	
	private int size(int[][] graph, byte option) {
		try {
			if(option == 0)
				return graph.length;
			return graph[option].length;
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
    
    public int getCountIslands() {
    	if(this.rows * this.columns == 0) {
    		return 0;
    	}
    	
    	int countIslands = 0;
    	boolean [][] visited = new boolean[this.rows][this.columns];
    	
    	for (int row = 0; row < this.rows; row++) {
			for (int column = 0; column < this.columns; column++) {
				if(graph[row][column] == 1 && !visited[row][column]) {
					countIslands++;
					dfs(row, column, visited);
				}
			}
		}
    	return countIslands;
    }
    
    //Depth First Search
    private void dfs(int row, int column, boolean [][] visited) {
    	if(row < 0 || row >= graph.length || column < 0 || column >= graph[1].length || graph[row][column] == 0 || visited[row][column])
    		return ;
    	
    	visited[row][column] = true;
    	
    	for (int dr = 0; dr < DIRECTIONS.length; dr++) {
			dfs(row + DIRECTIONS[dr][0], column + DIRECTIONS[dr][1], visited);
		}
    }
    
    
    public static void main(String[] args) {
		int[][] map = new int[][] {	{ 1, 1, 0, 0, 0 },
									{ 1, 1, 0, 0, 0 },
									{ 0, 0, 1, 1, 1 }};
			
			
    	MarcoPolo marco = new MarcoPolo(map);
		
		System.out.println(marco.getCountIslands());
		
	}


}
