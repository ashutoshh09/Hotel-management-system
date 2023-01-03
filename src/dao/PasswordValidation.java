package dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {
	
		private static final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

		private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

		public static boolean isValid(final String PASS) {
		    Matcher matcher = pattern.matcher(PASS);
		    return matcher.matches();
		}
   }


