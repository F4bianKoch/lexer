public class StringTokenValue extends TokenVal {
    public String strVal;

    public StringTokenValue(int line, int charnum, String value) {
        super(line, charnum);
        this.strVal = value;
    }
}
