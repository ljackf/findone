package com.ljf.service.impl;

import com.ljf.dao.LzxxUserRepository;
import com.ljf.entity.LzxxUser;
import com.ljf.service.LzxxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liujf05
 * @date 2019/3/12
 */
@Service
public class LzxxUserServiceImpl implements LzxxUserService{

    @Autowired
    private LzxxUserRepository lzxxUserRepository;

    public void save(LzxxUser lzxxUser){
        lzxxUserRepository.save(lzxxUser);
    }
}
