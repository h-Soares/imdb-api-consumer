package api;

import entities.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {
    private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");

    protected static List<Map<String, String>> parseToMapList(String json) {
        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find())
            throw new IllegalArgumentException("Não encontrou items.");

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : items) {

            Map<String, String> atributosItem = new HashMap<>();

            Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }

            dados.add(atributosItem);
        }
        return dados;
    }

    protected static List<Content> parseToContentList(String json) {
        List<Map<String, String>> mapList = parseToMapList(json);

        return mapList.stream().map(map ->
               new Content(map.get("title"), fixURL(map.get("image")), map.get("imDbRating")))
               .toList();
    }

    private static String fixURL(String URL) {
        return URL.replace("._V1_UX128_CR0,3,128,176_AL_", "");
    }
}