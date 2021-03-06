package com.travelagency.app.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.travelagency.app.dao.abstracthibernatedao.AbstractAgentHibernateDao;
import com.travelagency.app.dao.abstracthibernatedao.AbstractRoleHibernateDao;
import com.travelagency.app.entity.AgentEntity;
import com.travelagency.app.entity.RoleEntity;
import com.travelagency.app.service.abstracts.AgentService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
    private AbstractAgentHibernateDao agentDao;

	@Autowired
    private AbstractRoleHibernateDao roleDao;

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void add(AgentEntity agent) {
    	agent.setPassword(bCryptPasswordEncoder.encode(agent.getPassword()));
        Set<RoleEntity> roleEntities = new HashSet<RoleEntity>();
        if(agent.getLogin().equals("petrenko")) {
        	 roleEntities.add(roleDao.getById(2L));
        } else {
        	 roleEntities.add(roleDao.getById(1L));
        }
        agent.setRoles(roleEntities);
        agentDao.add(agent);
    }
    
    @Override
	public void update(AgentEntity agent) {
		agentDao.update(agent);		
	}

	@Override
	public void delete(AgentEntity agent) {
		agentDao.delete(agent);
	}

	@Override
    public AgentEntity getByLogin(String login) {
        return agentDao.getByLogin(login);
    }
    
    @Override
    public List<AgentEntity> getAll(){
    	return agentDao.getAll();
    }
    
    @Override
    public List<Object[]> getStatistics(){
    	return agentDao.getStatistics();
    }
    
}