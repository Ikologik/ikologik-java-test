package com.ikologik.test.mapper;

import com.ikologik.test.domain.TicketComment;
import com.ikologik.test.dto.TicketCommentDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketCommentMapper {

	TicketCommentMapper INSTANCE = Mappers.getMapper(TicketCommentMapper.class);

	// Mapping

	TicketCommentDto toDTO(TicketComment source);

	@Mapping(target = "id", ignore = true)
	@InheritInverseConfiguration(name = "toDTO")
	void fromDTO(TicketCommentDto source, @MappingTarget TicketComment target);

}
