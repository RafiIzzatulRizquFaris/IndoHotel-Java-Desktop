-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 05 Apr 2020 pada 15.50
-- Versi server: 10.4.10-MariaDB
-- Versi PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `indohoteldb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `available`
--

CREATE TABLE `available` (
  `id_jenis_kamar` int(11) NOT NULL,
  `jumlah_kamar` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `available`
--

INSERT INTO `available` (`id_jenis_kamar`, `jumlah_kamar`) VALUES
(1, 3),
(2, 2),
(3, 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `employee`
--

CREATE TABLE `employee` (
  `id_employee` int(11) NOT NULL,
  `username_employee` varchar(50) NOT NULL,
  `password_employee` varchar(100) NOT NULL,
  `name_employee` varchar(50) NOT NULL,
  `tanggal_employee` date NOT NULL,
  `jenis_kelamin_employee` varchar(50) NOT NULL,
  `email_employee` varchar(50) NOT NULL,
  `role_employee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `employee`
--

INSERT INTO `employee` (`id_employee`, `username_employee`, `password_employee`, `name_employee`, `tanggal_employee`, `jenis_kelamin_employee`, `email_employee`, `role_employee`) VALUES
(3, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', '2000-11-28', 'Laki', 'admin@gih.com', 1),
(4, 'quifar', '81dc9bdb52d04dc20036dbd8313ed055', 'Rafi Izzatul Rizqu Faris', '2002-11-28', 'Laki', 'risqufaris@gmail.com', 2),
(6, 'rifat', '35c0c28414ac08bb8b6729631f69ee01', 'Rifat Khadafy', '2020-03-01', 'Laki', 'khadafy@gmail.com', 2),
(7, 'akmal', '827ccb0eea8a706c4c34a16891f84e7b', 'Akmal Permata Sukma', '2003-03-14', 'Laki', 'akmal@gih.com', 2);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jeniskamar`
--

CREATE TABLE `jeniskamar` (
  `id_jenis_kamar` int(11) NOT NULL,
  `nama_jenis_kamar` varchar(50) DEFAULT NULL,
  `harga_jenis_kamar` int(11) DEFAULT NULL,
  `keterangan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jeniskamar`
--

INSERT INTO `jeniskamar` (`id_jenis_kamar`, `nama_jenis_kamar`, `harga_jenis_kamar`, `keterangan`) VALUES
(1, 'Economic', 500000, 'The Lowest Price'),
(2, 'Medium Sized', 1000000, 'For the Medium sized Bed'),
(3, 'Luxury', 2000000, 'The Hedon Price');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kamar`
--

CREATE TABLE `kamar` (
  `id_kamar` int(11) NOT NULL,
  `id_jenis_kamar` int(11) DEFAULT NULL,
  `nomor_kamar` int(3) DEFAULT NULL,
  `lantai_kamar` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kamar`
--

INSERT INTO `kamar` (`id_kamar`, `id_jenis_kamar`, `nomor_kamar`, `lantai_kamar`) VALUES
(19, 1, 111, '1'),
(20, 1, 112, '1'),
(21, 2, 221, '2'),
(22, 2, 222, '2'),
(23, 3, 331, '3'),
(24, 3, 332, '3'),
(25, 1, 113, '1');

--
-- Trigger `kamar`
--
DELIMITER $$
CREATE TRIGGER `available_room` AFTER INSERT ON `kamar` FOR EACH ROW BEGIN
INSERT INTO available SET id_jenis_kamar = new.id_jenis_kamar, jumlah_kamar = 1
ON duplicate KEY UPDATE jumlah_kamar = jumlah_kamar + 1;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` int(11) NOT NULL,
  `nama_pelanggan` varchar(50) DEFAULT NULL,
  `nomor_telepon` varchar(50) DEFAULT NULL,
  `nomor_identitas` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `nomor_telepon`, `nomor_identitas`) VALUES
(1, 'quifar', '082299189919', '18191146'),
(2, 'purdit', '0896ww22', '18191145'),
(3, 'Raid', '085771933140', '18191132'),
(6, 'abdi', '908098', '2131231');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_pembayaran` int(11) NOT NULL,
  `id_checkout` int(11) DEFAULT NULL,
  `id_pelanggan` int(11) DEFAULT NULL,
  `total_pembayaran` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembayaran`
--

INSERT INTO `pembayaran` (`id_pembayaran`, `id_checkout`, `id_pelanggan`, `total_pembayaran`) VALUES
(18, 21, 1, 509000),
(19, 22, 3, 2000000),
(20, 23, 1, 0),
(21, 24, 1, -10000000),
(22, 25, 1, 0),
(23, 26, 1, 0),
(24, 27, 1, 0),
(25, 28, 1, 0),
(26, 29, 3, 4000000),
(27, 30, 1, 1500000),
(28, 31, 4, 5000000),
(29, 32, 1, 16000000),
(30, 33, 2, 8000000),
(31, 34, 1, 500000),
(32, 35, 1, 500000),
(33, 36, 1, 515000),
(34, 37, 3, 4120000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `reservasi`
--

CREATE TABLE `reservasi` (
  `id_reservasi` int(11) NOT NULL,
  `id_pelanggan` int(11) DEFAULT NULL,
  `id_kamar` int(11) DEFAULT NULL,
  `tgl_checkin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Trigger `reservasi`
--
DELIMITER $$
CREATE TRIGGER `reservasi_kamar` AFTER INSERT ON `reservasi` FOR EACH ROW BEGIN
UPDATE available SET jumlah_kamar = jumlah_kamar - 1 WHERE id_jenis_kamar = (SELECT kamar.id_jenis_kamar FROM kamar WHERE kamar.id_kamar = new.id_kamar);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `reservasi_pelanggan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `reservasi_pelanggan` (
`id_reservasi` int(11)
,`id_kamar` int(11)
,`tgl_checkin` date
,`id_pelanggan` int(11)
,`nama_pelanggan` varchar(50)
,`nomor_telepon` varchar(50)
,`nomor_identitas` varchar(50)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `reservasi_pelanggan_kamar_jeniskamar`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `reservasi_pelanggan_kamar_jeniskamar` (
`id_reservasi` int(11)
,`tgl_checkin` date
,`id_pelanggan` int(11)
,`nama_pelanggan` varchar(50)
,`nomor_telepon` varchar(50)
,`nomor_identitas` varchar(50)
,`id_kamar` int(11)
,`nama_jenis_kamar` varchar(50)
,`harga_jenis_kamar` int(11)
,`keterangan` text
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `roomcheckout`
--

CREATE TABLE `roomcheckout` (
  `id_checkout` int(11) NOT NULL,
  `id_reservasi` int(11) DEFAULT NULL,
  `id_pelanggan` int(11) DEFAULT NULL,
  `id_kamar` int(11) DEFAULT NULL,
  `tgl_checkout` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `roomcheckout`
--

INSERT INTO `roomcheckout` (`id_checkout`, `id_reservasi`, `id_pelanggan`, `id_kamar`, `tgl_checkout`) VALUES
(21, 20, 1, 19, '2020-03-12'),
(22, 22, 3, 21, '2020-03-14'),
(23, 23, 1, 21, '2020-03-15'),
(24, 24, 1, 24, '2020-03-10'),
(25, 25, 1, 19, '2020-03-15'),
(26, 26, 1, 19, '2020-03-15'),
(27, 27, 1, 22, '2020-03-15'),
(28, 28, 1, 21, '2020-03-15'),
(29, 29, 3, 24, '2020-03-17'),
(30, 30, 1, 19, '2020-03-18'),
(31, 31, 4, 22, '2020-03-20'),
(32, 32, 1, 21, '2020-03-31'),
(33, 33, 2, 20, '2020-03-31'),
(34, 34, 1, 19, '2020-03-16'),
(35, 35, 1, 19, '2020-03-16'),
(36, 36, 1, 19, '2020-03-16'),
(37, 37, 3, 23, '2020-04-07');

--
-- Trigger `roomcheckout`
--
DELIMITER $$
CREATE TRIGGER `add_available` AFTER INSERT ON `roomcheckout` FOR EACH ROW BEGIN
INSERT INTO available SET available.id_jenis_kamar = (SELECT kamar.id_jenis_kamar FROM kamar WHERE kamar.id_kamar = new.id_kamar), jumlah_kamar = 1
ON duplicate KEY UPDATE jumlah_kamar = jumlah_kamar + 1;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `delete_reservasi` AFTER INSERT ON `roomcheckout` FOR EACH ROW BEGIN
DELETE FROM reservasi WHERE reservasi.id_reservasi = new.id_reservasi;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `print_pembayaran` AFTER INSERT ON `roomcheckout` FOR EACH ROW BEGIN
INSERT INTO pembayaran SET pembayaran.id_checkout = new.id_checkout, pembayaran.id_pelanggan = new.id_pelanggan, pembayaran.total_pembayaran = (SELECT datediff(new.tgl_checkout, reservasi.tgl_checkin)*jeniskamar.harga_jenis_kamar FROM reservasi, jeniskamar, kamar WHERE jeniskamar.id_jenis_kamar = kamar.id_jenis_kamar AND reservasi.id_kamar = kamar.id_kamar AND reservasi.id_reservasi = new.id_reservasi);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_role`
--

CREATE TABLE `user_role` (
  `id_role` int(11) NOT NULL,
  `name_role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user_role`
--

INSERT INTO `user_role` (`id_role`, `name_role`) VALUES
(1, 'admin'),
(2, 'employee');

-- --------------------------------------------------------

--
-- Struktur untuk view `reservasi_pelanggan`
--
DROP TABLE IF EXISTS `reservasi_pelanggan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reservasi_pelanggan`  AS  (select `reservasi`.`id_reservasi` AS `id_reservasi`,`reservasi`.`id_kamar` AS `id_kamar`,`reservasi`.`tgl_checkin` AS `tgl_checkin`,`pelanggan`.`id_pelanggan` AS `id_pelanggan`,`pelanggan`.`nama_pelanggan` AS `nama_pelanggan`,`pelanggan`.`nomor_telepon` AS `nomor_telepon`,`pelanggan`.`nomor_identitas` AS `nomor_identitas` from (`reservasi` join `pelanggan`) where `pelanggan`.`id_pelanggan` = `reservasi`.`id_pelanggan`) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `reservasi_pelanggan_kamar_jeniskamar`
--
DROP TABLE IF EXISTS `reservasi_pelanggan_kamar_jeniskamar`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `reservasi_pelanggan_kamar_jeniskamar`  AS  (select `reservasi`.`id_reservasi` AS `id_reservasi`,`reservasi`.`tgl_checkin` AS `tgl_checkin`,`pelanggan`.`id_pelanggan` AS `id_pelanggan`,`pelanggan`.`nama_pelanggan` AS `nama_pelanggan`,`pelanggan`.`nomor_telepon` AS `nomor_telepon`,`pelanggan`.`nomor_identitas` AS `nomor_identitas`,`kamar`.`id_kamar` AS `id_kamar`,`jeniskamar`.`nama_jenis_kamar` AS `nama_jenis_kamar`,`jeniskamar`.`harga_jenis_kamar` AS `harga_jenis_kamar`,`jeniskamar`.`keterangan` AS `keterangan` from (((`reservasi` join `kamar`) join `jeniskamar`) join `pelanggan`) where `reservasi`.`id_pelanggan` = `pelanggan`.`id_pelanggan` and `kamar`.`id_kamar` = `reservasi`.`id_kamar` and `kamar`.`id_jenis_kamar` = `jeniskamar`.`id_jenis_kamar`) ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `available`
--
ALTER TABLE `available`
  ADD UNIQUE KEY `id_jenis_kamar` (`id_jenis_kamar`);

--
-- Indeks untuk tabel `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id_employee`),
  ADD KEY `fk_role_employee` (`role_employee`);

--
-- Indeks untuk tabel `jeniskamar`
--
ALTER TABLE `jeniskamar`
  ADD PRIMARY KEY (`id_jenis_kamar`);

--
-- Indeks untuk tabel `kamar`
--
ALTER TABLE `kamar`
  ADD PRIMARY KEY (`id_kamar`),
  ADD KEY `fkjeniskamar` (`id_jenis_kamar`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indeks untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_pembayaran`);

--
-- Indeks untuk tabel `reservasi`
--
ALTER TABLE `reservasi`
  ADD PRIMARY KEY (`id_reservasi`),
  ADD KEY `fkkamar` (`id_kamar`);

--
-- Indeks untuk tabel `roomcheckout`
--
ALTER TABLE `roomcheckout`
  ADD PRIMARY KEY (`id_checkout`);

--
-- Indeks untuk tabel `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id_role`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `employee`
--
ALTER TABLE `employee`
  MODIFY `id_employee` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `jeniskamar`
--
ALTER TABLE `jeniskamar`
  MODIFY `id_jenis_kamar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `kamar`
--
ALTER TABLE `kamar`
  MODIFY `id_kamar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  MODIFY `id_pelanggan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_pembayaran` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT untuk tabel `reservasi`
--
ALTER TABLE `reservasi`
  MODIFY `id_reservasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT untuk tabel `roomcheckout`
--
ALTER TABLE `roomcheckout`
  MODIFY `id_checkout` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `available`
--
ALTER TABLE `available`
  ADD CONSTRAINT `fkjeniskamartersedia` FOREIGN KEY (`id_jenis_kamar`) REFERENCES `jeniskamar` (`id_jenis_kamar`);

--
-- Ketidakleluasaan untuk tabel `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_role_employee` FOREIGN KEY (`role_employee`) REFERENCES `user_role` (`id_role`);

--
-- Ketidakleluasaan untuk tabel `kamar`
--
ALTER TABLE `kamar`
  ADD CONSTRAINT `fkjeniskamar` FOREIGN KEY (`id_jenis_kamar`) REFERENCES `jeniskamar` (`id_jenis_kamar`);

--
-- Ketidakleluasaan untuk tabel `reservasi`
--
ALTER TABLE `reservasi`
  ADD CONSTRAINT `fkkamar` FOREIGN KEY (`id_kamar`) REFERENCES `kamar` (`id_kamar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
