public class Aa {

	public int valor;
	public int cor;
	public Aa esq;
	public Aa dir;
	static int R=0;
	static int N=1;

	public Aa(int v, int c, Aa Esq, Aa Dir) {
		valor = v;
		cor = c;
		esq = Esq;
		dir = Dir;				
	}
	
	static String infixe(Aa a) {
		String ret = new String();
		
		if(a.esq != null) {
			ret += infixe(a.esq);
		}
		
		ret += a.valor + " ";
		
		if(a.dir != null) {
			ret += infixe(a.dir);
		}
		
		return ret;
	}
	static Aa rodeDir(Aa a) {
		if(a != null && a.esq != null && a.esq.cor == R) {
			Aa aux = a.esq;
			a.esq = a.esq.dir;
			aux.dir = a;
			return aux;
		}
		return a;
	}
	
	static Aa rodeEsq(Aa a) {
		if(a != null && a.dir != null && a.dir.dir != null && a.dir.cor == R && a.dir.dir.cor == R) {
			Aa aux = a.dir;
			a.dir = aux.esq;
			aux.esq = a;
			return aux;
		}
		return a;
	}
	
	static Aa insere(Aa a, int i) {
		if(a == null) {
			a = new Aa(i, R, null, null);
		}
		else if(i > a.valor) {
			if(a.dir == null)
			{
				a.dir = new Aa(i, R, null, null);
			}
			else
				insere(a.dir, i);
		}
		else if(i < a.valor) {
			if(a.esq == null)
			{
				a.esq = new Aa(i, R, null, null);
			}
			else
				insere(a.esq, i);
		}
		a = rodeDir(a);
		a = rodeEsq(a);
		return a;
	}
	
	static Aa insereECorrigeRaiz(Aa a, int i) {
		a = insere(a, i);
		if(a.cor == R) {
			a.cor = N;
		}
		return a;
	}
	
	public static void main(String[] args) {
		//testInflixe();
		//testRodeDir();
		//testRodeEsq();
		//testRodeDir2();
		//testInsere1();
		//testInsere2();
		//testInsere3();
		//testInsereECorrige1();
		//testInsereECorrige2();
		//testInsereECorrige3();
		//testInsereECorrige4();
		testInsereECorrige5();
	}
	
	static void testInsereECorrige5() {
		System.out.println ("\n\n INSERE E CORRIGE 4");
		Aa a = null;
		Fenetre j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 2);
		j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 1);
		j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 4);
		j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 3);
		j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 6);
		//j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 5);
		//j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 7);
		//Fenetre j2 = new Fenetre(a);
	}
	
	static void testInflixe() {
		System.out.println ("\n\n TEST INFLIXE");
		Aa a = new Aa (3, N,
				new Aa (1, N, null, null),
					new Aa (8, R,
						new Aa (5, N, null,
							new Aa (6, R, null, null)),
								new Aa (9, N,null,
									new Aa (11, R, null, null))));
			System.out.println (infixe(a));
			
	}
	
	static void testRodeDir() {
		System.out.println ("\n\n RODE DIR");
		Aa a = new Aa (4, R,
				new Aa (2, R,
				new Aa (1, N, null, null),
				new Aa (3, N, null, null)),
				new Aa (5, N, null, null));
		Fenetre j1 = new Fenetre(a);
		a = rodeDir(a);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testRodeDir2() {
		System.out.println ("\n\n RODE DIR 2");
		Aa a = new Aa (4, R, 
							null,
							new Aa (5, N, null, null));
		Fenetre j1 = new Fenetre(a);
		a = rodeDir(a);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testRodeEsq() {
		System.out.println ("\n\n RODE ESQ");
		Aa a = new Aa (2, N,
				new Aa (1, N, null, null),
				new Aa (4, R,
				new Aa (3, N, null, null),
				new Aa (6, R,
				new Aa (5, N, null, null),
				new Aa (7, N, null, null))));
		Fenetre j1 = new Fenetre(a);
		a = rodeEsq(a);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testInsere1() {
		System.out.println ("\n\n INSERE1");
		Aa a = new Aa (2, N,
				new Aa (1, N, null, null),
				new Aa (4, R,
				new Aa (3, N, null, null),
				new Aa (6, R,
				new Aa (5, N, null, null),
				new Aa (7, N, null, null))));
		Fenetre j1 = new Fenetre(a);
		a = insere(a, 8);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testInsere2() {
		System.out.println ("\n\n INSERE2");
		Aa a = new Aa (2, N,
				new Aa (1, N, null, null),
				new Aa (4, R,
				new Aa (3, N, null, null),
				new Aa (6, R,
				new Aa (5, N, null, null),
				new Aa (7, N, null, null))));
		Fenetre j1 = new Fenetre(a);
		a = insere(a, 3);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testInsere3() {
		System.out.println ("\n\n INSERE3");
		Aa a = new Aa(0,R,
				new Aa(-1, R, null, null),null);
		Fenetre j1 = new Fenetre(a);
		a = insere(a, -2);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testInsere4() {
		System.out.println ("\n\n INSERE4");
		Aa a = new Aa (2, N,
				new Aa (1, N, null, null),
				new Aa (4, R,
				new Aa (3, N, null, null),
				new Aa (6, R,
				new Aa (5, N, null, null),
				new Aa (7, N, null, null))));
		Fenetre j1 = new Fenetre(a);
		a = insere(a, 8);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testInsereECorrige1() {
		System.out.println ("\n\n INSERE E CORRIGE 1");
		Aa a = new Aa (2, N,
				new Aa (1, N, null, null),
				new Aa (4, R,
				new Aa (3, N, null, null),
				new Aa (6, R,
				new Aa (5, N, null, null),
				new Aa (7, N, null, null))));
		Fenetre j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 8);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testInsereECorrige2() {
		System.out.println ("\n\n INSERE E CORRIGE 2");
		Aa a = new Aa (2, N,
				new Aa (1, N, null, null),
				new Aa (4, R,
				new Aa (3, N, null, null),
				new Aa (6, R,
				new Aa (5, N, null, null),
				new Aa (7, N, null, null))));
		Fenetre j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 3);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testInsereECorrige3() {
		System.out.println ("\n\n INSERE E CORRIGE 3");
		Aa a = new Aa(0,R,
				new Aa(-1, R, null, null),null);
		Fenetre j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, -2);
		Fenetre j2 = new Fenetre(a);
	}
	
	static void testInsereECorrige4() {
		System.out.println ("\n\n INSERE E CORRIGE 4");
		Aa a = new Aa (2, N,
				new Aa (1, N, null, null),
				new Aa (4, R,
				new Aa (3, N, null, null),
				new Aa (6, R,
				new Aa (5, N, null, null),
				new Aa (7, N, null, null))));
		Fenetre j1 = new Fenetre(a);
		a = insereECorrigeRaiz(a, 8);
		Fenetre j2 = new Fenetre(a);
	}
	
}
