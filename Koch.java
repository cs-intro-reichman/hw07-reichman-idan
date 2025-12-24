/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
	

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		//snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x5, double y5) {
        // Base case: simple straight line
        if (n == 0) {
            StdDraw.line(x1, y1, x5, y5);
            return;
        }
		double x2 = x1 + (x5 - x1) / 3.0;
        double y2 = y1 + (y5 - y1) / 3.0;

        double x4 = x1 + 2 * (x5 - x1) / 3.0;
        double y4 = y1 + 2 * (y5 - y1) / 3.0;

        double x3 = (x1 + x5) / 2.0 + (Math.sqrt(3) / 6.0) * (y1 - y5);
        double y3 = (y1 + y5) / 2.0 + (Math.sqrt(3) / 6.0) * (x5 - x1);
        
        curve(n - 1, x1, y1, x2, y2);  
        curve(n - 1, x2, y2, x3, y3);   
        curve(n - 1, x3, y3, x4, y4);   
        curve(n - 1, x4, y4, x5, y5);   
    }

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

        double x1 = 0.200, y1 = 0.650;
        double x2 = 0.800, y2 = 0.650;
        double x3 = 0.500, y3 = 0.130;

        // Draw the three sides of the snowflake
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    
	}
}

