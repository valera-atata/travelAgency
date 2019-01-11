package com.travelagency.app.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.travelagency.app.dao.abstracthibernatedao.AbstractAgentHibernateDao;
import com.travelagency.app.dao.abstracthibernatedao.AbstractRoleHibernateDao;
import com.travelagency.app.entity.AgentEntity;
import com.travelagency.app.entity.RoleEntity;
import com.travelagency.app.service.abstracts.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private AbstractAgentHibernateDao abstractAgentHibernateDao;

	@Autowired
    private AbstractRoleHibernateDao abstractRoleHibernateDao;

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(AgentEntity agentEntity) {
        agentEntity.setPassword(bCryptPasswordEncoder.encode(agentEntity.getPassword()));
        Set<RoleEntity> roleEntities = new HashSet<RoleEntity>();
        roleEntities.add(abstractRoleHibernateDao.getById(1L));
        agentEntity.setRoles(roleEntities);
        abstractAgentHibernateDao.save(agentEntity);
    }

    @Override
    public AgentEntity findByLogin(String login) {
        return abstractAgentHibernateDao.findByLogin(login);
    }
    
    @Override
    public List<AgentEntity> findAll(){
    	return abstractAgentHibernateDao.findAll();
    }
    
}