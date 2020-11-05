package com.ikologik.test.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class TicketComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@CreatedDate
	private LocalDateTime createdDate;
	@CreatedBy
	private String createdBy;
	@LastModifiedDate
	private LocalDateTime lastModifiedDate;
	@LastModifiedBy
	private String lastModifiedBy;
	@ManyToOne(targetEntity = Ticket.class, fetch = FetchType.LAZY)
	private Ticket ticket;

	private LocalDateTime date;
	private String comment;

}
