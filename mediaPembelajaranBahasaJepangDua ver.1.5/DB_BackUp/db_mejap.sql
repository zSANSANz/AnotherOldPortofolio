-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 19 Nov 2016 pada 06.07
-- Versi Server: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_mejap`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_jawaban_acak`
--

CREATE TABLE IF NOT EXISTS `tb_jawaban_acak` (
  `id_jawaban` int(11) NOT NULL,
  `id_soal` int(11) NOT NULL,
  `jawaban` text NOT NULL,
  `benar` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=182 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_jawaban_acak`
--

INSERT INTO `tb_jawaban_acak` (`id_jawaban`, `id_soal`, `jawaban`, `benar`) VALUES
(0, 3, 'hitori imasu', 0),
(6, 2, 'nananin kyoudai desu', 0),
(7, 2, 'shichinin kyoudai desu', 1),
(8, 2, 'shinin kyoudai desu', 0),
(9, 2, 'nananin kazoku desu', 0),
(10, 2, 'shichinin kazoku desu', 0),
(11, 1, 'gonin kyoudai desu           ', 0),
(12, 1, 'yonnin kyoudai desu', 0),
(13, 1, 'yonin kyoudai desu', 0),
(14, 1, 'yonnin kazoku desu', 0),
(15, 1, 'yonin kazoku desu', 1),
(16, 3, '  futari imasu', 0),
(17, 3, 'hitori imasu', 0),
(18, 3, 'hitori desu', 0),
(19, 3, 'futari imasu', 1),
(20, 4, 'sofu ga futari to sobo ga hitori imasu', 1),
(21, 4, 'chichi ga futari to haha ga hitori imasu', 0),
(22, 4, 'imouto ga futari to otouto ga hitori imasu', 0),
(23, 4, 'ane ga futari to ani ga hitori imasu', 0),
(24, 4, 'okaasan ga futari to otousan ga hitori imasu', 0),
(25, 5, 'Hitorikko   ', 1),
(26, 5, 'Futarikko', 0),
(27, 5, 'Hitori         ', 0),
(28, 5, 'Sannin        ', 0),
(29, 5, 'Futari', 0),
(30, 6, 'Doko', 0),
(31, 6, 'Nannin ', 1),
(32, 6, 'Oikutsu', 0),
(33, 6, 'Donna hito', 0),
(34, 6, 'Nansai', 0),
(35, 7, 'to, ni, ga', 0),
(36, 7, 'ni, ga, to', 0),
(37, 7, 'ga, to, ga', 1),
(38, 7, 'To, ga, to', 0),
(39, 7, 'to, ga, ni', 0),
(40, 8, 'ane ga kyuunin imasu', 0),
(41, 8, 'oneesan ga hachinin imasu', 0),
(42, 8, 'ani ga rokunin imasu', 0),
(43, 8, 'oniisan ga shichinin imasu', 0),
(44, 8, 'ani ga gonin imasu', 1),
(45, 9, 'imouto ga kyuunin imasu', 1),
(46, 9, 'imouto ga hachinin imasu', 0),
(47, 9, 'imoutosan ga rokunin imasu', 0),
(48, 9, 'otouto ga shichinin imasu', 0),
(49, 9, 'otoutosan ga gonin imasu', 0),
(50, 10, 'ojisan ga sannin to obasan ga gonin imasu', 0),
(51, 10, 'sofu ga sannin to sobo ga gonin imasu', 0),
(52, 10, 'okaasan ga rokunin to otousan ga gonin imasu', 1),
(53, 10, 'ojiisan ga gonin to obaasan ga sannin imasu', 0),
(54, 10, 'ojisan ga futari to obasan ga hitori imasu', 0),
(55, 11, 'okaasan ga sannin to otousan ga futari imasu', 0),
(56, 11, 'chichi ga sannin to haha ga ninin imasu', 0),
(57, 11, 'okaasan ga rokunin to otousan ga gonin imasu', 0),
(58, 11, 'otousan ga sannin to okaasan ga futari imasu', 0),
(59, 11, 'otoutosan ga sannin to okaasan ga futari imasu', 1),
(60, 12, 'kiteimasu', 0),
(61, 12, 'kaketeimasu', 0),
(62, 12, 'kabutteimasu', 0),
(63, 12, 'haiteimasu', 0),
(64, 12, 'shiteimasu', 1),
(65, 13, 'kiteimasu', 0),
(66, 13, 'kaketeimasu', 0),
(67, 13, 'kabutteimasu', 0),
(68, 13, 'haiteimasu', 0),
(69, 13, 'shiteimasu', 1),
(70, 14, 'kiteimasu', 0),
(71, 14, 'kaketeimasu', 0),
(72, 14, 'kabutteimasu', 0),
(73, 14, 'haiteimasu', 1),
(74, 14, 'shiteimasu', 0),
(75, 15, 'kiteimasu', 0),
(76, 15, 'kaketeimasu', 1),
(77, 15, 'kabutteimasu', 0),
(78, 15, 'haiteimasu', 0),
(79, 15, 'shiteimasu', 0),
(80, 16, 'Donna fuku', 1),
(81, 16, 'Nannin', 0),
(82, 16, 'Donna', 0),
(83, 16, 'Donna hito', 0),
(84, 16, 'Nansai', 0),
(85, 17, 'wa, to', 0),
(86, 17, 'ga, wa', 0),
(87, 17, 'ni, wa', 0),
(88, 17, 'wa, o', 1),
(89, 17, 'wa, de', 0),
(90, 18, 'Kiteimasu', 0),
(91, 18, 'Kabutteimasu', 1),
(92, 18, 'Kaketeimasu', 0),
(93, 18, 'Haiteimasu', 0),
(94, 18, 'Shiteimasu', 0),
(95, 19, 'otouto', 0),
(96, 19, 'imouto', 0),
(97, 19, 'otoutosan', 0),
(98, 19, 'imoutosan', 1),
(99, 19, 'otousan', 0),
(100, 20, 'otouto', 0),
(101, 20, 'imouto', 0),
(102, 20, 'otoutosan', 0),
(103, 20, 'imoutosan', 1),
(104, 20, 'otousan', 0),
(105, 21, 'to, ni, ga', 0),
(106, 21, 'ni, ga, to', 1),
(107, 21, 'to, ga, to', 0),
(108, 21, 'ga, to, ga', 0),
(109, 21, 'to, ga, ni', 0),
(110, 22, 'hatsuka desu', 0),
(111, 22, 'hatachi desu', 0),
(112, 22, 'nijussai desu', 0),
(113, 22, 'jussai desu', 1),
(114, 22, 'issai desu', 0),
(115, 23, 'juuhachisai des', 0),
(116, 23, 'juushichisai desu', 0),
(117, 23, 'juurokusai desu', 0),
(118, 23, 'juuhassai desu', 1),
(119, 23, 'juuissai desu', 0),
(120, 24, 'daigakusei desu', 1),
(121, 24, 'koukousei desu', 0),
(122, 24, 'shougakusei desu', 0),
(123, 24, 'chuugakusei desu', 0),
(124, 24, 'seito desu', 0),
(125, 25, 'kissaten ga yatteimasu', 0),
(126, 25, 'resutoran to yatteimasu', 0),
(127, 25, 'mise o yatteimasu', 1),
(128, 25, 'kissaten o yatteimasu', 0),
(129, 25, 'mise ga yatteimasu', 0),
(130, 26, 'donna fuku', 0),
(131, 26, 'nannin', 0),
(132, 26, 'nankai', 0),
(133, 26, 'donna hito', 0),
(134, 26, 'nansai', 1),
(135, 27, 'kaishain', 0),
(136, 27, 'gunjin', 0),
(137, 27, 'Koumuin', 1),
(138, 27, 'enjinia', 0),
(139, 27, 'ginkouin', 0),
(140, 28, 'to   ', 0),
(141, 28, 'ga', 0),
(142, 28, 'ni', 0),
(143, 28, 'o', 1),
(144, 28, 'de', 0),
(145, 29, 'ane wa kami ga mijikai desu', 1),
(146, 29, 'ane wa kami ga nagai desu', 0),
(147, 29, 'ani wa se ga takai desu', 0),
(148, 29, 'ani wa se ga hikui desu', 0),
(149, 29, 'ani wa yaseteimasu', 0),
(150, 30, 'yaseteimasu desu', 0),
(151, 30, 'futotteimasu desu', 0),
(152, 30, 'yasashii desu', 0),
(153, 30, 'futotteimasu', 1),
(154, 30, 'yaseteimasu', 0),
(155, 31, 'ane wa kami ga mijikai desu', 0),
(156, 31, 'ane wa kami ga nagai desu', 1),
(157, 31, 'ani wa se ga takai desu', 0),
(158, 31, 'ani wa se ga hikui desu', 0),
(159, 31, 'ani wa yaseteimasu', 0),
(160, 32, 'majime desu', 0),
(161, 32, 'yasashii desu', 0),
(162, 32, 'kawaii desu', 0),
(163, 32, 'kirei desu', 1),
(164, 32, 'kibishii desu', 0),
(165, 33, 'donna fuku', 0),
(166, 33, 'nannin', 0),
(167, 33, 'nankai', 0),
(168, 33, 'donna hito', 1),
(169, 33, 'nansai', 0),
(170, 34, 'to', 0),
(171, 34, 'ga', 1),
(172, 34, 'ni', 0),
(173, 34, 'o', 0),
(174, 34, 'de', 0),
(175, 35, 'to   ', 1),
(176, 35, 'ga   ', 0),
(177, 35, 'ni    ', 0),
(178, 35, 'o     ', 0),
(179, 35, 'de', 0),
(180, 36, '  jawaban a atau 1', 0),
(181, 36, '  jawaban b atau 2', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_login`
--

CREATE TABLE IF NOT EXISTS `tb_login` (
  `username` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `hakakses` varchar(25) NOT NULL,
  `nilai_materi_satu` int(11) NOT NULL,
  `nilai_materi_dua` int(11) NOT NULL,
  `nilai_materi_tiga` int(11) NOT NULL,
  `nilai_materi_empat` int(11) NOT NULL,
  `nilai_evaluasi` int(11) NOT NULL,
  `point` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_login`
--

INSERT INTO `tb_login` (`username`, `password`, `hakakses`, `nilai_materi_satu`, `nilai_materi_dua`, `nilai_materi_tiga`, `nilai_materi_empat`, `nilai_evaluasi`, `point`) VALUES
('adam', '1d7c2923c1684726dc23d2901c4d8157', 'siswa', 0, 0, 0, 0, 0, 1),
('admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 0, 0, 0, 0, 0, 1),
('ervan', '827ccb0eea8a706c4c34a16891f84e7b', 'siswa', 0, 0, 0, 0, 0, 1),
('ervanis', '81dc9bdb52d04dc20036dbd8313ed055', 'siswa', 0, 0, 0, 0, 0, 1),
('nurul', '6968a2c57c3a4fee8fadc79a80355e4d', 'siswa', 0, 0, 0, 0, 0, 0),
('putra', '5e0c5a0bf82decdd43b2150b622c66c5', 'siswa', 0, 0, 0, 0, 0, 0),
('susanto', '5c06181e1485af4fc4051d2c5aa0caba', 'siswa', 0, 0, 0, 0, 0, 0),
('utomo', 'e7c55751812cb7fdd484372896b49d0d', 'siswa', 0, 0, 0, 0, 0, 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_nilai`
--

CREATE TABLE IF NOT EXISTS `tb_nilai` (
  `id` int(11) NOT NULL,
  `nilai` int(11) NOT NULL,
  `materi` int(11) NOT NULL,
  `username` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_nilai`
--

INSERT INTO `tb_nilai` (`id`, `nilai`, `materi`, `username`) VALUES
(1, 0, 0, 'utomo'),
(2, 0, 0, 'utomo'),
(3, 0, 0, 'utomo'),
(4, 0, 0, 'utomo'),
(5, 0, 0, 'putra'),
(6, 0, 0, 'putra'),
(7, 50, 0, 'admin'),
(8, 95, 0, 'admin'),
(9, 35, 0, 'admin'),
(10, 0, 0, 'admin'),
(11, 5, 0, 'admin'),
(12, 10, 0, 'admin'),
(13, 0, 0, 'nurul'),
(14, 100, 0, 'admin'),
(15, 15, 0, 'admin'),
(16, 0, 0, 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_soal`
--

CREATE TABLE IF NOT EXISTS `tb_soal` (
  `id_soal` int(11) NOT NULL,
  `deskripsi_soal` varchar(255) NOT NULL,
  `gambar_soal` varchar(255) NOT NULL,
  `pilihan_a` varchar(255) NOT NULL,
  `pilihan_b` varchar(255) NOT NULL,
  `pilihan_c` varchar(255) NOT NULL,
  `pilihan_d` varchar(255) NOT NULL,
  `pilihan_e` varchar(255) NOT NULL,
  `jawaban_soal` varchar(10) NOT NULL,
  `tipe_soal` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_soal_acak`
--

CREATE TABLE IF NOT EXISTS `tb_soal_acak` (
  `id_soal` int(11) NOT NULL,
  `soal` text NOT NULL,
  `id_gambar` int(4) DEFAULT NULL,
  `id_materi` int(4) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_soal_acak`
--

INSERT INTO `tb_soal_acak` (`id_soal`, `soal`, `id_gambar`, `id_materi`) VALUES
(1, '“Saya adalah 4 orang keluarga”, terjemahan kalimat tersebut yang benar adalah Watashi wa ... .', NULL, 1),
(2, '“Saya adalah 7 orang saudara”, terjemahan kalimat tersebut yang benar adalah watashi wa … .', NULL, 1),
(3, 'Saya mempunyai 2 orang kakak laki-laki\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah Watashi wa ane ga … .', NULL, 1),
(4, 'Saya mempunyai 2 orang kakek dan 1 orang nenek\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah Watashi wa … .', NULL, 1),
(5, 'Watashi wa??????desu. (Anak Tunggal)', NULL, 1),
(6, '  ??????Kyoudai desuka. (berapa orang)', NULL, 1),
(7, 'Watashi wa ane  ???gonin????sobo???juunin imasu.', NULL, 1),
(8, 'Sakurasan mempunyai 7 orang kakak laki-laki\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah Sakurasan wa … .', NULL, 1),
(9, 'Yamadasan mempunyai 5 orang adik laki-laki\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah Yamadasan wa … .', NULL, 1),
(10, 'Sakakisan mempunyai 5 orang bapak dan 6 orang ibu\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah Sakakisan wa … .', NULL, 1),
(11, 'Makiosan mempunyai 2 orang bapak dan 3 orang ibu Terjemahan bahasa Jepang kalimat di atas yang benar adalah makiosan wa … .', NULL, 1),
(12, 'Nenek(saya) memakai jilbab, Terjemahan kalimat yang benar adalah sobo wa jirubabu o … .', NULL, 1),
(13, 'Kakek(saya) memakai dasi, Terjemahan kalimat tersebut yang benar adalah sofu wa nekutai o … .', NULL, 1),
(14, 'Ibu(saya) Memakai sandal, Terjemahan bahasa Jepang kalimat tersebut yang benar adalah Haha wa sandaru o … .', NULL, 1),
(15, 'Adik Laki-laki(saya) Memakai kacamata\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah Otouto wa megane o … .', NULL, 1),
(16, 'Oniisan wa???????o kiteimasuka?(pakaian yang bagaimana)', NULL, 1),
(17, ' Ane????Shatsu???kiteimasu?', NULL, 1),
(18, 'Haha wa boushi o ????????', NULL, 1),
(19, 'Yukisan wa??????ga Hitori imasu. (Adik perempuan)', NULL, 1),
(20, 'Narutosan wa??????ga Futari imasu. (Adik Laki-laki)', NULL, 1),
(21, 'Sakurasan wa oniisan   ??  rokunin  ??  oneesan  ??  sannin imasu.\r\nSakurasan wa oniisan   ??  rokunin  ??  oneesan  ??  sannin imasu.\r\n', NULL, 1),
(22, '“Saya adalah umur 20”, terjemahan kalimat tersebut yang benar adalah watashi wa … .', NULL, 1),
(23, '“Hikarisan adalah umur 18”, terjemahan kalimat tersebut yang benar adalah Hikarisan wa … .', NULL, 1),
(24, '“Kakek (saya) adalah mahasiswa”, terjemahan kalimat tersebut yang benar adalah Sofu wa ... .', NULL, 1),
(25, '“Nenek (saya) berwirausaha toko”, terjemahan kalimat tersebut yang benar adalah sobo wa … .', NULL, 1),
(26, '   oniisan wa???????desuka. (Umur Berapa)', NULL, 1),
(27, 'Ane wa???????desu. (Pegawai Negeri Sipil)\r\n', NULL, 1),
(28, 'Haha wa kissaten ???yatteimasu.', NULL, 1),
(29, '“Kakak Perempuan(saya) adalah Rambutnya pendek”\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah … .', NULL, 1),
(30, '“Bapak(saya) adalah Gemuk”, terjemahan kalimat tersebut yang benar adalah chichi wa … .\r\n', NULL, 1),
(31, '    “Adik Perempuan(saya) adalah Baik hati”\r\nTerjemahan bahasa Jepang Kalimat di atas yang benar adalah imouto wa … .', NULL, 1),
(32, '“Kakak Laki-laki(saya) adalah Badannya  Tinggi" Terjemahan bahasa Jepang kalimat di atas yang benar adalah … .', NULL, 1),
(33, '   Oneesan wa???????desuka.  (Orang yang bagaimana)', NULL, 1),
(34, 'Chichi wa se?????takai desu.', NULL, 1),
(35, 'Sofu wa kami????mijikai desu.', NULL, 1),
(36, '  abcd adalah', NULL, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_soal_hasil_acak`
--

CREATE TABLE IF NOT EXISTS `tb_soal_hasil_acak` (
  `id_soal` int(11) NOT NULL,
  `soal` text NOT NULL,
  `id_gambar` int(4) NOT NULL,
  `id_materi` int(4) NOT NULL,
  `id_soal_asal` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_soal_hasil_acak`
--

INSERT INTO `tb_soal_hasil_acak` (`id_soal`, `soal`, `id_gambar`, `id_materi`, `id_soal_asal`) VALUES
(1, 'Watashi wa ane  ???gonin????sobo???juunin imasu.', 0, 1, 7),
(2, 'Makiosan mempunyai 2 orang bapak dan 3 orang ibu Terjemahan bahasa Jepang kalimat di atas yang benar adalah makiosan wa … .', 0, 1, 11),
(3, '“Hikarisan adalah umur 18”, terjemahan kalimat tersebut yang benar adalah Hikarisan wa … .', 0, 1, 23),
(4, 'Ibu(saya) Memakai sandal, Terjemahan bahasa Jepang kalimat tersebut yang benar adalah Haha wa sandaru o … .', 0, 1, 14),
(5, '  ??????Kyoudai desuka. (berapa orang)', 0, 1, 6),
(6, 'Haha wa kissaten ???yatteimasu.', 0, 1, 28),
(7, '   Oneesan wa???????desuka.  (Orang yang bagaimana)', 0, 1, 33),
(8, 'Chichi wa se?????takai desu.', 0, 1, 34),
(9, 'Saya mempunyai 2 orang kakak laki-laki\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah Watashi wa ane ga … .', 0, 1, 3),
(10, 'Yukisan wa??????ga Hitori imasu. (Adik perempuan)', 0, 1, 19),
(11, '   oniisan wa???????desuka. (Umur Berapa)', 0, 1, 26),
(12, '“Kakak Perempuan(saya) adalah Rambutnya pendek”\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah … .', 0, 1, 29),
(13, '“Bapak(saya) adalah Gemuk”, terjemahan kalimat tersebut yang benar adalah chichi wa … .\r\n', 0, 1, 30),
(14, 'Sakakisan mempunyai 5 orang bapak dan 6 orang ibu\r\nTerjemahan bahasa Jepang kalimat di atas yang benar adalah Sakakisan wa … .', 0, 1, 10),
(15, 'Sakurasan wa oniisan   ??  rokunin  ??  oneesan  ??  sannin imasu.\r\nSakurasan wa oniisan   ??  rokunin  ??  oneesan  ??  sannin imasu.\r\n', 0, 1, 21),
(16, 'Sofu wa kami????mijikai desu.', 0, 1, 35),
(17, 'Watashi wa??????desu. (Anak Tunggal)', 0, 1, 5),
(18, '“Kakek (saya) adalah mahasiswa”, terjemahan kalimat tersebut yang benar adalah Sofu wa ... .', 0, 1, 24),
(19, '“Saya adalah 4 orang keluarga”, terjemahan kalimat tersebut yang benar adalah Watashi wa ... .', 0, 1, 1),
(20, '“Nenek (saya) berwirausaha toko”, terjemahan kalimat tersebut yang benar adalah sobo wa … .', 0, 1, 25);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_jawaban_acak`
--
ALTER TABLE `tb_jawaban_acak`
  ADD PRIMARY KEY (`id_jawaban`);

--
-- Indexes for table `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `tb_nilai`
--
ALTER TABLE `tb_nilai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_soal`
--
ALTER TABLE `tb_soal`
  ADD PRIMARY KEY (`id_soal`);

--
-- Indexes for table `tb_soal_acak`
--
ALTER TABLE `tb_soal_acak`
  ADD PRIMARY KEY (`id_soal`);

--
-- Indexes for table `tb_soal_hasil_acak`
--
ALTER TABLE `tb_soal_hasil_acak`
  ADD PRIMARY KEY (`id_soal`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_jawaban_acak`
--
ALTER TABLE `tb_jawaban_acak`
  MODIFY `id_jawaban` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=182;
--
-- AUTO_INCREMENT for table `tb_nilai`
--
ALTER TABLE `tb_nilai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `tb_soal`
--
ALTER TABLE `tb_soal`
  MODIFY `id_soal` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_soal_acak`
--
ALTER TABLE `tb_soal_acak`
  MODIFY `id_soal` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT for table `tb_soal_hasil_acak`
--
ALTER TABLE `tb_soal_hasil_acak`
  MODIFY `id_soal` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
