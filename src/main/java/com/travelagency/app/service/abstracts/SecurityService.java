package com.travelagency.app.service.abstracts;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
    
    String getCurrentUsername();
}
