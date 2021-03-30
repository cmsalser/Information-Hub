package com.project.informationhub.mappers;

import com.project.informationhub.dto.EventDto;
import com.project.informationhub.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {
    void updateCustomerFromDto(EventDto dto, @MappingTarget Event entity);
}
