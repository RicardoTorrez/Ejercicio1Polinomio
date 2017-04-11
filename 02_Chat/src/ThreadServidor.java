import java.io.*;
import java.util.*;
import javax.swing.*;
import java.net.*;

class ThreadServidor extends Thread {
	private String nombreCliente; // alias para el usuario
	private static String historial = "C:" + File.separatorChar + "java3-a/historial.txt";//la ruta del archivo historial.txt
	private static List clientesActivos = new ArrayList(); // contiene objetos ThreadServidor
	private Socket socket;
	private BufferedReader entrada;
	private PrintWriter salida;
	public ThreadServidor(Socket socket) throws IOException {
		this.socket = socket;
		PrintWriter salidaArchivo = null;
		// Se crea un PrintWriter asociado al flujo de salida orientada
		// a bytes del socket. El PrintWriter convierte los caracteres
		// leídos en bytes, siguiendo el juego de caracteres por defecto
		// de la plataforma. Se establece el flush() automático.
		salida = new PrintWriter(socket.getOutputStream(), true);
		// Se crea un BufferedReader asociado al flujo de entrada
		// orientada a bytes del socket. El InputStreamReader convierte en caracteres
		// los bytes leídos del socket, siguiendo el juego de caracteres por omisión
		// de la plataforma.
		// La clase BufferedReader proporciona el método readLine().
		entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		escribirHistorial("Conexión desde la dirección");
		// Se lanza el hilo. A partir de este punto, el tratamiento de las
		// excepciones queda en mano de run().		
		start();
	}
	public void run() {
		String textoUsuario = "";
		String mensaje="";
		String destino="";
		try {
			salida.println("> Bienvenido a este chat.");
			salida.println("> Introduzca su nombre, por favor.");
			nombreCliente = (entrada.readLine()).trim();
			// Si el cliente no introduce su nombre, se le asigna "Invitado".
			// Si el nombre esta repetido, se le añade al nombre el número del puerto.
			if ( (nombreCliente.equals("")) || (nombreCliente == null) ) {
					nombreCliente = "Invitado";
			}
			Iterator it = clientesActivos.iterator();
			while (it.hasNext()) {
				if (nombreCliente.equals(( (ThreadServidor) it.next()).nombreCliente)) {
					nombreCliente = nombreCliente + socket.getPort();
					break;
				}
			}
			// Se añade la conexión a la lista de clientes activos.
			anyadirConexion(this);
			salida.println("> Se le asignado el alias de " + nombreCliente);
			salida.println("> Introduzca salir o desconectar para terminar la comunicacion.");
			salida.println("> Introduzca lista o listado para ver los clientes conectados.");
			salida.println("> Introduzca todos o broadcast + enter y escriba el mensaje + enter para mandar mensaje a todos los clientes.");
			salida.println("> Introduzca privado o unico + enter y escriba el mensaje + enter para mandar mensaje a un solo cliente.");
			// Se establece el límite de tiempo sin actividad para la desconexión.
			// Transcurridos TIEMPO_DESCONEXION_AUTOMATICA milisegundos sin
			// ninguna llamada al método readLine(), se lanzará una excepción.			
socket.setSoTimeout(Servidor.TIEMPO_DESCONEXION_AUTOMATICA);
			// Se lee la entrada y se comprueba si corresponde a las órdenes 
			while ( (textoUsuario=entrada.readLine()) != null ) {
				mensaje="";
				if ((textoUsuario.equals("salir"))|| (textoUsuario.equals("desconectar"))) {
						salida.println("> ***********HASTA LA VISTA****************");
						escribirHistorial("Desconexión voluntaria desde la dirección:");
						break;
				}
				else if ((textoUsuario.equals("lista"))||(textoUsuario.equals("listado"))) {
						escribirCliente(this,"> " + listarClientesActivos());
				}
				else if ((textoUsuario.equals("privado"))||(textoUsuario.equals("unico"))){
						escribirCliente(this,"> " + listarClientesActivos());
						salida.println("> Escribe el destinatario:");
						destino=entrada.readLine().trim();
						salida.println("> Escribe el mensaje:");
						mensaje=entrada.readLine();
						if(mensaje!=null){
							escribirPrivado(destino, nombreCliente+"> "+ mensaje);
						}
						else{
							escribirPrivado(destino, nombreCliente+"> vacio");
						}
							
				}
				else if ((textoUsuario.equals("broadcast"))||(textoUsuario.equals("todos"))){
						mensaje=entrada.readLine();
						if(mensaje!=null){
							escribirATodos(nombreCliente+"> "+ mensaje);
						}
						else{
							escribirATodos(nombreCliente+"> Hola");
						}
							
				}
				else {
					escribirATodos(nombreCliente+"> "+ textoUsuario);
				}
			} // fin del while
		} // fin del try
		catch (java.io.InterruptedIOException e1) {
			escribirCliente(this, "> "+ "***************************************");
			escribirCliente(this, "> "+ "Se pasó del tiempo límite: Conexión cerrada");
			escribirCliente(this, "> "+ "Si desea continuar, abra otra sesión");
			escribirCliente(this, "> "+ "*****************ADIOS*****************");
			escribirHistorial("Desconexión por fin de tiempo desde la dirección:");
		}
		catch (IOException e2) {
			escribirHistorial("Desconexión involuntaria desde la dirección:");
		}
		finally {
			eliminarConexion(this);
			limpiar();
		} // fin try-catch-finally
	}
	
	private void limpiar() {
	// Si se llega a usar este método es porque ha habido una excepción (ya sea por un verdadero
	// error o porque el cliente ha terminado la conexión o porque han pasado
	// TIEMPO_DESCONEXION_AUTOMATICA milisegundos sin comunicación del cliente).
	// Nótese que el código de cierre es riguroso: una versión más abreviada podría limitarse
	// a intentar cerrar el socket (los flujos de E/S se cierran al cerrarse éste); el único problema
	// que podría aparecer en esa versión del código es que podrían quedarse abiertos los flujos si
	// no se pudiera cerrar el socket (esta posibilidad es inhabitual: normalmente, si el socket no
	// se puede cerrar es porque ya se había cerrado antes).
	// El igualar entrada, salida y socket a null es una buena práctica cuando se puede llamar
	// varias veces a limpiar(); así se evita intentar cerrar dos veces un objeto.
		if ( entrada != null ) {
			try {
				entrada.close();
			}
			catch (IOException e1) {}
				entrada = null;
		}
		if ( salida != null ) {
			salida.close();
			salida = null;
		}
		if ( socket != null ) {
			try {
				socket.close();
			}
			catch (IOException e2) {}
			socket = null;
		}
	}
	/**
	* Método sincronizado.
		* Elimina la conexión representada por el argumento threadServidor de la lista de
	* clientes activos.
	* @param threadServidor hilo que se va a eliminar de la lista de clientes activos.
	*/
	private static synchronized void eliminarConexion(ThreadServidor threadServidor) {
		clientesActivos.remove(threadServidor);
	}
	/**
	* Método sincronizado.
	* Añade la conexión representada por el argumento threadServidor a la lista de
	* clientes activos.
	* @param threadServidor hilo (correspondiente a una nueva conexión) que
	* se añade a la lista de clientes activos
	*/
	private static synchronized void anyadirConexion(ThreadServidor threadServidor) {
		clientesActivos.add(threadServidor);
	}
	/**
	* Método sincronizado.
	* Escribe la cadena de texto textoUsuario en todas las conexiones de la lista de clientes
	* activos, exceptuando el cliente activo que envía el mensaje.
	* @param textoUsuario texto que se envía a los clientes.
	*/
	private synchronized void escribirATodos(String textoUsuario) {
		Iterator it = clientesActivos.iterator();
		while (it.hasNext()) {
			ThreadServidor tmp = (ThreadServidor) it.next();
			if ( !(tmp.equals(this)) )
				escribirCliente(tmp, textoUsuario);
		}
	}
	/**
	* Método sincronizado.
	* Escribe la cadena de texto textoUsuario en la conexión representada por el hilo threadServidor.
	* @param threadServidor hilo (cliente) al que se envía el mensaje.
	* @param textoUsuario texto para enviar.
	*/
	private synchronized void escribirCliente(ThreadServidor threadServidor, String textoUsuario) {
		(threadServidor.salida).println(textoUsuario);
	}
	/**
	* Método sincronizado.
	* Escribe la cadena de texto textoUsuario en la conexion destino.
	* @param textoUsuario texto que se envía a los clientes.
	*/
	private synchronized void escribirPrivado(String destino, String textoUsuario) {
		if ( (destino.equals("")) || (destino == null) ) {
					destino = "nombreCliente";
		}
		else{	
			salida.println("el destino es:"+destino);
			salida.println("el mensaje es:"+textoUsuario);		
			
			Iterator ite = clientesActivos.iterator();
			while (ite.hasNext()) {
				ThreadServidor tmp2;
				if (destino.equals((tmp2=(ThreadServidor)ite.next()).nombreCliente)) {
					//salida.println(tmp2);
					escribirCliente(tmp2, textoUsuario);
					//break;
				}
					//(threadServidor.salida).println(textoUsuario);		
			}
		}
	}
	/**
	* Método sincronizado.
	* Escribe los alias de todos los clientes activos en la conexión representada por el hilo
	* threadServidor que los solicita.
	* @return StringBuffer lista de alias de los clientes activos.
	*/
	private static synchronized StringBuffer listarClientesActivos() {
		StringBuffer cadena = new StringBuffer();
		for (int i = 0; i < clientesActivos.size(); i++) {
			ThreadServidor tmp = (ThreadServidor) (clientesActivos.get(i));
			cadena.append((((ThreadServidor) clientesActivos.get(i)).nombreCliente)).append("||") ;
		}
		return cadena;
	}
	/**
	* Método sincronizado.
	* Escribe en el archivo de historial el texto mensaje, asociado a conexiones y
	* desconexiones de los clientes.
	* @param mensaje texto que se escribe en el archivo de historial.
	*/
	private synchronized void escribirHistorial(String mensaje ) {
		PrintWriter salidaArchivo = null;
		try {
			salidaArchivo = new PrintWriter(new BufferedWriter (new FileWriter(historial, true))); // true = autoflush
salidaArchivo.println(mensaje + " " +socket.getInetAddress().getHostName() +" por el puerto " + socket.getPort() +
" en la fecha " + new Date());
		}
		catch (IOException e1) {
		System.out.println( "Fallo en el archivo de historial.");
		}
		finally {
			if (salidaArchivo != null) {
				salidaArchivo.close();
				salidaArchivo = null;
			}
		}
	}
}