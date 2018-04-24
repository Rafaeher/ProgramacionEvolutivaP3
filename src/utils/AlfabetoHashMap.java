package utils;

import java.util.HashMap;

import dao.DAO_Ngramas;

public class AlfabetoHashMap {
	
	private static HashMap<Character, Integer>alfabeto;

	public static HashMap<Character, Integer> getAlfabetoHashMap()
	{
		if (alfabeto == null)
		{
			alfabeto = new HashMap<Character, Integer>();
			HashMap<String, Double> ngramas = DAO_Ngramas.lectura(1);
			
			int i = 0;
			for(String ngrama : ngramas.keySet())
			{
				alfabeto.put(ngrama.charAt(0), i);
				i++;
			}
		}
		
		return alfabeto;
	}
}
