package com.sample.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Environment implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    Long id;
    private Long envId;
    private String envName;
    private Boolean envActive;
    private String envDesc;
    
    public Environment() {
    }

    @Override
    public String toString() {
    return "Environment [envId=" + envId + ", envName=" + envName
        + ", isActive=" + envActive + ", envDesc=" + envDesc + "]";
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public String getEnvDesc() {
        return envDesc;
    }

    public void setEnvDesc(String envDesc) {
        this.envDesc = envDesc;
    }

    @Override
    public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((envDesc == null) ? 0 : envDesc.hashCode());
    result = prime * result + ((envId == null) ? 0 : envId.hashCode());
    result = prime * result + ((envName == null) ? 0 : envName.hashCode());
    result = prime * result
        + ((envActive == null) ? 0 : envActive.hashCode());
    return result;
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Environment other = (Environment) obj;
    if (envDesc == null) {
        if (other.envDesc != null)
        return false;
    } else if (!envDesc.equals(other.envDesc))
        return false;
    if (envId == null) {
        if (other.envId != null)
        return false;
    } else if (!envId.equals(other.envId))
        return false;
    if (envName == null) {
        if (other.envName != null)
        return false;
    } else if (!envName.equals(other.envName))
        return false;
    if (envActive == null) {
        if (other.envActive!= null)
        return false;
    } else if (!envActive.equals(other.envActive))
        return false;
    return true;
    }

    public Boolean getEnvActive() {
        return envActive;
    }

    public void setEnvActive(Boolean envActive) {
        this.envActive = envActive;
    }

    public Long getEnvId() {
        return envId;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

}
