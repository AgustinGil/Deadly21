/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadly21;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Agustín
 */
public class ListaParticipantes {
    
    Participante primero;
    int largo;
    
    ListaParticipantes(){
        primero = null;
        largo=0;
    }
    
    //Metodo para verificar si la lista esta vacia
    public boolean estaVacia(){
        if (primero==null){
            return true;
        }else{
            return false;
        }
    }

    //Ingresa un valor al inicio de la lista
    public void ingresarAlPrincipio (String nombre, String actitud){
        Participante nuevo = new Participante();  
        nuevo.establecerNombre(nombre);   
        nuevo.establecerActitud(actitud);

        if (estaVacia()){
            primero = nuevo;
        }else{
            nuevo.establecerSiguiente(primero);
            primero=nuevo;
        }
        
        largo++;
    }
    
    //Ingresa un valor al final de la lista
    
    public void ingresarAlFinal (String nombre, String actitud){
        Participante aux = primero;
        
        Participante nuevo = new Participante();  
        nuevo.establecerNombre(nombre);   
        nuevo.establecerActitud(actitud);

        if (estaVacia()){
            primero = nuevo;
        }else{
            while (aux.obtenerSiguiente()!=null){
                aux = aux.obtenerSiguiente();
            }
            aux.establecerSiguiente(nuevo);
        }
        
        largo++;
    }
    
    
    public Participante obtenerParticipante(int indice){
        Participante aux = primero;
        
        for (int i=0; i<indice;i++){
            aux = aux.obtenerSiguiente();
        }
        return aux;
    }
    //Metodo que devuelve el numero que almacena un nodo dado su indice
    public String obtenerNombreParticipante(int indice){
        Participante aux = primero;
        
        for (int i=0; i<indice;i++){
            aux = aux.obtenerSiguiente();
        }
        return aux.obtenerNombre();
    }
    
    public Participante obtenerParejaParticipante(int indice){
        Participante aux = primero;
        
        for (int i=0; i<indice;i++){
            aux = aux.obtenerSiguiente();
        }
        return aux.obtenerPareja();
    }
    
    public String obtenerActitudParticipante(int indice){
        Participante aux = primero;
        
        for (int i=0; i<indice;i++){
            aux = aux.obtenerSiguiente();
        }
        return aux.obtenerActitud();
    }
    

    //Metodo que permite insertar un nodo dado un indice
    public void insertarEnIndice(int indice,String nom, String act){
        if (indice == 0 ) {
            ingresarAlPrincipio(nom,act);
        }else if (indice==largo){
            ingresarAlFinal(nom,act);
        }else{
            Participante aux = primero;
            
            for (int i=0; i< indice-1;i++){
                aux = aux.obtenerSiguiente();
            }
            
            Participante sigCreado = aux.obtenerSiguiente();
            Participante nuevo = new Participante();
            nuevo.establecerNombre(nom);
            nuevo.establecerActitud(act);
            aux.establecerSiguiente(nuevo);
            nuevo.establecerSiguiente(sigCreado);
            }
        largo++;
    }
    
    //Metodo para eliminar un nodo
    public void eliminar(int indice){
        if (indice ==0 ) {
            primero = primero.obtenerSiguiente();
        }else {
            Participante aux = primero;
            
            for (int i=0; i< indice-1;i++){
                aux = aux.obtenerSiguiente();
            }
        
            Participante sigEliminado = aux.obtenerSiguiente();
            aux.establecerSiguiente(sigEliminado.obtenerSiguiente());
        }
        largo--;
    }
     public boolean buscar(String referencia){
        // Crea una copia de la lista.
        Participante aux = primero;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while(aux != null && encontrado != true){
            // Consulta si el valor del nodo es igual al de referencia.
            if (referencia == aux.obtenerNombre()){
                // Canbia el valor de la bandera.
                encontrado = true;
            }
            else{
                // Avansa al siguiente. nodo.
                aux = aux.obtenerSiguiente();
            }
        }
        // Retorna el resultado de la bandera.
        return encontrado;
    }
     
    public void eliminarPorReferencia(String referencia){
        // Consulta si el valor de referencia existe en la lista.
        if (buscar(referencia)) {
            // Consulta si el nodo a eliminar es el pirmero
            if (primero.obtenerNombre() == referencia) {
                // El primer nodo apunta al siguiente.
                primero = primero.obtenerSiguiente();
            } else{
                // Crea ua copia de la lista.
                 Participante aux = primero;
                // Recorre la lista hasta llegar al nodo anterior 
                // al de referencia.
                while(aux.obtenerSiguiente().obtenerNombre() != referencia){
                    aux = aux.obtenerSiguiente();
                }
                // Guarda el nodo siguiente del nodo a eliminar.
                Participante siguiente = aux.obtenerSiguiente().obtenerSiguiente();
                // Enlaza el nodo anterior al de eliminar con el 
                // sguiente despues de el.
                aux.establecerSiguiente(siguiente);  
            }
            // Disminuye el contador de tamaño de la lista.
            largo--;
        }
    }
    
    public void partidaSimulada(int i){
        int eliminacion = (int) Math.round(Math.random());
        
        if (eliminacion==1){
            eliminar(i); 
        }else{
            eliminar(i+1);
        }
    }
    
    
    public int total(){
        return largo;
    }
    
    public Participante competidor(int indice){
         Participante aux = primero;
         for (int i=0; i< indice;i++){
                aux = aux.obtenerSiguiente();
            }
         return aux;
    }
    
    public void emparejar(){
        Participante aux = primero;
        Participante aux2 = null;
        while (aux.obtenerSiguiente()!=null){
            aux2=aux;
            aux = aux.obtenerSiguiente();
            aux.establecerPareja(aux2);
            aux2.establecerPareja(aux);
            
            if (aux.obtenerSiguiente()!=null){
                aux = aux.obtenerSiguiente();
            }
        }
    }
    public void eliminarLista(){
        primero.establecerSiguiente(null);
        largo = 0;
    }
}
