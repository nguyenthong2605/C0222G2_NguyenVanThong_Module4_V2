package com.codegym.repository.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class SongRepositoryImpl implements ISongRepository {
    @Override
    public List<Song> findAll() {
        TypedQuery<Song> typedQuery =
                BaseRepository.entityManager.createQuery("select s" +
                        " from Song s", Song.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(Integer id) {
        TypedQuery<Song> typedQuery =
                BaseRepository.entityManager.createQuery("select s" +
                        " from Song s where s.id = :songId", Song.class);
        typedQuery.setParameter("songId", id);

        return typedQuery.getSingleResult() ;

    }

    @Override
    public void update(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public void remove(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Song.class,id));
        entityTransaction.commit();
    }
}
