/*
Se requiere un programa que lea y guarde países, y para evitar que se ingresen
repetidos usaremos un conjunto. El programa pedirá un país en un bucle, se
guardará el país en el conjunto y después se le preguntará al usuario si quiere
guardar otro país o si quiere salir, si decide salir, se mostrará todos los países
guardados en el conjunto.
Después deberemos mostrar el conjunto ordenado alfabéticamente para esto
recordar como se ordena un conjunto.
Y por ultimo, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator,
se buscará el país en el conjunto y si está en el conjunto se eliminará el país que
ingresó el usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto
se le informará al usuario.
 */
package ej5colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class Ej5Colecciones {

    public static void main(String[] args) {
        HashSet <String> listadoPaises = new HashSet();
       
        rellenarListaPaises(listadoPaises);
        mostrarLista(listadoPaises);
       ordenarAlf(listadoPaises);  
        System.out.println("LISTA DE PAISES ORDENADA ALFABETICAMENTE");
        mostrarLista(listadoPaises);
        eliminarPais(listadoPaises);
        System.out.println("LISTA DE PAISES CON EL PAIS ELIMINADO");
        mostrarLista(listadoPaises);
       
    }
    
    public static void rellenarListaPaises(HashSet listadoPaises){
        Scanner leer = new Scanner (System.in);
        boolean seguir = true;
         while(seguir){
            System.out.println("Ingrese un pais");
            listadoPaises.add(leer.next());
            System.out.println("¿QUIERE CONTINUAR? S/N");
            String continuar = leer.next();
            seguir= !"n".equals(continuar);
        }
    }
    
    public static void mostrarLista(HashSet<String> listadoPaises){    
        for (String var: listadoPaises)
        {
            System.out.println(var);
        }
    }
    
    public static void ordenarAlf (HashSet<String> listadoPaises){
        ArrayList<String> paisesLista = new ArrayList(listadoPaises);
        Collections.sort(paisesLista);
    }
    
    public static void eliminarPais (HashSet<String> listadoPaises){
        Scanner leer= new Scanner(System.in);
        System.out.println("Ingrese el pais que desea eliminar");
        String paisEliminar= leer.next();
        Iterator<String> it= listadoPaises.iterator();
        int cont = 0;
        while(it.hasNext()){
            if(it.next().equals(paisEliminar)){
                 it.remove();
                cont++;
            }
        }
        
        if(cont == 0){
            System.out.println("EL PAIS INGRESADO NO SE ENCUENTRA");
        }
    }
}
