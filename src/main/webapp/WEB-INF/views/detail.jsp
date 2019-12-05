<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/nav.jsp"%>

		<!-- PAGE HEADER -->
		<div id="post-header" class="page-header">
			<div class="page-header-bg" style="background-image: url('/images/header-1.jpg');" data-stellar-background-ratio="0.5" ></div>
			<div class="container">
				<div class="row">
					<div class="col-md-10">
					
						</br>
						<h1>${board.title }</h1>
						<ul class="post-meta">
							<li><a href="author.html">John Doe</a></li>
							<li>${board.createDate }</li>
						</ul>
						<br/><br/>
						<a href="/board/updateForm/${board.id }"><button class="primary-button">수정하기</button></a>
						<a href="/board/delete/${board.id }"><button class="primary-button">삭제하기</button></a>
						
					</div>
				</div>
			</div>
		</div>
		<!-- /PAGE HEADER -->
	</header>
	<!-- /HEADER -->

	<!-- section -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<!-- post share -->
					<div class="section-row">
						<div class="post-share">
							<a href="#" class="social-facebook"><i class="fa fa-facebook"></i><span>Share</span></a>
							<a href="#" class="social-twitter"><i class="fa fa-twitter"></i><span>Tweet</span></a>
							<a href="#" class="social-pinterest"><i class="fa fa-pinterest"></i><span>Pin</span></a>
							<a href="#" ><i class="fa fa-envelope"></i><span>Email</span></a>
						</div>
					</div>
					<!-- /post share -->

					<!-- post content -->
					<div class="section-row">
						<p>${board.content }</p>
						
						
					</div>
				</div>			
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->
<%@ include file="include/footer.jsp"%>