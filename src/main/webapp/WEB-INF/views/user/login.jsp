<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglibs.jsp"%>


<sistema:template titulo="Área de login">
	<c:if test="${successMessage != null}">
		<div class="alert alert-primary" role="alert">${successMessage}</div>
	</c:if>
	<c:if test="${param.error != null}">
		<div class="alert alert-danger" role="alert">Login ou senha
			inválidos</div>
	</c:if>


	<form:form action="/login">
		<div class="col-md-6 col-sm-12 mx-auto">
			<div class="row common-margin-bottom">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Email</span>
					</div>
					<input type="text" name="username" class="form-control"
						placeholder="Insira seu e-mail aqui" aria-label="Username"
						aria-describedby="basic-addon1">
				</div>
			</div>
			<div class="row common-margin-bottom">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Senha</span>
					</div>
					<input type="password" name="password" class="form-control"
						placeholder="Insira sua senha" aria-label="Username"
						aria-describedby="basic-addon1">
				</div>
			</div>
			<div class="row">
				<button type="submit"
					class="btn btn-success col-md-4 col-sm-4 col-xs-4 mx-auto">
					Login</button>
			</div>
		</div>
	</form:form>
</sistema:template>
