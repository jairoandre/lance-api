package br.com.vah.lance.api.converter;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Specializes;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import br.com.caelum.vraptor.serialization.gson.DateGsonConverter;

@Specializes
@Dependent
public class CustomDateGsonConverter extends DateGsonConverter implements JsonDeserializer<Date>, JsonSerializer<Date> {
	
	private final SimpleDateFormat customFormat;

	public CustomDateGsonConverter() {
		this.customFormat = new SimpleDateFormat("dd/MM/yyyy");
	}
	
	@Override
	public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
		String dateString = customFormat.format(date);
		return new JsonPrimitive(dateString);
	}
	
	@Override
	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		try {
			return customFormat.parse(json.getAsString());
		} catch (ParseException e) {
			throw new JsonSyntaxException(json.getAsString(), e);
		}
	}

}
