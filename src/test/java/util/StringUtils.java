package util;

public class StringUtils {
    public String buildLocatorForRegionChoice (String pattern, String contains) {
        String locatorForRegion = String.format(pattern, contains);
        return locatorForRegion;
    }
}
