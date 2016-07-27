<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left colum -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<form role="form" method="post">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">BNO</label>
							<input type="text" name='bno' class="form-control" value="${boardVO.bno}" readonly="readonly">
						
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Title</label>
							<input type="text" name='title' class="form-control" value="${boardVO.title}">
						
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea rows="3" class="form-control" name="content">${boardVO.content}</textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Writer</label> 
							<input type="text" name="writer" class="form-control" value="${boardVO.writer}">
						</div>
					</div>
					<!-- /.box-body -->
				</form>
				<!-- /.form -->
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>
				<!-- /.boxfooter -->
				
				<script>
				$(document).ready(function(){
					var formObj = $("form[role=form]");
					
					console.log(formObj);
					
					
					$(".btn-primary").on("click", function(){
						formObj.submit();
					});

					$(".btn-warning").on("click", function(){
						self.location = "/board/listAll";
					});
				});
				
				</script>
				
			</div>
			<!-- /.box -->
		</div>
		<!-- /.left-comum -->
	</div>
	<!-- /.row -->
</section>
<!-- /.section content -->


<%@ include file="../include/footer.jsp" %>