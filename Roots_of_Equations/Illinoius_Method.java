public class Function {
	private double y, x;


	public Function(){
	}

	public Function(double x){
		this.x=x;
		this.y = 2.0*x*x*x - 4.0*x*x + 3.0*x;
		//this.y = Math.cos(x) - x;
	}

    public static void main(String args[]) {
        double a   = -1.0 ;
		double b   =  1.0 ;
		double p =  1.0e-8;
		int count  =  0;
		int itsma = 0;
		int itsmb = 0;

		Function Ma = new Function(a);
		Function Mb = new Function(b);

		double x = ((a*Mb.y) - (b*Ma.y)) / ((Mb.y) - (Ma.y));

		Function Mx = new Function(x);

		System.out.println("#################################################################################");
		System.out.println("#################################### ILLINOIS ###################################");
		System.out.println("#################################################################################");

		while(Math.abs((b-a))>p && Math.abs((Mx.y))>p){

			if((itsma < 2) && (itsmb < 2)) x = ((a*Mb.y) - (b*Ma.y)) / ((Mb.y) - (Ma.y));
			if (itsma >= 2) x = ((a*Mb.y) - (b*0.5*Ma.y)) / ((Mb.y) - (0.5*Ma.y));
			if (itsmb >= 2) x = ((a*0.5*Mb.y) - (b*Ma.y)) / ((0.5*Mb.y) - (Ma.y));

			Mx = new Function(x);
			Ma = new Function(a);
			Mb = new Function(b);


			if( Ma.y*Mx.y > 0.0 ){
				a=x;
				itsma = 0;
				itsmb = itsmb + 1;
			}
			else{
				b=x;
				itsma = itsma + 1;
				itsmb = 0;
			}

			count = count + 1;


			System.out.println("it: "+count+" | a: "+a+" | b: "+b+" | E: "+ (b-a) +" | x: "+x+" | y: "+Mx.y+"| f(a): "+Ma.y+" | f(b): "+Mb.y+" ");	
		
		}
		System.out.println("Raiz: "+x+" ");	
    }
}