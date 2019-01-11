package com.travelagency.app.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelagency.app.dao.abstracthibernatedao.AbstractAgentHibernateDao;
import com.travelagency.app.entity.AgentEntity;
import com.travelagency.app.entity.RoleEntity;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private AbstractAgentHibernateDao abstractAgentHibernateDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("userDao: " + abstractAgentHibernateDao);
        AgentEntity user = abstractAgentHibernateDao.findByLogin(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

        for (RoleEntity roleEntity : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);
}
}