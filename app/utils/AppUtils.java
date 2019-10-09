package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtils {

	public static String getIdFrom(String ContainsId) {

		Pattern pattern = Pattern.compile("/[0-9]+/");
		Matcher matcher = pattern.matcher(ContainsId);
		while (matcher.find()) {
			return matcher.group().substring(1 ,  matcher.group().length()-1);
		}
		return "";
	}

}
