package br.com.flavorCRUD.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.flavorCRUD.domain.Ingredient;

public class JsonUtil {
	
	public static String objectToJson(Object o) {
		ObjectMapper objectMapper = new ObjectMapper(); 

		try {
			return objectMapper.writeValueAsString(o);
		} catch(Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static Ingredient JsonToObjectIngredient(String json) {
		ObjectMapper obj = new ObjectMapper();

		try {
			return obj.readValue(json, Ingredient.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
