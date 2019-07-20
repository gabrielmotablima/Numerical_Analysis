public class Function {
	private double y, x, ddx;


	public Function(){
	}

	public Function(double x){
		this.x=x;
		//this.ddx = 6.0*x*x - 8.0*x + 3.0;
		//this.y = 2.0*x*x*x - 4.0*x*x + 3.0*x;
		this.ddx = - 1 - Math.sin(x);
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
		System.out.println("################################ NEWTON-RAPHSON #################################");
		System.out.println("#################################################################################");
		
		while( Math.abs((Ma.y))>p ){
			Ma = new Function(a);

			b = a - (Ma.y/Ma.ddx);

			Mb = new Function(b);

			if( Math.abs((Mb.y))>p || Math.abs((b-a))>p ){
				x = b;
			}

			a = b - (Mb.y/Mb.ddx);
			x = a;
			count = count + 1 ;
			System.out.println("it: "+count+" | a: "+a+" | b: "+b+" | E: "+ (b-a) +" | x: "+x+" | f(a): "+Ma.y+" | f(b): "+Mb.y+" ");	
		
		}
		System.out.println("Raiz: "+x+" ");	
	}
}
