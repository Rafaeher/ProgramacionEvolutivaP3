package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;



public class DAO_Ngramas
{
	private static HashMap<String, Double> ngramas;
	private static int n;
	private final static String RUTA = "ngrams/";
	public final static int NMAX = 5;
	
	/**
	 * Obtiene un HashMap que contiene los n -gramas y sus frecuencias relativas, con n dado.
	 * 
	 * @param num
	 * @return un HashMap en el que la clave es el ngrama y el valor es un par del cual el
	 * primer elemento se inicializa a 0 y el segundo es la frecuencia relativa del ngrama
	 */
   public static HashMap<String, Double> lectura(int num)
   {
	  if (ngramas == null || num != n)
	  {
		  n = num;
	      File archivo = null;
	      FileReader fileReader = null;
	      BufferedReader bufferedReader = null;
	      ngramas = new HashMap<String, Double>();
	      Double total = 0.0;
	      try
	      {
	         archivo = new File (RUTA + obtenerNombreFichero(n));
	         fileReader = new FileReader (archivo);
	         bufferedReader = new BufferedReader(fileReader);
	
	         String linea;
	         while((linea=bufferedReader.readLine()) != null)
	         {
	            String[] separacion = linea.split(" ");
	            String ngrama = separacion[0];
	            ngrama = ngrama.toLowerCase();
	            Double frecuencia = Double.valueOf(separacion[1]);
	                        
	            ngramas.put(ngrama, frecuencia);
	            total = total + (frecuencia);
	         }
	         
	         
	         for(String ngrama : ngramas.keySet()) // Para cada n - grama, añade al resultado el n - grama con su frecuencia relativa
	         {
	        	 Double frecuenciaRelativa = ngramas.get(ngrama) / (total);
	        	 ngramas.replace(ngrama, frecuenciaRelativa);
	         }
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      finally
	      {
	         try
	         {                    
	            if( null != fileReader )
	            {   
	               fileReader.close();     
	            }                  
	         }
	         catch (Exception e2)
	         { 
	            e2.printStackTrace();
	         }
	      }
	  }
      
	  return ngramas;
   }
   
   /**
    * Obtiene el nombre del fichero de los n - gramas, con n dado
    * 
    * @param n
    * @return
    */
   private static String obtenerNombreFichero(int n)
   {
	   switch(n)
	   {
	   default: return "words.txt";
	   }
   }
   
   public static void main(String[] args)
   {
	   HashMap<String, Double> ngramas = DAO_Ngramas.lectura(1);
	   
	   Double total = 0.0;
	   
	   for(String ngrama : ngramas.keySet())
	   {
		   System.out.println(ngrama + "    " + ngramas.get(ngrama).toString());
		   total += ngramas.get(ngrama);
	   }
	   
	   System.out.println("TOTAL " + total);
   }
}