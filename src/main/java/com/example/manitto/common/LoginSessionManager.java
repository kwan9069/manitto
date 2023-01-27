package com.example.manitto.common;

import com.example.manitto.dtos.User;
import com.example.manitto.dtos.UserMatch;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by jonghyeon on 2023/01/24,
 * Package : com.example.manitto.common
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequiredArgsConstructor
public class LoginSessionManager {
    private final HttpSession session;
    public HttpSession getSession() {
        return session;
    }

    public boolean haveLoginSession() {
        return session.getAttribute("info") != null;
    }
    public void setLoginUserInfo(User.InfoDto info) {
        session.setAttribute("info", info);
    }

    public void removeLoginUserInfo() {
        session.removeAttribute("info");
    }
    public void updateLoginUserInfo(User.InfoDto info) {
        removeLoginUserInfo();
        session.setAttribute("info", info);
    }
    public User.InfoDto getLoginUserInfo() {
        if (session.getAttribute("info") == null)
            throw new RuntimeException(); // TODO: 2023/01/24 session not exist exception
        return (User.InfoDto) session.getAttribute("info");
    }
    public void setExtendedInfo(UserMatch.ExtendedDto extended) {
        session.setAttribute("extended", extended);
    }

    public UserMatch.ExtendedDto getExtendedInfo() {
        if (session.getAttribute("extended") == null)
            throw new RuntimeException(); // TODO: 2023/01/24 session not exist exception
        return (UserMatch.ExtendedDto) session.getAttribute("extended");
    }

    public void removeExtendedInfo() {
        session.removeAttribute("extended");
    }
    public void updateExtendedInfo(UserMatch.ExtendedDto extended) {
        removeLoginUserInfo();
        session.setAttribute("extended", extended);
    }
}
