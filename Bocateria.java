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
        //se crea primero el objeto cliente
        Cliente cliente = new Cliente(numeroDeBocadillos);
        //ahora se tiene que poner en cola
        //primero se comprueba si hay alguien en cola
        if(primeraPersonaEnLaCola == null) //no hay nadie en cola
        {
            primeraPersonaEnLaCola = cliente;
        }
        else //ya hay alguien en cola
        {
            
            if(primeraPersonaEnLaCola.siguienteEnLaCola() != null)
            {
                Cliente nuevo = primeraPersonaEnLaCola.siguienteEnLaCola();
                nuevo.setSiguienteEnLaCola(cliente);
                primeraPersonaEnLaCola.setSiguienteEnLaCola(nuevo);
            }
            else
            {
                primeraPersonaEnLaCola.setSiguienteEnLaCola(cliente);
            }

            
            
        }
    }

    /**
     * Metodo que visualiza por pantalla los datos de los clientes que estan
     * en cola
     */
    public void visualizaDatosClientesEnCola()
    {

    }
}
