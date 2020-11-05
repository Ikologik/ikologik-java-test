package com.ikologik.test.controller;

import com.ikologik.test.domain.Ticket;
import com.ikologik.test.dto.TicketDto;
import com.ikologik.test.mapper.TicketMapper;
import com.ikologik.test.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TicketController {

	private final TicketMapper mapper;
	private final TicketService service;

	// Constructors

	@Autowired
	public TicketController(TicketMapper mapper, TicketService service) {
		this.mapper = mapper;
		this.service = service;
	}

	// Actions

	@RequestMapping(value = "/ticket", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TicketDto>> list() {
		List<Ticket> o = service.getList();
		return new ResponseEntity<>(o.stream().map(t -> mapper.toDTO(t)).collect(Collectors.toList()), HttpStatus.OK);
	}

	@RequestMapping(value = "/ticket", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDto> add(@RequestBody TicketDto o) {
		Ticket e = new Ticket();
		mapper.fromDTO(o, e);
		return new ResponseEntity<>(mapper.toDTO(service.save(e)), HttpStatus.OK);
	}

	@RequestMapping(value = "/ticket/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDto> update(@PathVariable Long id, @RequestBody TicketDto o) {
		Ticket e = service.get(id);
		mapper.fromDTO(o, e);
		return new ResponseEntity<>(mapper.toDTO(service.save(e)), HttpStatus.OK);
	}

	@RequestMapping(value = "/ticket/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TicketDto> get(@PathVariable Long id) {
		Ticket e = service.get(id);
		return new ResponseEntity<>(mapper.toDTO(e), HttpStatus.OK);
	}

}
