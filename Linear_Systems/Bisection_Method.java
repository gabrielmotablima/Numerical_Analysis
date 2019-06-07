public class Function {
	private double y, x;

	public Function(){
	}

	public Function(double x){
		this.x=x;
		//this.y = 2.0*x*x*x - 4.0*x*x + 3.0*x;
		this.y = Math.cos(x) - x;
	}

	public static void main(String args[]) {
		double a   = 0.0 ;
		double b   =  1.0 ;
		double p =  1.0e-8;
		int count  =  0;
		double x = (a+b)/2;
		Function M;
		Function Mx = new Function(x);

		System.out.println("#################################################################################");
		System.out.println("################################### BISECTION ###################################");
		System.out.println("#################################################################################");
	
		while(Math.abs((b-a))>p && Math.abs((Mx.y))>p){
			x = (a+b)/2;
			Mx = new Function(x);
			M = new Function(a);

			if( M.y*Mx.y > 0.0 ) a=x;
			else b=x;

			count = count + 1 ;

			System.out.println("it: "+count+" | a: "+a+" | b: "+b+" | E: "+ (b-a) +" | x: "+x+" | y: "+Mx.y+" ");	

		}
		System.out.println("Raiz: "+x+" ");
	}
}
