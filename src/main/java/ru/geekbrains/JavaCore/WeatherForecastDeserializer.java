package ru.geekbrains.JavaCore;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.geekbrains.JavaCore.Entity.Weather;
import ru.geekbrains.JavaCore.Entity.WeatherForecast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WeatherForecastDeserializer extends StdDeserializer<WeatherForecast> {

    public WeatherForecastDeserializer() {
        this(null);
    }

    public WeatherForecastDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public WeatherForecast deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode node1 = node.get("DailyForecasts");
        List<Weather> result = new ArrayList<>();

        if (node1.isArray()) {
            for (final JsonNode objNode : node1) {
                String date = null;
                double temperature = 0;
                String conditions = null;
                Iterator<Map.Entry<String, JsonNode>> fields = objNode.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> jsonField = fields.next();

                    if (jsonField.getKey() == "Date")
                        date = jsonField.getValue().asText();

                    if (jsonField.getKey() == "Temperature")
                        temperature = jsonField.getValue().path("Maximum").path("Value").asDouble();

                    if (jsonField.getKey() == "Day")
                        conditions = jsonField.getValue().path("IconPhrase").asText();
                }

                String city = "Copenhagen";
                result.add(new Weather(city, date, temperature, conditions));
            }
        }

        return new WeatherForecast(result);
    }
}
