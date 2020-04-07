import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TaxDataParser {
    private TaxDataParser() {}

    public static Map<String, Double> fromURL(String url) throws IOException {
        Map<String, Double> result = new HashMap<>();
        Document doc = Jsoup.connect(url).get();
        Elements tables = doc.getElementsByClass("wikitable sortable");
        Element targetTable = tables.get(0);
        Elements rows = targetTable.getElementsByTag("tr");
        rows.forEach(row -> {
            Elements tableCells = row.getElementsByTag("td");
            if (tableCells.size() == 0) return;
            String innerHTML = tableCells.get(0).html();//state
            String state = clearStringFromTags(innerHTML);
            String innerHTMLBaseTax = tableCells.get(1).html();
            double baseTax = Double.parseDouble(innerHTMLBaseTax.replace("%", ""));
            result.put(state, baseTax);
        });
        return result;
    }

    private static String clearStringFromTags(String stateString) {
        var cleared = stateString.chars().takeWhile(c -> c != '<').mapToObj(c -> Character.toString((char)c));
        return cleared.collect(Collectors.joining("")).trim();
    }
}
