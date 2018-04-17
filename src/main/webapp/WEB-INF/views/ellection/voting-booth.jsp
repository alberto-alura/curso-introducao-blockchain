<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../taglibs.jsp"%>

<sistema:template titulo="Dê o seu voto">
	
	<sistema:message/>
	<form:form action="/votingbooth/vote" modelAttribute="votingBoothForm">
		<form:hidden path="ellectionId"/>				
		
        <div class="col-md-8 col-sm-12 mx-auto common-margin-bottom">
                <div class="row common-margin-bottom">
                    <div class="form-group d-block col-12">
                        <label for="ticketCode">Seu identificador</label>
                        <form:input path="ticketCode" class="form-control" placeholder="sua chave privada"/>
                        <form:errors path="ticketCode"/>
                    </div>
                </div>
         </div>
        <div class="col-md-8 col-sm-12 mx-auto common-margin-bottom">
                <div class="row common-margin-bottom">
                    <div class="form-group d-block col-12">
                        <label for="candidateId">Candidato</label>
                        <form:select path="candidateId" items="${candidates}" itemLabel="name" itemValue="id" class="custom-select custom-select-lg"/>
                        <form:errors path="candidateId"/>
                    </div>
                </div>
         </div>         
         <div class="row">
             <button type="submit" class="btn btn-success col-md-6 col-sm-6 col-xs-6 mx-auto">
                 Votar!
             </button>
         </div>		
	</form:form>
</sistema:template>