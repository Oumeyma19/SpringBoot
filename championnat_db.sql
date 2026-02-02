-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 02 fév. 2026 à 12:28
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
-- Base de données : `championnat_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `championnat`
--

CREATE TABLE `championnat` (
                               `id_championnat` bigint(20) NOT NULL,
                               `categorie` enum('FORMULA1','MOTOGP') DEFAULT NULL,
                               `code` varchar(255) DEFAULT NULL,
                               `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `championnat_courses`
--

CREATE TABLE `championnat_courses` (
                                       `championnats_id_championnat` bigint(20) NOT NULL,
                                       `courses_id_course` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
                           `archived` bit(1) DEFAULT NULL,
                           `montant` float DEFAULT NULL,
                           `equipe_id_equipe` bigint(20) DEFAULT NULL,
                           `id_contrat` bigint(20) NOT NULL,
                           `sponsor_id_sponsor` bigint(20) DEFAULT NULL,
                           `annee` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE `course` (
                          `date_course` date DEFAULT NULL,
                          `id_course` bigint(20) NOT NULL,
                          `emplacement` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `detail_championnat`
--

CREATE TABLE `detail_championnat` (
                                      `championnat_id_championnat` bigint(20) DEFAULT NULL,
                                      `id_detail_championnat` bigint(20) NOT NULL,
                                      `code` varchar(255) DEFAULT NULL,
                                      `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
                          `classement_general` int(11) DEFAULT NULL,
                          `nb_points_total` int(11) DEFAULT NULL,
                          `id_equipe` bigint(20) NOT NULL,
                          `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `pilote`
--

CREATE TABLE `pilote` (
                          `classement_general` int(11) DEFAULT NULL,
                          `nb_points_total` int(11) DEFAULT NULL,
                          `equipe_id_equipe` bigint(20) DEFAULT NULL,
                          `id_pilote` bigint(20) NOT NULL,
                          `libellep` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `position`
--

CREATE TABLE `position` (
                            `classement` int(11) DEFAULT NULL,
                            `nb_points` int(11) DEFAULT NULL,
                            `course_id_course` bigint(20) DEFAULT NULL,
                            `id_position` bigint(20) NOT NULL,
                            `pilote_id_pilote` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `sponsor`
--

CREATE TABLE `sponsor` (
                           `bloquer_contrat` bit(1) DEFAULT NULL,
                           `budget_annuel` float DEFAULT NULL,
                           `id_sponsor` bigint(20) NOT NULL,
                           `nom` varchar(255) DEFAULT NULL,
                           `pays` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `championnat`
--
ALTER TABLE `championnat`
    ADD PRIMARY KEY (`id_championnat`);

--
-- Index pour la table `championnat_courses`
--
ALTER TABLE `championnat_courses`
    ADD KEY `FK8jo9ldeo5kdrga9nplwm9hq94` (`courses_id_course`),
  ADD KEY `FKtddpd4j6762nto1n8scig1bn9` (`championnats_id_championnat`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
    ADD PRIMARY KEY (`id_contrat`),
  ADD KEY `FK44bs82lmkvxa2tc64om3jayuh` (`equipe_id_equipe`),
  ADD KEY `FKi4kkdpyyxwfhovvfq5e9nnpxg` (`sponsor_id_sponsor`);

--
-- Index pour la table `course`
--
ALTER TABLE `course`
    ADD PRIMARY KEY (`id_course`);

--
-- Index pour la table `detail_championnat`
--
ALTER TABLE `detail_championnat`
    ADD PRIMARY KEY (`id_detail_championnat`),
  ADD UNIQUE KEY `UK_rxyfrj39qo84m760mtswpi7cx` (`championnat_id_championnat`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
    ADD PRIMARY KEY (`id_equipe`);

--
-- Index pour la table `pilote`
--
ALTER TABLE `pilote`
    ADD PRIMARY KEY (`id_pilote`),
  ADD KEY `FKj7oagi90kxlxae5q5brso6a7a` (`equipe_id_equipe`);

--
-- Index pour la table `position`
--
ALTER TABLE `position`
    ADD PRIMARY KEY (`id_position`),
  ADD KEY `FKomcdqgk9bv898lypnjhht7c4w` (`course_id_course`),
  ADD KEY `FKh4keln0averws07s9760tc0tn` (`pilote_id_pilote`);

--
-- Index pour la table `sponsor`
--
ALTER TABLE `sponsor`
    ADD PRIMARY KEY (`id_sponsor`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `championnat`
--
ALTER TABLE `championnat`
    MODIFY `id_championnat` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
    MODIFY `id_contrat` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `course`
--
ALTER TABLE `course`
    MODIFY `id_course` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `detail_championnat`
--
ALTER TABLE `detail_championnat`
    MODIFY `id_detail_championnat` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
    MODIFY `id_equipe` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pilote`
--
ALTER TABLE `pilote`
    MODIFY `id_pilote` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `position`
--
ALTER TABLE `position`
    MODIFY `id_position` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `sponsor`
--
ALTER TABLE `sponsor`
    MODIFY `id_sponsor` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `championnat_courses`
--
ALTER TABLE `championnat_courses`
    ADD CONSTRAINT `FK8jo9ldeo5kdrga9nplwm9hq94` FOREIGN KEY (`courses_id_course`) REFERENCES `course` (`id_course`),
  ADD CONSTRAINT `FKtddpd4j6762nto1n8scig1bn9` FOREIGN KEY (`championnats_id_championnat`) REFERENCES `championnat` (`id_championnat`);

--
-- Contraintes pour la table `contrat`
--
ALTER TABLE `contrat`
    ADD CONSTRAINT `FK44bs82lmkvxa2tc64om3jayuh` FOREIGN KEY (`equipe_id_equipe`) REFERENCES `equipe` (`id_equipe`),
  ADD CONSTRAINT `FKi4kkdpyyxwfhovvfq5e9nnpxg` FOREIGN KEY (`sponsor_id_sponsor`) REFERENCES `sponsor` (`id_sponsor`);

--
-- Contraintes pour la table `detail_championnat`
--
ALTER TABLE `detail_championnat`
    ADD CONSTRAINT `FK7hsh6me0633nxb0iimwa6bmed` FOREIGN KEY (`championnat_id_championnat`) REFERENCES `championnat` (`id_championnat`);

--
-- Contraintes pour la table `pilote`
--
ALTER TABLE `pilote`
    ADD CONSTRAINT `FKj7oagi90kxlxae5q5brso6a7a` FOREIGN KEY (`equipe_id_equipe`) REFERENCES `equipe` (`id_equipe`);

--
-- Contraintes pour la table `position`
--
ALTER TABLE `position`
    ADD CONSTRAINT `FKh4keln0averws07s9760tc0tn` FOREIGN KEY (`pilote_id_pilote`) REFERENCES `pilote` (`id_pilote`),
  ADD CONSTRAINT `FKomcdqgk9bv898lypnjhht7c4w` FOREIGN KEY (`course_id_course`) REFERENCES `course` (`id_course`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
