<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/nav.jsp"%>
<br/><br/><br/><br/><br/>
<body>


		<div id="colorlib-contact">
			<div class="container">
				<div class="row">
					
					<div class="col-md-10 col-md-offset-1 animate-box">
						<h2>Welcome</h2>
						<form action="/user/join" method="POST">
							<div class="row form-group">
								<div class="col-md-12">
									<label for="fname">Name</label> <input type="text"
										id="username" name="username" class="form-control" placeholder="Your name">
								</div>
							
							</div>

							<div class="row form-group">
								<div class="col-md-12">
									<label for="email">Email</label> <input type="text" id="email"
										name="email" class="form-control" placeholder="Your email address">
								</div>
							</div>

							<div class="row form-group">
								<div class="col-md-12">
									<label for="password">Password</label> <input type="password"
										id="password" class="form-control"
										name="password" placeholder="Your Password">
								</div>
							</div>

							<div class="form-group text-right">
								<input type="submit" value="Join"
									class="primary-button" style="width:130px; height:60px; font-size:20px">
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>

<%@ include file="include/footer.jsp"%>
</html>

