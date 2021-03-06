package com.travelagency.app.service.abstracts;

import java.util.List;

import com.travelagency.app.entity.AgentEntity;


public interface AgentService {
    void add(AgentEntity agent);
    
    void update(AgentEntity agent);
    
    void delete(AgentEntity agent);

    AgentEntity getByLogin(String login);
    
    List<AgentEntity> getAll();
    
    List<Object[]> getStatistics();
}
