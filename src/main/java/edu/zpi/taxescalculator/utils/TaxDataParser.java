package edu.zpi.taxescalculator.utils;

import com.sun.source.tree.Tree;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/*
                _ ___                /^^\ /^\  /^^\_
    _          _@)@) \            ,,/ '` ~ `'~~ ', `\.
  _/o\_ _ _ _/~`.`...'~\        ./~~..,'`','',.,' '  ~:
 / `,'.~,~.~  .   , . , ~|,   ,/ .,' , ,. .. ,,.   `,  ~\_
( ' _' _ '_` _  '  .    , `\_/ .' ..' '  `  `   `..  `,   \_
 ~V~ V~ V~ V~ ~\ `   ' .  '    , ' .,.,''`.,.''`.,.``. ',   \_
  _/\ /\ /\ /\_/, . ' ,   `_/~\_ .' .,. ,, , _/~\_ `. `. '.,  \_
 < ~ ~ '~`'~'`, .,  .   `_: ::: \_ '      `_/ ::: \_ `.,' . ',  \_
  \ ' `_  '`_    _    ',/ _::_::_ \ _    _/ _::_::_ \   `.,'.,`., \-,-,-,_,_,
   `'~~ `'~~ `'~~ `'~~  \(_)(_)(_)/  `~~' \(_)(_)(_)/ ~'`\_.._,._,'_;_;_;_;_;
   
 */


public class TaxDataParser {

    private static final String TAX_EXEMPT_CELL_BACKGROUND_COLOR = "#4ee04e";
    private static final String TAX_SUBJECT_CELL_BACKGROUND_COLOR = "#7788ff";
    private static final String NO_STATEWIDE_TAX_CELL_BACKGROUND_COLOR = "#f62b0f";

    private TaxDataParser() {}

    @Deprecated
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

    public static Map<State, List<ProductCategoryStateTaxData>> fromUrlIncludeCategories(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements tables = doc.getElementsByClass("wikitable sortable");
        Element targetTable = tables.get(0);

        Elements rows = targetTable.getElementsByTag("tr");
        final ProductCategory[] categories = ProductCategory.values();
        Map<State, List<ProductCategoryStateTaxData>> taxData = new TreeMap<>();

        for (int i = 0; i < rows.size(); ++i) {
            Element row = rows.get(i);
            Elements tableCells = row.getElementsByTag("td");

            if (tableCells.size() == 0) continue;

            String stateName = clearStringFromTags(tableCells.get(0).html());
            double baseTax = Double.parseDouble(tableCells.get(1).html().replace("%", ""));
            State state = new State(stateName, baseTax);

            int startIndex = 3;//od 4 komórki tabeli do końca mamy informacje o podatku dla kategorii
            List<ProductCategoryStateTaxData> taxDataList = new ArrayList<>();

            for (int j = startIndex, categoryIndex = 0; j < tableCells.size(); ++j, ++categoryIndex) {
                Element cell = tableCells.get(j);
                Attributes attributes = cell.attributes();
                boolean included = false;
                Double tax = null;

                if (attributes.size() != 0) {
                    String backgroundValue = attributes.get("style").replace("background:", "").replace(";","");
                    //this is utterly fucking retarded
                    //style can also contain numbers colors, ugh
                    if (backgroundValue.contains(TAX_EXEMPT_CELL_BACKGROUND_COLOR)
                            || backgroundValue.contains(NO_STATEWIDE_TAX_CELL_BACKGROUND_COLOR)) {
                        included = false;
                    } else if (backgroundValue.contains(TAX_SUBJECT_CELL_BACKGROUND_COLOR)) {
                        included = true;
                        if (!cell.html().isBlank()) {
                            //I'm so disgusted with myself I can't even describe it
                            String taxString = cell.html().
                                    chars().
                                    mapToObj(e -> (char) e).
                                    takeWhile(c -> Character.isDigit(c) || Character.isWhitespace(c) || c.equals('.') || c.equals(',')).
                                    map(c -> Character.toString(c)).
                                    collect(Collectors.joining(""));
                            if (!taxString.isBlank()) {
                                tax = Double.parseDouble(taxString);
                            }
                        }
                    }
                }

                ProductCategoryStateTaxData data = new ProductCategoryStateTaxData(categories[categoryIndex], baseTax, included);
                if (tax != null) {
                    data.setTax(tax);
                }
                taxDataList.add(data);
            }
            taxData.put(state, taxDataList);
        }
        return taxData;
    }
}
