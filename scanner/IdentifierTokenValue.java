public class IdentifierTokenValue extends TokenVal {
    public String idName;

    public IdentifierTokenValue(int line, int charnum, String name) {
        super(line, charnum);
        this.idName = name;
    }
}
