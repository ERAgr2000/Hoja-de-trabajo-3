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
		
		//Metodo Merge, es el que implementa algoritmo de ordenamiento Merge sort
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable > ArrayList<T> merge(T[] lista_ordenar)
		{
			int n = lista_ordenar.length;
			
			sortMerge(lista_ordenar, 0, lista_ordenar.length - 1);
			ArrayList<T> lista_ordenada = new ArrayList<>();
			for(int i = 0; i < n; i=i+1){
				lista_ordenada.add(lista_ordenar[i]);
			}
			return lista_ordenada;
		}
		
		// Merges two subarrays of arr[].
		// First subarray is arr[l..m]
		// Second subarray is arr[m+1..r]
		static <T extends Comparable<T> > void merge(T[] arr, int l, int m, int r)
		{
			// Find sizes of two subarrays to be merged
			int n1 = m - l + 1;
			int n2 = r - m;

			/* Create temp arrays */
			ArrayList<T> L = new ArrayList<>();
			ArrayList<T> R = new ArrayList<>();

			/*Copy data to temp arrays*/
			for (int i = 0; i < n1; ++i)
				L.add(arr[l + i]);
			for (int j = 0; j < n2; ++j)
				R.add(arr[m + 1 + j]);

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0, j = 0;

			// Initial index of merged subarry array
			int k = l;
			while (i < n1 && j < n2) {
				if (L.get(i).compareTo(R.get(j)) <= 0) {
					arr[k] = L.get(i);
					i++;
				}
				else {
					arr[k] = R.get(j);
					j++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				arr[k] = L.get(i);
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				arr[k] = R.get(j);
				j++;
				k++;
			}
		}

		// Main function that sorts arr[l..r] using
		// merge()
		static < T extends Comparable<T> > void sortMerge(T[] arr, int l, int r)
		{
			if (l < r) {
				// Find the middle point
				int m =l+ (r-l)/2;

				// Sort first and second halves
				sortMerge(arr, l, m);
				sortMerge(arr, m + 1, r);

				// Merge the sorted halves
				merge(arr, l, m, r);
			}
		}

		
		//Metodo Quick, es el que implementa algoritmo de ordenamiento Quick sort. Se utilizara como pivote el ultimo elemento.
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable > ArrayList<T> quick(T[] lista_x_ordenar)
		{
			int n = lista_x_ordenar.length;
			sort(lista_x_ordenar, 0 , n-1);
			ArrayList<T> lista_ordenada = new ArrayList<>();
			for(int i = 0; i < n; i=i+1){
				lista_ordenada.add(lista_x_ordenar[i]);
			}
			return lista_ordenada;
		}
		
		static  <T extends Comparable<T> > int partition(T[] arr, int low, int high) 
		{ 
			T pivot = arr[high]; 
			int i = (low-1); // index of smaller element 
			for (int j=low; j<high; j++) 
			{ 
				// If current element is smaller than the pivot 
				if (arr[j].compareTo(pivot) < 0) 
				{ 
					i++; 

					// swap arr[i] and arr[j] 
					T temp = arr[i]; 
					arr[i] = arr[j]; 
					arr[j] = temp; 
				} 
			} 

			// swap arr[i+1] and arr[high] (or pivot) 
			T temp = arr[i+1]; 
			arr[i+1] = arr[high]; 
			arr[high] = temp; 

			return i+1; 
		} 


		/* The main function that implements QuickSort() 
		arr[] --> Array to be sorted, 
		low --> Starting index, 
		high --> Ending index */
		
		static <T extends Comparable<T> > void sort(T[] arr, int low, int high) 
		{ 
			if (low < high) 
			{ 
				
				int pi = partition(arr, low, high); 

				// Recursively sort elements before 
				// partition and after partition 
				sort(arr, low, pi-1); 
				sort(arr, pi+1, high); 
			} 
		}  

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
		Integer[] orden2 = {2,4,3,1,10,9,7,8,6,100,99,1,3};
		System.out.print(SortM.<Integer>merge(orden2));
				
	}

}