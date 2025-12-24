/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		sierpinski(n, 0.5, 1.0, 0.0, 0.866025, 0.0, 0.0 );
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) return;
			double nx1 = (x1 + x2)/2, nx2 = (x2 + x3)/2, nx3 = (x3 + x1)/2;
			double ny1 = (y1 + y2)/2, ny2 = (y2 + y3)/2, ny3 = (y3 + y1)/2;
			
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(x2, y2, x3, y3);
			StdDraw.line(x3, y3, x1, y1);
			
			sierpinski(n-1, x1, nx1, nx3, y1, ny1, ny3);
			sierpinski(n-1, nx1, x2, nx2, ny1, y2, ny2);
			sierpinski(n-1, nx3, nx2, x3, ny1, ny2, y3);
			}
}
