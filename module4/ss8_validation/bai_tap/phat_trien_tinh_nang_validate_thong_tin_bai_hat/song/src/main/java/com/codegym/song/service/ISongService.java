package com.codegym.song.service;

import com.codegym.song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(Integer id);

    void update(Song song);

    void remove(Integer id);
}
