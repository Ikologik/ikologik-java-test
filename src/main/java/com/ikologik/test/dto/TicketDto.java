package com.ikologik.test.dto;

import com.ikologik.test.domain.TicketStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketDto {

	private Long id;

	private LocalDateTime date;
	private String description;
	private String comment;
	private TicketStatus status;

}
