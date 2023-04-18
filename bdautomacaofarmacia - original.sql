-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 06-Jan-2023 às 20:27
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `clienteNome`, `clienteEndereco`, `clienteBairro`, `clienteCidade`, `clienteEstado`, `clienteCep`, `clienteTelefone`) VALUES
(1, 'Diego Antonio Oliveira', 'Rua Adalberto Nascimento 2010', 'Matinha', 'Patrocínio', 'MG', '38742150', '34992510132');

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
  `fk_cliente` int(11) DEFAULT NULL,
  `vendaData` date NOT NULL,
  `vendaValorLiquido` double NOT NULL,
  `vendaValorTotal` double NOT NULL,
  `vendaDesconto` double NOT NULL,
  PRIMARY KEY (`idVenda`),
  KEY `fk_cliente` (`fk_cliente`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`idVenda`, `fk_cliente`, `vendaData`, `vendaValorLiquido`, `vendaValorTotal`, `vendaDesconto`) VALUES
(1, 1, '2023-01-05', 100, 100, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendaproduto`
--

DROP TABLE IF EXISTS `vendaproduto`;
CREATE TABLE IF NOT EXISTS `vendaproduto` (
  `idVendaProduto` int(11) NOT NULL AUTO_INCREMENT,
  `fk_Produto` int(10) DEFAULT NULL,
  `fk_Venda` int(10) DEFAULT NULL,
  `vendaProdutoValor` double NOT NULL,
  `vendaProdutoQtd` int(11) NOT NULL,
  PRIMARY KEY (`idVendaProduto`),
  KEY `fk_produto` (`fk_Produto`),
  KEY `fk_venda` (`fk_Venda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `venda_ibfk_1` FOREIGN KEY (`fk_cliente`) REFERENCES `cliente` (`idCliente`);

--
-- Limitadores para a tabela `vendaproduto`
--
ALTER TABLE `vendaproduto`
  ADD CONSTRAINT `vendaproduto_ibfk_2` FOREIGN KEY (`fk_Venda`) REFERENCES `venda` (`idVenda`),
  ADD CONSTRAINT `vendaproduto_ibfk_1` FOREIGN KEY (`fk_Produto`) REFERENCES `produto` (`idProduto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
