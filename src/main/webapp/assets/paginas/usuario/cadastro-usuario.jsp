<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style><%@include file="../../estilos/cadastro-usuario.css"%></style>
<style><%@include file="../../estilos/padrao.css"%></style>
<title>Cadastre-se!</title>
</head>
<body>
	<%@ include file="../menu.jsp"%>	
			<div class="titulo">
				<h1 class="titulo-principal">Cadastrar-se</h1>
				<a href="#"> voltar -></a>
			</div>
	<form class="template-grid" id="formulario" action="inserir-usuario" method="post" enctype="multipart/form-data">
		<div class="formulario-esquerda">
 
			<div class="conteudo-nome-completo">
				<input type="text" id="nome-completo" name="nome-usuario"
					placeholder="Nome Completo" required>
			</div>
 
			<div class="conteudo-cpf-usuario">
				<input type="text" id="cpf" name="cpf-usuario" placeholder="CPF"
					required minlength="14" maxlength="14">
			</div>
 
			<div class="pronome-usuario">
				<select name="pronome-usuario" id="pronome-usuario"
					placeholder="E-mail">
					<option value="" selected>Pronomes</option>
					<option value="Ele/Dele">Ele/Dele</option>
					<option value="Ela/Dela">Ela/Dela</option>
					<option value="Elu/Delu">Elu/Delu</option>
					<option value="qualquer">Qualquer pronome</option>
					<option value="nao-informar">Não Informar</option>
				</select>
			</div>
 
			<div class="senha-usuario">
				<input type="password" id="senha" name="senha-usuario"
					placeholder="Digite uma senha" required>
			</div>
			<div class="termos-uso alinhamento-checkbox">
				<input type="checkbox" id="termos-uso" value="termos"> Li e
				Aceito os <a href="">Termos</a>

			</div>
		</div>
 
		<div class="formulario-direita">
 
			<div class="conteudo-nome-usuario">
				<input type="text" id="nusuario" name="nome-de-usuario"
					placeholder="Nome de Usuário" required>
			</div>
 
			<div class="conteudo-email-usuario">
				<input type="email" id="email" name="email-usuario"
					placeholder="E-mail" required>
			</div>
 
			<div class="ddn-usuario">
				<input type="date" id="data_de_nascimento_usuario"
					name="data-nascimento-usuario" placeholder="Data de Nascimento"
					required min="1900-01-01">
			</div>
 
			<div class="confirmar-senha-usuario">
				<input type="password" id="confirma-senha"
					placeholder="Confirme sua senha" required>
			</div>
 
			<div>
				<input type="submit" id="confirmar" value="CONFIRMAR"
					class="botao-medio texto-pequeno" style="color: var(--branco )">
			</div>

		</div>

		<div class="formulario-direita">
			<div id="foto-usuario" class="alinhamento-foto">
				<nav>
					<input type="file" name="foto-usuario" accept="image/*" />
				</nav>
				<p class="texto-grande texto-foto">Selecione Uma Foto De Perfil</p>
			</div>
		</div>
	</form>
</body>
</html>