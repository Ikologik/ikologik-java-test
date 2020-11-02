package com.ikologik.test.domain;

import java.time.LocalDateTime;

public class TicketComment {

	private LocalDateTime date;
	private String comment;

	// Constructors

	public TicketComment() {
	}

	// Getters

	public String getComment() {
		return comment;
	}

	public TicketComment setComment(String comment) {
		this.comment = comment;
		return this;
	}

}
