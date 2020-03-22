public class Cholesky {
  double [][]A = new double[4][4];
  double []b = new double[4];
  double []x = new double[4];
  int num;

  public Cholesky(){}

  public Cholesky(double A[][], double b[], int n){
    this.num = n;
    int num = n-1, i, j, k;
    double s, r;
    double []x = new double[n];
    double [][]G = new double[n][n];

    // Cholesky Decomposition
    for(i = 0; i< n;i++){
      for(k = 0; k < (i+1); k++){
        s = 0;
        for(j = 0; j < k; j++) s += G[i][j] * G[k][j];
        G[i][k] = (i == k) ? Math.sqrt(A[i][i] - s) : (1.0 / G[k][k] * (A[i][k] - s));
      }
    }
    
    for(i=0; i<n; i++){
      for(j=0; j<n; j++){
        if(j == n-1) System.out.print(G[i][j] + "\n");
        else System.out.print(G[i][j] +" ");
      }
    }

    // Successive subtraction
    x[0] = b[0] / G[0][0];
    for(k = 1; k < n; k++){
      s = 0 ;
      for(j = 0; j < k; j++) s = s + G[k][j] * x[j];
      x[k] = (b[k] - s) / G[k][k];
    }

    // X = G'
    double [][]X = new double[n][n];
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++) X[j][i] = G[i][j];
        
    //b = x
    for(i = 0; i < n; i++) b[i] = x[i];
    
    // Retroactive subtraction
    x[n-1] = b[n-1]/ X[n-1][n-1];
    for(k = n-2; k > -1; k--){
      s = 0 ;
      for(j = k+1; j < n; j++) s = s + X[k][j]*x[j];
      x[k] = (b[k] - s) / X[k][k];
    }
		
    // Internalizing in class
    for (i = 0; i < n; i++){
      this.b[i] = b[i]; this.x[i] = x[i];
      for (j = 0; j < n; j++) this.A[i][j] = G[i][j];
    }
  }

  public static void main(String args[]) {

  System.out.println("#################################################################################");
  System.out.println("################################# CHOLESKY ######################################");
  System.out.println("#################################################################################");

  double [][]A = {{9,6,-3,3},
                  {6,20,2,22},
                  {-3,2,6,2},
                  {3,22,2,28}};

  double []b = {12,64,4,82};

  Cholesky m = new Cholesky(A, b, 4);

  System.out.println(m.x[0]);
  System.out.println(m.x[1]);
  System.out.println(m.x[2]);
  System.out.println(m.x[3]);

  }
}
