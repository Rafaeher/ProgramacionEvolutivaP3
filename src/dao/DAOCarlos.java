package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class DAOCarlos {
	private HashMap<String, Double> map;
	
	public DAOCarlos(){
		map = new HashMap<String, Double>();
	}
	 public static HashMap<String, Double> lectura(int n)
	   {
	      File archivo = null;
	      FileReader fileReader = null;
	      BufferedReader bufferedReader = null;
	      HashMap<String, Double> resultado = new HashMap<String, Double>();
	      Double total = 0.0;
	      try
	      {
	         archivo = new File ("ngrams/carlos.txt");
	         fileReader = new FileReader (archivo);
	         bufferedReader = new BufferedReader(fileReader);

	         String linea;
	         while((linea=bufferedReader.readLine()) != null)
	         {
	            String[] separacion = linea.split(" ");
	            String ngrama = separacion[0];
	            ngrama = ngrama.toLowerCase();
	            Double frecuencia = Double.valueOf(separacion[1]);
	                        
	            resultado.put(ngrama, frecuencia);
	            total = total + (frecuencia);
	         }
	         
	         
	         for(String ngrama : resultado.keySet()) // Para cada n - grama, añade al resultado el n - grama con su frecuencia relativa
	         {
	        	 Double frecuenciaRelativa = resultado.get(ngrama) / (total);
	        	 resultado.replace(ngrama, frecuenciaRelativa);
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
	      
	      return resultado;
	   }
	 public boolean estaPalabra(String Word){
		 if(map.containsKey(Word.toUpperCase())) return true;
		 else return false;
	 }
}
