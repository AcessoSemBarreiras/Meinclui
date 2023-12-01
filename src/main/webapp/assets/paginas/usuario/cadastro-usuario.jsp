<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="../../estilos/padrao.css">
	<link rel="stylesheet" href="../../estilos/cadastro-usuario.css">
	<title>Cadastre-se!</title>
</head>

<body>

	<header class="template-grid">
		<nav class="cabecalho-geral">
			<img src="../../imagens/logo-meinclui.svg">
		</nav>
	</header>

	<div class=" template-grid">
		<div class="texto-titulo-cadastro">
			<h1 class="titulo-principal">Cadastrar-se</h1>
			<a href="#"> voltar -></a>
		</div>
	</div>

	<form class="template-grid" id="formulario">

		<div class="formulario-esquerda">

			<div class="conteudo-nome-completo">
				<input type="text" id="nome-completo" name="nome-usuario" placeholder="Nome Completo" required>
			</div>

			<div class="conteudo-cpf-usuario">
				<input type="text" id="cpf" name="cpf-usuario" placeholder="CPF" required minlength="14" maxlength="14">
			</div>

			<div class="pronome-usuario">
				<select name="pronome-usuario" id="pronome-usuario" placeholder="E-mail">
					<option value="" selected>Pronomes</option>
					<option value="Ele/Dele">Ele/Dele</option>
					<option value="Ela/Dela">Ela/Dela</option>
					<option value="Elu/Delu">Elu/Delu</option>
					<option value="qualquer">Qualquer pronome</option>
					<option value="nao-informar">Não Informar</option>
				</select>
			</div>

			<div class="senha-usuario">
				<input type="password" id="senha" name="senha-usuario" placeholder="Digite uma senha" required>
			</div>

			<div class="termos-uso alinhamento-checkbox">
				<input type="checkbox" id="termos-uso" value="termos"> Li
				e Aceito os <a href="">Termos</a>
			</div>

		</div>

		<div class="formulario-centro">

			<div class="conteudo-nome-usuario">
				<input type="text" id="nusuario" name="nome-de-usuario" placeholder="Nome de Usuário" required>
			</div>

			<div class="conteudo-email-usuario">
				<input type="email" id="email" name="email-usuario" placeholder="E-mail" required>
			</div>

			<div class="ddn-usuario">
				<input type="date" id="data_de_nascimento_usuario" name="data-nascimento-usuario"
					placeholder="Data de Nascimento" required min="1900-01-01">
			</div>

			<div class="confirmar-senha-usuario">
				<input type="password" id="confirma-senha" placeholder="Confirme sua senha" required>
			</div>

			<div>
				<input type="submit" id="confirmar" value="CONFIRMAR" class="botao-medio texto-pequeno">
			</div>

		</div>

		<div class="formulario-direita">
			<div id="foto-usuario" class="alinhamento-foto">
				<nav>
					<input type="image" src="../../imagens/foto-perfil-cadastro.svg" alt="Foto de Perfil" required>
				</nav>
				<p class="texto-grande texto-foto" >Selecione Uma Foto De Perfil</p>
			</div>
		</div>

	</form>

</body>

</html>
