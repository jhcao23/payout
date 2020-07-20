package technology.touchmars.model;

public enum TransactionStatus {
    // MySQL 8 needs an ENUM data type as well
    // create table table_name (
    //  id bigint not null primary key,
    //  status ENUM('FAILED', 'PARTIAL_FAILED', 'PARTIAL_COMPLETE', 'COMPLETE') ...
    // )
    SUBMITTED, PROCESSING, BLOCKED, CANCELED, HELD, DENIED, FAILED, SUCCESS, UNCLAIMED, REFUNDED, RETURNED
}
