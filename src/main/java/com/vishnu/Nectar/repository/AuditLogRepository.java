package com.vishnu.Nectar.repository;

import com.vishnu.Nectar.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {
}
