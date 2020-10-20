-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Out-2020 às 00:51
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `populacao`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentarios`
--

CREATE TABLE `comentarios` (
  `id` int(11) NOT NULL,
  `id_pai` int(11) DEFAULT NULL,
  `codigo_usuario` int(11) DEFAULT NULL,
  `id_gasto` int(11) DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `comentarios`
--

INSERT INTO `comentarios` (`id`, `id_pai`, `codigo_usuario`, `id_gasto`, `comentario`) VALUES
(1, NULL, 1, 1, 'gastou muito'),
(2, 1, 1, 1, 'Você deveria ver no meu município, gastou muito mais!'),
(3, 1, 2, 1, 'achei que gastou foi pouco'),
(4, 1, 2, 3, 'superfaturado'),
(5, NULL, 3, 2, 'não foi superfaturado'),
(6, NULL, 5, 5, 'desvio de dinheiro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estados`
--

CREATE TABLE `estados` (
  `codigo` char(4) NOT NULL,
  `nome` char(30) DEFAULT NULL,
  `populacao` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estados`
--

INSERT INTO `estados` (`codigo`, `nome`, `populacao`) VALUES
('sp', 'São Paulo', 45919049),
('mg', 'Minas Gerais', 21168791),
('rj', 'Rio de Janeiro', 17264943),
('ba', 'Bahia', 14873064),
('pr', 'Paraná', 11433957),
('rs', 'Rio Grande do Sul', 11377239),
('pe', 'Pernambuco', 9557071),
('ce', ' Ceará', 9132078),
('pa', 'Pará', 8602865),
('sc', ' Santa Catarina', 716488),
('ma', 'Maranhão', 7075181),
('go', 'Goiás', 7018354),
('am', 'Amazonas', 4144597),
('es', 'Espírito Santo', 4018650),
('pb', 'Paraíba', 4018127),
('rn', 'Rio Grande do Norte', 3506853),
('mt', 'Mato Grosso', 3484466),
('al', 'Alagoas', 3337357),
('pi', 'Piauí', 3273227),
('df', 'Distrito Federal', 3015268),
('ms', 'Mato Grosso do Sul', 2778986),
('se', 'Sergipe', 2298696),
('ro', 'Rondônia', 1777225),
('to', 'Tocantins', 1572866),
('ac', 'Acre', 881935),
('ap', 'Amapá', 845731),
('rr', 'Roraima', 605761);

-- --------------------------------------------------------

--
-- Estrutura da tabela `gastos`
--

CREATE TABLE `gastos` (
  `cidade` varchar(255) NOT NULL,
  `valor` decimal(10,0) NOT NULL,
  `empresa` varchar(255) NOT NULL,
  `estado` char(2) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `gastos`
--

INSERT INTO `gastos` (`cidade`, `valor`, `empresa`, `estado`, `id`) VALUES
('urutai', '100000', 'avex', 'go', 1),
('pires do rio', '416512', 'joa', 'go', 2),
('catalão', '321321321', 'aça', 'go', 3),
('uberlândia', '5132131', 'lal', 'mg', 4),
('uberaba', '321313213', 'lal', 'mg', 5),
('urutai', '321312', 'jax', 'go', 6),
('ipameri', '321313', 'jax', 'go', 7),
('ipameri', '6511321321', 'lal', 'go', 8),
('urutai', '50000', 'avax', 'go', 9),
('catalao', '4000000', 'avax', 'go', 10),
('rio de janeiro', '50000', 'avax', 'rj', 11),
('sao paulo', '4000000', 'joa', 'sp', 12),
('vitoria', '50000', 'avax', 'es', 13),
('salvador', '4000', 'avax', 'ba', 14),
('urutai', '50000', 'avax', 'go', 15),
('catalao', '400', 'avax', 'go', 16),
('dianópolis', '50000', 'avax', 'to', 17),
('flores', '4000', 'lal', 'go', 18),
('curitiba', '50000', 'avax', 'pr', 19),
('catalao', '40000', 'avax', 'go', 20),
('fortaleza', '50000', 'avax', 'ce', 21),
('catalao', '40000', 'avax', 'go', 22),
('urutai', '50000', 'avax', 'go', 23),
('ipameri', '400000', 'avax', 'go', 24),
('urutai', '50000', 'avax', 'go', 25),
('catalao', '400000', 'vox', 'go', 26);

-- --------------------------------------------------------

--
-- Estrutura da tabela `locais`
--

CREATE TABLE `locais` (
  `lat` decimal(8,4) NOT NULL,
  `lng` decimal(8,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `locais`
--

INSERT INTO `locais` (`lat`, `lng`) VALUES
('-30.0000', '100.00'),
('-25.0000', '130.00'),
('-24.0000', '80.00'),
('-23.0000', '-130.00'),
('-15.6000', '-47.28'),
('-15.4000', '-47.27'),
('-15.3000', '-47.58'),
('-15.1740', '-47.27'),
('-15.1740', '-47.17'),
('-15.1740', '-47.16'),
('-15.1400', '-47.16'),
('-15.1000', '-47.10'),
('-10.0000', '100.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `codigo` int(11) NOT NULL,
  `ativo` bit(1) NOT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `idioma` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nascimento` datetime DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`codigo`, `ativo`, `celular`, `email`, `idioma`, `login`, `nascimento`, `nome`, `senha`) VALUES
(22, b'1', '3242342342', 'crisfsantos@gmail.com', 'português', 'cristiane', '0101-11-11 00:00:00', 'cristiane', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `codigo_usuario` (`codigo_usuario`),
  ADD KEY `id_gasto` (`id_gasto`),
  ADD KEY `id_pai` (`id_pai`);

--
-- Indexes for table `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `gastos`
--
ALTER TABLE `gastos`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `locais`
--
ALTER TABLE `locais`
  ADD PRIMARY KEY (`lat`,`lng`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `UK_fl3uvb053wjkjly059t4j7xjp` (`login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `gastos`
--
ALTER TABLE `gastos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
