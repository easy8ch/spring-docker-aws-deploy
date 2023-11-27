INSERT INTO member (login_id, password, name) VALUES ('easy','1234','kim');
INSERT INTO member (login_id, password, name) VALUES ('easy2','1234','choi');
INSERT INTO member (login_id, password, name) VALUES ('easy3','1234','song');
INSERT INTO member (login_id, password, name) VALUES ('easy4','1234','lee');

INSERT INTO settlement (name) VALUES ('testSettlement1');
INSERT INTO settlement (name) VALUES ('testSettlement2');
INSERT INTO settlement (name) VALUES ('testSettlement3');
INSERT INTO settlement (name) VALUES ('testSettlement4');

INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (1, 1);
INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (1, 2);

INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (2, 1);
INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (2, 2);
INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (2, 3);
INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (2, 4);

INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (3, 1);
INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (3, 2);
INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (3, 3);
INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (3, 4);

INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (4, 1);
INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (4, 2);
INSERT INTO SETTLEMENT_PARTICIPANT (SETTLEMENT_ID, MEMBER_ID ) VALUES (4, 3);

INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('train', 1, 1, 80000, CURRENT_TIMESTAMP());
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('hotel', 1, 2, 200000, CURRENT_TIMESTAMP());
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('dinner', 1, 1, 50000, CURRENT_TIMESTAMP());

INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('train', 2, 1, 150000, CURRENT_TIMESTAMP());
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('hotel', 2, 2, 30000, CURRENT_TIMESTAMP());
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('dinner', 2, 1, 80000, CURRENT_TIMESTAMP());
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('dinner', 2, 4, 80000, CURRENT_TIMESTAMP());

INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('train', 3, 1, 100000, CURRENT_TIMESTAMP());
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('hotel', 3, 2, 100000, CURRENT_TIMESTAMP());
INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('hotel', 3, 2, 200000, CURRENT_TIMESTAMP());

INSERT INTO expense (name, settlement_id, payer_member_id, amount, expense_date_time) VALUES ('chicken', 4, 1, 100, CURRENT_TIMESTAMP());
