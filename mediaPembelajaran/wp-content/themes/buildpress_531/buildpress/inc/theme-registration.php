<?php
/**
 * Register automatic updates for this theme.
 */

use ProteusThemes\ThemeRegistration\ThemeRegistration;

class BuildPressThemeRegistration {
	function __construct() {
		$this->enable_theme_registration();
	}

	/**
	 * Load theme registration and automatic updates.
	 */
	private function enable_theme_registration() {
		$config = array(
			'item_name'        => 'BuildPress',
			'theme_slug'       => 'buildpress',
			'item_id'          => 2823,
			'tf_item_id'       => 9323981,
			'customizer_panel' => 'panel_buildpress',
			'build'            => 'tf',
		);
		$pt_theme_registration = ThemeRegistration::get_instance( $config );
	}
}

if ( ! BUILDPRESS_DEVELOPMENT && ! defined( 'ENVATO_HOSTED_SITE' ) ) {
	$buildpress_theme_registration = new BuildPressThemeRegistration();
}
