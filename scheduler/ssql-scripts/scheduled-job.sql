
CREATE TABLE IF NOT EXISTS scheduler_job
(
    id         bigint  not null
        constraint scheduler_job_pkey primary key,
    job_name  varchar(50)   not null,
    created    timestamp,
    updated    timestamp,
    row_status varchar(255)  not null
);