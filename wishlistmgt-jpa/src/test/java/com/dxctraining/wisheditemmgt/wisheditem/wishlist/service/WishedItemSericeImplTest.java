package com.dxctraining.wisheditemmgt.wisheditem.wishlist.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dxctraining.wishlistmgt.wishlist.entities.WishedItem;
import com.dxctraining.wishlistmgt.wishlist.exceptions.InvalidArgumentException;
import com.dxctraining.wishlistmgt.wishlist.service.IWishedItemService;
import com.dxctraining.wishlistmgt.wishlist.service.WishedItemServiceImpl;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({ WishedItemServiceImpl.class })
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class WishedItemSericeImplTest {

	@Autowired
	private IWishedItemService service;

	@Autowired
	private EntityManager entitymanager;

	@Test
	public void testAdd_1() {
		Executable executable = () -> service.save(null);
		Assertions.assertThrows(InvalidArgumentException.class, executable);
	}

	@Test
	public void testAdd_2() {
		int customerId = 1;
		String productId = "1";
		WishedItem wishedItem = new WishedItem(customerId, productId);
		wishedItem = service.save(wishedItem);
		List<WishedItem> list = new ArrayList<>();
		list.add(wishedItem);
		WishedItem fetched = list.get(0);
		Assertions.assertEquals(1, list.size());
		Assertions.assertEquals(customerId, fetched.getCustomerId());
		Assertions.assertEquals(productId, fetched.getProductId());
	}

}
