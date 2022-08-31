SET FOREIGN_KEY_CHECKS=0;

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "신한카드", "신한", "10000", "신용", "매일매일 할인 좋아", "0.3 1.0", "10만원 당 5천 머니", "5만원 당 3천원", "7만원 당 2천 머니", "100", "주부 그림/운동 30대");

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "국민카드", "국민", "10000", "체크", "매일매일 할인 안좋아", "0.3 2.0", "10만원 당 5천 머니", "5만원 당 3천원", "7만원 당 2천 머니", "100", "직장인 그림/운동 30대");

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "농협카드", "농협", "10000", "체크", "매일매일 할인 개좋아", "0.3 1.0", "10만원 당 5천 머니", "5만원 당 3천원", "7만원 당 2천 머니", "100", "무직 그림/운동 30대");

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "우리카드", "우리", "10000", "신용", "매일매일 할인 넘나좋아", "0.3 1.0", "10만원 당 5천 머니", "5만원 당 3천원", "7만원 당 2천 머니", "100", "주부 그림/운동 30대");

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "기업카드", "기업", "10000", "신용", "매일매일 할인 좋아", "0.3 1.0", "10만원 당 5천 머니", "5만원 당 3천원", "7만원 당 2천 머니", "100", "주부 그림/운동 30대");

INSERT INTO loan (PRODUCT_TYPE, LOAN_NAME, LOAN_COMPANY, CREDIT_LINE, RATE, PRIME_RATE, PERIOD, LOAN_LINE, TAG, IMG)
VALUES ("대출", "보험계약대출", "교보생명", "2000", "2.82 10.5", false, 3, "50 95", "직장인 모바일 2금융권", "https://cdn.banksalad.com/graphic/color/logo/circle/kyobo.png");

INSERT INTO loan (PRODUCT_TYPE, LOAN_NAME, LOAN_COMPANY, CREDIT_LINE, RATE, PRIME_RATE, PERIOD, LOAN_LINE, TAG, IMG)
VALUES ("대출", "IM직장인 간편신용대출", "대구은행", "7000", "3.29 6.83", false, 1, "50 90", "주부 모바일 1금융권", "https://cdn.banksalad.com/graphic/color/logo/circle/dgb.png");

INSERT INTO loan (PRODUCT_TYPE, LOAN_NAME, LOAN_COMPANY, CREDIT_LINE, RATE, PRIME_RATE, PERIOD, LOAN_LINE, TAG, IMG)
VALUES ("대출", "ONE신용대출", "부산은행", "4000", "3.4 11.25", false, 2, "50 90", "직장인 모바일 1금융권", "https://cdn.banksalad.com/graphic/color/logo/circle/bnk.png");

INSERT INTO loan (PRODUCT_TYPE, LOAN_NAME, LOAN_COMPANY, CREDIT_LINE, RATE, PRIME_RATE, PERIOD, LOAN_LINE, TAG, IMG)
VALUES ("대출", "JB 탄탄대로 사업자대출", "전북은행", "5000", "7.5 13.8", false, 5, "50 90", "무직 모바일 2금융권", "https://cdn.banksalad.com/graphic/color/logo/circle/knj.png");

INSERT INTO loan (PRODUCT_TYPE, LOAN_NAME, LOAN_COMPANY, CREDIT_LINE, RATE, PRIME_RATE, PERIOD, LOAN_LINE, TAG, IMG)
VALUES ("대출", "FI신용대출", "다올저축은행", "1000", "5.9 19.9", false, 3, "50 90", "주부 모바일 2금융권", "https://cdn.banksalad.com/graphic/color/logo/circle/daol.png");

