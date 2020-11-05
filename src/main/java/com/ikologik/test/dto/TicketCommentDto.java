package com.ikologik.test.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketCommentDto {

	private Long id;

	private LocalDateTime date;
	private String comment;

}
