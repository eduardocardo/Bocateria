
/**
 * Es una clase que representa un cliente que solicita bocadillos en una bocateria
 * 
 * @author (Eduardo) 
 * @version (0.1)
 */
public class Cliente
{
    //indica el numero de cliente que ha entrado en la bocateria
    private int numeroCliente;
    //indica que cliente es el siguiente en la cola
    private Cliente siguienteEnLaCola;
    //indica el numero de bocadillos que pide el cliente
    private int numeroDeBocadillos;
    //variable de clase que indica el numero de cliente que tiene el cliente
    //en funcion de los otros cliente
    private static int numeroClienteActual = 0;
    /**
     * Constructor de la clase cliente
     * @param numDeBocadillos es el numero de bocadillos que pide el cliente
     */
    public Cliente(int numDeBocadillos)
    {
       this.numeroDeBocadillos = numDeBocadillos;
       
       if(numeroClienteActual == 0) //si no hay ningun cliente
       {
           numeroCliente = 1;
           numeroClienteActual++;
       }
       else
       {
           numeroClienteActual++;
           numeroCliente = numeroClienteActual;
           
       }
       
       siguienteEnLaCola = null;
    }
    
    /**
     * Metodo que indica quien es el siguiente en la cola
     * @return indica que cliente es el siguiente en la cola
     */
    public Cliente siguienteEnLaCola()
    {
            return siguienteEnLaCola;
    }
    
    /**
     * Metodo que devuelve el numero de bocadillos que el cliente ha pedido
     * @return el numero de bocadillos pedidos por el cliente
     */
    public int getNumeroDeBocadillos()
    {
        return numeroDeBocadillos;
    }
    
    /**
     * Metodo que devuelve el numero de cliente
     * @return numero de cliente
     */
    public int getNumeroCliente()
    {
        return numeroCliente;
    }
    
    /**
     *Metodo que muestra los datos del cliente 
     */
    public String toString()
    {
        String datos = " ";
        datos ="El cliente numero " + numeroCliente + " ha solicitado " + numeroDeBocadillos 
               + " bocadillos";
        return datos;       
    }
    
    /**
     * Metodo que modifica el cliente que se encuentra siguiente en la cola
     * @param cliente es el objeto cliente
     */
    public void setSiguienteEnLaCola(Cliente cliente)
    {
        siguienteEnLaCola = cliente;
    }
}
