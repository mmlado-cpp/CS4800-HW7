public class Character {
    private char ch;
    private CharacterProperties properties;

    public Character(char ch, String properties) {
        this.ch = ch;
        this.properties = CharacterPropertiesFactory.getInstance().getCharacterProperties(properties);
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public CharacterProperties getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = CharacterPropertiesFactory.getInstance().getCharacterProperties(properties);
    }

    public String toString() {
        return ch + " -> " + properties;
    }

    public void setProperties(CharacterProperties properties) {
        this.properties = properties;
    }
}