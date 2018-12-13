import java.util.*;

public class Main
{
	public static void main(String args[])
	{
		Scanner scanner= new Scanner(System.in);
		
		String nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento;
		System.out.println("Nombre(s): ");
		nombre = scanner.nextLine();
		System.out.println("\nApellido paterno: ");
		apellidoPaterno = scanner.nextLine();
		System.out.println("\nApellido materno (Si no cuenta con apellido materno ingrese: X): ");
		apellidoMaterno = scanner.nextLine();
		System.out.println("\nFecha de nacimiento (Ej. A\u00f1o/mes/d\u00eda = [0000/00/00]): ");
		fechaNacimiento = scanner.nextLine();

		Persona persona1 = new Persona(nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento);

		String rfc=persona1.calculaRFC(persona1.nombre, persona1.apellidoPaterno, persona1.apellidoMaterno,persona1.fechaNacimiento);
		System.out.println("\n\n                      ==== Su RFC es: " +rfc +" ====");
	}
}