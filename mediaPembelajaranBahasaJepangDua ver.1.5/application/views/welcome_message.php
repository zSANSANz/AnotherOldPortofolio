<script type="text/javascript">
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();
            $('html,body').animate({scrollTop: $(this.hash).offset().top}, 900);
        });
    });
</script>


<div class="top_banner">

    <!-- SVG Arrows -->
    <div class="svg-wrap">
        <svg width="64" height="64" viewBox="0 0 64 64">
            <path id="arrow-left"
                  d="M46.077 55.738c0.858 0.867 0.858 2.266 0 3.133s-2.243 0.867-3.101 0l-25.056-25.302c-0.858-0.867-0.858-2.269 0-3.133l25.056-25.306c0.858-0.867 2.243-0.867 3.101 0s0.858 2.266 0 3.133l-22.848 23.738 22.848 23.738z"/>
        </svg>
        <svg width="64" height="64" viewBox="0 0 64 64">
            <path id="arrow-right"
                  d="M17.919 55.738c-0.858 0.867-0.858 2.266 0 3.133s2.243 0.867 3.101 0l25.056-25.302c0.858-0.867 0.858-2.269 0-3.133l-25.056-25.306c-0.858-0.867-2.243-0.867-3.101 0s-0.858 2.266 0 3.133l22.848 23.738-22.848 23.738z"/>
        </svg>
    </div>

    <div class="menu wow fadeInDown" data-wow-duration=".10s" data-wow-delay=".4s">

        <div class="socialCircle-container">
            <div class="socialCircle-item"><a href="<?php echo site_url('welcome/bantuan') ?>" title="Bantuan"><i
                        class="glyphicon glyphicon-question-sign"></i></a></div>
            <div class="socialCircle-item"><a href="<?php echo site_url('welcome/simulasi') ?>" title="Simulasi"><i
                        class="glyphicon glyphicon-expand"></i></a></div>
            <div class="socialCircle-item"><a href="<?php echo site_url('cSoalAcak/index') ?>" title="Evaluasi"><i
                        class="glyphicon glyphicon-edit"></i></a></div>
            <div class="socialCircle-item"><a href="<?php echo base_url() ?>index.php/welcome/beranda"
                                              title="Pembelajaran"><i class="glyphicon glyphicon-list"></i></a></div>
            <div class="socialCircle-item"><a href="<?php echo base_url() ?>index.php/welcome/ " title="Beranda"><i
                        class="glyphicon glyphicon-home"></i></a></div>
            <div class="socialCircle-center closed"><i class="fa fa-share-alt"></i></div>
        </div>
    </div>
    <script src="<?php echo base_url() ?>assets/h_b/web/js/socialCircle.js"></script>
    <script type="text/javascript">
        $(".socialCircle-center").socialCircle({
            rotate: 0,
            radius: 140,
            circleSize: 2,
            speed: 500
        });
    </script>


    <div class="sleekslider" id="home">
        <!-- Slider Pages -->
        <div class="slide active bg-1">
            <div class="slide-container">
                <div class="slide-content">

                    <p class="wow fadeInLeft" data-wow-duration=".20s" data-wow-delay=".15s">MEPJAP, Media Pembelajaran
                        Bahasa Jepang.
                    </p>
                </div>

            </div>
        </div>
        <div class="slide bg-2">
            <div class="slide-container">
                <div class="slide-content">
                    <p class="wow fadeInLeft" data-wow-duration=".20s" data-wow-delay=".14s">MEPJAP, Media Pembelajaran
                        Bahasa Jepang.
                        </p>

                </div>
            </div>
        </div>
        <div class="slide bg-3">
            <div class="slide-container">
                <div class="slide-content">
                    <p class="wow fadeInLeft" data-wow-duration=".20s" data-wow-delay=".14s">MEPJAP, Media Pembelajaran
                        Bahasa Jepang.</p>

                </div>
            </div>
        </div>
        <div class="slide bg-4">
            <div class="slide-container">
                <div class="slide-content">
                    <p class="wow fadeInLeft" data-wow-duration=".20s" data-wow-delay=".14s">MEPJAP, Media Pembelajaran
                        Bahasa Jepang.</p>

                </div>
            </div>
        </div>
        <div class="slide bg-5">
            <div class="slide-container">
                <div class="slide-content">
                    <p class="wow fadeInLeft" data-wow-duration=".20s" data-wow-delay=".14s">MEPJAP, Media Pembelajaran
                        Bahasa Jepang.</p>

                </div>
            </div>
        </div>


        <!-- Pagination -->
        <nav class="pagination">
            <span class="current"></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </nav>


    </div>
    <script type="text/javascript">
        $(document).ready(function () {
            /*
             var defaults = {
             containerID: 'toTop', // fading element id
             containerHoverID: 'toTopHover', // fading element hover id
             scrollSpeed:1200,
             easingType: 'linear'
             };
             */

            $().UItoTop({easingType: 'easeOutQuart'});

        });
    </script>
    <!-- JavaScripts -->
    <!-- JavaScripts -->
    <script type="text/javascript" src="<?php echo base_url() ?>assets/h_b/web/js/sleekslider.min.js"></script>
    <script type="text/javascript" src="<?php echo base_url() ?>assets/h_b/web/js/app.js"></script>
    <!--welcome-->
</div>
<script>
    new WOW().init();
</script>
<!-- //animation-effect -->


