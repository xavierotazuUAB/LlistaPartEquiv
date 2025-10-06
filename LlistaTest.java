import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlistaTest {
	
	Llista llistabuida;

	Llista creaLlistaNElements(int n_elem)
	{
		Llista llista_tmp = new Llista();
		
		for(int i=0;i<n_elem;++i)
			llista_tmp.afegirUltim(i);
		
		return llista_tmp;
	}


	@BeforeEach
	void setUp() throws Exception
	{
		llistabuida = new Llista();		
	}
	
	@Test
	void testLlista()
	{
		assertEquals(llistabuida.getPrimer(),null);	// decidim que primer ha de ser null
	}

	@Test
	void testAfegirUltim()
	{
		assertTrue(llistabuida.afegirUltim(10));
		assertEquals(llistabuida.getValor(0),10);

		assertTrue(llistabuida.afegirUltim(11));
		assertTrue(llistabuida.afegirUltim(12));
		assertEquals(llistabuida.getValor(1),11);
		assertEquals(llistabuida.getValor(2),12);	
	}

	@Test
	void testInsertarValor()
	{
		
		// Creem la llista
		Llista llista = creaLlistaNElements(4);
		
		// Insertem el valor
		llista.insertarValor(2, 10);

		// Comprovem que la llista és correcta 
		assertEquals(llista.getValor(0),0);
		assertEquals(llista.getValor(1),1);	
		assertEquals(llista.getValor(2),10);	
		assertEquals(llista.getValor(3),2);	
		assertEquals(llista.getValor(4),3);	

		// Particions equivalents del paràmetre posicio aplicades en una llsita buida
		
		Llista llistabuida = new Llista(); // Creem llista buida
		
		assertFalse(llistabuida.insertarValor(-10, 0));	// Insertem a la posició -10
		assertFalse(llistabuida.insertarValor(-1, 0));	// Insertem a la posició -1
		assertFalse(llistabuida.insertarValor(1, 0));	// Insertem a la posició 1
		assertFalse(llistabuida.insertarValor(10, 0));	// Insertem a la posició 1

		assertTrue(llistabuida.insertarValor(0, 0));	// Insertem la posicio 0. Hem d'acceptar-ho.
		assertEquals(llistabuida.getValor(0),0);

			// Particions equivalents del paràmetre posicio aplicades en una llista d'un element

		Llista llistaun = creaLlistaNElements(1); 
		
		// Posicions incorrectes
		assertFalse(llistaun.insertarValor(-10, 0));	// Insertem a la posició -10
		assertFalse(llistaun.insertarValor(-1, 0));		// Insertem a la posició -1
		assertFalse(llistaun.insertarValor(10, 0));		// Insertem a la posició 10
		
		// Posicions correctes		
		assertTrue(llistaun.insertarValor(0, 10));		// Insertem a la posició 0 (la primera).
		assertEquals(llistaun.getValor(0),10);
		assertEquals(llistaun.getValor(1),0);

		Llista llistaun2 = creaLlistaNElements(1); 

		assertTrue(llistaun2.insertarValor(1, 1));		// Insertem a la posició 1 (la ultima)
		assertEquals(llistaun2.getValor(0),0);
		assertEquals(llistaun2.getValor(1),1);
		
	}

	@Test
	void testEliminaValor()
	{
		Llista llista;
		
			// Llista buida
		
		assertFalse(llistabuida.eliminaValor(0));	// No és possible

			// Llista un element
		
		llista = creaLlistaNElements(1);

		// Valors incorrectes
		assertFalse(llista.eliminaValor(-10));
		assertFalse(llista.eliminaValor(-1));
		assertFalse(llista.eliminaValor(1));
		assertFalse(llista.eliminaValor(10));
		// Valor correcte
		assertFalse(llista.eliminaValor(0));
		assertTrue(llista.esBuida());

			// Llista de 4 elements
		llista = creaLlistaNElements(4);
		
		// Insertem el valor al mig de la llista
		llista.eliminaValor(2);

		// Comprovem que la llista és correcta 
		assertEquals(llista.getValor(0),0);
		assertEquals(llista.getValor(1),1);	
		assertEquals(llista.getValor(2),3);	
	}

	@Test
	void testEsBuida()
	{
		assertTrue(llistabuida.esBuida());
	}

	@Test
	void testGetNElements()
	{
		assertEquals(llistabuida.getNElements(),0);	// Llista buida

		assertTrue(llistabuida.afegirUltim(10));	
		assertEquals(llistabuida.getNElements(),1);	// Llista amb un element

		assertTrue(llistabuida.afegirUltim(11));
		assertTrue(llistabuida.afegirUltim(12));
		assertEquals(llistabuida.getNElements(),3);	// Llista amb 3 elements
	}

}
