<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">

	<table class="table table-striped">
		<thead>
			<tr>
				<th>Book NO</th>
				<th>Book Name</th>
				<th>Book Author</th>
				<th>Category</th>
				<th>No of Books</th>
				<th>Update</th>
				<th>Remove</th>
			</tr>
		</thead>
		<tbody>

		
			<c:forEach items="${ebookList }" var="ebook">
				<tr>
					<td>${ebook.bookId}</td>
					<td>${ebook.bookName}</td>
					<td>${ebook.author}</td>
					<td>${ebook.category}</td>
					<td>${ebook.noOfBooks}</td>
					<td><a href="/ebook-shop/ebooks/edit/${ebook.bookId}" 
						class="btn btn-info">
						<i class="fa fa-edit"></i> Edit</a>
						<!-- class="btn btn-info" id="updateId">Update</a> -->
						<%-- <form method="post" action="edit" id="updateFormId">
						<input type="hidden" value="${user.id}" id="updateUserId">
							<input type="submit" style="display: none;"/>
						</form> --%>
						
						
						</td>
						
						
						
						
						
						
						
					<td>
						<%-- <a href="/school-service/users/delete/${user.id}" class="deleteRecord">Delete
					 <span class="glyphicon glyphicon-remove"></span>
					</a> --%> <%-- <a href="/school-service/users/delete/${user.id}" data-toggle="modal" data-target="#exampleModal">Delete
					</a> --%> <a href="#"
						data-href="/ebook-shop/ebooks/delete/${ebook.bookId}"
						data-toggle="modal" data-target="#confirm-delete"
						class="btn btn-danger">  <i class="fa fa-trash-o" style="font-size:24px;"></i> Delete</a>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>





</div>

<%@include file="common/footer.jspf"%>