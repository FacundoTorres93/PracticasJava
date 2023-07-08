// Alumno: Torres Facundo
// Carrera: Analista de Sistemas

public class Desempeño1AED4 {
	
	class Nodo {
		int info;
		Nodo ante, sig; // Dos punteros
	}

	private Nodo raiz; 
	int cont = 0;
	
	public Desempeño1AED4() {
		raiz = null;
	}
	
	// Método para insertar dos elementos en la lista
	public void insertar(int x1, int x2){
		Nodo nuevo1 = new Nodo(); 
		Nodo nuevo2 = new Nodo(); 

		nuevo1.info = x1; 
		nuevo2.info = x2; 

		if (vacia()){ 
			raiz = nuevo1; 
			nuevo1.sig = nuevo2; 
			nuevo2.ante = nuevo1; 
		} 
		else {
			if (cont == 4){ 
				Nodo reco = raiz;
				while (reco.sig != null){  
					reco = reco.sig;
				}
				reco.sig = nuevo1; 
				nuevo1.sig = nuevo2; 
				nuevo2.ante = nuevo1; 
				nuevo1.ante = reco; 

			} else { 
				raiz.ante = nuevo2; 
				nuevo2.sig = raiz; 
				raiz = nuevo2; 
				raiz.ante = nuevo1; 
				nuevo1.sig = raiz; 
				raiz = nuevo1; 
			}
		}

		Nodo reco = raiz;
		while (reco.sig != null){ 
			reco = reco.sig;
		}
		cont += 2;
	}

	// Método para sumar los valores de los nodos en posiciones impares
	public int SumarPosImpar() {
		int suma = 0;
		Nodo reco = raiz; 
		int pos = 1;
		while(reco != null) {  
			if(pos % 2 != 0) { 
				suma += reco.info; 
			}
			reco = reco.sig; 
			pos++; 
		}
		return suma; 
	}

	// Método para borrar los nodos primero y último de la lista
	public void borrarNodos() {
		if(cantidad() == 1 || cantidad() == 2) { 
			raiz = null; 
		} else {
			Nodo primero = raiz; 
			Nodo ultimo = raiz; 
			
			while (ultimo.sig != null && ultimo.sig.sig != null) { 
				ultimo = ultimo.sig; 
			}
			raiz = primero.sig; 
			raiz.ante = null; 
			ultimo.sig = null; 
		}
	}

	// Método para intercambiar el primer y último nodo de la lista
	public void intercambiar(){
		Nodo reco = raiz;
		int aux; 
		while (reco.sig != null){
			reco = reco.sig;
		}
		aux = raiz.info;
		raiz.info = reco.info;
		reco.info = aux;
	}

	// Método para borrar todos los nodos que coinciden con el valor del primer nodo
	public void borrarCoincidentes() {
	    int valorPrimero = raiz.info;
	    
	    Nodo actual = raiz.sig; 
	    while (actual != null) {
	        if (actual.info == valorPrimero) {
	            if (actual.sig != null) {
	                actual.sig.ante = actual.ante;
	            }
	            actual.ante.sig = actual.sig;
	        }
	        
	        actual = actual.sig; 
	    }
	}

	// Método para verificar si la lista está vacía
	public boolean vacia(){
		if (raiz == null){
			return true;
		}
		return false;
	}

	// Método para obtener la cantidad de nodos en la lista
	public int cantidad() {
		int cant = 0; 
		Nodo reco = raiz; 
		while (reco != null) {
			cant++; 
			reco = reco.sig; 
		}
		return cant; 
	}

	// Método para imprimir los valores de los nodos en la lista
	public void imprimir() {
		Nodo reco = raiz; 
		while (reco != null) {
			System.out.print(reco.info + "-"); 
			reco = reco.sig; 
		}
		System.out.println();
		System.out.println("-------------------------------------");
	}

	public static void main(String[] args) {
		
		Desempeño1AED4 lg = new Desempeño1AED4(); 
		lg.insertar(10,20); 
		lg.insertar(5,8);
		lg.insertar(200,4);
		lg.insertar(1,2);
		
		System.out.println("Mi Lista: ");
		lg.imprimir(); 
		
		int sumarImpar = lg.SumarPosImpar(); 
		System.out.println("La suma de las posiciones impares de la lista es: " + sumarImpar);
		
		System.out.print("-------------------------------------");
		System.out.println();
		
		System.out.println("Borrando el primer y el último nodo de la lista:");
		lg.borrarNodos(); 
		lg.imprimir(); 
		
		System.out.println("Intercambiando el primer nodo con el último de la lista ");
		lg.intercambiar(); 
		lg.imprimir();
		
		 System.out.println("Borrar todos los nodos que coinciden con la información del primero de la lista ");
		 lg.insertar(20, 35); // Se insertan dos nuevos elementos en la lista
		 System.out.println("Insertamos dos nuevos elementos en la lista:");
		 lg.imprimir(); 
		 lg.borrarCoincidentes(); // Se borran los nodos que coinciden con la información del primer nodo
		 System.out.println("Esta es la lista actualizada después de haber borrado el nodo duplicado (20)");
		 lg.imprimir(); // Se imprime la lista actualizada (nodo 20 borrado)
	}
}
