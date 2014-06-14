package co.edu.udea.appempresariales.conversor;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RomanosToDecimalesTest 
{
	RomanosToDecimales instancia;
	
	@Before
	public void setUp() throws Exception
	{
		instancia = new RomanosToDecimales();		
	}

	@Test
	public void pruebaNumeroUno() 
	{
		int numero = instancia.convertir("I");
		Assert.assertEquals(1, numero);
	}
	
	@Test
	public void pruebaNumeroCinco() 
	{
		int numero = instancia.convertir("V");
		Assert.assertEquals(5, numero);
	}
	
	@Test
	public void pruebaNumeroDiez() 
	{
		int numero = instancia.convertir("X");
		Assert.assertEquals(10, numero);
	}
	
	@Test
	public void pruebaNumeroCincuenta() 
	{
		int numero = instancia.convertir("L");
		Assert.assertEquals(50, numero);
	}
	
	@Test
	public void pruebaNumeroCien() 
	{
		int numero = instancia.convertir("C");
		Assert.assertEquals(100, numero);
	}
	
	@Test
	public void pruebaNumeroQuinientos() 
	{
		int numero = instancia.convertir("D");
		Assert.assertEquals(500, numero);
	}
	
	@Test
	public void pruebaNumeroMil() 
	{
		int numero = instancia.convertir("M");
		Assert.assertEquals(1000, numero);
	}
	
	@Test
	public void pruebaNumeroVacio() 
	{
		int numero = instancia.convertir("");
		Assert.assertEquals(-1, numero);
	}
	
	@Test
	public void pruebaNumeroNulo() 
	{
		int numero = instancia.convertir(null);
		Assert.assertEquals(-1, numero);
	}
	
	@Test
	public void pruebaLetrasNoValidas() 
	{
		int numero = instancia.convertir("djueltf");
		Assert.assertEquals(-1, numero);
	}
	
	@Test
	public void pruebaCantidadLetrasIgualesSeguidas() 
	{
		int numero = instancia.convertir("LXXXXIV");
		Assert.assertEquals(-1, numero);				
	}
	
	// Con esta prueba se verifica que la expresion no contenga espacios en blanco 
	@Test
	public void pruebaEspacio() 
	{
		int numero = instancia.convertir("LXXVV VVII");
		Assert.assertEquals(-1, numero);				
	}
	
	//Con esta prueba se verifica que la expresion no contenga dos V seguidas
	@Test
	public void pruebaVseguidas() 
	{
		int numero = instancia.convertir("LXVVII");
		Assert.assertEquals(-1, numero);				
	}
	
	//Con esta prueba se verifica que la expresion no contenga dos L seguidas
	@Test
	public void pruebaLseguidas() 
	{
		int numero = instancia.convertir("CXLLVI");
		Assert.assertEquals(-1, numero);				
	}
	
	//Con esta prueba se verifica que la expresion no contenga dos D seguidas
	@Test
	public void pruebaDseguidas() 
	{
		int numero = instancia.convertir("MCDDXI");
		Assert.assertEquals(-1, numero);	
	}
	
	//Con esta prueba se verifica que la letra I no este antes de las letras L,C,D,M
	@Test
	public void pruebaIantesLetrasLCDM() 
	{
		int numero = instancia.convertir("MCDIDXI");
		Assert.assertEquals(-1, numero);	
	}
	
	//Con esta prueba se verifica que la letra X no este antes de las letras D,M
	@Test
	public void pruebaXantesLetrasDM() 
	{
		int numero = instancia.convertir("MCDXDXI");
		Assert.assertEquals(-1, numero);	
	}
	
	@Test
	public void pruebaConvertirRomano() 
	{
		int numero = instancia.convertir("MMMCMLXVII");
		Assert.assertEquals(3967,numero);		
	}
}
