-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 24 Okt 2016 pada 11.09
-- Versi Server: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_kerusakan_atm`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `01-view-matriks-kerusakan`
--
CREATE TABLE IF NOT EXISTS `01-view-matriks-kerusakan` (
`id_gejala` int(11)
,`kode` varchar(50)
,`P1` decimal(32,0)
,`P2` decimal(32,0)
,`P3` decimal(32,0)
,`P4` decimal(32,0)
,`P5` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `01-view-matriks-kerusakan-densitas`
--
CREATE TABLE IF NOT EXISTS `01-view-matriks-kerusakan-densitas` (
`id_gejala` int(11)
,`kode` varchar(50)
,`P1` double(22,5)
,`P2` double(22,5)
,`P3` double(22,5)
,`P4` double(22,5)
,`densitas` float(10,5)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `01-view-matriks-kerusakan-logika`
--
CREATE TABLE IF NOT EXISTS `01-view-matriks-kerusakan-logika` (
`id_gejala` int(11)
,`kode` varchar(50)
,`P1` decimal(23,0)
,`P2` decimal(23,0)
,`P3` decimal(23,0)
,`P4` decimal(23,0)
,`P5` decimal(23,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `01-view-teta`
--
CREATE TABLE IF NOT EXISTS `01-view-teta` (
`id_kerusakan` int(11)
,`id_gejala` int(11)
,`kode_p` varchar(50)
,`kode_g` varchar(50)
,`gejala` varchar(100)
,`densitas` float(10,5)
,`teta` double(22,5)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `02-view-teta-simple`
--
CREATE TABLE IF NOT EXISTS `02-view-teta-simple` (
`kode_p` varchar(50)
,`kode_g` varchar(50)
,`densitas` float(10,5)
,`teta` double(22,5)
,`id_kerusakan` int(11)
,`id_gejala` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `03-0-view-all-gejala`
--
CREATE TABLE IF NOT EXISTS `03-0-view-all-gejala` (
`id_kerusakan_gejala` int(11)
,`id_kerusakan` int(11)
,`id_gejala` int(11)
,`kerusakan` varchar(150)
,`kode_p` varchar(50)
,`kode_g` varchar(50)
,`gejala` varchar(100)
,`keterangan` varchar(250)
,`density` decimal(10,5)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `03-1-get-all-index`
--
CREATE TABLE IF NOT EXISTS `03-1-get-all-index` (
`id_g_index` int(11)
,`noindex` int(11)
,`id_p` int(11)
,`id_g` int(11)
,`d` decimal(10,5)
,`t` decimal(10,5)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `03-2-define-m`
--
CREATE TABLE IF NOT EXISTS `03-2-define-m` (
`id_g_index` int(11)
,`id_p` int(11)
,`jml` bigint(21)
,`m1` decimal(32,5)
,`mt1` decimal(32,5)
,`m2` decimal(32,5)
,`mt2` decimal(32,5)
,`m3` decimal(32,5)
,`mt3` decimal(32,5)
,`m4` decimal(32,5)
,`mt4` decimal(32,5)
,`m5` decimal(32,5)
,`mt5` decimal(32,5)
,`m6` decimal(32,5)
,`mt6` decimal(32,5)
,`m7` decimal(32,5)
,`mt7` decimal(32,5)
,`m8` decimal(32,5)
,`mt8` decimal(32,5)
,`m9` decimal(32,5)
,`mt9` decimal(32,5)
,`m10` decimal(32,5)
,`mt10` decimal(32,5)
,`kode` varchar(50)
,`kerusakan` varchar(150)
,`keterangan` varchar(250)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `03-3-view-gejala`
--
CREATE TABLE IF NOT EXISTS `03-3-view-gejala` (
`id_gejala` int(11)
,`kode` varchar(50)
,`gejala` varchar(100)
,`keterangan` varchar(250)
,`densitas` float(10,5)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `04-view-gejala-kerusakan`
--
CREATE TABLE IF NOT EXISTS `04-view-gejala-kerusakan` (
`id_kerusakan` int(11)
,`id_gejala` int(11)
,`kode` varchar(50)
,`kerusakan` varchar(150)
,`keterangan` varchar(250)
,`penyebab` text
,`penanggulangan` text
,`kode_g` varchar(50)
,`gejala` varchar(100)
,`densitas` float(10,5)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `04-view-inferensi`
--
CREATE TABLE IF NOT EXISTS `04-view-inferensi` (
`id_kerusakan_gejala` int(11)
,`kode_p` varchar(50)
,`kerusakan` varchar(150)
,`kode_g` varchar(50)
,`gejala` varchar(100)
,`datetime` datetime
,`id_kerusakan` int(11)
,`id_gejala` int(11)
,`densitas` decimal(10,5)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `05-view-hasil-wizard`
--
CREATE TABLE IF NOT EXISTS `05-view-hasil-wizard` (
`id_wizard` int(11)
,`nama_user` varchar(100)
,`email` varchar(100)
,`hp` varchar(15)
,`kode` varchar(50)
,`kerusakan` varchar(150)
,`penyebab` text
,`penanggulangan` text
,`gejala_masukan` text
,`hasil_believe` double(11,2)
,`datetime` datetime
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `gejala`
--

CREATE TABLE IF NOT EXISTS `gejala` (
  `id_gejala` int(11) NOT NULL,
  `kode` varchar(50) DEFAULT NULL,
  `gejala` varchar(100) DEFAULT NULL,
  `keterangan` varchar(250) DEFAULT NULL,
  `densitas` float(10,5) DEFAULT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gejala`
--

INSERT INTO `gejala` (`id_gejala`, `kode`, `gejala`, `keterangan`, `densitas`, `datetime`) VALUES
(1, 'G1', 'Kartu Tidak Keluar', '', 0.50000, '2016-10-20 18:33:54'),
(2, 'G2', 'Kartu Tidak Jatuh Pada Box', '', 0.50000, '2016-10-20 18:34:35'),
(3, 'G3', 'Uang Tidak Muncul', '', 0.20000, '2016-10-20 18:35:17'),
(4, 'G4', 'Cek Saldo OK', '', 0.20000, '2016-10-20 18:36:01'),
(5, 'G5', 'Print History Transaksi Bisa', '', 0.20000, '2016-10-20 18:36:27'),
(6, 'G6', 'Koneksi Lemot', '', 0.20000, '2016-10-20 18:36:47'),
(7, 'G7', 'Transfer Tidak Bisa', '', 0.20000, '2016-10-20 18:37:32'),
(8, 'G8', 'Test Recash, Error "TRANSPORT BLOCKED"', '', 0.30000, '2016-10-20 19:08:51'),
(9, 'G9', 'Koneksi Lancar', '', 0.20000, '2016-10-20 18:41:36'),
(10, 'G10', 'Transfer Bisa', '', 0.20000, '2016-10-20 18:41:56'),
(11, 'G11', 'Test Recash, Error "DISPENSER PROBLEM"', '', 0.30000, '2016-10-20 19:09:07'),
(12, 'G12', 'Tulisan Struk Tidak Muncul', '', 0.50000, '2016-10-20 19:04:49'),
(13, 'G13', 'Test Print Hanya Keluar Kertas', '', 0.50000, '2016-10-20 19:05:22'),
(14, 'G14', 'Layar Mati', '', 0.30000, '2016-10-20 19:12:10'),
(15, 'G15', 'Compare Kabel VGA OK', '', 0.40000, '2016-10-20 19:12:37'),
(16, 'G16', 'PC Hidup', '', 0.30000, '2016-10-20 19:13:58'),
(17, 'G17', 'Uang Muncul', '', 0.20000, '2016-10-20 19:19:06'),
(18, 'G18', 'Muncul Error Message "HANDLE OPEN"', '', 0.50000, '2016-10-20 19:22:18'),
(19, 'G19', 'Test Ping IP Server RTO', '', 0.25000, '2016-10-20 19:22:50'),
(20, 'G20', 'Test Ping IP Gateway REPLY', '', 0.25000, '2016-10-20 19:23:23'),
(21, 'G21', 'Compare LAN Cable OK', '', 0.30000, '2016-10-20 19:27:26'),
(22, 'G22', 'Numpad/Menupad Susah Ditekan/Tidak Respon', '', 0.40000, '2016-10-20 19:37:52'),
(23, 'G23', 'Menu Sering Berganti Tanpa Sebab', '', 0.50000, '2016-10-20 19:31:39'),
(24, 'G24', 'Baterai UPS Tidak Terisi', '', 0.10000, '2016-10-20 19:39:03');

-- --------------------------------------------------------

--
-- Struktur dari tabel `gejala_backup`
--

CREATE TABLE IF NOT EXISTS `gejala_backup` (
  `id_gejala` int(11) NOT NULL,
  `kode` varchar(50) DEFAULT NULL,
  `gejala` varchar(100) DEFAULT NULL,
  `keterangan` varchar(250) DEFAULT NULL,
  `densitas` float(10,5) DEFAULT NULL,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gejala_backup`
--

INSERT INTO `gejala_backup` (`id_gejala`, `kode`, `gejala`, `keterangan`, `densitas`, `datetime`) VALUES
(1, 'G1', 'Bibit yang terkena mati', NULL, 0.75000, '2015-03-14 16:53:17'),
(2, 'G2', 'Tumbuh memanjang kurang wajar', NULL, 0.25000, '2015-03-14 16:53:37'),
(3, 'G3', 'Garis air pada batang', NULL, 0.50000, '2015-03-14 16:53:40'),
(4, 'G4', 'Tetesan embun seperti susu timbul di permukaan', NULL, 0.33000, '2015-03-14 16:54:25'),
(5, 'G5', 'Menghasilkan beberaoa anakan dengan malai kosong', NULL, 0.25000, '2015-03-18 06:27:06'),
(6, 'G6', 'Bakteri menetas pada luka baru', NULL, 0.25000, '2015-03-14 16:54:35'),
(7, 'G7', 'Daun kuning', NULL, 0.70000, '2015-03-14 16:54:00'),
(8, 'G8', 'Fungsi berbentuk bubuk keputihan', NULL, 0.50000, '2015-03-19 22:01:30'),
(9, 'G9', 'Kadang malai busuk', NULL, 0.85000, '2015-03-14 16:54:10'),
(10, 'G10', 'Tidak menghasilkan malai', NULL, 0.50000, '2015-03-19 22:01:52');

-- --------------------------------------------------------

--
-- Struktur dari tabel `gejala_index`
--

CREATE TABLE IF NOT EXISTS `gejala_index` (
  `id_g_index` int(11) NOT NULL,
  `noindex` int(11) DEFAULT NULL,
  `id_p` int(11) NOT NULL,
  `id_g` int(11) DEFAULT NULL,
  `d` decimal(10,5) DEFAULT NULL,
  `t` decimal(10,5) DEFAULT NULL,
  `datetime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gejala_index`
--

INSERT INTO `gejala_index` (`id_g_index`, `noindex`, `id_p`, `id_g`, `d`, `t`, `datetime`) VALUES
(1, 1, 1, 1, '0.50000', '0.50000', '2015-03-28 19:23:13'),
(2, 2, 1, 2, '0.40000', '0.60000', '2015-03-28 19:23:13'),
(3, 3, 1, 3, '0.60000', '0.40000', '2015-03-28 19:23:13'),
(4, 1, 9, 4, '0.25000', '0.75000', '2015-03-28 19:23:13');

-- --------------------------------------------------------

--
-- Struktur dari tabel `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` mediumint(8) unsigned NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `groups`
--

INSERT INTO `groups` (`id`, `name`, `description`) VALUES
(1, 'admin', 'Administrator'),
(2, 'members', 'General User'),
(3, 'petugas', 'Petugas Pertandingan'),
(4, 'pengawas', 'Pengawas Pertandingan'),
(5, 'peserta', 'Peserta Pertandingan'),
(6, 'official', 'Pengurus Tim'),
(7, 'publik', 'Umum'),
(8, 'memberbaru', 'anak baru datang');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kerusakan`
--

CREATE TABLE IF NOT EXISTS `kerusakan` (
  `id_kerusakan` int(11) NOT NULL,
  `kode` varchar(50) DEFAULT NULL,
  `kerusakan` varchar(150) DEFAULT NULL,
  `keterangan` varchar(250) DEFAULT NULL,
  `penyebab` text NOT NULL,
  `penanggulangan` text,
  `isactive` enum('1','0') DEFAULT NULL,
  `isadmin` enum('1','2','3','4','5','6') DEFAULT NULL,
  `datetime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kerusakan`
--

INSERT INTO `kerusakan` (`id_kerusakan`, `kode`, `kerusakan`, `keterangan`, `penyebab`, `penanggulangan`, `isactive`, `isadmin`, `datetime`) VALUES
(1, 'P1', 'Roller Penarik Kartu Aus', '', 'Proses Penarikan Kartu yang Kasar', 'Lepaskan kabel sensor, Ganti unit dengan yang stock backup', '', '', '2016-10-20 18:51:08'),
(2, 'P2', 'Proxy Belum Tersetting', '', 'Teknisi lupa setting proxy setelah update software', 'Tambahkan IP Proxy pada konfigurasi IP PC', '', '', '2016-10-20 18:51:14'),
(4, 'P4', 'Kegagalan Jaringan', '', 'Verifikasi transaksi yang telalu lama', 'Laporkan ke IT Bank dengan menyertakan hasil test ping dan file history transaksi', '', '', '2016-10-20 18:50:59'),
(5, 'P3', 'Jalur Robotic Trouble', '', 'Sensor yang tidak berfungsi, Uang yang kusut, Roda penarik yang tidak berfungsi', 'Cek Semua Sensor pada jalur dan bersihkan juga. Cek roda penarik apakah lepas atau tidak', '', '', '2016-10-20 18:55:16'),
(6, 'P5', 'Head/Pemanas Printer Rusak', '', '', 'Ganti unit printer dengan stock backup', '', '', '2016-10-20 19:10:46'),
(7, 'P6', 'Kabel VGA Rusak', '', '', 'Ganti kabel dengan stock backup', '', '', '2016-10-20 19:14:53'),
(8, 'P7', 'Server Lemot', '', 'Workload Server yang melebihi batas', 'Ganti IP Server dengan IP Server yang lain', '', '', '2016-10-20 19:17:37'),
(9, 'P8', 'Switch Handle Berubah Posisi', '', 'Terpaan angin yang besar membuat posisinya berubah', 'Rubah posisi Switch Handle Parabola dengan koordinasi bersama IT Bank mengenai posisi terbaik', '', '', '2016-10-20 19:25:44'),
(10, 'P9', 'Modem Problem', '', '', 'Koordinasi dengan Team Provider mengenai Service Modem', '', '', '2016-10-20 19:28:38'),
(11, 'P10', 'Numpad/Menupad Kotor/Rusak', '', '', 'Bersihkan dahulu tempat tombolnya. Apabila tetap error maka ganti Numpad/Menupad', '', '', '2016-10-20 19:34:41'),
(12, 'P11', 'UPS Trouble', '', '', 'Tekan tombol pada UPS beberapa kali sampai indikator baterai terisi. Apabila masih tidak mengisi maka ganti dengan backup', '', '', '2016-10-20 19:41:42');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kerusakan_gejala`
--

CREATE TABLE IF NOT EXISTS `kerusakan_gejala` (
  `id_kerusakan_gejala` int(11) NOT NULL,
  `id_kerusakan` int(11) NOT NULL,
  `id_gejala` int(11) DEFAULT NULL,
  `density` decimal(10,5) DEFAULT NULL,
  `datetime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kerusakan_gejala`
--

INSERT INTO `kerusakan_gejala` (`id_kerusakan_gejala`, `id_kerusakan`, `id_gejala`, `density`, `datetime`) VALUES
(190, 1, 1, NULL, '2015-03-26 09:44:57'),
(191, 1, 2, NULL, '2015-03-26 09:44:57'),
(192, 1, 3, NULL, '2015-03-26 10:43:11'),
(193, 9, 4, NULL, '2015-03-26 11:06:59');

-- --------------------------------------------------------

--
-- Struktur dari tabel `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id_role` int(11) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `role_json` tinytext,
  `datetime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `role`
--

INSERT INTO `role` (`id_role`, `role_name`, `role_json`, `datetime`) VALUES
(1, 'petugas', '[{''player_info'':1}]', '0000-00-00 00:00:00'),
(2, 'official', '[{''edit_tim'':1,''add_player'':1}]', '0000-00-00 00:00:00'),
(3, 'peserta', '[{''edit_profil'':1}]', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `rule_inferensi`
--

CREATE TABLE IF NOT EXISTS `rule_inferensi` (
  `id_kerusakan_gejala` int(11) NOT NULL,
  `id_kerusakan` int(11) NOT NULL,
  `id_gejala` int(11) DEFAULT NULL,
  `densitas` decimal(10,5) DEFAULT NULL,
  `datetime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `rule_inferensi`
--

INSERT INTO `rule_inferensi` (`id_kerusakan_gejala`, `id_kerusakan`, `id_gejala`, `densitas`, `datetime`) VALUES
(1, 1, 1, '0.80000', '2016-10-20 18:55:51'),
(2, 1, 2, '0.25000', '2015-03-28 15:06:52'),
(3, 2, 3, '0.75000', '2016-10-20 20:03:24'),
(4, 2, 4, '0.25000', '2016-10-20 18:56:37'),
(5, 2, 5, '0.50000', '2016-10-20 18:56:55'),
(6, 2, 6, '0.50000', '2016-10-20 18:57:06'),
(7, 2, 7, '0.60000', '2016-10-20 18:57:18'),
(8, 4, 4, '0.40000', '2016-10-20 18:57:37'),
(9, 4, 3, '0.80000', '2016-10-20 18:57:51'),
(10, 4, 5, '0.20000', '2016-10-20 18:58:08'),
(11, 3, 1, '0.70000', '2015-03-28 15:07:12'),
(12, 3, 2, '0.30000', '2015-03-28 15:07:14'),
(13, 3, 3, NULL, '2015-03-19 23:03:57'),
(14, 3, 4, NULL, '2015-03-19 23:04:04'),
(15, 3, 5, NULL, '2015-03-19 23:04:05'),
(16, 3, 6, NULL, '2015-03-19 23:04:05'),
(17, 3, 7, NULL, '2015-03-19 23:04:06'),
(18, 4, 9, NULL, '2016-10-20 18:58:27'),
(19, 4, 10, NULL, '2016-10-20 18:58:45'),
(20, 5, 3, NULL, '2016-10-20 18:59:50'),
(21, 5, 4, '0.50000', '2016-10-20 19:00:07'),
(22, 5, 5, NULL, '2016-10-20 19:01:34'),
(23, 5, 8, NULL, '2016-10-20 19:02:02'),
(27, 14, 1, '0.00000', '2015-03-28 13:22:33'),
(28, 14, 6, '0.00000', '2015-03-28 13:22:53'),
(29, 14, 8, '0.00000', '2015-03-28 13:24:12'),
(30, 5, 10, NULL, '2016-10-20 20:05:05'),
(31, 5, 11, NULL, '2016-10-20 19:03:17'),
(32, 6, 12, NULL, '2016-10-20 19:11:04'),
(33, 6, 13, NULL, '2016-10-20 19:11:12'),
(34, 7, 14, NULL, '2016-10-20 19:15:07'),
(35, 7, 15, NULL, '2016-10-20 19:15:18'),
(36, 7, 16, NULL, '2016-10-20 19:15:29'),
(37, 8, 17, NULL, '2016-10-20 19:19:20'),
(38, 8, 4, NULL, '2016-10-20 19:19:32'),
(39, 8, 5, NULL, '2016-10-20 19:20:01'),
(40, 8, 6, NULL, '2016-10-20 19:20:18'),
(41, 8, 10, NULL, '2016-10-20 19:20:32'),
(42, 9, 18, NULL, '2016-10-20 19:25:57'),
(43, 9, 19, NULL, '2016-10-20 19:26:06'),
(44, 9, 20, NULL, '2016-10-20 19:26:18'),
(45, 10, 19, NULL, '2016-10-20 19:28:56'),
(46, 10, 20, NULL, '2016-10-20 19:29:10'),
(47, 10, 21, NULL, '2016-10-20 19:29:21'),
(48, 10, 6, NULL, '2016-10-20 19:29:34'),
(49, 11, 22, NULL, '2016-10-20 19:34:56'),
(50, 11, 23, NULL, '2016-10-20 19:35:07'),
(51, 12, 22, NULL, '2016-10-20 19:41:59'),
(52, 12, 23, NULL, '2016-10-20 19:42:15'),
(53, 12, 24, NULL, '2016-10-20 19:42:26');

-- --------------------------------------------------------

--
-- Struktur dari tabel `temp`
--

CREATE TABLE IF NOT EXISTS `temp` (
  `id_temp` int(11) NOT NULL,
  `var1` float NOT NULL,
  `var2` float NOT NULL DEFAULT '0',
  `var3` float NOT NULL DEFAULT '0',
  `var4` float NOT NULL DEFAULT '0',
  `val1` float NOT NULL DEFAULT '0',
  `val2` float NOT NULL DEFAULT '0',
  `val3` float NOT NULL DEFAULT '0',
  `val4` float NOT NULL DEFAULT '0',
  `datetime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) unsigned NOT NULL,
  `ip_address` varchar(15) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `activation_code` varchar(40) DEFAULT NULL,
  `forgotten_password_code` varchar(40) DEFAULT NULL,
  `forgotten_password_time` int(11) unsigned DEFAULT NULL,
  `remember_code` varchar(40) DEFAULT NULL,
  `created_on` int(11) unsigned NOT NULL,
  `last_login` int(11) unsigned DEFAULT NULL,
  `active` tinyint(1) unsigned DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `ip_address`, `username`, `password`, `salt`, `email`, `activation_code`, `forgotten_password_code`, `forgotten_password_time`, `remember_code`, `created_on`, `last_login`, `active`, `first_name`, `last_name`, `company`, `phone`) VALUES
(1, '127.0.0.1', 'administrator', '$2a$07$SeBknntpZror9uyftVopmu61qg0ms8Qv1yV6FG.kQOSM.9QhmTo36', '', 'admin@admin.com', '', NULL, NULL, '3LyNKmDwSaFR4DNS9WQFKO', 1268889823, 1477281050, 1, 'Admin', 'istrator', 'ADMIN', '0'),
(2, '', 'petugas', '$2a$07$SeBknntpZror9uyftVopmu61qg0ms8Qv1yV6FG.kQOSM.9QhmTo36', NULL, 'petugas@gmail.com', NULL, NULL, NULL, 'UBHKS622uhF32j9h4uttjO', 0, 1423312036, 1, 'Petugas', 'Pertandingan', 'PERBASI', '123123'),
(3, '', 'pengawas', '$2a$07$SeBknntpZror9uyftVopmu61qg0ms8Qv1yV6FG.kQOSM.9QhmTo36', NULL, 'pengawas@gmail.com', NULL, NULL, NULL, NULL, 0, NULL, 1, 'Pengawas', 'Pertandingan', 'EO', NULL),
(4, '', 'official', '$2a$07$SeBknntpZror9uyftVopmu61qg0ms8Qv1yV6FG.kQOSM.9QhmTo36', NULL, 'official@gmail.com', NULL, NULL, NULL, NULL, 0, NULL, 1, 'Official ', 'Team', 'Universitas', NULL),
(5, '', 'peserta', '$2a$07$SeBknntpZror9uyftVopmu61qg0ms8Qv1yV6FG.kQOSM.9QhmTo36', NULL, 'peserta@gmail.com', NULL, NULL, NULL, 'mOyHQqmW2NEl5IGYGjE64e', 0, 1423314363, 1, 'Peserta', 'Team Player', 'Tim', '123123123'),
(27, '::1', 'syahroni', '$2a$07$SeBknntpZror9uyftVopmu61qg0ms8Qv1yV6FG.kQOSM.9QhmTo36', NULL, 'roniwahyu@gmail.com', '61025f038864db70d03704580ed3d305618fbc8b', NULL, NULL, NULL, 1420726628, 1420726628, 1, '0', '0', NULL, NULL),
(28, '::1', 'admine', '$2a$07$SeBknntpZror9uyftVopmu61qg0ms8Qv1yV6FG.kQOSM.9QhmTo36', NULL, 'admine@gmail.com', 'c16412d8c085c9761c4be5f0f940dd5de6179c40', NULL, NULL, NULL, 1422161800, 1423093966, 1, '0', '0', NULL, NULL),
(29, '::1', 'mirasai', '$2a$07$SeBknntpZror9uyftVopmu61qg0ms8Qv1yV6FG.kQOSM.9QhmTo36', NULL, 'mirasai@gmail.com', NULL, NULL, NULL, NULL, 1422162679, 1422162679, 1, '0', '0', NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `users_groups`
--

CREATE TABLE IF NOT EXISTS `users_groups` (
  `id` int(11) unsigned NOT NULL,
  `user_id` int(11) unsigned NOT NULL,
  `group_id` mediumint(8) unsigned NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

--
-- Dumping data untuk tabel `users_groups`
--

INSERT INTO `users_groups` (`id`, `user_id`, `group_id`) VALUES
(1, 1, 1),
(37, 2, 3),
(4, 3, 4),
(5, 4, 6),
(39, 5, 2),
(40, 5, 5),
(33, 27, 2),
(41, 27, 5),
(34, 28, 2),
(43, 28, 5),
(45, 29, 2),
(46, 29, 5),
(47, 29, 8);

-- --------------------------------------------------------

--
-- Struktur dari tabel `wizard`
--

CREATE TABLE IF NOT EXISTS `wizard` (
  `id_wizard` int(11) NOT NULL,
  `nama_user` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `hp` varchar(15) DEFAULT NULL,
  `gejala_masukan` text,
  `hasil_id` int(11) DEFAULT NULL,
  `hasil_believe` double(11,2) DEFAULT NULL,
  `datetime` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `wizard`
--

INSERT INTO `wizard` (`id_wizard`, `nama_user`, `email`, `hp`, `gejala_masukan`, `hasil_id`, `hasil_believe`, `datetime`) VALUES
(1, '456', '56', '0', '["8","9","10"]', 2, 75.00, '2015-04-09 18:04:22'),
(2, 'asd', 'asd', '0', '["1","7"]', 3, 72.73, '2015-04-10 02:04:26'),
(3, 'dfsd', 'syahroni.w@gmail.com', '0', '["3","5","9"]', 3, 64.71, '2015-04-10 02:04:19'),
(4, 'AngkasaLuas', 'roniwahyu@gmail.com', '0', '["1","3","5"]', 3, 80.65, '2015-04-11 00:04:13'),
(5, 'Mikasa', 'mirasai@gmail.com', '0', '["1","2","3","5","8","9","10"]', 2, 85.71, '2015-04-11 00:04:22'),
(6, 'SMAN 8 Malang', 'pembelaislam.cyber@gmail.com', '0', '["7"]', 3, 25.00, '2015-04-11 00:04:40'),
(7, 'asd', 'asd', '0', '["3","5","7","9"]', 3, 68.42, '2015-04-11 00:04:17'),
(8, 'sdbn', 'bnvcxzcxv', '0', '["7","8","9","10"]', 2, 75.00, '2015-04-11 00:04:38'),
(9, 'asd', 'asd', '0', '["1","7"]', 3, 90.32, '2015-04-11 00:04:26'),
(10, 'xfg', 'dfg', '0', '["1","7"]', 3, 90.32, '2015-04-11 01:04:30'),
(11, 'asd', 'asd', '0', '["3","5"]', 3, 64.71, '2015-04-11 01:04:52'),
(12, 'scdvfbgnhm', 'cvbn', '0', '["1","2","3","5","8","10"]', 2, 92.11, '2015-04-12 14:04:58'),
(13, 'cvbnm', 'mnbnm', '0', '["1","2","3","5","8","10"]', 2, 85.00, '2015-04-12 14:04:50'),
(14, 'fds', 'sdf', '0', '["1","2","3","4","10"]', 3, 83.78, '2015-10-26 02:10:58'),
(15, 'Agus', 'agus@yahoo.co.id', '0', '["1","3","4","7","8","9","10"]', 2, 85.71, '2015-10-26 02:10:31'),
(16, 'g', 'fg', '0', '["2","5","9"]', 1, 62.50, '2015-10-27 04:10:35'),
(17, 'g', 'fg', '0', '["2","5","9"]', 1, 62.50, '2015-10-27 04:10:35'),
(18, 'Agus', 'agus@yahoo.co.id', '0', '["3","4","8","9","10"]', 2, 75.00, '2015-10-27 04:10:54'),
(19, 'aa', 'alirusdi1@gmail.com', '0', '["1","2"]', 1, 76.92, '2016-01-11 02:01:28'),
(20, 'santoso', 'santoso@gmail.com', '0', '["1","2","3","4","5","6","7","8","9","10"]', 2, 88.68, '2016-10-07 04:10:51'),
(21, 'sdf', 'asf', '0', '["5","6"]', 2, 57.14, '2016-10-07 06:10:46'),
(22, 'aa', 'mollor.genk@gmail.com', '0', '["1"]', 1, 76.00, '2016-10-18 04:10:52'),
(23, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["1","4","5"]', 2, 90.00, '2016-10-18 17:10:29'),
(24, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["2","3","4","6"]', 1, 52.63, '2016-10-20 02:10:39'),
(25, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["3","4","10","11"]', 4, 42.86, '2016-10-20 19:10:28'),
(26, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["11"]', 5, 20.00, '2016-10-20 19:10:03'),
(27, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["1","4","7","10","15","18"]', 2, 60.00, '2016-10-20 19:10:19'),
(28, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["1","4","9","12","19","22"]', 10, 57.14, '2016-10-20 19:10:08'),
(29, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["1","4","9","12","19"]', 10, 57.14, '2016-10-20 19:10:28'),
(30, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["3","4","5","6"]', 2, 50.00, '2016-10-21 02:10:21'),
(31, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["3","4","5","6","7"]', 2, 55.56, '2016-10-21 02:10:39'),
(32, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["1","10","14","19","22"]', 1, 50.00, '2016-10-21 14:10:13'),
(33, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["3","4","5","7","9"]', 2, 50.00, '2016-10-21 14:10:31'),
(34, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["1","2"]', 1, 66.67, '2016-10-21 14:10:47'),
(35, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["1","2"]', 1, 66.67, '2016-10-21 14:10:54'),
(36, 'Fiqih Syamsah Ardian Nuriyanto', 'mollor.genk@gmail.com', '0', '["14"]', 7, 30.00, '2016-10-21 14:10:48'),
(37, 'asdad', 'dsadad@asda.com', '0', '["1"]', 1, 50.00, '2016-10-24 05:10:39'),
(38, 'sad', 'dasds@adsad.com', '0', '["2","4","6","10"]', 1, 50.00, '2016-10-24 05:10:36'),
(39, 'gjfhj', 'dgfsf@gfhd.com', '0', '["1","3"]', 1, 50.00, '2016-10-24 05:10:13'),
(40, 'gjfhj', 'dgfsf@gfhd.com', '0', '["1","3"]', 1, 50.00, '2016-10-24 06:10:56'),
(41, 'gjfhj', 'dgfsf@gfhd.com', '0', '["1","3"]', 1, 50.00, '2016-10-24 06:10:59'),
(42, 'sad', 'dasds@adsad.com', '0', '["2","4","6","10"]', 8, 42.86, '2016-10-24 06:10:13'),
(43, 'sad', 'dasds@adsad.com', '0', '["2","4","6","10"]', 1, 50.00, '2016-10-24 06:10:36'),
(44, 'sad', 'dasds@adsad.com', '0', '["2","4","6","10"]', 1, 50.00, '2016-10-24 06:10:36'),
(45, 'asda', 'asdasd@asdc.com', '0', '["1","2","6","24"]', 1, 66.67, '2016-10-24 06:10:06'),
(46, 'asdasd', 'asdklasndl@saad.com', '0', '["3","7","8","9","14"]', 1, NULL, '2016-10-24 06:10:28'),
(47, 'asdasd', 'asdklasndl@saad.com', '0', '["3","7","8","9","14"]', 1, NULL, '2016-10-24 06:10:23'),
(48, 'asdasd', 'asdklasndl@saad.com', '0', '["3","7","8","9","14"]', 1, NULL, '2016-10-24 06:10:45'),
(49, 'asdasd', 'asdklasndl@saad.com', '0', '["3","7","8","9","14"]', 1, NULL, '2016-10-24 06:10:49'),
(50, 'asdasd', 'asdklasndl@saad.com', '0', '["3","7","8","9","14"]', 1, NULL, '2016-10-24 06:10:07'),
(51, 'asdasd', 'asdklasndl@saad.com', '0', '["3","7","8","9","14"]', 1, NULL, '2016-10-24 06:10:10'),
(52, 'asdasd', 'asdklasndl@saad.com', '0', '["3","7","8","9","14"]', 1, NULL, '2016-10-24 06:10:13'),
(53, 'asdasd', 'asdklasndl@saad.com', '0', '["3","7","8","9","14"]', 1, NULL, '2016-10-24 06:10:40'),
(54, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 1, NULL, '2016-10-24 06:10:28'),
(55, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 06:10:07'),
(56, 'gjfhj', 'dgfsf@gfhd.com', '0', '["1","3"]', 1, 50.00, '2016-10-24 06:10:41'),
(57, 'gjfhj', 'dgfsf@gfhd.com', '0', '["1","3"]', 1, 50.00, '2016-10-24 06:10:28'),
(58, 'asdasd', 'sadasd@asdad.com', '0', '["1"]', 1, 50.00, '2016-10-24 06:10:31'),
(59, 'asdasd', 'sadasd@asdad.com', '0', '["1"]', 1, 50.00, '2016-10-24 06:10:44'),
(60, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 1, NULL, '2016-10-24 08:10:48'),
(61, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 10, 40.00, '2016-10-24 08:10:01'),
(62, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:28'),
(63, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:24'),
(64, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:27'),
(65, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:21'),
(66, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:35'),
(67, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:37'),
(68, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:53'),
(69, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:19'),
(70, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:18'),
(71, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:57'),
(72, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:16'),
(73, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:49'),
(74, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:23'),
(75, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:54'),
(76, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:14'),
(77, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:52'),
(78, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:55'),
(79, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:14'),
(80, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:03'),
(81, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:40'),
(82, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:12'),
(83, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 08:10:50'),
(84, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:06'),
(85, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:36'),
(86, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:39'),
(87, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:56'),
(88, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:10'),
(89, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:21'),
(90, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:24'),
(91, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:17'),
(92, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:33'),
(93, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:53'),
(94, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:39'),
(95, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:16'),
(96, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:37'),
(97, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:51'),
(98, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:36'),
(99, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:54'),
(100, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:43'),
(101, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:45'),
(102, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:52'),
(103, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:00'),
(104, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:03'),
(105, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:06'),
(106, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:48'),
(107, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:18'),
(108, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:35'),
(109, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:04'),
(110, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:34'),
(111, 'sadsad', 'adsadsad@asdkl.com', '0', '["15","16","19","20"]', 7, 52.27, '2016-10-24 09:10:52'),
(112, 'susanto', 'susanto@gmail.com', '0', '["8","9","14","20"]', 5, 30.00, '2016-10-24 09:10:52'),
(113, 'asdad', 'sadads@asdasd.com', '0', '["1"]', 1, 50.00, '2016-10-24 09:10:13'),
(114, 'sadad', 'adsadsad@asdkl.com', '0', '["1","2"]', 1, 66.67, '2016-10-24 09:10:28'),
(115, 'asdad', 'Sadada@asdad.com', '0', '["5","10","11","14","17","18"]', 9, 50.00, '2016-10-24 09:10:45'),
(116, 'satu', 'sandipermanasoebagio@gmail.com', '0', '["1","3"]', 1, 50.00, '2016-10-24 09:10:15'),
(117, 'asdad', 'sadsad@asdad.com', '0', '["8","10","11","15"]', 5, 52.54, '2016-10-24 09:10:40'),
(118, 'asdasd', 'sadasd@asdad.com', '0', '["1"]', 1, 50.00, '2016-10-24 09:10:21'),
(119, 'fsfdkl', 'sandalJepit@gmail.com', '0', '["7","17","20","24"]', 9, 25.00, '2016-10-24 09:10:59'),
(120, 'aa', 'bb', '0', '["1","3","5"]', 1, 50.00, '2016-10-24 10:10:35'),
(121, 'aa', 'bb', '0', '["22","23","24"]', 12, 64.00, '2016-10-24 10:10:50'),
(122, 'asdasd', 'sadsad@sajkdasj.com', '0', '["1","2","3","4","5"]', 1, 66.67, '2016-10-24 10:10:20'),
(123, 'aa', 'bb', '0', '["3","4","5","9","10"]', 4, 55.56, '2016-10-24 10:10:45'),
(124, 'aa', 'bb', '0', '["3","4","5","9","10","22","23","24"]', 12, 64.00, '2016-10-24 10:10:05'),
(125, 'asd', 'asd', '0', '["22","23","24"]', 12, 64.00, '2016-10-24 10:10:35');

-- --------------------------------------------------------

--
-- Struktur untuk view `01-view-matriks-kerusakan`
--
DROP TABLE IF EXISTS `01-view-matriks-kerusakan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `01-view-matriks-kerusakan` AS select distinct `a`.`id_gejala` AS `id_gejala`,`a`.`kode` AS `kode`,sum(if((`b`.`id_kerusakan` = 1),`a`.`id_gejala`,0)) AS `P1`,sum(if((`b`.`id_kerusakan` = 2),`a`.`id_gejala`,0)) AS `P2`,sum(if((`b`.`id_kerusakan` = 3),`a`.`id_gejala`,0)) AS `P3`,sum(if((`b`.`id_kerusakan` = 4),`a`.`id_gejala`,0)) AS `P4`,sum(if((`b`.`id_kerusakan` = 5),`a`.`id_gejala`,0)) AS `P5` from ((`gejala` `a` left join `kerusakan_gejala` `b` on((`b`.`id_gejala` = `a`.`id_gejala`))) left join `kerusakan` `c` on((`c`.`id_kerusakan` = `b`.`id_kerusakan`))) group by `a`.`id_gejala`;

-- --------------------------------------------------------

--
-- Struktur untuk view `01-view-matriks-kerusakan-densitas`
--
DROP TABLE IF EXISTS `01-view-matriks-kerusakan-densitas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `01-view-matriks-kerusakan-densitas` AS select distinct `a`.`id_gejala` AS `id_gejala`,`a`.`kode` AS `kode`,sum(if((`b`.`id_kerusakan` = 1),(1 - `a`.`densitas`),0)) AS `P1`,sum(if((`b`.`id_kerusakan` = 2),(1 - `a`.`densitas`),0)) AS `P2`,sum(if((`b`.`id_kerusakan` = 3),(1 - `a`.`densitas`),0)) AS `P3`,sum(if((`b`.`id_kerusakan` = 4),(1 - `a`.`densitas`),0)) AS `P4`,`a`.`densitas` AS `densitas` from ((`gejala` `a` left join `kerusakan_gejala` `b` on((`b`.`id_gejala` = `a`.`id_gejala`))) left join `kerusakan` `c` on((`c`.`id_kerusakan` = `b`.`id_kerusakan`))) group by `a`.`id_gejala`;

-- --------------------------------------------------------

--
-- Struktur untuk view `01-view-matriks-kerusakan-logika`
--
DROP TABLE IF EXISTS `01-view-matriks-kerusakan-logika`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `01-view-matriks-kerusakan-logika` AS select distinct `a`.`id_gejala` AS `id_gejala`,`a`.`kode` AS `kode`,sum(if((`b`.`id_kerusakan` = 1),1,0)) AS `P1`,sum(if((`b`.`id_kerusakan` = 2),1,0)) AS `P2`,sum(if((`b`.`id_kerusakan` = 3),1,0)) AS `P3`,sum(if((`b`.`id_kerusakan` = 4),1,0)) AS `P4`,sum(if((`b`.`id_kerusakan` = 5),1,0)) AS `P5` from ((`gejala` `a` left join `kerusakan_gejala` `b` on((`b`.`id_gejala` = `a`.`id_gejala`))) left join `kerusakan` `c` on((`c`.`id_kerusakan` = `b`.`id_kerusakan`))) group by `a`.`id_gejala`;

-- --------------------------------------------------------

--
-- Struktur untuk view `01-view-teta`
--
DROP TABLE IF EXISTS `01-view-teta`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `01-view-teta` AS select `a`.`id_kerusakan` AS `id_kerusakan`,`a`.`id_gejala` AS `id_gejala`,`c`.`kode` AS `kode_p`,`b`.`kode` AS `kode_g`,`b`.`gejala` AS `gejala`,`b`.`densitas` AS `densitas`,(1 - `b`.`densitas`) AS `teta` from ((`kerusakan_gejala` `a` left join `kerusakan` `c` on((`c`.`id_kerusakan` = `a`.`id_kerusakan`))) left join `gejala` `b` on((`b`.`id_gejala` = `a`.`id_gejala`)));

-- --------------------------------------------------------

--
-- Struktur untuk view `02-view-teta-simple`
--
DROP TABLE IF EXISTS `02-view-teta-simple`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `02-view-teta-simple` AS select `a`.`kode_p` AS `kode_p`,`a`.`kode_g` AS `kode_g`,`a`.`densitas` AS `densitas`,`a`.`teta` AS `teta`,`a`.`id_kerusakan` AS `id_kerusakan`,`a`.`id_gejala` AS `id_gejala` from `01-view-teta` `a` group by `a`.`id_kerusakan`,`a`.`id_gejala` order by `a`.`id_kerusakan`,`a`.`id_gejala`;

-- --------------------------------------------------------

--
-- Struktur untuk view `03-0-view-all-gejala`
--
DROP TABLE IF EXISTS `03-0-view-all-gejala`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `03-0-view-all-gejala` AS select `a`.`id_kerusakan_gejala` AS `id_kerusakan_gejala`,`a`.`id_kerusakan` AS `id_kerusakan`,`a`.`id_gejala` AS `id_gejala`,`c`.`kerusakan` AS `kerusakan`,`c`.`kode` AS `kode_p`,`b`.`kode` AS `kode_g`,`b`.`gejala` AS `gejala`,`b`.`keterangan` AS `keterangan`,`a`.`density` AS `density` from ((`kerusakan_gejala` `a` join `gejala` `b` on((`b`.`id_gejala` = `a`.`id_gejala`))) join `kerusakan` `c` on((`c`.`id_kerusakan` = `a`.`id_kerusakan`)));

-- --------------------------------------------------------

--
-- Struktur untuk view `03-1-get-all-index`
--
DROP TABLE IF EXISTS `03-1-get-all-index`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `03-1-get-all-index` AS select `a`.`id_g_index` AS `id_g_index`,`a`.`noindex` AS `noindex`,`a`.`id_p` AS `id_p`,`a`.`id_g` AS `id_g`,`a`.`d` AS `d`,`a`.`t` AS `t` from `gejala_index` `a`;

-- --------------------------------------------------------

--
-- Struktur untuk view `03-2-define-m`
--
DROP TABLE IF EXISTS `03-2-define-m`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `03-2-define-m` AS select `a`.`id_g_index` AS `id_g_index`,`a`.`id_p` AS `id_p`,count(`a`.`noindex`) AS `jml`,sum(if((`a`.`noindex` = 1),`a`.`d`,0)) AS `m1`,sum(if((`a`.`noindex` = 1),`a`.`t`,0)) AS `mt1`,sum(if((`a`.`noindex` = 2),`a`.`d`,0)) AS `m2`,sum(if((`a`.`noindex` = 2),`a`.`t`,0)) AS `mt2`,sum(if((`a`.`noindex` = 3),`a`.`d`,0)) AS `m3`,sum(if((`a`.`noindex` = 3),`a`.`t`,0)) AS `mt3`,sum(if((`a`.`noindex` = 4),`a`.`d`,0)) AS `m4`,sum(if((`a`.`noindex` = 4),`a`.`t`,0)) AS `mt4`,sum(if((`a`.`noindex` = 5),`a`.`d`,0)) AS `m5`,sum(if((`a`.`noindex` = 5),`a`.`t`,0)) AS `mt5`,sum(if((`a`.`noindex` = 6),`a`.`d`,0)) AS `m6`,sum(if((`a`.`noindex` = 6),`a`.`t`,0)) AS `mt6`,sum(if((`a`.`noindex` = 7),`a`.`d`,0)) AS `m7`,sum(if((`a`.`noindex` = 7),`a`.`t`,0)) AS `mt7`,sum(if((`a`.`noindex` = 8),`a`.`d`,0)) AS `m8`,sum(if((`a`.`noindex` = 8),`a`.`t`,0)) AS `mt8`,sum(if((`a`.`noindex` = 9),`a`.`d`,0)) AS `m9`,sum(if((`a`.`noindex` = 9),`a`.`t`,0)) AS `mt9`,sum(if((`a`.`noindex` = 10),`a`.`d`,0)) AS `m10`,sum(if((`a`.`noindex` = 10),`a`.`t`,0)) AS `mt10`,`b`.`kode` AS `kode`,`b`.`kerusakan` AS `kerusakan`,`b`.`keterangan` AS `keterangan` from (`03-1-get-all-index` `a` join `kerusakan` `b` on((`b`.`id_kerusakan` = `a`.`id_p`))) group by `a`.`id_p`;

-- --------------------------------------------------------

--
-- Struktur untuk view `03-3-view-gejala`
--
DROP TABLE IF EXISTS `03-3-view-gejala`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `03-3-view-gejala` AS select `a`.`id_gejala` AS `id_gejala`,`a`.`kode` AS `kode`,`a`.`gejala` AS `gejala`,`a`.`keterangan` AS `keterangan`,`a`.`densitas` AS `densitas` from `gejala` `a`;

-- --------------------------------------------------------

--
-- Struktur untuk view `04-view-gejala-kerusakan`
--
DROP TABLE IF EXISTS `04-view-gejala-kerusakan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `04-view-gejala-kerusakan` AS select `a`.`id_kerusakan` AS `id_kerusakan`,`a`.`id_gejala` AS `id_gejala`,`b`.`kode` AS `kode`,`b`.`kerusakan` AS `kerusakan`,`b`.`keterangan` AS `keterangan`,`b`.`penyebab` AS `penyebab`,`b`.`penanggulangan` AS `penanggulangan`,`c`.`kode` AS `kode_g`,`c`.`gejala` AS `gejala`,`c`.`densitas` AS `densitas` from ((`kerusakan_gejala` `a` join `kerusakan` `b` on((`b`.`id_kerusakan` = `a`.`id_kerusakan`))) join `gejala` `c` on((`c`.`id_gejala` = `a`.`id_gejala`)));

-- --------------------------------------------------------

--
-- Struktur untuk view `04-view-inferensi`
--
DROP TABLE IF EXISTS `04-view-inferensi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `04-view-inferensi` AS select `a`.`id_kerusakan_gejala` AS `id_kerusakan_gejala`,`b`.`kode` AS `kode_p`,`b`.`kerusakan` AS `kerusakan`,`c`.`kode` AS `kode_g`,`c`.`gejala` AS `gejala`,`a`.`datetime` AS `datetime`,`a`.`id_kerusakan` AS `id_kerusakan`,`a`.`id_gejala` AS `id_gejala`,`a`.`densitas` AS `densitas` from ((`rule_inferensi` `a` join `gejala` `c` on((`c`.`id_gejala` = `a`.`id_gejala`))) join `kerusakan` `b` on((`b`.`id_kerusakan` = `a`.`id_kerusakan`)));

-- --------------------------------------------------------

--
-- Struktur untuk view `05-view-hasil-wizard`
--
DROP TABLE IF EXISTS `05-view-hasil-wizard`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `05-view-hasil-wizard` AS select `a`.`id_wizard` AS `id_wizard`,`a`.`nama_user` AS `nama_user`,`a`.`email` AS `email`,`a`.`hp` AS `hp`,`b`.`kode` AS `kode`,`b`.`kerusakan` AS `kerusakan`,`b`.`penyebab` AS `penyebab`,`b`.`penanggulangan` AS `penanggulangan`,`a`.`gejala_masukan` AS `gejala_masukan`,`a`.`hasil_believe` AS `hasil_believe`,`a`.`datetime` AS `datetime` from (`wizard` `a` join `kerusakan` `b` on((`b`.`id_kerusakan` = `a`.`hasil_id`)));

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gejala`
--
ALTER TABLE `gejala`
  ADD PRIMARY KEY (`id_gejala`);

--
-- Indexes for table `gejala_backup`
--
ALTER TABLE `gejala_backup`
  ADD PRIMARY KEY (`id_gejala`);

--
-- Indexes for table `gejala_index`
--
ALTER TABLE `gejala_index`
  ADD PRIMARY KEY (`id_g_index`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kerusakan`
--
ALTER TABLE `kerusakan`
  ADD PRIMARY KEY (`id_kerusakan`);

--
-- Indexes for table `kerusakan_gejala`
--
ALTER TABLE `kerusakan_gejala`
  ADD PRIMARY KEY (`id_kerusakan_gejala`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id_role`);

--
-- Indexes for table `rule_inferensi`
--
ALTER TABLE `rule_inferensi`
  ADD PRIMARY KEY (`id_kerusakan_gejala`);

--
-- Indexes for table `temp`
--
ALTER TABLE `temp`
  ADD PRIMARY KEY (`id_temp`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_groups`
--
ALTER TABLE `users_groups`
  ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `uc_users_groups` (`user_id`,`group_id`), ADD KEY `fk_users_groups_users1_idx` (`user_id`), ADD KEY `fk_users_groups_groups1_idx` (`group_id`);

--
-- Indexes for table `wizard`
--
ALTER TABLE `wizard`
  ADD PRIMARY KEY (`id_wizard`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `gejala`
--
ALTER TABLE `gejala`
  MODIFY `id_gejala` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `gejala_backup`
--
ALTER TABLE `gejala_backup`
  MODIFY `id_gejala` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `gejala_index`
--
ALTER TABLE `gejala_index`
  MODIFY `id_g_index` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
  MODIFY `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `kerusakan`
--
ALTER TABLE `kerusakan`
  MODIFY `id_kerusakan` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `kerusakan_gejala`
--
ALTER TABLE `kerusakan_gejala`
  MODIFY `id_kerusakan_gejala` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=194;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id_role` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `rule_inferensi`
--
ALTER TABLE `rule_inferensi`
  MODIFY `id_kerusakan_gejala` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `temp`
--
ALTER TABLE `temp`
  MODIFY `id_temp` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `users_groups`
--
ALTER TABLE `users_groups`
  MODIFY `id` int(11) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT for table `wizard`
--
ALTER TABLE `wizard`
  MODIFY `id_wizard` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=126;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `users_groups`
--
ALTER TABLE `users_groups`
ADD CONSTRAINT `users_groups_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
ADD CONSTRAINT `users_groups_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
