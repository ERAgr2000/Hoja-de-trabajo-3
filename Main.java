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
import java.io.*; 
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.File; 

public class Main{
	
	public static class SortM{
		
		//Metodo Gnome, es el que implementa algoritmo de ordenamiento Gnome sort
		//Parametro: lista_ordenar es una estructura de datos con implementacion de objetos con interfaz Comparable, es la lista que se ordenara
		//Return: lista_ordenada es una lista 
		public static < T extends Comparable<T> > ArrayList<T> gnome(T[] lista_ordenar)
		{
			int i = 0;
			int size = lista_ordenar.length;
			
			//De esta forma se compara los objetos T para su ordenamiento y se repite la secuencia hasta llegar al ultimo dato. 
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
			//Convercion de T[] haci una ArrayList.
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
		
		// Junto dos subarrays de arr[].
		// Priemr subarray es arr[l..m]
		// segundo subarray es arr[m+1..r]
		static <T extends Comparable<T> > void merge(T[] arr, int l, int m, int r)
		{
			//Buscar el tamano de dos subarrays para su posterior mezcla
			int n1 = m - l + 1;
			int n2 = r - m;

			/* Crear arrays temporales */
			ArrayList<T> L = new ArrayList<>();
			ArrayList<T> R = new ArrayList<>();

			/*Copiar datos del array*/
			for (int i = 0; i < n1; ++i)
				L.add(arr[l + i]);
			for (int j = 0; j < n2; ++j)
				R.add(arr[m + 1 + j]);

			/* juntar los arrays temp */

			// Indices iniciales 
			int i = 0, j = 0;

			//Indice inicial para la mezcla
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

			/* COpiar los elementos restantes*/
			while (i < n1) {
				arr[k] = L.get(i);
				i++;
				k++;
			}

			
			while (j < n2) {
				arr[k] = R.get(j);
				j++;
				k++;
			}
		}

		//funcion principal arr[l..r]
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
			int i = (low-1); // indice del elemento principal 
			for (int j=low; j<high; j++) 
			{ 
				// si es menor que el pivot 
				if (arr[j].compareTo(pivot) < 0) 
				{ 
					i++; 

					// cmabiamos 
					T temp = arr[i]; 
					arr[i] = arr[j]; 
					arr[j] = temp; 
				} 
			} 

			// cambiar arr[i+1] y arr[high] (o pivot) 
			T temp = arr[i+1]; 
			arr[i+1] = arr[high]; 
			arr[high] = temp; 

			return i+1; 
		} 


		/* funcion principal para el quick sort 
		 */
		static <T extends Comparable<T> > void sort(T[] arr, int low, int high) 
		{ 
			if (low < high) 
			{ 
				
				int pi = partition(arr, low, high); 

				// ordenamiento recursuvo previo a la 
				//particion y despues de la misma
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

		// una funcion para el ordenamiento 
		static void countSort(int arr[], int n, int exp) 
		{ 
			int output[] = new int[n]; // output array 
			int i; 
			int count[] = new int[10]; 
			Arrays.fill(count, 0); 

			// guarda las ocurrencias  
			for (i = 0; i < n; i++) 
				count[(arr[i] / exp) % 10]++; 

			
			for (i = 1; i < 10; i++) 
				count[i] += count[i - 1]; 

			// construye el array de devolucion
			for (i = n - 1; i >= 0; i--) { 
				output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
				count[(arr[i] / exp) % 10]--; 
			} 

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
		
	
	
		public static String readFileAsString(String fileName)throws Exception 
		{ 
			String data = ""; 
			data = new String(Files.readAllBytes(Paths.get(fileName))); 
			return data; 
		}

		//Para contar el tiempo de ordenar
		public static < T extends Comparable<T> > long[] time_sorts_quick(T[] lista_ordenar){
			long startTimeUn = System.nanoTime();
			quick(lista_ordenar);
			long elapsedTimeUn = System.nanoTime() - startTimeUn;
			
			long startTime = System.nanoTime();
			quick(lista_ordenar);
			long elapsedTime = System.nanoTime() - startTime;
			
			long[] tiempo = {elapsedTimeUn, elapsedTime};
			return tiempo;
		}
		
		public static < T extends Comparable<T> > long[] time_sorts_merge(T[] lista_ordenar){
			long startTimeUn = System.nanoTime();
			merge(lista_ordenar);
			long elapsedTimeUn = System.nanoTime() - startTimeUn;
			
			long startTime = System.nanoTime();
			merge(lista_ordenar);
			long elapsedTime = System.nanoTime() - startTime;
			
			long[] tiempo = {elapsedTimeUn, elapsedTime};
			return tiempo;
		}
		
		public static < T extends Comparable<T> > long[] time_sorts_bubble(T[] lista_ordenar){
			long startTimeUn = System.nanoTime();
			bubble(lista_ordenar);
			long elapsedTimeUn = System.nanoTime() - startTimeUn;
			
			long startTime = System.nanoTime();
			bubble(lista_ordenar);
			long elapsedTime = System.nanoTime() - startTime;
			
			long[] tiempo = {elapsedTimeUn, elapsedTime};
			return tiempo;
		}
		
		public static < T extends Comparable<T> > long[] time_sorts_gnome(T[] lista_ordenar){
			long startTimeUn = System.nanoTime();
			gnome(lista_ordenar);
			long elapsedTimeUn = System.nanoTime() - startTimeUn;
			
			long startTime = System.nanoTime();
			gnome(lista_ordenar);
			long elapsedTime = System.nanoTime() - startTime;
			
			long[] tiempo = {elapsedTimeUn, elapsedTime};
			return tiempo;
		}
		
		public static long[] time_sorts_radix(int[] lista_ordenar){
			long startTimeUn = System.nanoTime();
			radix(lista_ordenar);
			long elapsedTimeUn = System.nanoTime() - startTimeUn;
			
			long startTime = System.nanoTime();
			radix(lista_ordenar);
			long elapsedTime = System.nanoTime() - startTime;
			
			long[] tiempo = {elapsedTimeUn, elapsedTime};
			return tiempo;
		}
		
		
	}

	public static void main(String args[]) throws IOException
	{
		
		//Integer[] orden = {2,4,3,1};
		//Integer[] orden2 = {2,4,3,1,10,9,7,8,6,100,99,1,3};
		//System.out.print(SortM.<Integer>merge(orden2));
		try{
			
			String data = SortM.readFileAsString("myfile.txt");	
			
			String[] numbers_list_str = data.split(",");
			
			int size = numbers_list_str.length;
			
			String times = "";
			for(int j=10; j<3001; j++){
				
				Integer[] numbers_list = new Integer[j];
				
				for(int i=0; i<j; i++) {
					numbers_list[i] = Integer.parseInt(numbers_list_str[i]);
					
				}
				
				long[] a = SortM.<Integer>time_sorts_quick(numbers_list);
				times = times + a[0] + "," + a[1] + "\n";
			}
			
			FileWriter myWriter = new FileWriter("quick.csv");
			myWriter.write(times);
			myWriter.close();
			times = "";
			
			for(int j=10; j<3001; j++){
				
				Integer[] numbers_list = new Integer[j];
				
				for(int i=0; i<j; i++) {
					numbers_list[i] = Integer.parseInt(numbers_list_str[i]);
				}
				
				long[] a = SortM.<Integer>time_sorts_bubble(numbers_list);
				times = times + a[0] + "," + a[1] + "\n";
			}
			
			FileWriter myWriterB = new FileWriter("bubble.csv");
			myWriterB.write(times);
			myWriterB.close();
			times = "";
			
			
			for(int j=10; j<3001; j++){
				
				Integer[] numbers_list = new Integer[j];
				int[] numbers_list_radix = new int[j];
				
				for(int i=0; i<j; i++) {
					numbers_list[i] = Integer.parseInt(numbers_list_str[i]);
				}
				
				long[] a = SortM.<Integer>time_sorts_merge(numbers_list);
				times = times+ a[0] + "," + a[1] + "\n";
			}
			
			FileWriter myWriterM = new FileWriter("merge.csv");
			myWriterM.write(times);
			myWriterM.close();
			times = "";
			
			
			for(int j=10; j<3001; j++){
				
				Integer[] numbers_list = new Integer[j];
				int[] numbers_list_radix = new int[j];
				
				for(int i=0; i<j; i++) {
					numbers_list[i] = Integer.parseInt(numbers_list_str[i]);
				}
				
				long[] a = SortM.<Integer>time_sorts_gnome(numbers_list);
				times = times + a[0] + "," + a[1] + "\n";
			}
			
			FileWriter myWriterG = new FileWriter("gnome.csv");
			myWriterG.write(times);
			myWriterG.close();
			times = "";
			
			for(int j=10; j<3001; j++){
				
				int[] numbers_list_radix = new int[j];
				
				for(int i=0; i<j; i++) {
					numbers_list_radix[i] = Integer.parseInt(numbers_list_str[i]);
					
				}
				
				long[] a = SortM.<Integer>time_sorts_radix(numbers_list_radix);
				times = times + a[0] + "," + a[1] + "\n";
			}
			
			FileWriter myWriterR = new FileWriter("radix.csv");
			myWriterR.write(times);
			myWriterR.close();
		}
		catch(Exception e){
			System.out.print(e);
		}
		
	}

}