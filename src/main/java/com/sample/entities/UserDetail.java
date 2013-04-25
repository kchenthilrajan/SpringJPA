package com.sample.entities;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    Long id;
    private Integer userId;
    private String userName;

    @Override
    public int hashCode() {
    int hash = 0;
    hash += (this.userId != null ? this.userId.hashCode() : 0);
    return hash;
    }

    @Override
    public boolean equals(Object object) {
    if (!(object instanceof UserDetail)) {
        return false;
    }
    UserDetail other = (UserDetail) object;
    if (this.userId != other.userId
        && (this.userId == null || !this.userId.equals(other.userId))) {
        return false;
    }
    return true;
    }

    @Override
    public String toString() {
    return "com.sample.entity.UserDetail[" + "userId=" + userId + "]";
    }

    public Integer getUserId() {    return userId;  }
    public void setUserId(Integer userId) { this.userId = userId;   }
    public String getUserName() {   return userName;    }
    public void setUserName(String userName) {  this.userName = userName;   }
}
