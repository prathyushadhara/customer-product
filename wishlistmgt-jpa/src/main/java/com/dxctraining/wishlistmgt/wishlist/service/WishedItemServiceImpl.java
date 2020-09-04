package com.dxctraining.wishlistmgt.wishlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.wishlistmgt.wishlist.dao.IWishedItemDao;
import com.dxctraining.wishlistmgt.wishlist.entities.WishedItem;
import com.dxctraining.wishlistmgt.wishlist.exceptions.InvalidArgumentException;

import java.util.List;
import java.util.Random;

@Transactional
@Service
public class WishedItemServiceImpl implements IWishedItemService {

	@Autowired
	private IWishedItemDao dao;

	@Override
	public WishedItem save(WishedItem wishedItem) {
		wishedItem = dao.save(wishedItem);
		return wishedItem;
	}

	@Override
	public List<WishedItem> allWishedItems() {
		List<WishedItem> list = dao.findAll();
		return list;
	}

	@Override
	public List<WishedItem> findAllById(int customerId) {
		validateId(customerId);
		List<WishedItem> list = dao.findAllById(customerId);
		return list;
	}

	private void validateId(int customerId) {
		if (customerId == 0) {
			throw new InvalidArgumentException("id should not be null");
		}

	}

}
