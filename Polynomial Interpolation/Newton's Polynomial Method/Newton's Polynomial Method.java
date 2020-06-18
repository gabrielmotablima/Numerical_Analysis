public class InterpolaNewton{
  double a;

  public InterpolaNewton(){}

  public InterpolaNewton(double x[], double y[], double z){
    int m = x.length;
    double []Dely = y;
	
	
    for(int i = 1; i < m; i++)
      for(int j = m-1; j > i; j--) 
        Dely[j] = ( Dely[j] - Dely[j-1] ) / ( x[j] - x[j-i] );

    double r = Dely[m-1];

    for(int i = m-2; i > 0; i--)
      r = r * (z - x[i]) + Dely[i]; 
		
    this.a = r;
  }

  public static void main(String[] args) {
    double []x = { 0.0, 0.100, 0.600, 0.800 };
    double []y = { 0.0, 1.221, 3.320, 4.953 };
    double z = 0.200 ;
    InterpolaNewton A = new InterpolaNewton(x, y, z);
    System.out.println(A.a);
  }
}
