package co.edu.udea.appempresariales.conversor;

public class RomanosToDecimales 
{
	public int convertir(String romano)
	{
		if(validarEntrada(romano) == -1)
		{
			return -1;			
		}	
		
		int numero = 0;
		int cant = romano.length();	
		
		if(cant == 1)
		{
			char num = romano.charAt(0);
			numero = obtenerValorLetra(num);
			return numero;
		}
			
		int num1 = 0;
		int num2 = 0;
		int valorParcial;
		char letra1;
		char letra2;
		
		for(int i = 0; i < cant; i++)
		{
			letra1 = romano.charAt(i);
			num1 = obtenerValorLetra(letra1);
			
			if(i < cant-1)
			{
				letra2 = romano.charAt(i+1);
				num2 = obtenerValorLetra(letra2);
				
				if(num2 > num1)
				{
					valorParcial = num2 -num1;
					numero = numero + valorParcial;
					i=i+1;
				}
				else
				{
					numero = numero + num1; 
				}
			}
			else
			{
				numero = numero + num1;
			}		
		}			
		
		return numero;
	}
	
	public int obtenerValorLetra(char letra)
	{
		int num;
		
		switch(letra)
		{
			case 'I': num = 1;
			break;
			
			case 'V': num = 5;
			break;
			
			case 'X': num = 10;
			break;
			
			case 'L': num = 50;
			break;
			
			case 'C': num = 100;
			break;
			
			case 'D': num = 500;
			break;
			
			case 'M': num = 1000;
			break;
			
			default: num = 0;
		}
		
		return num;		
	}
	
	//Retorno -1 si la validacion no paso
	//Retorno 1 si la validacion paso
	public int validarEntrada(String valor)
	{
		//Valido que la entrada no sea nula ni vacia 
		if(valor == null || valor.isEmpty())
		{
			return -1;
		}
		
		//Valido que la entrada no contenga espacios en blanco 
		if(valor.contains(" "))
		{
			return -1;
		}
		
		//Convierto los caracteres del string a letras mayusculas
		String var = valor.toUpperCase();
				
		//Valido que las letras del string correspondan a las letras de los numeros romanos
		if(var.matches("[I,V,X,L,C,D,M]*"))
		{
			//Valido que no haya mas de tres veces seguidas la misma letra
			int lon = valor.length();
			int veces = 1;
			char aux;
			String auxiliar;			
			
			for(int i = 0; i < lon; i++)
			{
				if(i != lon-1)
				{
					if(valor.charAt(i) == valor.charAt(i+1))
					{
						veces++;
					}
					else
					{
						veces = 1;
					}	
					
					if(veces > 3)
					{
						return -1;
					}
					
					//Se valida que no haya dos V seguidas
					if(valor.charAt(i) == 'V' && valor.charAt(i+1) == 'V')
					{
						return -1;
					}
					
					//Se valida que no haya dos L seguidas
					if(valor.charAt(i) == 'L' && valor.charAt(i+1) == 'L')
					{
						return -1;
					}	
					
					//Se valida que no haya dos D seguidas
					if(valor.charAt(i) == 'D' && valor.charAt(i+1) == 'D')
					{
						return -1;
					}
					
					aux = valor.charAt(i+1);
					auxiliar = aux + "";
					
					//Se valida que la letra I no este antes de las letras L,C,D,M 
					if(valor.charAt(i) == 'I' && auxiliar.matches("[L,C,D,M]*"))
					{
						return -1;
					}
					
					//Se valida que la letra X no este antes de las letras D y M 
					if(valor.charAt(i) == 'X' && auxiliar.matches("[D,M]*"))
					{
						return -1;
					}
				}						
			}
			
			return 1; 			
		}
		else
		{
			return -1;					
		}	
	}
}
