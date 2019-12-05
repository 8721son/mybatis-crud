<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<!-- row -->
					<div class="row">
						<div class="col-md-12">
							<div class="section-title">
								<h2 class="title">Recent posts</h2>
							</div>
						</div>
						<!-- post -->
						<c:forEach var="board" items="${boards }">
						<div class="col-md-6">
							<div class="post">
								<a class="post-img" href="/board/detail/${board.id }"><img src="/images/jina.jpg" alt=""></a>
								<div class="post-body">
									<div class="post-category">
										<a href="/board/detail/${board.id }">${board.title }</a>
									</div>
									<ul class="post-meta">
										<li>John Doe</li>
										<li>${board.createDate }</li>
									</ul>
								</div>
							</div>
						</div>
						</c:forEach>
						<!-- /post -->


						<div class="clearfix visible-md visible-lg"></div>

					

					</div>
					<!-- /row -->


				</div>
				
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->


<%@ include file="include/footer.jsp"%>