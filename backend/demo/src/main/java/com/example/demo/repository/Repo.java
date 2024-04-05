package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Note;

public interface Repo extends JpaRepository<Note,Long>{

}
