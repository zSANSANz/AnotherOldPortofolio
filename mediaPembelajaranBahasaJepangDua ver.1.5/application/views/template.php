<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<link rel="icon" href="<?php echo base_url()?>assets/favicon.ico">
	
	<title>MEPJAP</title>
	 
	<!-- Bootstrap core CSS -->
	<link href="<?php echo base_url()?>assets/css/bootstrap.min.css" rel="stylesheet">
	 
	 
	
	<link href="<?php echo base_url()?>assets/css/charisma-app.css" rel="stylesheet">

	<link href='<?php echo base_url()?>assets/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>

	<link href='<?php echo base_url()?>assets/bower_components/chosen/chosen.min.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/css/jquery.noty.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/css/noty_theme_default.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/css/elfinder.min.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/css/elfinder.theme.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/css/jquery.iphone.toggle.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/css/uploadify.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/css/animate.min.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/h_b/web/css/owl.carousel.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/h_b/web/css/slider.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/h_b/web/css/style.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/protectly-web/web/css/lightGallery.css' rel='stylesheet'>

	<link href='<?php echo base_url()?>assets/protectly-web/web/css/popup.css' rel='stylesheet'>

	<!-- jQuery -->
	<script src="<?php echo base_url()?>assets/bower_components/jquery/jquery.min.js"></script>

	<script src="<?php echo base_url()?>assets/h_b/web/js/jquery.min.js"></script>

	<script src="<?php echo base_url()?>assets/h_b/web/js/app.js"></script>

	<script src="<?php echo base_url()?>assets/h_b/web/js/easing.js"></script>

	<script src="<?php echo base_url()?>assets/h_b/web/js/main.js"></script>

	<script src="<?php echo base_url()?>assets/h_b/web/js/move-top.js"></script>

	<script src="<?php echo base_url()?>assets/h_b/web/js/owl.carousel.js"></script>

	<script src="<?php echo base_url()?>assets/h_b/web/js/sleekslidera.min.js"></script>

	<script src="<?php echo base_url()?>assets/h_b/web/js/socialCircle.js"></script>

	<script src="<?php echo base_url()?>assets/h_b/web/js/wow.min.js"></script>

	<script src="<?php echo base_url()?>assets/protectly-web/web/js/jquery.magnific-popup.js"></script>

	<script src="<?php echo base_url()?>assets/protectly-web/web/js/jquery.wmuSlider.js"></script>

	<script src="<?php echo base_url()?>assets/protectly-web/web/js/lightGallery.js"></script>

	<script src="<?php echo base_url()?>assets/protectly-web/web/js/wow.min.js"></script>



	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="img/favicon.ico">

	<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
			});
		});
		</script>
	<!--Animation-->
	<script>
		new WOW().init();
	</script>

</head>
 
<body>
 		
		<?= $contents ?>
	 
	
 
 
<script src="<?php echo base_url()?>assets/js/bootstrap.min.js"></script>

<!-- external javascript -->

<script src="<?php echo base_url()?>assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="<?php echo base_url()?>assets/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='<?php echo base_url()?>assets/bower_components/moment/min/moment.min.js'></script>
<script src='<?php echo base_url()?>assets/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='<?php echo base_url()?>assets/js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="<?php echo base_url()?>assets/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="<?php echo base_url()?>assets/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="<?php echo base_url()?>assets/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="<?php echo base_url()?>assets/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="<?php echo base_url()?>assets/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="<?php echo base_url()?>assets/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="<?php echo base_url()?>assets/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="<?php echo base_url()?>assets/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="<?php echo base_url()?>assets/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="<?php echo base_url()?>assets/js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="<?php echo base_url()?>assets/js/charisma.js"></script>
 
</html>