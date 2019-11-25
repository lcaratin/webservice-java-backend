package webservice.util;

import javax.servlet.http.HttpServletResponse;

public class Utils {
	public static void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
    }
}
