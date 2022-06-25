package com.codegym.song.service;

import com.codegym.song.model.Song;
import com.codegym.song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Song song) {
        this.iSongRepository.save(song);
    }

    @Override
    public void remove(Integer id) {
        this.iSongRepository.deleteById(id);
    }
}
