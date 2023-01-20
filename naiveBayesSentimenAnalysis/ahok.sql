-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08 Des 2016 pada 05.07
-- Versi Server: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ahok`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_dokumen`
--

CREATE TABLE IF NOT EXISTS `tb_dokumen` (
  `id_dokumen` int(11) NOT NULL,
  `deskripsi_dokumen` varchar(455) NOT NULL,
  `munafik` int(11) NOT NULL,
  `dukung` int(11) NOT NULL,
  `maju` int(11) NOT NULL,
  `jelek` int(11) NOT NULL,
  `kecewa` int(11) NOT NULL,
  `class` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_dokumen`
--

INSERT INTO `tb_dokumen` (`id_dokumen`, `deskripsi_dokumen`, `munafik`, `dukung`, `maju`, `jelek`, `kecewa`, `class`) VALUES
(16, 'ada manusia semunafik ahok.. Terang2an munafiknya tapi msh banyak orang goblok yg dukung ', 2, 1, 0, 0, 0, -1),
(17, 'mana tuh china china jelek yg teriak Islam munafik...MAKAN TUH AHOK JAUH LEBIH MUNAFIK ', 2, 0, 0, 1, 0, -1),
(18, 'manusia paling munafik di Indonesia itu ahok,omongan gak sesuai dengan perbuatan ,lewat jalur partai juga lo nyet', 1, 0, 0, 0, 0, -1),
(19, 'sumpah ngeliat kelakuan jokowi dan ahok bikin geleng geleng pala kecewa,gak habis pikir bajingan dua ini masih ada yg dukung untuk maju', 0, 1, 1, 0, 1, -1),
(20, 'Munafik kali ahok ini siang bilang A, besok bilang B.', 1, 0, 0, 0, 0, 1),
(21, 'Tapi namanya Ahok, mau maju lewat Komunitas Penggemar Capsa Susun aku tetap dukung dan itu bukan munafik', 1, 1, 1, 0, 0, 1),
(22, 'Apapun jalur yg dipilih @Ahok, akan tetap dapat dukungan rakyat;  Sekarang rakyat lebih melihat kualitas figur untuk jakarta yang maju.', 0, 1, 1, 0, 0, 1),
(23, 'Teman Ahok mendukung penuh keputusan tsb dan tidak kecewa. Kami yakin ini keputusan sulit dan beresiko yg diambil stlh mempertimbangkan byk', 0, 1, 0, 0, 1, 1),
(24, 'Berdasar survei, bagi warga DKI yg mendukung Ahok, tdk jadi soal apakah Ahok maju dari jalur independen atau partai', 0, 1, 1, 0, 0, 1),
(25, 'Jalur apapun yg dtempuh w ttp gk akan goyah untuk dukung pak Ahok karena kualitasnya gak jelek kok.', 0, 1, 0, 1, 0, 1),
(41, 'ahok kafir keparat mata duitan kurang ajar munafik ahok kafir keparat mata duitan kurang ajar munafik', 2, 0, 0, 0, 0, 1),
(42, 'Penetapan Ahok sebagai Tersangka Diwarnai Perbedaan Pendapat Ahli · Kapolri Singgung Ahok dan Kasus Jessica di Pengajian Habib', 0, 0, 0, 0, 0, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_dokumen`
--
ALTER TABLE `tb_dokumen`
  ADD PRIMARY KEY (`id_dokumen`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_dokumen`
--
ALTER TABLE `tb_dokumen`
  MODIFY `id_dokumen` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=43;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
