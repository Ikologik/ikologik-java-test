package com.ikologik.test.domain;

import java.time.LocalDateTime;

public class Ticket {

	private LocalDateTime date;
	private String description;
	private String comment;
	private TicketStatus status;

	// Constructors

	public Ticket() {
	}

	// Getters

	public String getDescription() {
		return description;
	}

	public Ticket setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public Ticket setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public Ticket setStatus(TicketStatus status) {
		this.status = status;
		return this;
	}

}
