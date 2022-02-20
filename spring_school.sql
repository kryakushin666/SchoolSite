-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Фев 20 2022 г., 23:44
-- Версия сервера: 8.0.24
-- Версия PHP: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `spring_school`
--

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(15);

-- --------------------------------------------------------

--
-- Структура таблицы `post`
--

CREATE TABLE `post` (
  `id` bigint NOT NULL,
  `anons` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `full_text` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `views` int NOT NULL,
  `url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `post`
--

INSERT INTO `post` (`id`, `anons`, `date`, `full_text`, `title`, `type`, `views`, `url`) VALUES
(1, 'Within the framework of the events \"Blockade bread\" 4 \"B\" and 2\"A\" classes took part in the master class \"Fireflies of memory\".', '27 January', 'Within the framework of the events \"Blockade bread\" 4 \"B\" and 2\"A\" classes took part in the master class \"Fireflies of memory\".\r\n\r\nThe blockade \"firefly\" – phosphorescent small badges that were attached to clothes and helped residents of besieged Leningrad to move around the city, plunged into complete darkness during the Great Patriotic War. They were not visible from the air and did not attract the attention of enemy aircraft.\r\nThe children successfully coped with the production of \"fireflies\", learned about the life of people during the siege of Leningrad and received certificates of participants of the action \"Blockade bread', '\"Memory Fireflies\"', NULL, 0, 'https://sun9-59.userapi.com/impg/jE87F_vBAUkwfA43rUzFDjbL3uTlmA4imOYCrA/Xw2ZpGJ_7Po.jpg?size=1280x1280&quality=96&sign=acab265ac737a71c9b1bdcab3d5d18b2&type=album'),
(2, 'February 15 is the International Day of Children with Cancer. This date has been celebrated annually since 2003.', '15 February', 'February 15 is the International Day of Children with Cancer. This date has been celebrated annually since 2003.\r\n\r\nThe golden ribbon is a symbol of the fight against childhood oncological diseases. It reminds us how priceless the health of our children is.\r\nAt 8 \"A\" today there was a class hour on the topic: \"Mercy. Do good.\"\r\nThe volunteer squad \"Iskra\" took part in the \"Golden Ribbon\" campaign. The guys distributed brochures and ribbons to passers-by to draw attention to this problem.\r\n\r\nThe golden ribbon is a symbol of the fight against childhood oncological diseases. It reminds us how priceless the health of our children is.\r\nAt 8 \"A\" today there was a class hour on the topic: \"Mercy. Do good.\"\r\nThe volunteer squad \"Iskra\" took part in the \"Golden Ribbon\" campaign. The guys distributed brochures and ribbons to passers-by to draw attention to this problem.', 'International Day of Children with Cancer', 'Мир', 0, 'https://sun9-4.userapi.com/impg/tfxpJhnxrM4tR11rIF4dDxqyqCwvTlcKTPdjiw/N21DvIZM5sE.jpg?size=2560x1707&quality=95&sign=fede032bd25bd34db266800540c4a532&type=album'),
(3, '​The competition is held for students of classes 1 - 11 according to the schedule. Teams of boys from each class participate in the competition. In each parallel, the winning team is revealed.​', '18 February', '​The competition is held for students of classes 1 - 11 according to the schedule. Teams of boys from each class participate in the competition. In each parallel, the winning team is revealed.​', 'The competition \"Come on, young men!\". The competition \"Come on, boys!\"', 'Мир', 0, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
