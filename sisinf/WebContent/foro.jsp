<!doctype html>
<html lang="en">
    

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="icon" href="img/favicon.png" type="image/png">
        <title>Flash Photography</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="vendors/linericon/style.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="vendors/lightbox/simpleLightbox.css">
        <link rel="stylesheet" href="vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="vendors/animate-css/animate.css">
        <link rel="stylesheet" href="vendors/popup/magnific-popup.css">
        <!-- main css -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/responsive.css">
    </head>
    <body>
        
                <!--================Header Menu Area =================-->
				<header class="header_area">
					<div class="main_menu">
						<div id="barra">
						<nav class="navbar navbar-expand-lg navbar-light"> 
							<div class="container">
								<!-- Brand and toggle get grouped for better mobile display -->
								<a class="navbar-brand logo_h" href="index.html"><img src="img/logo.png" alt=""></a>
								<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
								<!-- Collect the nav links, forms, and other content for toggling -->
								<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
									<ul class="nav navbar-nav menu_nav ml-auto">
										<li class="nav-item"    ><a class="nav-link" href="index.html">Home</a></li> 
										<!-- <li class="nav-item"><a class="nav-link" href="about-us.html">About</a></li>  -->
										<!-- <li class="nav-item submenu dropdown">
											<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Projects</a>
											<ul class="dropdown-menu"> -->
										<li class="nav-item"><a class="nav-link" href="foro.jsp">Foro</a></li>
												<!-- <li class="nav-item"><a class="nav-link" href="project-details.html">Project Details</a></li> -->
										<!-- <li class="nav-item submenu dropdown"> -->
											<!-- <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pages</a>
											<ul class="dropdown-menu">
												<li class="nav-item"><a class="nav-link" href="elements.html">Elements</a></li>
											</ul> -->
										</li> 
										<li class="nav-item submenu dropdown">
											<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Noticias</a>
											<ul class="dropdown-menu">
												<li class="nav-item "><a class="nav-link" href="blog.html">Noticias última hora</a></li>
												<li class="nav-item"><a class="nav-link" href="single-blog.html">Noticias detalladas</a></li>
											</ul>
										</li> 
										<li class="nav-item"><a class="nav-link" href="contact.html">Contactar</a></li>
										<li class="nav-item submenu dropdown">
											<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mi Cuenta</a>
											<ul class="dropdown-menu">
												<li class="nav-item "><a class="nav-link" href="inisesion.html">Inicio de sesión</a></li>
												<li class="nav-item"><a class="nav-link" href="registro.html"> Registrarse</a></li>
											</ul>
										</li>
									</ul>
								</div> 
							</div>
						</nav>
						<div>
					</div>
				</header>
        <!--================Header Menu Area =================-->
        	<!--es la barra de home -> foro -->
        
        <!--================Home Banner Area =================-->
        <section class="banner_area">
            <div class="box_1620">
				<div class="banner_inner d-flex align-items-center">
					<div class="container">
						<div class="banner_content text-center">
							<h2>Foro</h2>
							<div class="page_link">
								<a href="index.html">Home</a>
								<a href="foro.jsp">Foro</a>
							</div>
						</div>
					</div>
				</div>
            </div>
        </section>
        <!--================End Home Banner Area =================-->
        
        

					 	<!-- METO AQUI SCRIPT PARA GENERAR PAGINA DINÁMICA -->
					 	<%@ page import="java.sql.*" %>
				        <%@ page import="es.unizar.sisinf.*" %>
				        <%@ page import="es.unizar.sisinf.data.db.ConnectionManager.*" %>
				      	<%
				      	  String findNews = "SELECT * FROM Publicacion";
					        	try {
								Connection conn = ConnectionManager.getConnection();
								PreparedStatement ps = conn.prepareStatement(findNews);
								System.out.println("query done");
								ResultSet rs = ps.executeQuery();
								out.println("<section class=\"home_blog_area p_120\">");
									out.println("<div class=\"container\">");
										out.println("<div class=\"home_blog_inner\">");
											out.println("<div class=\"col-lg-6\">");
												out.println("<div class=\"h_blog_text\">");
													out.println("<div class=\"h_blog_text_inner left\">");
															out.println("<h2 id=\"ultimas\">ÚLTIMAS &nbspPUBLICACIONES</br></h2>");
													out.println("</div>");
												out.println("</div>");
											out.println("</div>");
								while ( rs.next()) {
									System.out.println("query get correctly");
									String tit = rs.getString("titulo");
									String body = rs.getString("contenido");
									String user = rs.getString("correousuario");
									out.println("<div class=\"row h_blog_item\">");
										out.println("<div class=\"col-lg-6\">");
											out.println("<div class=\"h_blog_img\">");
												out.println("<img class=\"img-fluid\" src=\"img/home-blog/h-blog-3.jpg\" alt=\"\">");
											out.println("</div>");
										out.println("</div>");
										out.println("<div class=\"col-lg-6\">");
											out.println("<div class=\"h_blog_text\">");
												out.println("<div class=\"h_blog_text_inner left\">");
													out.println("<h4>"+"TOPIC:   "+tit+"</h4>");
													out.println("<p>"+user+" Ha publicado:"+"</p>");
													out.println("<p>"+body+"</p>");
												out.println("</div>");
											out.println("</div>");
										out.println("</div>");
									out.println("</div>");
								}
							}catch (SQLException se) {
								se.printStackTrace();
							} catch (Exception e) {
								e.printStackTrace(System.err);
							}
				        
				        
		    							out.println("</div>");
       								out.println("</div>");
								out.println("</section>"); 
						%>   
						<!--
						<section class="home_blog_area p_120">
							<div class="container">
								<div class="home_blog_inner">
									<div class="col-lg-6">
										<div class="h_blog_text">
											<div class="h_blog_text_inner left">
													<h2 id="ultimas">ÚLTIMAS &nbspPUBLICACIONES</br></h2>
											</div>
										</div>
									</div>
								<c:forEach var="demo" items="${listaDemo}">
							-->
									<!-- String tit = rs.getString("titulo");
									String body = rs.getString("contenido");
									String user = rs.getString("correousuario");-->
							<!--		<div class="row h_blog_item">
										<div class="col-lg-6">
											<div class="h_blog_img">
												<img class="img-fluid" src="img/home-blog/h-blog-3.jpg" alt="">
											</div>
										</div>
										<div class="col-lg-6">
											<div class="h_blog_text">
												<div class="h_blog_text_inner left">
													<h4>"TOPIC: ${demo.title}"</h4>
													<p>${demo.author} "ha publicado:"</p>
													<p>${demo.content}</p>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								</div>
							</div>"
						</section>"-->
						
        <!--================ECRIBIR PUBLICACION AREA =================-->
        <section class="home_blog_area p_120">
        	<div class="container">
        		<div class="home_blog_inner">
					<div class="col-lg-6">
						<div class="h_blog_text">
							<div class="h_blog_text_inner left">
								<h2 id="ultimas">ESCRIBIR &nbspPUBLICACION</h2></br>
							</div>
						</div>
					</div>
		
					<div class="row h_blog_item">
						<div class="col-lg-6">
							<form id="login-form" method="post" action="ponerPost" role="form" novalidate="novalidate" style="display: block;">
								<div class="form-group">
									<input type="text" name="title" id="title" tabindex="1" class="form-control" placeholder="Título" value="">
								</div>
								<div class="form-group">
									<textarea class="form-control" name="text" id="text" rows="1" placeholder="Escribe tu mensaje"></textarea>
								</div>
								
									<div class="col-md-12 text-right">
										<button type="submit" value="submit" class="btn submit_btn">Publicar</button>
									</div>
								</div>
						</div>



        			</div>
			</div>
		</div>
			



			
		
</section>
        
         <!--================Footer Area =================-->
		 <footer class="footer_area">
			<div class="container">
				<div class="row footer_inner">
					<div class="col-lg-5 col-sm-6">
						<aside class="f_widget ab_widget">
							<div class="f_title">
								<h3>Sobre nosotros</h3>
							</div>
							<p>Somos tres jovenes de Zaragoza con ciertas inquietudes y preocupación sobre el cambio climático y la contaminación, tratando que al entrar a esta web todo el mundo salga con un poco de conocimiento del que ha entrado.</p>
							<p>¡Muchas gracias Colorlib por la plantilla!</p>
							<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</p>
						</aside>
					</div>
                    <div class="col-lg-5 col-sm-6">
                     <aside class="f_widget ab_widget">
                            <div class="f_title">
                                <h3>¡Subscríbete!</h3>
                            </div>
                            <p>No te pierdas las últimas noticias</p>
                                <form method="post" action="contactar" class="subscribe_form relative">
                                    <div class="input-group d-flex flex-row">
                                        <input name="EMAIL" id="EMAIL" placeholder="Introduce tu correo" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email Address '" type="email">
                                        
                                            <!-- <input style="text-align: center" type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Enviar">             -->
                                            <button type= "submit" class="btn sub-btn"><span class="lnr lnr-arrow-right"></span></button>
                                        </div>
                                </form>
                                </aside>
                        <div class="col-lg-2">
                            <aside class="f_widget social_widget">
                                <div class="f_title">
                                    <h3>¡Síguenos!</h3>
                                </div>
                            </aside>
                        </div>
                    </div>
					<div class="col-lg-2">
						<aside class="f_widget social_widget">
							<div class="f_title">
								<h3>¡Síguenos!</h3>
							</div>
							<ul class="list">
								<li><a href="#"><i class="fa fa-instagram"></i></a></li>
								<li><a href="https://twitter.com/EcoZity"><i class="fa fa-twitter"></i></a></li>
								<li><a href="https://www.google.es/maps/@41.6477477,-0.8962048,15z?hl=es"><i class="fa fa-map"></i></a></li>
								<li><a href="https://www.google.com/maps/place/Zaragoza/data=!4m2!3m1!1s0xd5914dd5e618e91:0x49df13f1158489a8!5m1!1e1?sa=X&ved=2ahUKEwj8urPemKHlAhWGHxQKHfQwAlcQ8gEwAHoECAoQAQ"><i class="fa fa-car"></i></a></li>
							</ul>
						</aside>
					</div>
				</div>
			</div>
		</footer>
		<!--================End Footer Area =================-->
        
        
        
        
        
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/stellar.js"></script>
        <script src="vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="vendors/nice-select/js/jquery.nice-select.min.js"></script>
        <script src="vendors/isotope/imagesloaded.pkgd.min.js"></script>
        <script src="vendors/isotope/isotope.pkgd.min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="vendors/popup/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="vendors/counter-up/jquery.waypoints.min.js"></script>
        <script src="vendors/counter-up/jquery.counterup.js"></script>
        <script src="js/mail-script.js"></script>
        <script src="js/theme.js"></script>
    </body>
</html>