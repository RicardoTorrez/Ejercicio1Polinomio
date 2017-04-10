package mx.lasalle.shunting.dataStructure;

import mx.lasalle.shunting.dataStructure.exceptions.InvalidQueueSizeException;
import mx.lasalle.shunting.dataStructure.exceptions.QueueOverFlowException;
import mx.lasalle.shunting.dataStructure.exceptions.QueueUnderFlowException;

public class Queue<T> {
    
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private Integer maxsize;
    private Integer actualsize;    
    
    public Queue(Integer size) throws InvalidQueueSizeException{
        if (size < 0)
            throw new InvalidQueueSizeException("ERROR: Tamaño de pila no valido");
        head = null;
        tail = null;
        maxsize = size;
        actualsize = 0;        
    }
    
    public Queue() throws InvalidQueueSizeException{
        this(0);
    }
    
    public boolean isEmptyQueue(){
        return head == null;
    }
    
    public boolean isFullQueue(){
        return maxsize == 0 ? false : maxsize.compareTo(actualsize) == 0;
    }    
    
    public void enqueue(T elemento) throws QueueOverFlowException{
        if (isFullQueue())
            throw new QueueOverFlowException("ERROR: No es posible encolar en cola llena");
        NodoDoble<T> nuevo = new NodoDoble(elemento);
        actualsize++;
        if(isEmptyQueue()){
            head = nuevo;
            tail = nuevo;
        }else{
            nuevo.setSiguiente(tail);
            tail.setAnterior(nuevo);
            tail = nuevo;
        }
    }
     
    public T dequeue() throws QueueUnderFlowException{
        if (isEmptyQueue())
            throw new QueueUnderFlowException("ERROR: No es posible descolar en cola vacia");
        NodoDoble<T> aux = head;
        actualsize--;
        if (head == tail){
            head = null;
            tail = null;
        }else{
            head = head.getAnterior();
            head.setSiguiente(null);
            aux.setAnterior(null);
        }
        return aux.getDato();
    }   
    
    public void recorrer(){
        NodoDoble aux = tail;
        aux = head;
        while (aux != null){
            System.out.print(aux.getDato());
            aux = aux.getAnterior();
        }    
        System.out.println("");
    }    
    
}
