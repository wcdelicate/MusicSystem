package com.example.musicprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.musicapi.service.AdminService;
import com.example.musicprovider.dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public boolean veritypasswd(String name, String password) {

        return adminMapper.verifyPassword(name, password)>0?true:false;
    }
}
