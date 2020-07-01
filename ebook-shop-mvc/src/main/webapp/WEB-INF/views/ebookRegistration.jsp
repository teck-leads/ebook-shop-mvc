<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>

<div class="container">



	<form:form modelAttribute="ebookCmd" id="form1">



		<fieldset class="form-group">
			<c:if test="${idKey ne 0}">
				<label for="bookId">Book No</label>
				<form:input path="bookId" class="form-control" readonly="true" />
			</c:if>




			<label for="bookName">Book Name</label>
			<form:input path="bookName" class="form-control" required="required"
				oninvalid="this.setCustomValidity('Enter Book Name')"
				oninput="this.setCustomValidity('')" id="bookName" />

			<label for="bookAuthor">Book Author</label>
			<form:input path="author" class="form-control" required="required"
				oninvalid="this.setCustomValidity('Enter Book Author')"
				oninput="this.setCustomValidity('')" id="bookAuthor" />

			<label for="bookCategory">Book Category</label>
			<form:input path="category" class="form-control" required="required"
				oninvalid="this.setCustomValidity('Enter Book Category')"
				oninput="this.setCustomValidity('')" id="bookCategory" />

			<label for="noOfBooks">No of Books</label>
			<form:input path="noOfBooks" class="form-control" required="required"
				oninvalid="this.setCustomValidity('Enter No Of books')"
				oninput="this.setCustomValidity('')" id="noOfBooks" />


		</fieldset>




		<c:if test="${idKey eq 0}">
			<input type="submit" value="Register" class="btn btn-outline-primary">
			<input type="reset" value="Reset" class="btn btn-outline-dark">

		</c:if>
		<c:if test="${idKey gt 0}">
			<input type="submit" value="Update" class="btn btn-outline-primary">
		</c:if>

	</form:form>
</div>

<%@include file="common/footer.jspf"%>