<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglibs.jsp"%>
<html>
<body>
	<div class="box">
		<div class="box-header" style="text-align: center">
			<h2 class="box-title">Partiu Bolão!</h2>
		</div>
	</div>
	<div class="box col-md-4" style="text-align: center">
		<div class="box-header" style="text-align: center">
			<h3 class="box-title">Cadastre e comece a apostar com os amigos</h3>
		</div>
		<form:form action="/users" method="post" commandName="simpleUserForm">
			<div class="box-body">
				<form:hidden path="shareCode" />
				<div class="form-group">
					<label for="name">Nome:</label>
					<form:input path="name" class="form-control" />
					<form:errors path="name" cssClass="error_message" />
				</div>

				<div class="form-group">
					<label for="email">Email:</label>
					<form:input path="email" class="form-control" />
					<form:errors path="email*" cssClass="error_message" />
				</div>

				<div class="form-group">
					<label for="rawPassword">Senha:</label>
					<form:password path="rawPassword" class="form-control" />
					<form:errors path="rawPassword" cssClass="error_message" />
				</div>

				<button type="submit" class="button">Gravar</button>
			</div>
		</form:form>
	</div>

</body>
</html>
