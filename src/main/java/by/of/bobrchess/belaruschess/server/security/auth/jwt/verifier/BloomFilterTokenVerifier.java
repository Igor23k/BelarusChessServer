package by.of.bobrchess.belaruschess.server.security.auth.jwt.verifier;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        if (StringUtils.isNotEmpty(jti)) {
            //todo
        }
        return true;
    }
}
