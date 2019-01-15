package com.travelagency.app.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.app.dao.abstracthibernatedao.AbstractContractHibernateDao;
import com.travelagency.app.entity.ContractEntity;
import com.travelagency.app.service.abstracts.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private AbstractContractHibernateDao contractDao;
	
	@Override
	public void add(ContractEntity contract) {
		contractDao.add(contract);
	}
	
	@Override
	public List<ContractEntity> getAllByAgent(String login){
		return contractDao.getAllByAgent(login);
	}
	
	@Override
	public List<ContractEntity> getAll(){
		return contractDao.getAll();
	}
	
	@Override
	public ContractEntity getById(Long id) {
		return contractDao.getById(id);
	}
	
}
