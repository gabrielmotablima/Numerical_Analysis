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

		Function Ma = new Function(a);
		Function Mb = new Function(b);

		double x = b;

		Function Mx = new Function(x);
		double DeltaX = (-1)*((Mx.y)/(Mb.y-Ma.y))*(b-a);

		

		System.out.println("#################################################################################");
		System.out.println("##################################### PEGASUS ###################################");
		System.out.println("#################################################################################");
		
		count = count + 1 ;
		System.out.println("it: "+count+" | a: "+a+" | b: "+b+" | E: "+ (b-a) +" | x: "+x+" | f(x): "+Mx.y+" | f(a): "+Ma.y+" | f(b): "+Mb.y+" ");	

		while(Math.abs((DeltaX))>p && Math.abs((Mx.y))>p){
			Mx = new Function(x);
			DeltaX = (-1)*((Mx.y)/(Mb.y-Ma.y))*(b-a);
			x = x + DeltaX;
			Mx = new Function(x);
			
			
			if( Mb.y*Mx.y < 0.0 ){
				a=b;
				Ma = new Function(a);
			}
			else{
				Ma.y = Ma.y*Mb.y/(Mb.y+Mx.y);
			}

			b = x;
			Mb = new Function(b);

			count = count + 1 ;
			System.out.println("it: "+count+" | a: "+a+" | b: "+b+" | E: "+ (b-a) +" | x: "+x+" | f(x): "+Mx.y+" | f(a): "+Ma.y+" | f(b): "+Mb.y+" ");	
		
		}
		System.out.println("Raiz: "+x+" ");	
    }
}
