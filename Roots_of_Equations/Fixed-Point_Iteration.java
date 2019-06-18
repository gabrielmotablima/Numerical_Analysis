public class Function {
	private double y, x, rho;

	public Function(){
	}

	public Function(double x){
		this.x=x;
		//this.rho = -(2.0/3.0)*x*x*x + (4.0/3.0)*x*x;
		//this.y = 2.0*x*x*x - 4.0*x*x + 3.0*x;
		this.rho = Math.cos(x);
		this.y = Math.cos(x) - x;
	}

	public static void main(String args[]) {
		double a = 0.0;
		double b = 1.0;
		double p =  1.0e-8;
		int count  =  0;
		double x=0;

		Function Ma = new Function(a);
		Function Mb = new Function(b);

		System.out.println("#################################################################################");
		System.out.println("################################## FIXED-POINT ##################################");
		System.out.println("#################################################################################");
		
		while( Math.abs((Ma.y))>p ){
			Ma = new Function(a);

			b = Ma.rho;

			Mb = new Function(b);

			if( Math.abs((Mb.y))>p || Math.abs((b-a))>p ){
				x = b;
			}

			a = Mb.rho;
			x = a;
			count = count + 1 ;
			System.out.println("it: "+count+" | a: "+a+" | b: "+b+" | E: "+ (b-a) +" | x: "+x+" | f(a): "+Ma.y+" | f(b): "+Mb.y+" ");	
		
		}
		System.out.println("Raiz: "+x+" ");	
	}
}
