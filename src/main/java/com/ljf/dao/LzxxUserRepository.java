package com.ljf.dao;

import com.ljf.entity.LzxxUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * @author liujf05
 * @date 2019/3/12
 */
public interface LzxxUserRepository extends JpaRepository<LzxxUser,Serializable> {
}
