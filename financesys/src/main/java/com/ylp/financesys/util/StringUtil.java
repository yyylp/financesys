package com.ylp.financesys.util;

public class StringUtil {
	public static boolean isNull(String ... params) {
		for (int i = 0; i < params.length; i++) {
			if (params[i]==null || params[i].equals("")) {
				return true;
			}
		}
		return false;
	}
}
