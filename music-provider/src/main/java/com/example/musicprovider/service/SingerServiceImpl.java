package com.example.musicprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.musicapi.pojo.Singer;
import com.example.musicapi.service.SingerService;
import com.example.musicprovider.dao.SingerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerMapper singerMapper;

    @Override
    public boolean updateSingerMsg(Singer singer) {
        return singerMapper.updateSingerMsg(singer) > 0;
    }

    @Override
    public boolean updateSingerPic(Singer singer) {

        return singerMapper.updateSingerPic(singer) > 0;
    }

    @Override
    public boolean deleteSinger(Integer id) {
        return singerMapper.deleteSinger(id) > 0;
    }

    @Override
    public List<Singer> allSinger()
    {
        return singerMapper.allSinger();
    }

    @Override
    public boolean addSinger(Singer singer)  {

        return singerMapper.insertSelective(singer) > 0;
    }

    @Override
    public List<Singer> singerOfName(String name)

    {
        return singerMapper.singerOfName(name);
    }

    @Override
    public List<Singer> singerOfSex(Integer sex)

    {
        return singerMapper.singerOfSex(sex);
    }
}
