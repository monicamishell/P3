public class Persona
{
	String nombre;
	String apellidoPaterno;
	String apellidoMaterno;
	String fechaNacimiento;

	public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento)
	{
		this.nombre= nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.fechaNacimiento = fechaNacimiento;

	}


	String primerNombre;
	int claveRFC;
	int j;
	String segundoNombre, nombreCompleto;
	String rfc, validarRFC, nombreEnRfc, nombreOficial;
	String [] nombreComun={"MARIA","JOSE"};
	String [] antiSonantes={"BUEI","CACA","CAGA","CAKA","COGE","COJE","COJO","FETO","JOTO","KACO","KAGO","KOJO","KULO","MAMO","MEAS","MION","MULA","PEDO","PUTA","QULO","RUIN","BUEY","CACO","CAGO","CAKO","COJA","COJI","CULO","GUEY","KACA","KAGA","KOGE","KAKA","MAME","MEAR","MEON","MOCO","PEDA","PENE","PUTO","RATA"};
	boolean validarComun;
	boolean validarAntisonante;
	int[] arrayAux= new int [50];
	int clave;
	int sumaArray=0;
	char[] arrayNombreCompleto;



	public String calculaRFC(String nombre, String apellidoPaterno, String apellidoMaterno,String fechaNacimiento)
	{
		apellidoPaterno = apellidoPaterno.toUpperCase();
		apellidoMaterno = apellidoMaterno.toUpperCase();

		if(nombre.contains(" "))
		{
			nombreEnRfc=separarNombres(nombre, primerNombre, segundoNombre, nombreEnRfc);
		}

		else nombreEnRfc=nombre.toUpperCase();

		apellidoPaterno=validarApellidoPat(apellidoPaterno);

		nombreCompleto=apellidoPaterno;
		nombreCompleto=nombreCompleto.concat(" ");
		nombreCompleto=nombreCompleto.concat(apellidoMaterno);
		nombreCompleto=nombreCompleto.concat(" ");
		nombreCompleto=nombreCompleto.concat(nombreEnRfc);

		char[] arrayNombreCompleto= nombreCompleto.toCharArray();
		for(int i=0; i<arrayNombreCompleto.length; i++)
		{
			System.out.println(" "+arrayNombreCompleto[i]);	
		}
		System.out.println(nombreCompleto); //Si funciona

		claveRFC=claveDiferenciadora(arrayNombreCompleto);//clave
		System.out.println(claveRFC);

		rfc = apellidoPaterno.substring(0,2);
		rfc =rfc.concat(apellidoMaterno.substring(0,1));
		rfc =rfc.concat(nombreEnRfc.substring(0,1));

		rfc=validarAnti(rfc);

		rfc =rfc.concat(fechaNacimiento.substring(2,4));
		rfc=rfc.concat(fechaNacimiento.substring(5,7));
		rfc=rfc.concat(fechaNacimiento.substring(8,10));

		rfc=rfc.concat(fechaNacimiento.substring(8,9));//HOMOCLAVE NO OFICIAL
		rfc =rfc.concat("H");
		rfc =rfc.concat(nombreEnRfc.substring(1,2));
		return rfc;
	}

	public String separarNombres(String nombre,String primerNombre, String segundoNombre, String nombreEnRfc)
	{
			String nombreSeparado [] = nombre.split(" ");
			primerNombre = nombreSeparado[0];
			segundoNombre = nombreSeparado[1];
			primerNombre = primerNombre.toUpperCase();
			segundoNombre = segundoNombre.toUpperCase();
			nombreEnRfc = validaNombreComun(primerNombre,segundoNombre);

			return nombreEnRfc;
	}

	public String validaNombreComun(String primerNombre, String segundoNombre)
	{
		for(int i=0; i<2; i++)
		{
			validarComun=primerNombre.contains(nombreComun[i]);
			if(validarComun)
			{
				nombreOficial= segundoNombre;
				break;
			}
			else nombreOficial= primerNombre;
		}

	return nombreOficial;
	}

	public String validarApellidoPat(String apellidoPaterno)
	{
		if(apellidoPaterno.contains(" "))
		{
			String auxApellido[] = apellidoPaterno.split( " ");
			apellidoPaterno= auxApellido[auxApellido.length-1];
		}
		return apellidoPaterno;
	}

	public String validarAnti(String rfc)
	{
		for(int i=0; i<41; i++)
			{
				validarAntisonante=rfc.contains(antiSonantes[i]);
				if(validarAntisonante)
				{
					rfc=rfc.substring(0,3);
					rfc=rfc.concat("X");
					break;
				}
			}
				return rfc;
	}

//////////////////////////////////////////
public int claveDiferenciadora(char[] arrayNombreCompleto)
{
	for(int i=0, j=0; i<arrayNombreCompleto.length; i++, j++)
	{
		switch(arrayNombreCompleto[i])
		{
				case ' ': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=0;
						  break;

				case '0': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=0;
						  break;

				case '1': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=1;
						  break;

				case '2': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=2;
						  break;

				case '3': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=3;
						  break;

				case '4': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=4;
						  break;

				case '5': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=5;
						  break;

				case '6': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=6;
						  break;

				case '7': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=7;
						  break;

				case '8': arrayAux[i+j]= 0;
					      arrayAux[i+j+1]=8;
						  break;

				case '9': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=9;
						  break;

				case '&': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=0;
						  break;

				case 'A': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=1;
						  break;

				case 'B': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=2;
						  break;

				case 'C': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=3;
						  break;

				case 'D': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=4;
						  break;

				case 'E': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=5;
						  break;

				case 'F': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=6;
						  break;

				case 'G': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=7;
						  break;

				case 'H': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=8;
						  break;

				case 'I': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=9;
						  break;

				case 'J': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=1;
						  break;

				case 'K': arrayAux[i+j]= 2;
					      arrayAux[i+j+1]=2;
						  break;

				case 'L': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=3;
						  break;

				case 'M': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=4;
						  break;

				case 'N': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=5;
						  break;

				case 'O': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=6;
						  break;

				case 'P': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=7;
						  break;

				case 'Q': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=8;
						  break;

				case 'R': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=9;
						  break;

				case 'S': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=2;
						  break;

				case 'T': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=3;
						  break;

				case 'U': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=4;
						  break;

				case 'V': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=5;
						  break;

				case 'W': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=6;
						  break;

				case 'X': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=7;
						  break;

				case 'Y': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=8;
						  break;

				case 'Z': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=9;
						  break;

		}	
	}
	clave=arrayAux[0]*arrayAux[0];
	System.out.println("\n" +clave);
	for(int i=0; i<(arrayNombreCompleto.length)*2; i++)
		{
			sumaArray+=clave;
			clave=(((arrayAux[i])*10)+arrayAux[i+1])*arrayAux[i+1];
		}
System.out.println("\n " +sumaArray%1000 +"\n" +sumaArray%35);
return  sumaArray;
}

/*public char valorDeClaveDiferenciadora()
{
	for(int i=0, j=0; i<arrayNombreCompleto.length; i++, j++)
	{
		switch(arrayNombreCompleto[i])
		{
				case ' ': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=0;
						  break;

				case '0': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=0;
						  break;

				case '1': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=1;
						  break;

				case '2': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=2;
						  break;

				case '3': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=3;
						  break;

				case '4': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=4;
						  break;

				case '5': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=5;
						  break;

				case '6': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=6;
						  break;

				case '7': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=7;
						  break;

				case '8': arrayAux[i+j]= 0;
					      arrayAux[i+j+1]=8;
						  break;

				case '9': arrayAux[i+j]= 0;
						  arrayAux[i+j+1]=9;
						  break;

				case '&': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=0;
						  break;

				case 'A': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=1;
						  break;

				case 'B': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=2;
						  break;

				case 'C': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=3;
						  break;

				case 'D': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=4;
						  break;

				case 'E': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=5;
						  break;

				case 'F': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=6;
						  break;

				case 'G': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=7;
						  break;

				case 'H': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=8;
						  break;

				case 'I': arrayAux[i+j]= 1;
						  arrayAux[i+j+1]=9;
						  break;

				case 'J': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=1;
						  break;

				case 'K': arrayAux[i+j]= 2;
					      arrayAux[i+j+1]=2;
						  break;

				case 'L': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=3;
						  break;

				case 'M': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=4;
						  break;

				case 'N': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=5;
						  break;

				case 'O': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=6;
						  break;

				case 'P': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=7;
						  break;

				case 'Q': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=8;
						  break;

				case 'R': arrayAux[i+j]= 2;
						  arrayAux[i+j+1]=9;
						  break;

				case 'S': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=2;
						  break;

				case 'T': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=3;
						  break;

				case 'U': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=4;
						  break;

				case 'V': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=5;
						  break;

				case 'W': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=6;
						  break;

				case 'X': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=7;
						  break;

				case 'Y': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=8;
						  break;

				case 'Z': arrayAux[i+j]= 3;
						  arrayAux[i+j+1]=9;
						  break;

		}	
	}
	clave=arrayAux[0]*arrayAux[0];
	System.out.println("\n" +clave);
	for(int i=0; i<(arrayNombreCompleto.length)*2; i++)
		{
			sumaArray+=clave;
			clave=(((arrayAux[i])*10)+arrayAux[i+1])*arrayAux[i+1];
		}
System.out.println("\n " +sumaArray%1000 +"\n" +sumaArray%35);
return  sumaArray;
}*/
/////////////////////////////////////////////////////

}//End class






