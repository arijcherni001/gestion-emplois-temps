-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 25 mai 2024 à 11:57
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `emploidutemps_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `id` int(11) NOT NULL,
  `classe` varchar(30) NOT NULL,
  `matiere` varchar(80) NOT NULL,
  `num_jour` smallint(6) DEFAULT NULL,
  `jour` varchar(20) NOT NULL,
  `heure` varchar(20) NOT NULL,
  `matricule_ens` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`id`, `classe`, `matiere`, `num_jour`, `jour`, `heure`, `matricule_ens`) VALUES
(1, '1L_SE', 'Anglais', 1, 'LUNDI', '08:00-10:00', 'ens1'),
(2, '2L_SE', 'Automatique ', 2, 'MARDI', '10:00-12:00', 'ens2'),
(3, '2L_CS', 'Cloud ', 3, 'MERCREDI', '13:00-15:00', 'ens3'),
(4, '1L_SE', 'Capteurs', 4, 'JEUDI', '15:00-17:00', 'ens4'),
(5, '2L_CS', 'Développement mobile', 5, 'VENDREDI', '08:00-10:00', 'ens5'),
(6, '1L_IRS', 'Algèbre', 1, 'LUNDI', '10:00-12:00', 'ens6'),
(7, '1L_SE', 'Bases de données', 2, 'MARDI', '13:00-15:00', 'ens7'),
(10, '2L_IRS', 'réseaux', 5, 'VENDREDI', '10:00-12:00', 'ens10'),
(11, '1L_IRS', 'Systèmes d\'exploitation', 1, 'LUNDI', '10:00-12:00', 'ens1'),
(12, '2L_CS', 'Physique', 2, 'MARDI', '13:00-15:00', 'ens2'),
(13, '1L_IRS', 'Électronique', 3, 'MERCREDI', '15:00-17:00', 'ens3'),
(14, '3L_SE', 'Électronique', 4, 'JEUDI', '10:00-12:00', 'ens4'),
(15, '1L_IRS', 'Bases de données', 5, 'VENDREDI', '13:00-15:00', 'ens5'),
(16, '2L_SE', 'Analyse', 1, 'LUNDI', '08:00-10:00', 'ens1'),
(17, '3L_IRS', 'Anglais ', 2, 'MARDI', '10:00-12:00', 'ens2'),
(18, '1L_IRS', 'Onde ', 3, 'MERCREDI', '13:00-15:00', 'ens3'),
(20, '3L_CS', 'gestion d\'entreprises', 5, 'VENDREDI', '08:00-10:00', 'ens5'),
(21, '2L_CS', 'Geographie', 1, 'LUNDI', '10:00-12:00', 'ens6'),
(22, '2L_IRS', 'Analyse', 2, 'MARDI', '13:00-15:00', 'ens7'),
(23, '1L_SE', 'Algèbre', 3, 'MERCREDI', '15:00-17:00', 'ens8'),
(24, '2L_CS', 'Système d\'exploitation', 4, 'JEUDI', '08:00-10:00', 'ens9'),
(25, '3L_CS', 'Services réseau', 5, 'VENDREDI', '10:00-12:00', 'ens10'),
(26, '1L_CS', 'algorithmique', 1, 'LUNDI', '10:00-12:00', 'ens1'),
(27, '2L_IRS', 'systèmes logique', 2, 'MARDI', '13:00-15:00', 'ens2'),
(28, '3L_SE', 'Algèbre', 3, 'MERCREDI', '15:00-17:00', 'ens3'),
(29, '1L_CS', 'Angalis ', 4, 'JEUDI', '10:00-12:00', 'ens4'),
(30, '2L_CS', 'Programmation Python', 5, 'VENDREDI', '13:00-15:00', 'ens5'),
(31, '1L_SE', 'Mathematiques', 1, 'LUNDI', '08:00-10:00', 'ens1'),
(32, '1L_SE', 'Systèmes d\'exploitation', 4, 'JEUDI', '08:00-10:00', 'ens9'),
(44, '3L_IRS', 'IA', 1, 'LUNDI', '10:00-12:00', 'ens8'),
(45, '2L_CS', 'IA', 3, 'MERCREDI', '15:00-17:00', 'ens4'),
(46, '1L_IRS', 'Math', 6, 'SAMEDI', '10:00-12:00', 'ens2'),
(47, '3L_SE', 'IA ', 3, 'MERCREDI', '13:00-15:00', 'ens5'),
(49, '1L_IRS', 'Ia', 4, 'JEUDI', '10:00-12:00', 'ENS5');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `matricule` varchar(20) NOT NULL,
  `nom` varchar(150) NOT NULL,
  `contact` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`matricule`, `nom`, `contact`) VALUES
('ens1', 'Molka ', '42524555'),
('ens10', 'Youssef Naceur', '60123456'),
('ens2', 'Ahmed Cherni', '21548525'),
('ens20', 'Cherni Rihab ', '26325831'),
('ens3', 'Hassan Chahed', '63456789'),
('ens4', 'Fatima Dridi', '64567890'),
('ens45', 'atef', '6675555'),
('ens5', 'Amina Gharbi', '65678901'),
('ens6', 'Ali Hammami', '66789012'),
('ens7', 'Sami Kefi', '67890123'),
('ens8', 'Imen Lahmar', '68901234'),
('ens9', 'Sonia Mabrouk', '69012345');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `enseignant_cours`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `enseignant_cours` (
`matricule` varchar(20)
,`nom` varchar(150)
,`contact` varchar(50)
,`id` int(11)
,`classe` varchar(30)
,`matiere` varchar(80)
,`num_jour` smallint(6)
,`jour` varchar(20)
,`heure` varchar(20)
);

-- --------------------------------------------------------

--
-- Structure de la vue `enseignant_cours`
--
DROP TABLE IF EXISTS `enseignant_cours`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `enseignant_cours`  AS SELECT `enseignant`.`matricule` AS `matricule`, `enseignant`.`nom` AS `nom`, `enseignant`.`contact` AS `contact`, `cours`.`id` AS `id`, `cours`.`classe` AS `classe`, `cours`.`matiere` AS `matiere`, `cours`.`num_jour` AS `num_jour`, `cours`.`jour` AS `jour`, `cours`.`heure` AS `heure` FROM (`enseignant` join `cours` on(`enseignant`.`matricule` = `cours`.`matricule_ens`)) ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk` (`matricule_ens`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`matricule`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `fk` FOREIGN KEY (`matricule_ens`) REFERENCES `enseignant` (`matricule`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
