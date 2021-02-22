/*
Elder Guzman Carne 19628
Universidad del Valle de Guatemala
Algoritmos y Estructurade Datos
Hoja de Trabajo Numero 3

Referencias:
	https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/
	https://www.geeksforgeeks.org/merge-sort/
	https://www.geeksforgeeks.org/radix-sort/
	https://www.geeksforgeeks.org/bubble-sort/
	https://www.geeksforgeeks.org/quick-sort/
	
*/

import java.util.ArrayList; 
import java.util.Arrays;

public class Main{
	
	public static class SortM{
		
		//Metodo Gnome, es el que implementa algoritmo de ordenamiento Gnome sort
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable<T> > ArrayList<T> gnome(T[] lista_ordenar)
		{
			int i = 0;
			int size = lista_ordenar.length;
			
			while(i < size-1 ){
				if( lista_ordenar[i].compareTo(lista_ordenar[i+1]) > 0 ){
					T temp = lista_ordenar[i+1];
					lista_ordenar[i+1] = lista_ordenar[i];
					lista_ordenar[i] = temp;
					if(i>0){
						i = i-1;
					}
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
			int size = lista_x_ordenar.size();
			int i = 0;
			
			
			ArrayList<T> lista_menor = new ArrayList<T>();
			ArrayList<T> lista_mayor = new ArrayList<T>();
			
			T pivot = lista_x_ordenar.get(size - 1);
		
			while(i < size-1){
				
				if( pivot.compareTo(lista_x_ordenar.get(i)) < 0 ){
					
					lista_menor.add(lista_x_ordenar.get(i));
					
				}else{
					
					lista_mayor.add(lista_x_ordenar.get(i));
				}
				i++;
			}
		
			int len_menor = lista_menor.size();
			int len_mayor = lista_mayor.size();
			
			ArrayList<T> lista_mayor_ordenada;
			ArrayList<T> lista_menor_ordenada;
			
			if(len_menor > 0){
				lista_mayor_ordenada = quick(lista_mayor);
			}
			else{
				lista_mayor_ordenada = lista_mayor;
			}
			if(len_mayor > 1){
				lista_menor_ordenada = quick(lista_menor);
			}
			else{
				lista_menor_ordenada = lista_menor;
			}
			
			
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
		
		*/
		//Metodo Radix, es el que implementa algoritmo de ordenamiento Radix sort
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		
		static int getMax(int arr[], int n) 
		{ 
			int mx = arr[0]; 
			for (int i = 1; i < n; i++) 
				if (arr[i] > mx) 
					mx = arr[i]; 
			return mx; 
		} 

		// A function to do counting sort of arr[] according to 
		// the digit represented by exp. 
		static void countSort(int arr[], int n, int exp) 
		{ 
			int output[] = new int[n]; // output array 
			int i; 
			int count[] = new int[10]; 
			Arrays.fill(count, 0); 

			// Store count of occurrences in count[] 
			for (i = 0; i < n; i++) 
				count[(arr[i] / exp) % 10]++; 

			// Change count[i] so that count[i] now contains 
			// actual position of this digit in output[] 
			for (i = 1; i < 10; i++) 
				count[i] += count[i - 1]; 

			// Build the output array 
			for (i = n - 1; i >= 0; i--) { 
				output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
				count[(arr[i] / exp) % 10]--; 
			} 

			// Copy the output array to arr[], so that arr[] now 
			// contains sorted numbers according to curent digit 
			for (i = 0; i < n; i++) 
				arr[i] = output[i]; 
		} 

		// The main function to that sorts arr[] of size n using 
		// Radix Sort 
		static void radixsort(int arr[], int n) 
		{ 
			// Find the maximum number to know number of digits 
			int m = getMax(arr, n); 

			// Do counting sort for every digit. Note that 
			// instead of passing digit number, exp is passed. 
			// exp is 10^i where i is current digit number 
			for (int exp = 1; m / exp > 0; exp *= 10) 
				countSort(arr, n, exp); 
		}
	
		
		public static int[] radix(int[] lista_ordenar){
			
			try {
				
				int n = lista_ordenar.length;
				
				radixsort(lista_ordenar, n);
				print(lista_ordenar, n); 
				return lista_ordenar;
			}
			catch(Exception e) {
				return lista_ordenar;
			}
			
		}
		
		static void print(int arr[], int n) 
		{ 
			for (int i = 0; i < n; i++) 
				System.out.print(arr[i] + " "); 
		} 
		
		//Metodo Bubble, es el que implementa algoritmo de ordenamiento Bubble sort
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable > ArrayList<T> bubble(T[] lista_ordenar){
			int contador=1;
			
			while(contador != 0){
				contador = 0; 
				for(int i = 0; i < lista_ordenar.length-1; i = i+1){
					if(lista_ordenar[i].compareTo(lista_ordenar[i+1]) > 0){
						T temp = lista_ordenar[i];
						lista_ordenar[i] = lista_ordenar[i+1];
						lista_ordenar[i+1] = temp;
						contador = 1;
					}
				}
			}
			ArrayList<T> lista_ordenada = new ArrayList<>(Arrays.asList(lista_ordenar));
			
			return lista_ordenada;
		}
		
	}
	
	public static void main(String args[]) 
	{
		Integer[] orden = {2,4,3,1};
		int[] orden2 = {2,4,3,1,10,9,7,8,6};
		SortM.radix(orden2);
		
		
	}

}