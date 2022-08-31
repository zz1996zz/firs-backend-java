SET FOREIGN_KEY_CHECKS=0;

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "신한카드 YOLO(미니언즈)", "신한카드", "15000", "신용", "인율과 디자인을 내 마음대로!! 나의 맞춤카드를 원하신다면, “YOLO”오세요~", "2.0%", "10만원 당 5천 머니", "5만원 당 3천원", "7만원 당 2천 머니", "1000", "주부 낚시 30대", "https://cdn.banksalad.com/entities/etc/1556265601126-3858.png");

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "삼성카드 taptap O", "삼성카드", "10000", "신용", "직접 선택하는 혜택, 탭탭오 옵션형!", "0.3-2.0%", "5만원 당 2천 머니", "3만원 당 1천원", "7만원 당 2천 머니", "1000", "직장인 운동 20대", "https://cdn.banksalad.com/cards/samsung_2928.png");

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "청춘대로 톡톡카드", "KB국민카드", "12000", "신용", "Simple하게 즐기자! 혜택 톡톡!", "1.2%", "20만원 당 7천 머니", "5만원 당 3천원", "7만원 당 4천 머니", "1000", "무직 독서 40대", "https://cdn.banksalad.com/cards/kb_3350.png");

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "BC 바로 클리어 플러스", "BC 바로카드", "5000", "체크", "점심/배달앱 7% 할인, 쿠팡 10% 할인", "0.4-2.0%", "10만원 당 5천 머니", "5만원 당 2천원", "7만원 당 2천 머니", "1000", "직장인 게임 60대", "https://cdn.banksalad.com/resources/images/cards/bc_clear.png");

INSERT INTO card (PRODUCT_TYPE, CARD_NAME, CARD_COMPANY, ANNUAL_FEE, CARD_TYPE, CARD_DESCRIPTION, FRANCHISEE, SHOPPING, OILING, INSURANCE, CAFE, TAG, IMG)
VALUES ("카드", "LOCA LIKIT 1.2", "롯데카드", "10000", "체크", "모든 가맹점 1.2% 할인", "0.3-1.0%", "10만원 당 5천 머니", "5만원 당 3천원", "2만원 당 1천 머니", "1000", "주부 음악 감상 50대", "https://cdn.banksalad.com/resources/images/cards/lotte_loca_12.png");

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

