package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class DAOEjemplos
{
	private static String RUTA = "ejemplos.txt";
	
	public static HashMap<Double, Double> leerEjemplos()
	{
	      File file = null;
	      FileReader fileReader = null;
	      BufferedReader bufferedReader = null;
	      HashMap<Double, Double> periodos = new HashMap<Double, Double>();
	      
	      try
	      {
	         file = new File (RUTA);
	         fileReader = new FileReader (file);
	         bufferedReader = new BufferedReader(fileReader);

	         String linea;
	         while((linea = bufferedReader.readLine()) != null)
	         {
	            String[] datos = linea.split(" ");
	            periodos.put(Double.valueOf(datos[0]), Double.valueOf(datos[1]));
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
	            if(fileReader != null)
	            {   
	               fileReader.close();     
	            }                  
	         }
	         catch (Exception e2)
	         { 
	            e2.printStackTrace();
	         }
	      }
	      
	      return periodos;
	}
}
