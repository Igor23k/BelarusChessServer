package by.of.bobrchess.belaruschess.server.security.common;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SecurityUtil {
    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    private static final String X_REQUESTED_WITH = "X-Requested-With";

    private static final String CONTENT_TYPE = "Content-type";
    private static final String CONTENT_TYPE_JSON = "application/json";

    public static boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader(XML_HTTP_REQUEST);
        return XML_HTTP_REQUEST.equals(request.getHeader(X_REQUESTED_WITH));
    }
}
