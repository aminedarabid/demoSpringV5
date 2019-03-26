package com.objis.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objis.spring.demodao.IFormationDao;
import com.objis.spring.demodomaine.Formation;

@Service
public class FormationService {

	@Autowired
	private IFormationDao iformationDao;
	
	public List<Formation> getAll() {
		return iformationDao.findAll();
	}
	
	public void create(Formation newform) {
		iformationDao.save(newform);
	}
	
	public void deletebyId(Integer id) {
		iformationDao.deleteById(id);
	}

	public Formation findById(Integer id) {
		return iformationDao.getOne(id);
	}

	public void validateUpdate(Formation formation) {
		iformationDao.save(formation);
	}
	
}
