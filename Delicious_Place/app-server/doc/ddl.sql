CREATE TABLE `user` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT '유저번호',
  `role` VARCHAR(50) NOT NULL COMMENT '권한',
  `activation` CHAR(1) NOT NULL COMMENT '활성화 여부',
  `email` VARCHAR(40) NOT NULL COMMENT '이메일',
  `password` VARCHAR(30) NOT NULL COMMENT '비밀번호',
  `name` VARCHAR(50) NOT NULL COMMENT '아이디',
  `birthdate` DATE NOT NULL COMMENT '생년월일',
  `gender` CHAR(1) NOT NULL COMMENT '성별',
  `file_id` INTEGER COMMENT '유저 이미지 파일 ID',
  `created_at` DATETIME NOT NULL DEFAULT (now()) COMMENT '생성일시',
  `updated_at` DATETIME NOT NULL COMMENT '수정일시'
);

CREATE TABLE `post_review` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT 'id',
  `post_id` INTEGER COMMENT '게시글 번호',
  `restaurant_id` INTEGER COMMENT '음식점 번호',
  `has_receipt` CHAR(1) DEFAULT "N" COMMENT '영수증여부',
  `star_raiting` INTEGER NOT NULL COMMENT '별점'
);

CREATE TABLE `post_comment` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT '댓글번호',
  `post_id` INTEGER COMMENT '게시글 번호',
  `user_id` INTEGER COMMENT '유저번호(글쓴이)',
  `content` MEDIUMTEXT NOT NULL COMMENT '내용',
  `created_at` DATETIME NOT NULL DEFAULT (now()) COMMENT '생성일시',
  `updated_at` DATETIME NOT NULL COMMENT '수정일시'
);

CREATE TABLE `post` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT '게시글 번호',
  `user_id` INTEGER NOT NULL COMMENT '유저번호',
  `title` VARCHAR(255) NOT NULL COMMENT '제목',
  `content` MEDIUMTEXT NOT NULL COMMENT '내용',
  `view_count` INTEGER NOT NULL COMMENT '조회수',
  `category` INTEGER NOT NULL COMMENT '카테고리',
  `created_at` DATETIME NOT NULL DEFAULT (now()) COMMENT '생성일시',
  `updated_at` DATETIME NOT NULL COMMENT '수정일시'
);

CREATE TABLE `restaurant` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT '음식점 번호',
  `name` VARCHAR(50) NOT NULL COMMENT '음식점 이름',
  `addr` VARCHAR(255) COMMENT '주소',
  `tel` VARCHAR(30) COMMENT '전화번호',
  `restaurant_type_id` INTEGER COMMENT '음식점 종류 코드',
  `menu_id` INTEGER COMMENT '메뉴 번호',
  `file_id` INTEGER COMMENT '주소 이미지 파일 ID'
);

CREATE TABLE `like_list` (
  `post_id` INTEGER NOT NULL COMMENT '게시글 번호',
  `user_id` INTEGER NOT NULL COMMENT '유저번호',
  PRIMARY KEY (`post_id`, `user_id`)
);

CREATE TABLE `restaurant_type` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT '음식점 종류 코드',
  `category` INTEGER NOT NULL COMMENT '음식점 종류'
);

CREATE TABLE `restaurant_menu` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT '메뉴 번호',
  `menu` VARCHAR(50) NOT NULL COMMENT '메뉴명',
  `menu_price` INTEGER COMMENT '가격'
);

CREATE TABLE `post_gather` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT '모임번호',
  `restaruant_id` INTEGER NOT NULL COMMENT '음식점 번호',
  `desired_attendees` INTEGER NOT NULL COMMENT '참석 인원수',
  `appointment_time` DATETIME NOT NULL COMMENT '약속 시간'
);

CREATE TABLE `file_menu_resource` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT '메뉴사진번호',
  `menu_id` INTEGER NOT NULL COMMENT '메뉴 번호',
  `file_id` INTEGER NOT NULL COMMENT '파일ID'
);

CREATE TABLE `gather_list` (
  `user_id` INTEGER NOT NULL COMMENT '유저번호',
  `gather_id` INTEGER NOT NULL COMMENT '모임번호',
  PRIMARY KEY (`user_id`, `gather_id`)
);

CREATE TABLE `file_common` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT 'ID',
  `file_type` VARCHAR(10) NOT NULL COMMENT '파일타입(Image, zip)',
  `file_path` VARCHAR(255) NOT NULL COMMENT 'Path',
  `file_category` VARCHAR(255) COMMENT '사용처(리뷰, 메뉴, 레스토랑)',
  `original_name` VARCHAR(255) NOT NULL COMMENT '원본파일명',
  `save_name` VARCHAR(255) COMMENT '변경파일명',
  `is_temp` CHAR(1) DEFAULT "N" COMMENT '임시저장유무',
  `temp_save_date` DATETIME COMMENT '임시저장기한',
  `created_at` DATETIME COMMENT '파일생성일',
  `user_id` INTEGER NOT NULL COMMENT '유저번호'
);

CREATE TABLE `file_review_resource` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT 'ID',
  `review_id` INTEGER NOT NULL COMMENT '리뷰ID',
  `file_id` INTEGER NOT NULL COMMENT '파일ID'
);

CREATE TABLE `path_common` (
  `id` INTEGER PRIMARY KEY NOT NULL COMMENT 'ID',
  `use` VARCHAR(255) NOT NULL COMMENT '사용처',
  `fix_path` VARCHAR(255) NOT NULL COMMENT '고정경로'
);

CREATE UNIQUE INDEX `UIX_user` ON `user` (`email`);

CREATE UNIQUE INDEX `UIX_file_common` ON `file_common` (`file_type`);

ALTER TABLE `user` COMMENT = '유저';

ALTER TABLE `post_review` COMMENT = '게시글_리뷰';

ALTER TABLE `post_comment` COMMENT = '게시글_댓글';

ALTER TABLE `post` COMMENT = '게시글';

ALTER TABLE `restaurant` COMMENT = '음식점';

ALTER TABLE `like_list` COMMENT = '좋아요';

ALTER TABLE `restaurant_type` COMMENT = '음식점 종류';

ALTER TABLE `restaurant_menu` COMMENT = '음식점_메뉴';

ALTER TABLE `post_gather` COMMENT = '게더(모임)';

ALTER TABLE `file_menu_resource` COMMENT = '메뉴파일Resource';

ALTER TABLE `gather_list` COMMENT = '게더(모임)_참가한 인원';

ALTER TABLE `file_common` COMMENT = '파일공통';

ALTER TABLE `file_review_resource` COMMENT = '리뷰파일Resource';

ALTER TABLE `path_common` COMMENT = '공통패스';

ALTER TABLE `post_review` ADD FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`);

ALTER TABLE `post_review` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

ALTER TABLE `post_comment` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `post_comment` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

ALTER TABLE `post` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `restaurant` ADD FOREIGN KEY (`restaurant_type_id`) REFERENCES `restaurant_type` (`id`);

ALTER TABLE `restaurant` ADD FOREIGN KEY (`menu_id`) REFERENCES `restaurant_menu` (`id`);

ALTER TABLE `user` ADD FOREIGN KEY (`file_id`) REFERENCES `file_common` (`id`);

ALTER TABLE `restaurant` ADD FOREIGN KEY (`file_id`) REFERENCES `file_common` (`id`);

ALTER TABLE `like_list` ADD FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

ALTER TABLE `like_list` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `post_gather` ADD FOREIGN KEY (`id`) REFERENCES `post` (`id`);

ALTER TABLE `post_gather` ADD FOREIGN KEY (`restaruant_id`) REFERENCES `restaurant` (`id`);

ALTER TABLE `file_menu_resource` ADD FOREIGN KEY (`menu_id`) REFERENCES `restaurant_menu` (`id`);

ALTER TABLE `file_menu_resource` ADD FOREIGN KEY (`file_id`) REFERENCES `file_common` (`id`);

ALTER TABLE `gather_list` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `gather_list` ADD FOREIGN KEY (`gather_id`) REFERENCES `post_gather` (`id`);

ALTER TABLE `file_common` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `file_review_resource` ADD FOREIGN KEY (`review_id`) REFERENCES `post_review` (`id`);

ALTER TABLE `file_review_resource` ADD FOREIGN KEY (`file_id`) REFERENCES `file_common` (`id`);
