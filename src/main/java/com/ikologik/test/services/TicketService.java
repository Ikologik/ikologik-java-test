package com.ikologik.test.services;

import com.ikologik.test.domain.Ticket;
import com.ikologik.test.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

	private final TicketRepository repository;

	// Constructors

	@Autowired
	public TicketService(TicketRepository repository) {
		this.repository = repository;
	}

	// Actions

	public List<Ticket> getList() {
		return this.repository.findAll();
	}

	public Ticket get(Long id) {
		Assert.notNull(id, "No id provided");
		Optional<Ticket> o = this.repository.findById(id);
		if (o.isPresent()) return o.get();
		else throw new RuntimeException("Entity not found");
	}

	public Ticket save(Ticket o) {
		Assert.notNull(o, "No object provided");
		return this.repository.save(o);
	}

	public void delete(Long id) {
		Assert.notNull(id, "No id provided");
		Optional<Ticket> o = this.repository.findById(id);
//		if (o.isPresent()) repository.deleteById(o.get().getId());
//		else throw new RuntimeException("Entity not found");
	}

}
