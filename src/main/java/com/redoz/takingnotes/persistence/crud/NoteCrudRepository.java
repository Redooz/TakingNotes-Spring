package com.redoz.takingnotes.persistence.crud;

import com.redoz.takingnotes.persistence.entity.NoteEntity;
import org.springframework.data.repository.CrudRepository;

public interface NoteCrudRepository extends CrudRepository<NoteEntity, Integer> {
}
