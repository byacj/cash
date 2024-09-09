-- 유저정보
DROP TABLE IF EXISTS USER_INFO;

-- 유저정보
CREATE TABLE user_info (
    id    bigint   auto_increment primary key,
    user_id   VARCHAR(20)    NOT NULL,
    name   VARCHAR(30)    NOT NULL,
    business_no   VARCHAR(30)    NOT NULL
);
CREATE INDEX idx_business_no on user_info (business_no);

-- 결제 정보
DROP TABLE IF EXISTS payment_detail;

-- 결제 정보
CREATE TABLE payment_detail (
    id    bigint   auto_increment primary key,
    user_id   VARCHAR(20)    NOT NULL,
    mall_no   bigint    NOT NULL,
    status   VARCHAR(30)    NOT NULL,
    payment_at   DATETIME    NOT NULL,
    card_corporation   VARCHAR(30)    NOT NULL,
    partnership_card_corporation   VARCHAR(30)   NULL,
    card_no  VARCHAR(30)    NOT NULL,
    approval_no   VARCHAR(30)    NULL,
    payment_amt   bigint    NOT NULL,
    monthly_installment_plan   int    NOT NULL,
    created_at   DATETIME    NOT NULL,
    created_by   VARCHAR(30)    NOT NULL,
    updated_at   DATETIME    NOT NULL,
    updated_by   VARCHAR(30)    NOT NULL
);
CREATE INDEX idx_user_id_mall_no_payment_at on payment_detail (user_id, mall_no, payment_at);

-- 약관 동의
DROP TABLE IF EXISTS user_terms_of_use;

-- 약관 동의
CREATE TABLE user_terms_of_use (
    id    bigint   auto_increment primary key,
    user_id   VARCHAR(20)    NOT NULL,
    simple_connection_agree_at   DATETIME    NULL,
    provide_data_agree_at   DATETIME    NULL
);
CREATE INDEX idx_user_id on user_terms_of_use (user_id);

-- 메세지 전송
DROP TABLE IF EXISTS transfer_message;

-- 메세지 전송
CREATE TABLE transfer_message (
    id    bigint   auto_increment primary key,
    user_id   VARCHAR(20)    NOT NULL,
    mall_no   bigint    NOT NULL,
    type   VARCHAR(30)    NOT NULL,
    use   boolean    default false NOT NULL,
    cancel_at   DATETIME    NULL,
    created_at   DATETIME    NOT NULL,
    created_by   VARCHAR(30)    NOT NULL,
    updated_at   DATETIME    NOT NULL,
    updated_by   VARCHAR(30)    NOT NULL
);
CREATE INDEX idx_user_id_mall_no_type_use on transfer_message (user_id, mall_no, type, use);

-- 메세지 전송 내역
DROP TABLE IF EXISTS transfer_message_history;

-- 메세지 전송 내역
CREATE TABLE transfer_message_history (
    id    bigint   auto_increment primary key,
    user_id   VARCHAR(20)    NOT NULL,
    mall_no   bigint    NOT NULL,
    transfer_message_id bigint not null,
    period int not null,
    proceed_end_date DATE not null,
    status VARCHAR(20)    NOT NULL,
    type   VARCHAR(30)    NOT NULL,
    created_at   DATETIME    NOT NULL,
    created_by   VARCHAR(30)    NOT NULL,
    updated_at   DATETIME    NOT NULL,
    updated_by   VARCHAR(30)    NOT NULL
);
CREATE INDEX idx_user_id_mall_no_transfer_message_id_proceed_end_date on transfer_message_history (user_id, mall_no, transfer_message_id, proceed_end_date);

