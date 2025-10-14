package calculator.Util;

public class Util {

    public boolean isInteger(char c) {
        if(c - '0' >= 0 && c - '0' <= 9) return true;
        return false;
    }

}