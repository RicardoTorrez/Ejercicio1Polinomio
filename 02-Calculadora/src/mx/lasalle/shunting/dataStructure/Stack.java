package mx.lasalle.shunting.dataStructure;

import mx.lasalle.shunting.dataStructure.exceptions.InvalidStackSizeException;
import mx.lasalle.shunting.dataStructure.exceptions.StackOverFlowException;
import mx.lasalle.shunting.dataStructure.exceptions.StackUnderFlowException;

/**
 * @author karimnot
 */
public class Stack<T> {
    
    private Nodo<T> top;
    private Integer maxsize;
    private Integer actualsize;
    
    public Stack(Integer size) throws InvalidStackSizeException{
        if (size < 0)
            throw new InvalidStackSizeException("ERROR: Tamaño de pila no valido");
        top = null;
        maxsize = size;
        actualsize = 0;
    }
    
    public Stack() throws InvalidStackSizeException{
        this(0);
    }
    
    public boolean isEmptyStack(){
        return top == null;
    }
    
    public boolean isFullStack(){
        return maxsize == 0 ? false : maxsize.compareTo(actualsize) == 0;
    }
    
    public void push(T elemento) throws StackOverFlowException{
        if (isFullStack())
            throw new StackOverFlowException("ERROR: No es posible insertar en pila llena");
        Nodo nuevo = new Nodo<T>(elemento);
        actualsize++;
        if (!isEmptyStack())
            nuevo.setSiguiente(top);
        top = nuevo;
    }
    
    public T pop() throws StackUnderFlowException{
        if (isEmptyStack())
            throw new StackUnderFlowException("ERROR: No es posible sacar en pila vacia");
        actualsize--;
        Nodo<T> aux = top;
        top = top.getSiguiente();
        aux.setSiguiente(null);
        return aux.getDato();
    }
    
    public void recorrer(){
        Nodo aux = top;
        while (aux != null){
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }     
    
}
