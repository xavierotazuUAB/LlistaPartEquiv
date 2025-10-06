
public class Llista
{
	public Llista() {primer = null;};
	
	public boolean afegirUltim(int valor)
	{
		Node node = new Node(valor); 

		Node aux = primer;
		
		// Comprovem que primer no sigui null
		if(aux!=null)
		{
			while(aux.getNext()!=null)
			{
				aux = aux.getNext();
			}			

			aux.setNext(node);
		}
		else
		{
			primer = node;			
		}
				
		
		return true;
	}
	
	
	public boolean insertarValor(int posicio, int valor)
	{
		boolean bInsertat = false;
		
		Node anterior = null;	// guardarem el node anterior d'on hem de fer la insercio
		Node seguent = primer;	// guardarem el node seguent d'on hem de fer la insercio

		int pos = 0;

		if(posicio==0)
		{
			Node nou = new Node(valor);	// creem el nou node a insertar
			nou.setNext(primer);
			primer = nou;
			bInsertat = true;
		}
		else
		{
			if(posicio>0 && posicio<=getNElements()) // Si posicio és <0 o major al nombre d'elements, no continuem i retornarem false
			{
				// Comprovem que primer no sigui null
				if(primer!=null)
				{
					// Ens desplacem fins la posicio on hem de fer la inserció
					while(pos<posicio)
					{
						anterior = seguent;
						seguent = seguent.getNext();
						pos = pos+1;
					}
					
					seguent = anterior.getNext(); // guardem una referencia/punter al node següent
						
					Node nou = new Node(valor);	// creem el nou node a insertar
						
					anterior.setNext(nou);		// apuntem la referencia/punter next del node anterior al  nou node
					nou.setNext(seguent);
						
					bInsertat = true;				

				}
				
			}
			
		}
		
		
		
		return bInsertat;
	}
	
	
	public boolean eliminaValor(int posicio)
	{
		boolean bEliminat = false;
		
		Node anterior = null;	// guardarem el node anterior del que hem d'eliminar
		Node actual = primer;	// guardarem el node que hem d'eliminar
		Node seguent = null;	// guardarem el node seguent del que hem d'eliminar
		
		int pos = 0;

		if(posicio>=0 && posicio<getNElements()) // Si posicio és <0 o major o igual al nombre d'elements, no continuem i retornarem false
		{
			// Comprovem que primer no sigui null
			if(primer!=null)
			{
				
				// Ens desplacem fins el node on hem de fer el tall
				while(pos<posicio)
				{
					anterior = actual;
					actual = actual.getNext();
					pos = pos+1;
				}
				
				seguent = actual.getNext(); // guardem una referencia/punter al node següent
				
				if(actual==primer) // no hem recorregut la llista, per tant, estem eliminat el primer element
				{
					primer = seguent;
				}
				else 
				{
					anterior.setNext(seguent);	// hem recorregut la llista
				}
				
				bEliminat = true;

			}
			
		}

		
		return bEliminat;
	}
	
	
	
	public int getValor(int posicio)
	{
		int valor = 0;

		int pos = 0;
		Node aux = primer;
		
		// Comprovem que primer no sigui null
		if(aux!=null)
		{
			while(aux.getNext()!=null && pos<posicio)
			{
				aux = aux.getNext();
				pos = pos+1;
			}
			
			valor = aux.getValor();

		}
				
		
		return valor;
	};
	
	public boolean esBuida() {return primer==null;};
	
	public int getNElements()
	{
		int n_elem = 0;

		Node aux = primer;
		
		// Comprovem que primer no sigui null
		if(aux!=null)
		{
			while(aux!=null)
			{
				n_elem = n_elem+1;
				aux = aux.getNext();
			}	

		}
		
		return n_elem;
		
	}
	
	private Node primer;
	
	// Mètodes per fer test
	public Node getPrimer() {return primer;};
}
