<div class="jumbotron  jumbotron--<?php echo get_field( 'slider_with_captions' ) ? 'with-captions' : 'no-catption'; ?>">
	<div class="carousel  slide  js-jumbotron-slider" id="headerCarousel" <?php printf( 'data-interval="%s"', get_field( 'auto_cycle' ) ? get_field( 'cycle_interval' ) : 'false' ); ?>>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
		<?php
			$i = -1;
			while ( have_rows( 'slides' ) ) :
				the_row();
				$i++;

				$slide_image_id     = absint( get_sub_field( 'slide_image' ) );
				$slide_alt_text     = get_sub_field( 'slide_title' );
				$slide_image_srcset = buildpress_get_slide_sizes( $slide_image_id );
				$slide_image_src    = wp_get_attachment_image_src( $slide_image_id, 'jumbotron-slider-s' );

				if ( empty( $slide_alt_text ) ) {
					$slide_alt_text = buildpress_get_attachment_alt_text( $slide_image_id );
				}
		?>

			<div class="item <?php echo 0 === $i ? ' active' : ''; ?>">
				<img src="<?php echo esc_url( $slide_image_src[0] ); ?>" srcset="<?php echo $slide_image_srcset; ?>" sizes="100vw" alt="<?php echo esc_attr( $slide_alt_text ); ?>">
				<?php if ( get_field( 'slider_with_captions' ) ) : ?>
				<div class="container">
					<div class="carousel-content">
					<?php if ( strlen( get_sub_field( 'slide_category' ) ) ) : ?>
						<div class="jumbotron__category">
							<h6><?php the_sub_field( 'slide_category' ); ?></h6>
						</div>
					<?php endif; ?>
						<div class="jumbotron__title">
							<p><?php the_sub_field( 'slide_title' ); ?></p>
						</div>
						<div class="jumbotron__content">
							<?php the_sub_field( 'slide_text' ); ?>
						</div>
					</div>
				</div>
				<?php endif; ?>
			</div>

		<?php
			endwhile;
		?>
		</div>

		<!-- Controls -->
		<a class="left  carousel-control" href="#headerCarousel" role="button" data-slide="prev">
			<i class="fa  fa-angle-left"></i>
		</a>
		<a class="right  carousel-control" href="#headerCarousel" role="button" data-slide="next">
			<i class="fa  fa-angle-right"></i>
		</a>

	</div>
</div>