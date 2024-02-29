package com.example.scheduler.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "SCHEDULER_JOB")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchedulerJobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_generator")
    @SequenceGenerator(name = "url_generator", sequenceName = "url_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    BigInteger id;

    @Column(name = "job_name", nullable = false)
    String jobName;

    @Column(name = "created")
    Date created;

    @Column(name = "updated")
    Date updated;

    @Column(name = "row_status", nullable = false)
    String rowStatus;
}
