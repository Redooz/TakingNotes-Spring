package com.redoz.takingnotes.persistence.mapper;

import com.redoz.takingnotes.domain.Note;
import com.redoz.takingnotes.persistence.entity.NoteEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    @Mappings({
            @Mapping(target = "id", source = "noteEntity.id"),
            @Mapping(target = "date", source = "noteEntity.date"),
            @Mapping(target = "title", source = "noteEntity.title"),
            @Mapping(target = "body", source = "noteEntity.body")
    })
    Note toNote(NoteEntity noteEntity);
    List<Note> toNotes(List<NoteEntity> noteEntityList);

    @InheritInverseConfiguration
    NoteEntity toNoteEntity(Note note);
}
