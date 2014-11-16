package org.neigbors.analitics.fetcher.news.feedzilla;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.neigbors.analitics.dto.CategoryDto;

import java.io.IOException;

public class FeedzillaCategoryDeserializer extends JsonDeserializer<CategoryDto> {


    private final String ID = "category_id";
    private final String NAME = "english_category_name";


    @Override
    public CategoryDto deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = node.get(ID).getNumberValue().intValue();
        String name = node.get(NAME).getValueAsText();


        return new CategoryDto(id, name);
    }
}
