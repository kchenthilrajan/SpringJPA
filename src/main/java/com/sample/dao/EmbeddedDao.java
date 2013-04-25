package com.sample.dao;

import java.util.List;

import com.sample.entities.Environment;

public interface EmbeddedDao {

    public void saveEnvironment(Environment env);

    public List<Environment> getAllEnvironments();

}
