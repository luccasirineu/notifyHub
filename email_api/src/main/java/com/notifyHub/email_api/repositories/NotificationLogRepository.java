package com.notifyHub.email_api.repositories;

import com.notifyHub.email_api.models.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}
