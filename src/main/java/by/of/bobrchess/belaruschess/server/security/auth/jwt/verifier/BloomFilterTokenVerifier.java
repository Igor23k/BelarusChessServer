package by.of.bobrchess.belaruschess.server.security.auth.jwt.verifier;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        if (StringUtils.isNotEmpty(jti)) {
            //https://web.archive.org/web/20190613055248/https://tools.ietf.org/html/rfc7519#section-4.1.7
        }
        return true;
    }
}
