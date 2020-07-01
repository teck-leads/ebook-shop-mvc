package com.ebooks.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebooks.app.model.EbookShop;
import com.ebooks.app.repository.EbookRepository;

@Service
public class EbookService {
	@Autowired
	private EbookRepository repository;

	public List<EbookShop> findAllEbooks() {
		return repository.findAll();
	}

	public EbookShop findEbookById(Integer id) {
		Optional<EbookShop> ebook = repository.findById(id);
		if (ebook.isPresent()) {

			return ebook.get();
		} else {
			return new EbookShop();
		}

	}
	
	public EbookShop saveEbookshop(EbookShop ebookShop) {
		EbookShop savedBook = repository.save(ebookShop);
		return savedBook;
	}
	
	public void deleteEbook(Integer id) {
		repository.deleteById(id);
	}

}
