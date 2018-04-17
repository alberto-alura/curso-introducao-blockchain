<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglibs.jsp"%>
<sistema:template titulo="Cadastro de novo candidato">
	<sistema:message/>
	<form:form action="/candidates" method="post" modelAttribute="newCandidateForm">
	<div class="col-md-8 col-sm-12 mx-auto common-margin-bottom">
         <div class="row common-margin-bottom">
             <div class="form-group d-block col-12">
                 <label for="name">Nome</label>
                 <form:input path="name" class="form-control" placeholder="nome do eleitor"/>
                 <form:errors path="name"/>
             </div>
         </div>		
         <div class="row common-margin-bottom">
             <div class="form-group d-block col-12">
                 <label for="number">Número</label>
                 <form:input path="number" class="form-control" placeholder="número do candidato, ex: 8739478643"/>
                 <form:errors path="number"/>
             </div>
         </div>		
         <div class="row common-margin-bottom">
             <div class="form-group d-block col-12">
                 <label for="ellectionId">Eleição</label>
				<form:select path="ellectionId" class="custom-select d-block w-100">
					<form:option value="">Selecione</form:option>
					<form:options items="${ellections}" itemLabel="name" itemValue="id" />
				</form:select>
				<form:errors path="ellectionId"/>
             </div>             
         </div>
         <div class="row">
             <button type="submit" class="btn btn-success col-md-6 col-sm-6 col-xs-6 mx-auto">
                 Cadastrar candidato
             </button>
         </div>         		
	</div>
	</form:form>
</sistema:template>