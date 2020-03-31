package br.com.flavorCRUD.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.flavorCRUD.util.JsonUtil;

@FacesConverter("IngredientConverter")
public class IngredientConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return JsonUtil.JsonToObjectIngredient(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return JsonUtil.objectToJson(value);
	}
}
