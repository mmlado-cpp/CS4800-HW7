import java.util.HashMap;

public class CharacterPropertiesFactory {
    private final HashMap<String, CharacterProperties> characterPropertiesMap = new HashMap<>();
    private static CharacterPropertiesFactory factory = null;

    private CharacterPropertiesFactory() {}

    public static CharacterPropertiesFactory getInstance() {
        if (factory == null) {
            factory = new CharacterPropertiesFactory();
        }

        return factory;
    }

    public CharacterProperties getCharacterProperties(String properties) {
        return characterPropertiesMap.computeIfAbsent(properties, key -> {
            String[] propertyVals = key.split("-");
            String font = propertyVals[0];
            String color = propertyVals[1];
            int size = Integer.parseInt(propertyVals[2]);
            return new CharacterProperties(font, color, size);
        });
    }
    

}