package neuralnet;
public class numpy {

	public static double sigmoid(double x) {
		return 1 / (1 + Math.exp(-x));
	}

	public static double[][] random(double mid, double range, int rows, int cols) {
		double[][] D = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				D[i][j] = Math.random() * range + (mid - range/2);
			}
		}
		return D;
	}

	public static double[][] transpose(double[] m1) {
		double[][] M = {m1};
		return numpy.transpose(M);
	}
	
	public static double[][] transpose(double[][] m) {
		double[][] T = new double[m[0].length][m.length];
		for(int i = 0; i < m[0].length; i++) {
			for(int j = 0; j < m.length; j++) {
				T[i][j] = m[j][i];
			}
		}
		return T;
	}

	public static double[][] dot(double[][] m1, double[][] m2) {
		double[][] M = new double[m1.length][m2[0].length];
		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m2[0].length; j++) {
				for(int k = 0; k < m1[0].length; k++) {
					M[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return M;
	}

	public static double[][] subtract(double[][] m1, double[][] m2) {
		double[][] M = new double[m1.length][m1[0].length];
		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1[0].length; j++) {
				M[i][j] = m1[i][j] - m2[i][j];
			}
		}
		return M;
	}

	

	public static double[][] subtract(double d, double[][] m1) {
		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1[0].length; j++) {
				m1[i][j] = d - m1[i][j];
			}
		}
		return m1;
	}

	public static double[][] multiply(double[][] m1, double[][] m2) {
		double[][] M = new double[m1.length][m1[0].length];
		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1[0].length; j++) {
				M[i][j] = m1[i][j] * m2[i][j];
			}
		}
		return M;
	}

	public static double[][] multiply(double val, double[][] m1) {
		double[][] M = new double[m1.length][m1[0].length];
		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1[0].length; j++) {
				M[i][j] = m1[i][j] * val;
			}
		}
		return M;
	}

	public static double[][] add(double[][] m1, double[][] m2) {
		double[][] M = new double[m1.length][m1[0].length];
		for(int i = 0; i < m1.length; i++) {
			for(int j = 0; j < m1[0].length; j++) {
				M[i][j] = m1[i][j] + m2[i][j];
			}
		}
		return M;
	}
	
	public static void printMatrix(double[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j]  + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		double[][] m1 = {{1,2,3}, {4,5,6}};
		double[][] m2 = {{4, 3, 1}, {5, 8, 1}};
		double[][] m3 = {{3,4}, {5,6}};
		double[] m4 = {1,2,3,4,5};
		double[][] m5 = {{4},{2}};
		double[][] m6 = {{4,5,8,3,4,5,6},{1,2,3,4,5,6,7},{1,3,4,5,6,7,3}};
		double[] m7 = {1,2,3,4,5,6,7};
//		printMatrix(m1);
//		m1 = numpy.subtract(m2,  m1);
//		printMatrix(numpy.transpose(m4));
		printMatrix(numpy.dot(m6, numpy.transpose(m7)));
	}
	
}
