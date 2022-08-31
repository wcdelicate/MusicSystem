package com.example.musicprovider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.musicapi.pojo.Song;
import com.example.musicapi.service.SongService;
import com.example.musicprovider.dao.SongMapper;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;
    @Autowired(required =false)
    private StringRedisTemplate stringRedisTemplate;
    public List<Song> allSong()
    {
        return songMapper.allSong();
    }
    @Override
    public List<Song> allSongs(){
     String song=stringRedisTemplate.opsForValue().get("song");
     if (StringUtils.isNullOrEmpty(song)){
         List<Song> list=allSong();
         String s= JSON.toJSONString(list);
         stringRedisTemplate.opsForValue().set("song",s); //存入Reids中
         System.out.println("-----------来自数据库----------");
         return list;
     }
     else{
         List<Song> listSong=JSON.parseObject(song,new TypeReference<ArrayList<Song>>(){}); //从Redis中取数据
         System.out.println("-----------来自缓存----------");
         return listSong;
     }
    }

    @Override
    public boolean addSong(Song song)
    {

        return songMapper.insertSelective(song) > 0?true:false;
    }

    @Override
    public boolean updateSongMsg(Song song) {
        return songMapper.updateSongMsg(song) >0 ?true:false;
    }

    @Override
    public boolean updateSongUrl(Song song) {

        return songMapper.updateSongUrl(song) >0 ?true:false;
    }

    @Override
    public boolean updateSongPic(Song song) {

        return songMapper.updateSongPic(song) >0 ?true:false;
    }

    @Override
    public boolean deleteSong(Integer id) {
        return songMapper.deleteSong(id) >0 ?true:false;
    }

    @Override
    public List<Song> songOfSingerId(Integer singerId)

    {
        return songMapper.songOfSingerId(singerId);
    }

    @Override
    public List<Song> songOfId(Integer id)

    {
        return songMapper.songOfId(id);
    }

    @Override
    public List<Song> songOfSingerName(String name)

    {
        return songMapper.songOfSingerName(name);
    }

    @Override
    public List<Song> songOfName(String name)

    {
        return songMapper.songOfName(name);
    }
}
