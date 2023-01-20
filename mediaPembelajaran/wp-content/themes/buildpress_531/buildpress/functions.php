<?php
/**
 * BuildPress functions and definitions
 *
 * @author Primoz Ciger <primoz@proteusnet.com>
 * @author Marko Prelec <marko.prelec@proteusnet.com>
 */

// Display informative message if PHP version is less than 5.4
if ( version_compare( phpversion(), '5.4', '<' ) ) {
	die( sprintf( 'This theme requires <strong>PHP 5.4+</strong> to run. Please contact your hosting company and ask them to update the PHP version of your site to at least PHP 5.4.<br> Your current version of PHP: <strong>%s</strong>', phpversion() ) );
}


// Composer autoloader
require_once get_template_directory() . '/vendor/autoload.php';


/**
 * Define the version variable to assign it to all the assets (css and js)
 */
define( 'BUILDPRESS_WP_VERSION', wp_get_theme()->get( 'Version' ) );



/**
 * Define the development constant
 */
if ( ! defined( 'BUILDPRESS_DEVELOPMENT' ) ) {
	define( 'BUILDPRESS_DEVELOPMENT', false );
}



/**
 * Settings for the NavXT plugin
 * @todo remove in the future
 * @since 1.5.2
 */
if ( ! defined( 'BCN_SETTINGS_USE_LOCAL' ) ) {
	define( 'BCN_SETTINGS_USE_LOCAL', true );
}



/**
 * Set the content width based on the theme's design and stylesheet.
 *
 * @see http://developer.wordpress.com/themes/content-width/Enqueue
 */
if ( ! isset( $content_width ) ) {
	$content_width = 1140; /* pixels */
}



/**
 * Advanced Custom Fields calls to require the plugin within the theme
 */
locate_template( 'inc/acf.php', true, true );



/**
 * Theme support and thumbnail sizes
 */
if ( ! function_exists( 'buildpress_theme_setup' ) ) {
	function buildpress_theme_setup() {
		/*
		 * Make theme available for translation.
		 * Translations can be filed in the /languages/ directory.
		 * If you're building a theme based on BuildPress, use a find and replace
		 * to change 'buildpress_wp' to the name of your theme in all the template files
		 */
		load_theme_textdomain( 'buildpress_wp', get_template_directory() . '/languages' );

		// Add default posts and comments RSS feed links to head.
		add_theme_support( 'automatic-feed-links' );

		// Add title tag support
		add_theme_support( 'title-tag' );

		// WooCommerce basic support
		add_theme_support( 'woocommerce' );
		add_theme_support( 'wc-product-gallery-zoom' );
		add_theme_support( 'wc-product-gallery-lightbox' );
		add_theme_support( 'wc-product-gallery-slider' );

		// Custom Backgrounds
		add_theme_support( 'custom-background', array(
			'default-color' => 'ffffff',
		) );

		/**
		 * Enable support for Post Thumbnails on posts and pages.
		 *
		 * @link http://codex.wordpress.org/Function_Reference/add_theme_support#Post_Thumbnails
		 */
		add_theme_support( 'post-thumbnails' );
		set_post_thumbnail_size( 848, 480, true );

		$slider_width  = 1920;
		$slider_height = 580;
		if ( buildpress_is_transparent_header_style_active() ) {
			$slider_height = 700;
		}

		add_image_size( 'jumbotron-slider-l', $slider_width, $slider_height, true );
		add_image_size( 'jumbotron-slider-m', $slider_width / 2, $slider_height / 2, true );
		add_image_size( 'jumbotron-slider-s', $slider_width / 4, $slider_height / 4, true );
		add_image_size( 'page-box', 360, 202, true );
		add_image_size( 'project-gallery', 555, 555 );

		/**
		 * Additional image size after version 2.1.0.
		 * @see https://bitbucket.org/proteusnet/buildpress-wp/issue/39/dont-overwrite-core-options-on-activation issue #39
		 */
		if ( buildpress_installed_after( '2.1.0' ) ) {
			add_image_size( '100x75-crop', 100, 75, true );
		}

		// Menus
		add_theme_support( 'menus' );
		register_nav_menu( 'main-menu', _x( 'Main Menu', 'backend', 'buildpress_wp' ) );

		// register top bar menu only, if it is visible and used in this header style.
		if ( 'no' !== get_theme_mod( 'top_bar_visibility', 'yes' ) && buildpress_should_top_bar_menu_be_active() ) {
			register_nav_menu( 'top-bar-menu', _x( 'Top Bar Menu', 'backend', 'buildpress_wp' ) );
		}

		register_nav_menu( 'footer-bottom-menu', _x( 'Footer Bottom Menu', 'backend', 'buildpress_wp' ) );

		// Add theme support for Semantic Markup
		add_theme_support( 'html5', array(
			'search-form',
			'comment-form',
			'comment-list',
			'gallery',
			'caption',
		) );

		// add excerpt support for pages
		add_post_type_support( 'page', 'excerpt' );

		// Add CSS for the TinyMCE editor
		add_editor_style();
	}
	add_action( 'after_setup_theme', 'buildpress_theme_setup' );
}



/**
 * Enqueue CSS stylesheets
 */
if ( ! function_exists( 'buildpress_enqueue_styles' ) ) {
	function buildpress_enqueue_styles() {
		wp_enqueue_style( 'buildpress-main', get_stylesheet_uri(), array(), BUILDPRESS_WP_VERSION );
	}
	add_action( 'wp_enqueue_scripts', 'buildpress_enqueue_styles' );
}



/**
 * Enqueue Google Web Fonts.
 */
if ( ! function_exists( 'buildpress_enqueue_google_web_fonts' ) ) {
	function buildpress_enqueue_google_web_fonts() {
		wp_enqueue_style( 'google-fonts', buildpress_google_web_fonts_url(), array(), null );
	}
	add_action( 'wp_enqueue_scripts', 'buildpress_enqueue_google_web_fonts' );
}



/**
 * Enqueue JS scripts
 */
if ( ! function_exists( 'buildpress_enqueue_scripts' ) ) {
	function buildpress_enqueue_scripts() {
		// modernizr for the frontend feature detection
		wp_enqueue_script( 'buildpress-modernizr', get_template_directory_uri() . '/assets/js/modernizr.custom.24530.js', array(), null );

		// picturefill for the support of the <picture> element today
		// wp_enqueue_script( 'buildpress-picturefill', get_template_directory_uri() . '/bower_components/picturefill/dist/picturefill.min.js', array( 'buildpress-modernizr' ), '2.1.0' );

		// respimage for the support of the <picture> element today
		wp_enqueue_script( 'buildpress-respimage', get_template_directory_uri() . '/bower_components/respimage/respimage.min.js', array( 'buildpress-modernizr' ), '1.2.0' );

		// flip clock
		if ( is_active_widget( false, false, 'pt_countdown' ) || defined( 'WPB_VC_VERSION' ) || class_exists( 'WPML_Config' ) ) {
			wp_enqueue_script( 'buildpress-flipclock-js', get_template_directory_uri() . '/bower_components/flipclock/compiled/flipclock.min.js', array( 'jquery' ), '0.7.7', true );

			wp_enqueue_style( 'buildpress-flipclock-css', get_template_directory_uri() . '/bower_components/flipclock/compiled/flipclock.css', array(), '0.7.7' );
		}

		// google maps
		wp_register_script( 'buildpress-gmaps', buildpress_get_google_maps_api_url(), array(), null, true );

		// main JS file
		wp_enqueue_script( 'buildpress-main', get_template_directory_uri() . '/assets/js/main.min.js', array(
			'jquery',
			'underscore',
			'buildpress-gmaps',
		), BUILDPRESS_WP_VERSION, true );

		// Pass data to the main script
		wp_localize_script( 'buildpress-main', 'BuildPressVars', array(
			'pathToTheme'  => get_template_directory_uri(),
		) );

		// for nested comments
		if ( is_singular() && comments_open() ) {
			wp_enqueue_script( 'comment-reply' );
		}
	}
	add_action( 'wp_enqueue_scripts', 'buildpress_enqueue_scripts' );
}



/**
 * Register admin JS scripts
 */
if ( ! function_exists( 'buildpress_admin_enqueue_scripts' ) ) {
	function buildpress_admin_enqueue_scripts( $hook ) {
		$allowed_hooks = array( 'widgets.php', 'post.php', 'post-new.php' );

		wp_register_script( 'buildpress-mustache', get_template_directory_uri() . '/bower_components/mustache/mustache.min.js', array(), null, true );

		// enqueue admin utils js, conditionally
		// https://codex.wordpress.org/Plugin_API/Action_Reference/admin_enqueue_scripts
		if ( in_array( $hook, $allowed_hooks ) ) {
			wp_enqueue_script( 'buildpress-admin-utils', get_template_directory_uri() . '/assets/js/admin.js', array( 'jquery', 'underscore', 'backbone', 'buildpress-mustache' ), '1.1' );

			// provide the global variable to the `buildpress-admin-utils`
			wp_localize_script( 'buildpress-admin-utils', 'BuildPressAdminVars', array(
				'pathToTheme' => get_template_directory_uri(),
				'ajax_url'    => admin_url( 'admin-ajax.php' ),
				'ajax_nonce'  => wp_create_nonce( 'pt-buildpress-ajax-verification' ),
				'ajax_error'  => esc_html__( 'An error occurred while retrieving data via the AJAX request!', 'buildpress_wp' ),
			) );

			// css for admin
			wp_enqueue_style( 'buildpress-admin', get_template_directory_uri() . '/assets/stylesheets/admin.css' );
		}
	}
	add_action( 'admin_enqueue_scripts', 'buildpress_admin_enqueue_scripts' );
}



/**
 * Require the files in the folder /inc/
 */
$buildpress_files_to_require = array(
	'helpers',
	'theme-widgets',
	'theme-sidebars',
	'filters',
	'compat',
	'shortcodes',
	'custom-comments',
	'theme-customizer',
	'woocommerce',
	'ie-hacks',
	'theme-vc-shortcodes',
	'theme-registration',
);

// Conditionally require the includes files, based if they exist in the child theme or not
foreach ( $buildpress_files_to_require as $file ) {
	locate_template( "inc/{$file}.php", true, true );
}



/**
 * Require some files only when in admin
 */
if ( is_admin() ) {
	// other files
	$buildpress_admin_files_to_require = array(
		// custom code
		'inc/tgm-plugin-activation',
		'inc/documentation-link',
	);

	foreach ( $buildpress_admin_files_to_require as $file ) {
		locate_template( $file . '.php' , true, true );
	}
}
