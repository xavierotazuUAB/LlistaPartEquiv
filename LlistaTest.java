import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlistaTest {
	
	Llista llista;

	Llista creaLlistaUnElement()
	{
		Llista llista_tmp = new Llista();
		llista_tmp.afegirUltim(0);
		
		return llista_tmp;
	}


	@BeforeEach
	void setUp() throws Exception
	{
		llista = new Llista();		
	}
	
	@Test
	void testLlista()
	{
		assertEquals(llista.getPrimer(),null);	// decidim que primer ha de ser null
	}

	@Test
	void testAfegirUltim()
	{
		assertTrue(llista.afegirUltim(10));
		assertEquals(llista.getValor(0),10);

		assertTrue(llista.afegirUltim(11));
		assertTrue(llista.afegirUltim(12));
		assertEquals(llista.getValor(1),11);
		assertEquals(llista.getValor(2),12);	
	}

	@Test
	void testInsertarValor()
	{
//		assertFalse(llista.insertarValor(0, 0));	// Llista buida
		
		// Creem la llista
		assertTrue(llista.afegirUltim(0));
		assertTrue(llista.afegirUltim(1));
		assertTrue(llista.afegirUltim(2));
		assertTrue(llista.afegirUltim(3));
		
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

		Llista llistaun = creaLlistaUnElement(); 
		
		// Posicions incorrectes
		assertFalse(llistaun.insertarValor(-10, 0));	// Insertem a la posició -10
		assertFalse(llistaun.insertarValor(-1, 0));		// Insertem a la posició -1
		assertFalse(llistaun.insertarValor(10, 0));		// Insertem a la posició 10
		
		// Posicions correctes		
		assertTrue(llistaun.insertarValor(0, 10));		// Insertem a la posició 0 (la primera).
		assertEquals(llistaun.getValor(0),10);
		assertEquals(llistaun.getValor(1),0);

		Llista llistaun2 = creaLlistaUnElement(); 

		assertTrue(llistaun2.insertarValor(1, 1));		// Insertem a la posició 1 (la ultima)
		assertEquals(llistaun2.getValor(0),0);
		assertEquals(llistaun2.getValor(1),1);
		
	}

	@Test
	void testEliminaValor()
	{
		assertFalse(llista.eliminaValor(0)); // llista buida
		
		// Creem la llista
		assertTrue(llista.afegirUltim(0));
		assertTrue(llista.afegirUltim(1));
		assertTrue(llista.afegirUltim(2));
		assertTrue(llista.afegirUltim(3));
		
		// Insertem el valor
		llista.eliminaValor(2);

		// Comprovem que la llista és correcta 
		assertEquals(llista.getValor(0),0);
		assertEquals(llista.getValor(1),1);	
		assertEquals(llista.getValor(2),3);	
	}

	@Test
	void testEsBuida()
	{
		assertTrue(llista.esBuida());
	}

	@Test
	void testGetNElements()
	{
		assertEquals(llista.getNElements(),0);	// Llista buida

		assertTrue(llista.afegirUltim(10));	
		assertEquals(llista.getNElements(),1);	// Llista amb un element

		assertTrue(llista.afegirUltim(11));
		assertTrue(llista.afegirUltim(12));
		assertEquals(llista.getNElements(),3);	// Llista amb 3 elements
	}

}
