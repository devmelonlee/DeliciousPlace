INSERT INTO `user` (`id`, `role`, `activation`, `email`, `password`, `name`, `birthdate`, `gender`, `file_id`, `created_at`, `updated_at`)
VALUES
(1, 'user', 'Y', 'aaa@test.com', 'hashed_password_1', 'user1', '1990-01-15', 'M', NULL,
'2023-08-28 12:34:56', '2023-08-28 12:34:56'),
(2, 'admin', 'Y', 'admin@example.com', 'hashed_password_2', 'admin1', '1985-05-22', 'F', NULL, '2023-08-28 12:34:56', '2023-08-28 12:34:56'),
(3, 'user', 'N', 'user2@example.com', 'hashed_password_3', 'user2', '1995-09-08', 'M', NULL, '2023-08-28 12:34:56', '2023-08-28 12:34:56'),
(4, 'user', 'Y', 'user3@example.com', 'hashed_password_4', 'user3', '1988-03-30', 'F', NULL, '2023-08-28 12:34:56', '2023-08-28 12:34:56');
