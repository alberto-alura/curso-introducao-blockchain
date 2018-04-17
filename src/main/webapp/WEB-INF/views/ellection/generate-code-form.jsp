<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../taglibs.jsp"%>
<sistema:template titulo="Gerar código de eleição">
	<sistema:message/>
	<form:form action="/votingbooth/code" modelAttribute="generateCodeForm">
        <div class="col-md-8 col-sm-12 mx-auto common-margin-bottom">
                <div class="row common-margin-bottom">
                    <div class="form-group d-block col-12">
                        <label for="voterNumber">Número de eleitor</label>
                        <form:input path="voterNumber" class="form-control" placeholder="seu número de eleitor"/>
                        <form:errors path="voterNumber"/>
                    </div>
                </div>
         </div>
         <div class="row">
             <button type="submit" class="btn btn-success col-md-6 col-sm-6 col-xs-6 mx-auto">
                 Gerar número de voto
             </button>
         </div>         			
	</form:form>
</sistema:template>