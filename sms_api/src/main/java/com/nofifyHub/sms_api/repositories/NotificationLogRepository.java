package com.nofifyHub.sms_api.repositories;

import com.nofifyHub.sms_api.models.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
}
