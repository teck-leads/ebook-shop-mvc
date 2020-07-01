package com.ebooks.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebooks.app.model.EbookShop;

public interface EbookRepository extends JpaRepository<EbookShop, Integer> {

}
