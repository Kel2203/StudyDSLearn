package com.devsuperior.dslearnbds.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import org.springframework.data.jpa.repository.Query;

public interface NotificationRepository extends JpaRepository<Notification, Long> {


	@Query("SELECT obj FROM Notification obj WHERE "
	+ "(obj.user = :user) AND "
	+"(:unreadOnly = false OR obj.read = false) "
	+"ORDER BY obj.moment DESC")
	Page<Notification> find(User user,boolean unreadOnly, Pageable pageable);


}
