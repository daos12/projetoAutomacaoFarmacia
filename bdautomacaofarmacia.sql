-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 05-Jan-2023 às 20:26
-- Versão do servidor: 5.5.21
-- versão do PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdautomacaofarmacia`
--


CREATE DATABASE bdautomacaofarmacia;
USE bdautomacaofarmacia;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--



DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `clienteNome` varchar(300) DEFAULT NULL,
  `clienteEndereco` varchar(200) DEFAULT NULL,
  `clienteBairro` varchar(200) NOT NULL,
  `clienteCidade` varchar(200) NOT NULL,
  `clienteEstado` varchar(2) NOT NULL,
  `clienteCep` varchar(9) NOT NULL,
  `clienteTelefone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `produtoNome` varchar(300) NOT NULL,
  `produtoValor` double NOT NULL,
  `produtoEstoque` int(11) NOT NULL,
  `produtoObservacao` varchar(400) NOT NULL,
  PRIMARY KEY (`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuarioNome` varchar(150) NOT NULL,
  `usuarioLogin` varchar(100) NOT NULL,
  `usuarioSenha` varchar(20) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

DROP TABLE IF EXISTS `venda`;
CREATE TABLE IF NOT EXISTS `venda` (
  `idVenda` int(11) NOT NULL AUTO_INCREMENT,
  `fk_cliente` int(10) UNSIGNED DEFAULT NULL,
  `vendaData` date NOT NULL,
  `vendaValorLiquido` double NOT NULL,
  `vendaValorTotal` double NOT NULL,
  `vendaDesconto` double NOT NULL,
  PRIMARY KEY (`idVenda`),
  KEY `fk_cliente` (`fk_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendaproduto`
--

DROP TABLE IF EXISTS `vendaproduto`;
CREATE TABLE IF NOT EXISTS `vendaproduto` (
  `idVendaProduto` int(11) NOT NULL AUTO_INCREMENT,
  `fk_Produto` int(10) UNSIGNED DEFAULT NULL,
  `fk_Venda` int(10) UNSIGNED DEFAULT NULL,
  `vendaProdutoValor` double NOT NULL,
  `vendaProdutoQtd` int(11) NOT NULL,
  PRIMARY KEY (`idVendaProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
