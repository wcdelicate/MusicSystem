package com.example.musicapi.service;
import com.example.musicapi.pojo.SongList;

import java.util.List;
public interface SongListService {

    boolean addSongList(SongList songList);

    boolean updateSongListMsg(SongList songList);

    boolean updateSongListImg(SongList songList);

    boolean deleteSongList(Integer id);

    List<SongList> allSongList();

    List<SongList> likeTitle(String title);

    List<SongList> likeStyle(String style);

    List<SongList> songListOfTitle(String title);

}
