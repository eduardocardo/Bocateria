import java.util.HashMap;
import java.util.ArrayList;
/**
 * Clase que representa una bocateria
 * 
 * @author (Eduardo) 
 * @version (a version number or a date)
 */
public class Bocateria
{
    // indica la primera persona en la cola
    private Cliente primeraPersonaEnLaCola;
    //indica la facturacion total acumulada en la bocateria
    private int facturacionTotal;
    //mapa que indica los clientes despachados
    private HashMap<Integer,Cliente> clientesDespachados;
    //indica el valor del precio del bocadillo
    private static final int PRECIO_BOCADILLO = 5;

    /**
     * Constructor for objects of class Bocateria
     */
    public Bocateria()
    {
        primeraPersonaEnLaCola = null;
        facturacionTotal = 0;
        clientesDespachados = new HashMap<Integer,Cliente>();

    }

    /**
     * Metodo que crea un objeto cliente y lo pone a la cola
     * @param numeroDeBocadillos es el numero de bocadillos que va a pedir el cliente creado
     */
    public void llegaNuevoClienteALaCola(int numeroDeBocadillos)
    {

        //primero se comprueba si hay alguien en cola
        if(primeraPersonaEnLaCola == null) //no hay nadie en cola
        {
            primeraPersonaEnLaCola =  new Cliente(numeroDeBocadillos);
        }
        else //ya hay alguien en cola
        {
            Cliente ultimo = primeraPersonaEnLaCola;
            while(ultimo.siguienteEnLaCola() != null)
            {
                ultimo = ultimo.siguienteEnLaCola();
            } 
            ultimo.setSiguienteEnLaCola(new Cliente(numeroDeBocadillos));
        }
    }

    /**
     * Metodo que visualiza por pantalla los datos de los clientes que estan
     * en cola
     */
    public void visualizaDatosClientesEnCola()
    {
        Cliente siguienteCliente = primeraPersonaEnLaCola;                   
        while( siguienteCliente != null)
        {

            System.out.println(siguienteCliente.toString() + "("  
                + (siguienteCliente.getNumeroDeBocadillos()*PRECIO_BOCADILLO) 
                + " euros)");
            siguienteCliente = siguienteCliente.siguienteEnLaCola();               
        }
    }

    /**
     * Metodo que despacha al primer cliente de la cola,aumenta la facturacion de la caja
     */
    public void despacharClienteActual()
    {

        if(primeraPersonaEnLaCola == null) //si no hay clientes
        {
            facturacionTotal = 0;
        }
        else
        {
            facturacionTotal += primeraPersonaEnLaCola.getNumeroDeBocadillos()*PRECIO_BOCADILLO;
            //introducimos en el HashMap el cliente despachado
            clientesDespachados.put(primeraPersonaEnLaCola.getNumeroCliente(),primeraPersonaEnLaCola);
            //avanza la cola
            primeraPersonaEnLaCola = primeraPersonaEnLaCola.siguienteEnLaCola();
        }
    }

    /**
     * Metodo que muestra los datos de la bocateria en el momento actual
     */
    public void datosDeLaBocateriaEnLaActualidad()
    {

        System.out.println("Facturacion actual : " + facturacionTotal);
        System.out.println("Estado de la cola . ");
        Cliente siguienteCliente = primeraPersonaEnLaCola;                   
        while( siguienteCliente != null)
        {

            System.out.println(siguienteCliente.toString() + "("  
                + (siguienteCliente.getNumeroDeBocadillos()*PRECIO_BOCADILLO) 
                + " euros)");
            siguienteCliente = siguienteCliente.siguienteEnLaCola();               
        }
        System.out.println("Clientes despachados : ");
        Cliente despachado = null;
        for(int i = 1; i < clientesDespachados.size()+ 1; i++)
        {
            despachado = clientesDespachados.get(i);
            System.out.println(despachado.toString()+ "("  
                + (despachado.getNumeroDeBocadillos()*PRECIO_BOCADILLO) 
                + " euros)");
        }
    }

    /**
     * Metodo que devuelve la posicion en la cola del primer cliente que mas bocadillos ha pedido
     * @return la posicion en la cola del primer cliente que pide mas bocadillos,en caso de empate 
     * devuelve el cliente cuya posicion en la cola sea menor
     * Si no hay nadie en cola devuelve -1
     */
    public int getPosicionPrimerClienteConMasBocadillos()
    {
        Cliente cliente = primeraPersonaEnLaCola;
        int posicion = 0;
        if(primeraPersonaEnLaCola == null)
        {
            posicion = -1;
        }
        else
        {
            int mayorNumeroBocadillos = 0;     //almacena la cantidad mayor de bocadillos pedidos
            
            while(cliente != null)  //mientras existan clientes
            {
                //se comprueba el numero de bocadillos que ha pedido el cliente
                
                if(cliente.getNumeroDeBocadillos() > mayorNumeroBocadillos) //si es numero es mayor que el que esta almacenado
                {
                    //se guarda el numero de bocadillos
                    mayorNumeroBocadillos = cliente.getNumeroDeBocadillos();
                    //se guarda la posicion en la cola del cliente
                    posicion = cliente.getNumeroCliente();
                    //se guarda el siguiente cliente
                    cliente = cliente.siguienteEnLaCola();
                }
                else if(cliente.getNumeroDeBocadillos() == mayorNumeroBocadillos) //si el numero es igual
                {
                    //se comprueba la posicion del cliente en la cola
                    if(posicion > cliente.getNumeroCliente()) //si la posicion almacenada es mayor
                    {
                        posicion = cliente.getNumeroCliente(); //se guarda la nueva posicion
                        //se guarda el siguiente cliente
                        cliente = cliente.siguienteEnLaCola();
                    }
                    else 
                    {
                        posicion = posicion; //se mantiene la posicion
                        cliente = cliente.siguienteEnLaCola();
                    }
                }
                else
                {
                    //se guarda el siguiente cliente
                    cliente = cliente.siguienteEnLaCola();
                }
            }
            
        }
        return posicion;
    }
}
