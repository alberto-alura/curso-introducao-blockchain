<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../../taglibs.jsp"%>

<sistema:template titulo="Liberação de eleitores">


    <div class="container">
    	<sistema:message/>
        <form:form method="get" action="/registered/ellection" modelAttribute="searchEllectionForm">
            <div class="col-md-8 col-sm-12 mx-auto common-margin-bottom">
                <div class="row common-margin-bottom">
                    <div class="form-group d-block col-8">
	                    <form:select path="ellectionId" items="${ellections}" itemLabel="name" itemValue="id" class="custom-select custom-select-lg"/>
                    </div>
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-lg btn-block">
                        Pesquisar
                        </button>
                    </div>
                </div>
                <div class="row">
                </div>
            </div>
        </form:form>
    </div>
    
    <div class="container">
        <h1>Eleitores para aprovação</h1>
        <table class="table table-striped">
        <thead>
            <tr>
            <th scope="col">identificador</th>
            <th scope="col">aprovado?</th>
            </tr>
        </thead>
        <tbody>
	        <c:forEach var="voter" items="${voters}">
	            <tr>
	                <td>${voter.number}</td>
					<c:if test="${voter.approved}">
						<td>aprovado</td>
					</c:if>	
					<c:if test="${!voter.approved}">
	                <td>
	                	<form:form action="/registered/${voter.id}/approve" method="post">
	                    	<button type="submit" class="btn btn-dark">Aprovar</button>
	                    </form:form>	                    
	                </td>					
					</c:if>                	                
	            </tr>
	         </c:forEach>
        </tbody>
        </table>
    </div>    
</sistema:template>