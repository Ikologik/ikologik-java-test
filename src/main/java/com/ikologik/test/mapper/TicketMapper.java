package com.ikologik.test.mapper;

import com.ikologik.test.domain.Ticket;
import com.ikologik.test.dto.TicketDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

	TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

	// Mapping

	TicketDto toDTO(Ticket source);

	@Mapping(target = "id", ignore = true)
	@InheritInverseConfiguration(name = "toDTO")
	void fromDTO(TicketDto source, @MappingTarget Ticket target);

}
