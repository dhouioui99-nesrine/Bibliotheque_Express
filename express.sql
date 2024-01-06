-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 06 jan. 2024 à 16:41
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `express`
--

-- --------------------------------------------------------

--
-- Structure de la table `catalogue`
--

CREATE TABLE `catalogue` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `catalogue`
--

INSERT INTO `catalogue` (`id`, `description`, `nom`) VALUES
(1, 'LLL', 'LOCAL');

-- --------------------------------------------------------

--
-- Structure de la table `catalogue_livre`
--

CREATE TABLE `catalogue_livre` (
  `catalogue_id` bigint(20) NOT NULL,
  `livre_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `catalogue_livre`
--

INSERT INTO `catalogue_livre` (`catalogue_id`, `livre_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `name`) VALUES
(3, 'HISTOIRIQUE'),
(1, 'POLICIER'),
(2, 'ROMANCE'),
(4, 'science fiction');

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

CREATE TABLE `emprunt` (
  `id` bigint(20) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `renouvele` bit(1) NOT NULL,
  `livre_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`id`, `date_debut`, `date_fin`, `renouvele`, `livre_id`, `user_id`) VALUES
(1, '2024-01-17', '2024-01-23', b'0', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

CREATE TABLE `livre` (
  `id` bigint(20) NOT NULL,
  `exemplaire` int(11) NOT NULL,
  `auteur` varchar(255) NOT NULL,
  `date_pub` varchar(255) NOT NULL,
  `num_esrn` bigint(20) NOT NULL,
  `titre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `exemplaire`, `auteur`, `date_pub`, `num_esrn`, `titre`) VALUES
(1, 10, 'molia', '2024-01-01', 12368, 'remance'),
(2, 1, 'ADF', '2024-01-19', 145248204585, 'AA');

-- --------------------------------------------------------

--
-- Structure de la table `livre_cat`
--

CREATE TABLE `livre_cat` (
  `livre_id` bigint(20) NOT NULL,
  `categorie_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `livre_cat`
--

INSERT INTO `livre_cat` (`livre_id`, `categorie_id`) VALUES
(2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `rappel`
--

CREATE TABLE `rappel` (
  `id` bigint(20) NOT NULL,
  `date_rappel` date DEFAULT NULL,
  `emprunt_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL,
  `date_res` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `res_livre`
--

CREATE TABLE `res_livre` (
  `res_id` bigint(20) NOT NULL,
  `livre_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `res_user`
--

CREATE TABLE `res_user` (
  `res_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `name`, `password`) VALUES
(1, 'maya@gmail.com', 'maya elabed', '$2a$10$vTnr2KDOv5bElIt.MMywHuRdCIFnOsadfq1PA7PJ1Keubpb.1N7lO'),
(2, 'admin@gmail.com', 'admin admin', '$2a$10$rX8.uftWq6tECt65dpSbMufp093mC4n3A8MKo7V.fQ/.FOeRvgsTO'),
(3, 'nesrine@gmail.com', 'nesrine', '1234'),
(4, 'a@gmail.com', 'A A', '$2a$10$gJnDWqFU8PBL0LrXkbmE0Ova8t5wBx5uiai4oZOGKUlhFogFIW3qu'),
(5, 'amine@gmail.com', 'amine amine', '$2a$10$4Zr.bzvHxVLvGw9TQStTMen/YbZVQg7tjnAzjnSNCPeNZkIWQwMYa'),
(6, 'ness@gmail.com', 'ness ness', '$2a$10$JpW.YJch9IcT9n.8etEWoeP0LYZptZKh43TuAmX7mIjbeQPzfs2oK');

-- --------------------------------------------------------

--
-- Structure de la table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(4, 1),
(5, 2),
(6, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `catalogue`
--
ALTER TABLE `catalogue`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `catalogue_livre`
--
ALTER TABLE `catalogue_livre`
  ADD KEY `FK643nhac0ibdjvwrvsuqu85kfx` (`livre_id`),
  ADD KEY `FKdm0jjre56xu7ga4u3hy1dpurd` (`catalogue_id`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_g0q7wt2eac72pdh1knn9upk6b` (`name`);

--
-- Index pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjnn7ll8vl64xhmb6779svt7c` (`livre_id`),
  ADD KEY `FK60f2jqc8hjutggih44b96l37d` (`user_id`);

--
-- Index pour la table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `livre_cat`
--
ALTER TABLE `livre_cat`
  ADD KEY `FKoqgbsfaxfi10ksl9gdb4ldlil` (`categorie_id`),
  ADD KEY `FKskmn3x5ylbduvsnwsbjx4jdx8` (`livre_id`);

--
-- Index pour la table `rappel`
--
ALTER TABLE `rappel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmmyjc60v4ld0qfi0b3cw7a7vf` (`emprunt_id`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `res_livre`
--
ALTER TABLE `res_livre`
  ADD KEY `FKp6aaeva2r1jerv963qio7rokq` (`livre_id`),
  ADD KEY `FKhesp9dwqm2i6h2rercmemqx5g` (`res_id`);

--
-- Index pour la table `res_user`
--
ALTER TABLE `res_user`
  ADD KEY `FK32cxheh5xisl4mkl5ebdagmhp` (`user_id`),
  ADD KEY `FKpm3nsaylmvjkarhh1gghlncq8` (`res_id`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- Index pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  ADD KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `catalogue`
--
ALTER TABLE `catalogue`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `emprunt`
--
ALTER TABLE `emprunt`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `livre`
--
ALTER TABLE `livre`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `rappel`
--
ALTER TABLE `rappel`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=760;

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `catalogue_livre`
--
ALTER TABLE `catalogue_livre`
  ADD CONSTRAINT `FK643nhac0ibdjvwrvsuqu85kfx` FOREIGN KEY (`livre_id`) REFERENCES `livre` (`id`),
  ADD CONSTRAINT `FKdm0jjre56xu7ga4u3hy1dpurd` FOREIGN KEY (`catalogue_id`) REFERENCES `catalogue` (`id`);

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `FK60f2jqc8hjutggih44b96l37d` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKjnn7ll8vl64xhmb6779svt7c` FOREIGN KEY (`livre_id`) REFERENCES `livre` (`id`);

--
-- Contraintes pour la table `livre_cat`
--
ALTER TABLE `livre_cat`
  ADD CONSTRAINT `FKoqgbsfaxfi10ksl9gdb4ldlil` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`),
  ADD CONSTRAINT `FKskmn3x5ylbduvsnwsbjx4jdx8` FOREIGN KEY (`livre_id`) REFERENCES `livre` (`id`);

--
-- Contraintes pour la table `rappel`
--
ALTER TABLE `rappel`
  ADD CONSTRAINT `FKmmyjc60v4ld0qfi0b3cw7a7vf` FOREIGN KEY (`emprunt_id`) REFERENCES `emprunt` (`id`);

--
-- Contraintes pour la table `res_livre`
--
ALTER TABLE `res_livre`
  ADD CONSTRAINT `FKhesp9dwqm2i6h2rercmemqx5g` FOREIGN KEY (`res_id`) REFERENCES `reservation` (`id`),
  ADD CONSTRAINT `FKp6aaeva2r1jerv963qio7rokq` FOREIGN KEY (`livre_id`) REFERENCES `livre` (`id`);

--
-- Contraintes pour la table `res_user`
--
ALTER TABLE `res_user`
  ADD CONSTRAINT `FK32cxheh5xisl4mkl5ebdagmhp` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKpm3nsaylmvjkarhh1gghlncq8` FOREIGN KEY (`res_id`) REFERENCES `reservation` (`id`);

--
-- Contraintes pour la table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
