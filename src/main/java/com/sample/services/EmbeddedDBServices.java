package com.sample.services;

import java.util.List;

import com.sample.dao.EmbeddedDao;
import com.sample.entities.Environment;

public class EmbeddedDBServices {

    public EmbeddedDao embeddedDao;
    
    public void saveEnvironment(Environment env){
	embeddedDao.saveEnvironment(env);
    }

    public void setEmbeddedDao(EmbeddedDao embeddedDao) {
        this.embeddedDao = embeddedDao;
    }
    
    public List<Environment> getAllEnvironments(){
	return embeddedDao.getAllEnvironments();
    }
}
