import java.util.*;

public class Clothing {
    public String type; // one of "top", "bottom", "shoes", or "accessory"
    public String color; // describes the color of the item

    public Clothing(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public void dyeColor(String newColor) {
        ...
    }
}

class Closet {
    private Set<Clothing> clothingSet = new HashSet<>();
    private Map<String, List<Clothing>> sameColor = new HashMap<>();

    public Closet(List<Clothing> clothingList) {
        for (Clothing cl : clothingList) { // can be simplified to clothingSet.addAll(clothingList);
            clothingSet.add(cl);
        }

        for (Clothing cl: clothingSet) {
            String itemColor = cl.color;
            if (!sameColor.containsKey(itemColor)) {
                sameColor.put(itemColor, new List<Clothing>());
            }
            sameColor.get(itemColor).add(cl);
        }
    }

    public List<Clothing> getItemsByDay(Map<String, String> daysToColors, String currentDay) {
        return sameColor.get(daysToColors.get(currentDay));
    }

    public void enterEmoPhase(List<String> happyColors) {
        for (String s : happyColors) {
            for (Clothing cl : sameColor.get(s)) {
                cl.dyeColor("Black");
            }
        }
    }
}
