package com.example.musicprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.musicapi.pojo.ListSong;
import com.example.musicapi.service.ListSongService;
import com.example.musicprovider.dao.ListSongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
@Service
public class ListSongServiceImpl implements ListSongService {

    @Autowired
    private ListSongMapper listSongMapper;

    @Override
    public List<ListSong> allListSong()
    {
        return listSongMapper.allListSong();
    }

    @Override
    public boolean updateListSongMsg(ListSong listSong) {
        return listSongMapper.updateListSongMsg(listSong) > 0;
    }

    @Override
    public boolean deleteListSong(Integer songId) {
        return listSongMapper.deleteListSong(songId) > 0;
    }

    @Override
    public boolean addListSong(ListSong listSong)
    {
        return listSongMapper.insertSelective(listSong) > 0;
    }

    @Override
    public List<ListSong> listSongOfSongId(Integer songListId)
    {
        return listSongMapper.listSongOfSongId(songListId);
    }

}
