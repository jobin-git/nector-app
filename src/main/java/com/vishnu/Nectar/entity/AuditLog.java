package com.vishnu.Nectar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class AuditLog {
    private int id;
    private String requestEndPoint;
    private String requestType;
    private String responsePayload;
    private String userId;
    private String time;
}
