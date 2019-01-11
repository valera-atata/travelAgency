package com.travelagency.app.service.abstracts;

import java.util.List;

import com.travelagency.app.entity.AgentEntity;


public interface UserService {
    void save(AgentEntity agentEntity);

    AgentEntity findByLogin(String login);
    
    List<AgentEntity> findAll();
}
