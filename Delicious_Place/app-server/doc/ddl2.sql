
Table "user" {
  "id" INTEGER [pk, not null, note: '유저번호']
  "role" VARCHAR(50) [not null, note: '권한']
  "activation" CHAR(1) [not null, note: '활성화 여부']
  "email" VARCHAR(40) [not null, note: '이메일']
  "password" VARCHAR(30) [not null, note: '비밀번호']
  "name" VARCHAR(50) [not null, note: '아이디']
  "birthdate" DATE [not null, note: '생년월일']
  "gender" CHAR(1) [not null, note: '성별']
  "created_at" DATETIME [not null, note: '생성일시']
  "updated_at" DATETIME [not null, note: '수정일시']

Indexes {
  email [unique, name: "UIX_user"]
}
  Note: '유저'
}

Table "post_review" {
  "id" INTEGER [pk, not null, note: 'id']
  "post_id" INTEGER [note: '게시글 번호']
  "restaurant_id" INTEGER [note: '음식점 번호']
  "has_receipt" CHAR(1) [note: '영수증여부']
  "star_raiting" INTEGER [not null, note: '별점']
  "created_at" DATETIME [not null, note: '생성일']
  Note: '게시글_리뷰'
}

Table "post_comment" {
  "id" INTEGER [pk, not null, note: '댓글번호']
  "post_id" INTEGER [note: '게시글 번호']
  "user_id" INTEGER [note: '유저번호(글쓴이)']
  "content" MEDIUMTEXT [not null, note: '내용']
  "created_at" DATETIME [not null, note: '생성일시']
  Note: '게시글_댓글'
}

Table "post" {
  "id" INTEGER [pk, not null, note: '게시글 번호']
  "user_id" INTEGER [not null, note: '유저번호']
  "title" VARCHAR(255) [not null, note: '제목']
  "content" MEDIUMTEXT [not null, note: '내용']
  "view_count" INTEGER [not null, note: '조회수']
  "category" INTEGER [not null, note: '카테고리']
  "created_at" DATETIME [not null, note: '생성일시']
  "updated_at" DATETIME [not null, note: '수정일시']
  Note: '게시글'
}

Table "restaurant" {
  "id" INTEGER [pk, not null, note: '음식점 번호']
  "name" VARCHAR(50) [not null, note: '음식점 이름']
  "addr" VARCHAR(255) [note: '주소']
  "tel" VARCHAR(30) [note: '전화번호']
  "restaurant_type_id" INTEGER [note: '음식점 종류 코드']
  "menu_id" INTEGER [note: '메뉴 번호']
  "file_id" INTEGER [note: '주소 이미지 파일 ID']
  Note: '음식점'
}

Table "like_list" {
  "post_id" INTEGER [not null, note: '게시글 번호']
  "user_id" INTEGER [not null, note: '유저번호']

Indexes {
  (post_id, user_id) [pk]
}
  Note: '좋아요'
}

Table "restaurant_type" {
  "id" INTEGER [pk, not null, note: '음식점 종류 코드']
  "category" INTEGER [not null, note: '음식점 종류']
  Note: '음식점 종류'
}

Table "restaurant_menu" {
  "id" INTEGER [pk, not null, note: '메뉴 번호']
  "menu" VARCHAR(50) [not null, note: '메뉴명']
  "menu_price" INTEGER [note: '가격']
  Note: '음식점_메뉴'
}

Table "gather" {
  "id" INTEGER [pk, not null, note: '모임번호']
  "restaruant_id" INTEGER [not null, note: '음식점 번호']
  "desired_attendees" INTEGER [not null, note: '참석 인원수']
  "appointment_time" DATETIME [not null, note: '약속 시간']
  Note: '게더(모임)'
}

Table "file_menu_resource" {
  "id" INTEGER [pk, not null, note: '메뉴사진번호']
  "menu_id" INTEGER [not null, note: '메뉴 번호']
  "file_id" INTEGER [not null, note: '파일ID']
  Note: '메뉴파일Resource'
}

Table "gather_list" {
  "user_id" INTEGER [not null, note: '유저번호']
  "gather_id" INTEGER [not null, note: '모임번호']

Indexes {
  (user_id, gather_id) [pk]
}
  Note: '게더(모임)_참가한 인원'
}

Table "file_common" {
  "id" INTEGER [pk, not null, note: 'ID']
  "file_type" VARCHAR(10) [not null, note: '파일타입(Image, zip)']
  "file_path" VARCHAR(255) [not null, note: 'Path']
  "file_category" VARCHAR(255) [note: '사용처(리뷰, 메뉴, 레스토랑)']
  "original_name" VARCHAR(255) [not null, note: '원본파일명']
  "save_name" VARCHAR(255) [note: '변경파일명']
  "is_temp" CHAR(1) [note: '임시저장유무']
  "temp_save_date" DATETIME [note: '임시저장기한']
  "created_at" DATETIME [note: '파일생성일']
  "user_id" INTEGER [not null, note: '유저번호']

Indexes {
  file_type [unique, name: "UIX_file_common"]
}
  Note: '파일공통'
}

Table "file_review_resource" {
  "id" INTEGER [pk, not null, note: 'ID']
  "review_id" INTEGER [not null, note: '리뷰ID']
  "file_id" INTEGER [not null, note: '파일ID']
  Note: '리뷰파일Resource'
}

Table "path_common" {
  "id" INTEGER [pk, not null, note: 'ID']
  "use" VARCHAR(255) [not null, note: '사용처']
  "fix_path" VARCHAR(255) [not null, note: '고정경로']
  Note: '공통패스'
}

Ref:"restaurant"."id" < "post_review"."restaurant_id"

Ref:"post"."id" < "post_review"."post_id"

Ref:"user"."id" < "post_comment"."user_id"

Ref:"post"."id" < "post_comment"."post_id"

Ref:"user"."id" < "post"."user_id"

Ref:"restaurant_type"."id" < "restaurant"."restaurant_type_id"

Ref:"restaurant_menu"."id" < "restaurant"."menu_id"

Ref:"file_common"."id" < "restaurant"."file_id"

Ref:"post"."id" < "like_list"."post_id"

Ref:"user"."id" < "like_list"."user_id"

Ref:"post"."id" < "gather"."id"

Ref:"restaurant"."id" < "gather"."restaruant_id"

Ref:"restaurant_menu"."id" < "file_menu_resource"."menu_id"

Ref:"file_common"."id" < "file_menu_resource"."file_id"

Ref:"user"."id" < "gather_list"."user_id"

Ref:"gather"."id" < "gather_list"."gather_id"

Ref:"user"."id" < "file_common"."user_id"

Ref:"post_review"."id" < "file_review_resource"."review_id"

Ref:"file_common"."id" < "file_review_resource"."file_id"
