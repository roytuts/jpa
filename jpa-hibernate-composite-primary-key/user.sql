
CREATE TABLE IF NOT EXISTS `user` (
  `id` int unsigned NOT NULL,
  `first_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`last_name`,`first_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


INSERT INTO `user` (`id`, `first_name`, `last_name`) VALUES
	(0, 'First', 'Last'),
	(3, 'Arup', 'Roy'),
	(1, 'Soumitra', 'Roy'),
	(2, 'Liton', 'Sarkar'),
	(2, 'Liton', 'Sarkr');
