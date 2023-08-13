-- dp_user 테이블에 샘플 데이터 삽입
INSERT INTO dp_user (role, email, password, gender, created_at, updated_at)
VALUES
    ('ADMIN', 'admin@test.com', SHA2('adminpass', 256), 'MALE', NOW(), NOW()),
    ('USER', 'user1@test.com', SHA2('userpass1', 256), 'FEMALE', NOW(), NOW()),
    ('USER', 'user2@test.com', SHA2('userpass2', 256), 'MALE', NOW(), NOW()),
    ('USER', 'user3@test.com', SHA2('userpass3', 256), 'FEMALE', NOW(), NOW()),
    ('USER', 'user4@test.com', SHA2('userpass4', 256), 'MALE', NOW(), NOW()),
    ('USER', 'user5@test.com', SHA2('userpass5', 256), 'FEMALE', NOW(), NOW()),
    ('USER', 'user6@test.com', SHA2('userpass6', 256), 'MALE', NOW(), NOW()),
    ('USER', 'user7@test.com', SHA2('userpass7', 256), 'FEMALE', NOW(), NOW()),
    ('USER', 'user8@test.com', SHA2('userpass8', 256), 'MALE', NOW(), NOW()),
    ('USER', 'user9@test.com', SHA2('userpass9', 256), 'FEMALE', NOW(), NOW());

-- dp_content 테이블에 샘플 데이터 삽입
INSERT INTO dp_content (store_name, contents, eat_Menu, has_receipt, star_rating, like_button, view_count, created_at, author_id)
VALUES
    ('레스토랑 A', '맛있는 음식!', '피자', 1, 4, 0, 10, NOW(), 2),
    ('카페 B', '좋은 커피가 있는 곳.', '라떼', 1, 5, 0, 150, NOW(), 3),
    ('베이커리 C', '신선한 빵과 페이스트리.', '크로와상', 1, 4, 0, 120, NOW(), 4),
    ('레스토랑 D', '환상적인 분위기와 음식.', '스테이크', 1, 5, 0, 200, NOW(), 2),
    ('레스토랑 E', '퀄리티 높은 해산물 요리.', '초밥', 1, 4, 0, 180, NOW(), 5),
    ('카페 F', '친구들과 함께하는 아늑한 시간.', '아메리카노', 1, 4, 0, 120, NOW(), 6),
    ('한식 레스토랑 G', '전통 한식 요리.', '비빔밥', 1, 4, 0, 90, NOW(), 2),
    ('피자 전문점 H', '다양한 피자 메뉴.', '페퍼로니 피자', 1, 4, 0, 110, NOW(), 3),
    ('카페 I', '커피와 디저트를 함께.', '카페라떼', 1, 4, 0, 130, NOW(), 5),
    ('이탈리안 레스토랑 J', '정통 이탈리안 요리.', '파스타', 1, 5, 0, 170, NOW(), 4);

-- dp_gather 테이블에 샘플 데이터 삽입
INSERT INTO dp_gather (post_name, store_name, content, desired_attendees, current_attendees, appointment_time, created_at, author_id)
VALUES
    ('영화 관람', '영화관 X', '함께 영화를 보러 가요!', 10, 7, '2023-08-15 18:00:00', NOW(), 3),
    ('독서 모임', '지역 도서관', '최신 소설을 읽고 이야기해요.', 8, 6, '2023-08-20 14:00:00', NOW(), 4),
    ('등산 모임', '자연 공원', '자연을 만끽하는 등산 일정.', 15, 12, '2023-08-25 09:00:00', NOW(), 2),
    ('커피 모임', '카페 Z', '가볍게 커피한잔 하면서 이야기해요.', 20, 18, '2023-08-18 10:30:00', NOW(), 5),
    ('요가 세션', '웰니스 스튜디오', '편안한 요가 수업을 함께 즐겨요.', 25, 20, '2023-08-22 17:00:00', NOW(), 3),
    ('음악 공연', '음악홀 Y', '음악을 감상하러 모이는 자리.', 30, 27, '2023-08-20 19:30:00', NOW(), 2),
    ('맛집 탐방', '맛있는 식당 Z', '다양한 음식을 맛보기로 해요.', 12, 10, '2023-08-17 13:00:00', NOW(), 4),
    ('바다 여행', '해변 리조트', '바닷가에서 힐링 여행을 떠나요.', 18, 15, '2023-08-23 08:00:00', NOW(), 5),
    ('프로그래밍 스터디', '온라인', '함께 프로그래밍 공부를 합시다.', 10, 7, '2023-08-21 15:00:00', NOW(), 2),
    ('미술 워크샵', '아트 스튜디오', '창의적인 미술 작품을 만들어요.', 15, 12, '2023-08-19 11:00:00', NOW(), 4);

-- dp_gather_comment 테이블에 샘플 데이터 삽입
INSERT INTO dp_gather_comment (post_id, user_id, content, created_at, updated_at)
VALUES
    (1, 2, '기대되네요!', NOW(), NOW()),
    (1, 3, '영화 관람 기대돼요!', NOW(), NOW()),
    (2, 4, '책 소개가 재미있어 보여요.', NOW(), NOW()),
    (3, 5, '등산 모임에 참여할래요!', NOW(), NOW()),
    (4, 2, '커피 모임에서 뵙겠습니다.', NOW(), NOW()),
    (5, 3, '요가 세션을 함께 하고 싶어요.', NOW(), NOW()),
    (6, 4, '음악 공연이 기대돼요.', NOW(), NOW()),
    (7, 5, '맛집 탐방은 언제나 즐겁죠.', NOW(), NOW()),
    (8, 2, '바다 여행이 꿈같아요.', NOW(), NOW()),
    (9, 3, '프로그래밍 스터디 함께 해요!', NOW(), NOW());
