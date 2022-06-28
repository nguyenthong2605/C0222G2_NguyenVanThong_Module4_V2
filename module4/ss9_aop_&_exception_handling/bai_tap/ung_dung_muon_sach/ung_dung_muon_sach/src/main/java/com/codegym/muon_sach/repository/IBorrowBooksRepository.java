package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowBooksRepository extends JpaRepository<BorrowBooks, Integer> {
}
