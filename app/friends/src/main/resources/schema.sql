
DROP TABLE IF EXISTS payment_detail;

-- 결제 정보
CREATE TABLE payment_detail (
    id    bigint   auto_increment primary key,
    user_id   VARCHAR(20)    NOT NULL,
    mallNo   bigint    NOT NULL,
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
CREATE INDEX idx_user_id_mall_no_payment_at on payment_detail (user_id, mallNo, payment_at);