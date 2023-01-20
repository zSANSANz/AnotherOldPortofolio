
  <!-- Fixed navbar -->
  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        </button>
        <div class="logo wow bounceInDown animated" data-wow-delay="0.4s" style="visibility: visible; animation-delay: 0.4s; animation-name: bounceInDown;">
          <a href="#"><img src="<?php echo base_url()?>assets/images/logo-um.png" style="width: 70px; height: 40px" alt="logo um"></a>
        </div>
        <a class="navbar-brand" href="<?php echo site_url('welcome') ?>">MEJAP</a>
      </div>

            <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
        <li><a href="<?php echo base_url() ?>/index.php/welcome/ ">beranda</a></li>
        <li><a href="<?php echo base_url() ?>/index.php/welcome/beranda ">pembelajaran</a></li>
        <li><a href="http://localhost/cat/adm/ikuti_ujian">evaluasi</a></li>
        <li><a href="<?php echo site_url('welcome/simulasi') ?>">simulasi</a></li>
        <li><a href="<?php echo site_url('welcome/bantuan') ?>">bantuan</a></li>
        </ul>
            <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="login.html">Logout</a></li>
                </ul>
            </div>
      <!--/.nav-collapse -->
    </div>
  </nav>

  <br/><br/><br/><br/>

  <div class="header_bottom">
        <h1 class="m_head wow rollIn" data-wow-delay="0.4s">Protect Your sensitive<br> files across cloud services.</h1>
        
    </div>

  <div class="container">
  
<h3>ini halaman bab 1 terdapat tujuan yang akan dibahas yaitu :</h3>

<div class="container">
  <div class="row">
    <div class="col-sm-3 col-md-6">
    	<p>
    		<?php echo anchor(base_url().'index.php/cBabDua/babDuaTujuan','<input type="button" class="btn btn-large btn-danger btn-sm btn-block" value="KD0">');?>
    	</p>
    </div>
  </div>
 </div>

<div class="container">
  <div class="row">
    <p>
  		<?php echo anchor(base_url().'index.php/cBabDua/babDuaTujuan','<input type="button" class="btn btn-danger btn-lg btn-block" value="Kompetensi Dasar Satu(1): Memahami berbagai layanan jaringan">');?>
  	</p>
  </div>
  <div class="row">
  	<p>
  		<?php echo anchor(base_url().'index.php/cBabDua/babDuaTujuan','<input type="button" class="btn btn-primary btn-lg btn-block" value="Kompetensi Dasar Dua(2): Menyajikan berbagai layanan jaringan">');?>
  	</p>
  </div>
</div>

</div> <!-- /container -->