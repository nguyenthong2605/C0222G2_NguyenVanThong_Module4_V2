package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        List<Song> songList = iSongRepository.findAll();
        return songList;
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void update(Song song) {
        try {
            iSongRepository.update(song);
        }catch (Exception e) {
            e.printStackTrace();
        }
//        iSongRepository.update(song);
    }

    @Override
    public void remove(Integer id) {
        try {
            iSongRepository.remove(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
//        iSongRepository.remove(id);
    }
}
