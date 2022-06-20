package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.SongRepository;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getAllSong() {
        List<Song> songs = songRepository.getAllSong();
        return songs;
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }
}