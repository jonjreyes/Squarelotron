package squarelotron;

public class Squarelotron {
	int [][] squarelotron; 
	int size; 

	//constructor
	public Squarelotron (int n) { 
		size = n;
		squarelotron  =  new int [n][n]; 
		int count = 1; 

		for (int i =0; i < n; i++) {
			for (int j = 0; j<n; j++) {
				squarelotron[i][j] = count ; 
				count++; 
			}
		}
	}

	// Helper Method
	public void copy(Squarelotron sq) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				sq.squarelotron[i][j] = this.squarelotron[i][j];
			}
		}
	}

	//ADDITIONAL CONSTRUCTORS
	//Converts an array into a squarelotron
	public Squarelotron(int[] array){
		Squarelotron newS = Squarelotron.makeSquarelotron(array);
		this.squarelotron = new int[newS.size][newS.size];
		this.size = newS.size;
		// deep-copy the board
		for(int i=0; i<newS.size; i++){
			for(int j=0; j<newS.size; j++){
				this.squarelotron[i][j] = newS.squarelotron[i][j];
			}
		}
	}


	// Method to construct a Squarelotron using an array
	public static Squarelotron makeSquarelotron(int[] array){
		// test if it is a perfect square length
		int sqrt = (int) Math.sqrt(array.length);
		if(sqrt*sqrt != array.length){
			throw new IllegalArgumentException("bad array has been provided");
		}
		// test if the element is an integer between 0 to 99
		for(int i=0; i<array.length; i++){
			if(array[i] < 0 || array[i] >99 || array[i] != (int)array[i]){
				throw new IllegalArgumentException("bad array has been provided");
			}
		}
		// if pass the previous test, we need to construct squarelotron
		Squarelotron sq= new Squarelotron(sqrt);
		for(int i=0; i<sqrt; i++){
			for(int j=0; j<sqrt; j++){
				sq.squarelotron[i][j] = array[(i*sqrt)+j];
			}
		}
		sq.size = sqrt;
		return sq;
	}

	//Flip the squarelotron according to the ring number, the flip is upside down 
	public Squarelotron upsideDownFlip (int ring) {

		Squarelotron sq = new Squarelotron(size);
		this.copy(sq);

		int firstNumber  = ring -1; 
		int lastNumber = size - ring; 

		for (int i = 0; i <= size -1; i++) {
			for (int j = 0; j <= size -1; j++) {
				//flipping the first and last rows within the ring
				if (i == firstNumber || i == lastNumber) {
					if (j >= firstNumber && j <= lastNumber) {
						sq.squarelotron[i][j] = this.squarelotron[size -1 -i][j];
					}
				}
				//flipping the in between rows of the ring
				else if (i > firstNumber && i < lastNumber) { 
					if (j == firstNumber || j == lastNumber) {
						sq.squarelotron[i][j] = this.squarelotron[size -1 -i][j];
					}
				}
			}
		}
		return sq;
	}

	//This method performs the Main Diagonal Flip of the squarelotron(depending on the ring) and returns the new squarelotron. 
	public Squarelotron mainDiagonalFlip(int ring) {

		Squarelotron sq = new Squarelotron(size);
		this.copy(sq);

		int firstNumber  = ring -1; 
		int lastNumber = size - ring; 

		for (int i = 0; i <= size -1; i++) {
			for (int j = 0; j <= size -1; j++) {

				//flipping the first and last rows within the ring
				if (i == firstNumber || i == lastNumber) {
					if (j >= firstNumber && j <= lastNumber) {
						sq.squarelotron[i][j] = this.squarelotron[j][i];
					}
				}

				//flipping the in between rows of the ring
				else if (i > firstNumber && i < lastNumber) { 
					if (j == firstNumber || j == lastNumber) {
						sq.squarelotron[i][j] = this.squarelotron[j][i];
					}
				}
			}
		}
		return sq;
	}

	//The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise.
	//A value of negative number indicates a 90° counterclockwise rotation. 
	void rotateRight(int numberOfTurns) {
		Squarelotron temp = new Squarelotron(size);
		this.copy(temp); 

		int count = 0; 

		//Rotating 90 degrees clockwise
		if (numberOfTurns >= 1) {
			while(count < numberOfTurns) {
				for (int i = 0 ; i < size; i++) {
					for (int j = 0; j < size; j++) {
						this.squarelotron[i][j] = temp.squarelotron[size-j-1][i];
					}
				}
				this.copy(temp); 
				count++;
			}	
		}
		//Rotating 90 degrees counterclockwise if given a negative number
		else if (numberOfTurns < 0 ) {
			while(count > numberOfTurns) {
				for (int i = 0 ; i < size; i++) {
					for (int j = 0; j < size; j++) {
						this.squarelotron[i][j] = temp.squarelotron[j][size -i - 1];
					}
				}
				this.copy(temp); 
				count--;
			}
		}
		// no rotation if given 0
		else {
			this.copy(temp);
		}

	}

	@Override
	//Printing a screen friendly Squarelotron
	public String toString(){
		String s = "";
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				s += Integer.toString(this.squarelotron[i][j]) + "\t";
			}
			s += "\n";
		}
		return s;
	}
	//Main method
	public static void main(String[] args) {
		Squarelotron sq = new Squarelotron(4);
		Squarelotron temp;
		System.out.println("Starting Point");
		sq.rotateRight(0);
		System.out.print(sq);
		System.out.println("Main Diagonal Flip Outer Ring");
		temp = sq.mainDiagonalFlip(1);
		System.out.print(temp);
		System.out.println("Upside Down Flip Outer Ring");
		temp = sq.upsideDownFlip(1);
		System.out.print(temp);
		System.out.println("Rotate Right 90 Degrees");
		sq.rotateRight(1);
		System.out.print(sq);

	}
}
