package com.erika.wetalknow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erika.wetalknow.model.Message;

public interface Messages extends JpaRepository<Message, Long> {

}
