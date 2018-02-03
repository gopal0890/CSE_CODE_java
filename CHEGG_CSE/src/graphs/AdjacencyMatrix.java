package graphs;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class AdjacencyMatrix {
	/**
	 *  Class to read an input file and generate an Adjacency Matrix
	 *  eg->
	 *  0 <--- Starting Vertex
	 *  4 <--- No of Vertices in the Graph
	 *  0 1 0 1
	 *  1 0 1 1
	 *  0 1 0 1
	 *  1 1 1 0
	 */

	private String inputFileName;
	private int[][] adjadencyMatrix;
	private int startVertex;

	public AdjacencyMatrix(String inputFileName) throws FileNotFoundException {
		this.inputFileName = inputFileName;
		generateAdjacencyMatrix(this.inputFileName);
	}

	private int[][] generateAdjacencyMatrix(final String inputFileName) throws FileNotFoundException {
		Scanner scan = new Scanner(new FileReader(inputFileName));
		// read the first two lines containing startVertex and nxn size of adjacency Matrix
		this.startVertex = Integer.parseInt(scan.nextLine().split("\\s+")[0]);
		int matrixSize = Integer.parseInt(scan.nextLine().split("\\s+")[0]);

		// Declare/Instantiate multidimensional integer array to hold the adjacency matrix values
		adjadencyMatrix = new int[matrixSize][matrixSize];

		// for each line in the given adjacency matrix
		for (int i = 0; i < matrixSize; i++) {
			// Read line as one long string, and split at whitespace into an array before assigning to aLine
			String[] aLine = scan.nextLine().split("\\s+");
			// Convert each character element in aLine into an integer and copy into matrix
			for (int j = 0; j < matrixSize; j++)
				adjadencyMatrix[i][j] = Integer.parseInt(aLine[j]);
		}
		
		// Print the starting Vertex of the Graph
		System.out.println("Starting Vertex of Graph Is:-> " + startVertex);
		// Print the Adjacency Matrix
		System.out.println("The Adjacency Matrix Is:->");
		for(int i=0;i<matrixSize;i++){
			for(int j=0;j<matrixSize;j++){
				System.out.print(adjadencyMatrix[i][j] + "\t");
			}
			System.out.println();
		}
			
		return adjadencyMatrix;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public int[][] getAdjadencyMatrix() {
		return adjadencyMatrix;
	}

	public int getStartVertex() {
		return startVertex;
	}
	
	// Driver method to test run the Adjacency Matrix
	public static void main(String[] args) {
		try {
			AdjacencyMatrix adjMatrixObj = new AdjacencyMatrix("C:\\CHEGG_GIT\\CHEGG_CSE\\src\\graphs\\AdjacencyMatrix.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}