package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface SongService {
    List<Song> getAllSong();

    void save(Song song);
}