package com.soxam.yliad.repository;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.soxam.yliad.entity.IdolEntity;

@SpringBootTest
public class IdolRepositoryTest {

	@Autowired
	private IdolRepository idolRepository;

	@Test
	public void testIdolRepository() {
		// given
		IdolEntity idol = new IdolEntity();
		idol.setName("ISA");
		idol.setAge(22);
		idolRepository.save(idol);

		// when
		IdolEntity isa = idolRepository.findById(idol.getId()).get();

		// then
		assertEquals(isa.getName(), "ISA");
		assertEquals(isa.getAge(), Integer.valueOf(22));
	}

}
