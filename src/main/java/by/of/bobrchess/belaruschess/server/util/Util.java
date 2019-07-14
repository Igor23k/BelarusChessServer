package by.of.bobrchess.belaruschess.server.util;

import by.of.bobrchess.belaruschess.server.entity.User;
import by.of.bobrchess.belaruschess.server.entity.UserRole;
import by.of.bobrchess.belaruschess.server.exception.NoAssignedRolesException;
import by.of.bobrchess.belaruschess.server.exception.UserScopesAreEmptyException;
import by.of.bobrchess.belaruschess.server.security.model.token.JwtToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static by.of.bobrchess.belaruschess.server.util.Constants.*;

public class Util {

    public static List<GrantedAuthority> buildAuthorities(User user) {
        List<UserRole> roles = user.getRoles();
        if (!CollectionUtils.isEmpty(roles)) {
            return roles.stream()
                    .map(authority -> new SimpleGrantedAuthority(Util.buildRoleName(authority.getRole().getName())))
                    .collect(Collectors.toList());
        }
        throw new NoAssignedRolesException();
    }

    private static String buildRoleName(String name) {//todo убрать когда запросы будут норм работать
        return "ROLE_" + name;
    }


    public static List<GrantedAuthority> buildAuthorities(List<String> scopes) {
        if (!CollectionUtils.isEmpty(scopes)) {
            return scopes.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }
        throw new UserScopesAreEmptyException();

    }

    @SuppressWarnings("unchecked")
    public static boolean hasSufficientRights(HttpServletRequest request, String roleName) {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) request.getAttribute(AUTHORITIES);
        if (!CollectionUtils.isEmpty(authorities)) {
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(roleName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<String, String> buildTokenMap(JwtToken accessToken, JwtToken refreshToken) {
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put(TOKEN, accessToken.getToken());
        tokenMap.put(REFRESH_TOKEN, refreshToken.getToken());
        return tokenMap;
    }
}
