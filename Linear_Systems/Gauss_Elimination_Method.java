public class Function {

  public Function(){
  }
  
  public static void main(String args[]) {
    // Matrix Scale
    int n = 3;

    // Matrixes
    double [][] a = new double[3][3];
    double [] b = new double[3], x = new double[3];

    // Third Variables
    double m, s;

    // Loop Variables
    int i, j, k, l, c;

    a[0][0] = 3;
    a[0][1] = 2;
    a[0][2] = 4;
    a[1][0] = 1;
    a[1][1] = 1;
    a[1][2] = 2;
    a[2][0] = 4;
    a[2][1] = 3;
    a[2][2] = 2;

    b[0] = 1;
    b[1] = 2;
    b[2] = 3;

    // Elimination
    for(k = 0; k<n-1; k++){
      for(i = k+1; i<n; i++){
        m = a[i][k]/a[k][k];
        a[i][k] = 0;
        b[i] = b[i] - m*b[k];
        for(j = k+1; j<n; j++){
        a[i][j] = a[i][j] - m*a[k][j];
        }
      }
    }

    // Linear System Resolution
    x[n-1] = b[n-1]/a[n-1][n-1];
    for(k = n-2; k > -1; k--){
      s = 0;
      for(j = k+1; j<n; j++){
        s = s + a[k][j]*x[j];
      }
      x[k] = (b[k] - s)/a[k][k];
    }

    // Results Printing
    System.out.println(" ");
    for(i = 0; i<n; i++){
      for(j = 0; j<n; j++){
        if(j == n-1) System.out.println("["+a[i][j]+"]|["+b[i]+"]");
          else System.out.print("["+a[i][j]+"]");
      }
    }

    for(i = 0; i < n; i++) System.out.println("x["+i+"] = "+x[i]);
  }
}
