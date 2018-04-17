<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../taglibs.jsp"%>
<sistema:template titulo="Cadastro de eleição">
	<sistema:message/>
	<form:form action="/ellections" method="post" modelAttribute="newEllectionForm">
        <div class="col-md-8 col-sm-12 mx-auto common-margin-bottom">
                <div class="row common-margin-bottom">
                    <div class="form-group d-block col-12">
                        <label for="name">Nome da eleição</label>
                        <form:input path="name" class="form-control" placeholder="nome da eleição"/>
                        <small id="name" class="form-text text-muted">Pense em um nome criativo.</small>
                        <form:errors path="name"/>
                    </div>
                </div>        
                <div class="row common-margin-bottom">
                    <div class="form-group d-block col-12">
                        <label for=endingTime>Data de fim</label>
                        <form:input path="endingTime" class="form-control" placeholder="ex:20/10/2018"/>
                        <small id="endingTime" class="form-text text-muted">não erre a data :)</small>
                        <form:errors path="endingTime"/>
                    </div>
                </div>    
                <div class="row">
                    <button type="submit" class="btn btn-success col-md-6 col-sm-6 col-xs-6 mx-auto">
                        Cadastrar eleição
                    </button>
                </div>                    
        </div>	
	</form:form>
</sistema:template>
