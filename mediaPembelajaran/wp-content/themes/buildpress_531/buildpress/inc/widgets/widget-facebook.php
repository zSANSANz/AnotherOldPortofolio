<?php
/**
 * Footer Facebook Widget
 *
 * @package BuildPress
 */


if ( ! class_exists( 'PT_Footer_Facebook' ) ) {
	class PT_Footer_Facebook extends WP_Widget {

		/**
		 * Register widget with WordPress.
		 */
		public function __construct() {
			parent::__construct(
				false, // ID, auto generate when false
				_x( 'ProteusThemes: Facebook', 'backend' , 'buildpress_wp'), // Name
				array(
					'description' => _x( 'Use this widget only in the footer of the BuildPress theme', 'backend', 'buildpress_wp'),
				)
			);

			// color picker needed
			add_action( 'admin_enqueue_scripts', array( $this, 'add_color_picker' ) );
		}

		/**
		 * Add color picker as we need it in this widget
		 */
		public function add_color_picker() {
			wp_enqueue_style( 'wp-color-picker' );
			wp_enqueue_script( 'wp-color-picker' );
		}

		/**
		 * Front-end display of widget.
		 *
		 * @see WP_Widget::widget()
		 *
		 * @param array $args     Widget arguments.
		 * @param array $instance Saved values from database.
		 */
		public function widget( $args, $instance ) {
			extract( $args );
			echo $before_widget;
			$instance['title']      = apply_filters( 'widget_title', empty( $instance['title'] ) ? '' : $instance['title'], $instance, $this->id_base );
			$instance['height']     = absint( $instance['height'] );
			$instance['background'] = esc_attr( $instance['background'] );

			// params for the iframe
			// @see https://developers.facebook.com/docs/plugins/like-box-for-pages

			$fb_params = array(
				'colorscheme' => $instance['colorscheme'],
				'stream'      => 'false',
				'show_border' => 'false',
				'header'      => 'false',
				'show_faces'  => 'true',
				'width'       => 263,
				'height'      => $instance['height'],
				'href'        => $instance['like_link'],
			);

			?>
				<?php echo $before_title . $instance['title'] . $after_title; ?>

				<div class="iframe-like-box">
					<iframe src="//www.facebook.com/plugins/likebox.php?<?php echo http_build_query( $fb_params ); ?>" frameborder="0"></iframe>
				</div>

				<style type="text/css">
					.iframe-like-box > iframe { min-height: <?php echo $fb_params['height']; ?>px; background-color: <?php echo $instance['background']; ?>; max-width: 100%; }
				</style>

			<?php
			echo $after_widget;
		}

		/**
		 * Sanitize widget form values as they are saved.
		 *
		 * @see WP_Widget::update()
		 *
		 * @param array $new_instance Values just sent to be saved.
		 * @param array $old_instance Previously saved values from database.
		 *
		 * @return array Updated safe values to be saved.
		 */
		public function update( $new_instance, $old_instance ) {
			$instance = array();

			$instance['title']       = wp_kses_post( $new_instance['title'] );
			$instance['colorscheme'] = sanitize_key( $new_instance['colorscheme'] );
			$instance['like_link']   = esc_url_raw( $new_instance['like_link'] );
			$instance['height']      = absint( $new_instance['height'] );
			$instance['background']  = esc_attr( $new_instance['background'] );

			return $instance;
		}

		/**
		 * Back-end widget form.
		 *
		 * @see WP_Widget::form()
		 *
		 * @param array $instance Previously saved values from database.
		 */
		public function form( $instance ) {
				$title       = isset( $instance[ 'title' ] ) ? $instance[ 'title' ] : 'Facebook';
				$colorscheme = isset( $instance[ 'colorscheme' ] ) ? $instance[ 'colorscheme' ] : 'light';
				$like_link   = isset( $instance[ 'like_link' ] ) ? $instance[ 'like_link' ] : 'https://www.facebook.com/ProteusThemes';
				$height      = isset( $instance['height'] ) ? $instance['height'] : 290;
				$background  = isset( $instance['background'] ) ? $instance['background'] : '#ffffff';

			?>
			<p>
				<label for="<?php echo $this->get_field_id( 'title' ); ?>"><?php _ex( 'Title:', 'backend', 'buildpress_wp'); ?></label>
				<input class="widefat" id="<?php echo $this->get_field_id( 'title' ); ?>" name="<?php echo $this->get_field_name( 'title' ); ?>" type="text" value="<?php echo esc_attr( $title ); ?>" />
			</p>

			<p>
				<label for="<?php echo $this->get_field_id( 'like_link' ); ?>"><?php _ex( 'FB Page to like (the whole URL)', 'backend', 'buildpress_wp'); ?>:</label> <br />
				<input class="widefat" id="<?php echo $this->get_field_id( 'like_link' ); ?>" name="<?php echo $this->get_field_name( 'like_link' ); ?>" type="text" value="<?php echo $like_link; ?>" />
			</p>

			<p>
				<label for="<?php echo $this->get_field_id( 'height' ); ?>"><?php _ex( 'Height (in pixels):', 'backend', 'buildpress_wp' ); ?></label>
				<input class="widefat" id="<?php echo $this->get_field_id( 'height' ); ?>" name="<?php echo $this->get_field_name( 'height' ); ?>" type="number" min="0" step="10" value="<?php echo esc_attr( $height ); ?>" />
			</p>

			<p>
				<label for="<?php echo $this->get_field_id( 'colorscheme' ); ?>"><?php _ex( 'Color scheme', 'backend', 'buildpress_wp'); ?>:</label> <br />
				<select id="<?php echo $this->get_field_id( 'colorscheme' ); ?>" name="<?php echo $this->get_field_name( 'colorscheme' ); ?>">
					<option value="light"<?php selected( $colorscheme, 'light' ); ?>><?php _ex( 'Light', 'backend', 'buildpress_wp' ); ?></option>
					<option value="dark"<?php selected( $colorscheme, 'dark' ); ?>><?php _ex( 'Dark', 'backend', 'buildpress_wp' ); ?></option>
				</select>
			</p>

			<p>
				<label for="<?php echo $this->get_field_id( 'background' ); ?>"><?php _ex( 'Background color:', 'backend', 'buildpress_wp'); ?></label> <br>
				<input class="js-pt-color-picker" id="<?php echo $this->get_field_id( 'background' ); ?>" name="<?php echo $this->get_field_name( 'background' ); ?>" type="text" value="<?php echo esc_attr( $background ); ?>" data-default-color="<?php echo '#ffffff'; ?>" />
			</p>

			<?php
		}

	}
	add_action( 'widgets_init', create_function( '', 'register_widget( "PT_Footer_Facebook" );' ) );
}