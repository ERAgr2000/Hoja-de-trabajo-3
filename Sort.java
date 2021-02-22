/*
Clase con los diferentes metodos de ordenamiento
Es static para el uso de los metodos sin instancia
*/

import java.util.ArrayList; 
import java.util.Arrays;

public class Sort{
	public static class SortM{
		
		//Metodo Gnome, es el que implementa algoritmo de ordenamiento Gnome sort
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable<T> > ArrayList<T> gnome(T[] lista_ordenar)
		{
			int i = 0;
			int size = lista_ordenar.length;
			
			while(i < size ){
				if( lista_ordenar[i].compareTo(lista_ordenar[i+1]) < 0 ){
					T temp = lista_ordenar[i+1];
					lista_ordenar[i+1] = lista_ordenar[i];
					lista_ordenar[i] = temp;
					i = i-1;
				}
				else{
					i++;
				}
			}
			
			ArrayList<T> lista_ordenada = new ArrayList<>(Arrays.asList(lista_ordenar));
			
			return lista_ordenada;
		}
		/*
		//Metodo Merge, es el que implementa algoritmo de ordenamiento Merge sort
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable > ArrayList<T> merge(T[] lista_ordenar)
		{
			int i = 0;
			int size = lista_ordenar.length;
			
			
			
			return lista_ordenada;
		}
		
		//Metodo Quick, es el que implementa algoritmo de ordenamiento Quick sort. Se utilizara como pivote el ultimo elemento.
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable > ArrayList<T> quick(T[] lista_x_ordenar)
		{
			ArrayList<T> lista_ordenar = new ArrayList<>(Arrays.asList(lista_x_ordenar));
			return quick(lista_ordenar);
			
		}
		
		public static < T extends Comparable > ArrayList<T> quick(ArrayList<T> lista_x_ordenar)
		{
			int size = lista_ordenar.length;
			int i = 0;
			
			
			ArrayList<T> lista_menor = new ArrayList<T>();
			ArrayList<T> lista_mayor = new ArrayList<T>();
			T pivot = lista_ordenar[size - 1];
			while(i< size){
				
				if( pivot.compareTo(lista_ordenar[i]) < 0 ){
					
					lista_menor.add(lista_ordenar[i]);
					
				}else{
					
					lista_mayor.add(lista_ordenar[i]);
				}
			}
			
			
			ArrayList<T> lista_menor_ordenada = quick(lista);
			ArrayList<T> lista_mayor_ordenada = quick(lista_mayor_ordenar);
			
			int len_menor = lista_menor_ordenada.size();
			int len_mayor = lista_mayor_ordenada.size();
			
			ArrayList<T> lista_ordenada = new ArrayList<>();
			
			for(i = 0; i < len_menor; i = i+1){
				lista_mayor_ordenada.add(lista_menor_ordenada.get(i));
			}
			lista_ordenada.add(pivot);
			for(i = 0; i < len_mayor; i = i+1){
				lista_mayor_ordenada.add(lista_mayor_ordenada.get(i));
			}
			
			return lista_ordenada;
		}
		
		//Metodo Radix, es el que implementa algoritmo de ordenamiento Radix sort
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable > T[] radix(T[] lista_ordenar)
		{
			return lista_ordenada;
		}
		
		//Metodo Bubble, es el que implementa algoritmo de ordenamiento Bubble sort
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable > T[] bubble(T[] lista_ordenar)
		{
			return lista_ordenada;
		}
		*/
	}
}