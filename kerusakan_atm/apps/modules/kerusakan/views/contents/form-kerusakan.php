<div class="row clearfix">
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 kelola" style="display:none">
		<div id="form_input" class="">
		<?php echo form_open(base_url('kerusakan/submit'),array('id'=>'addform','role'=>'form','class'=>'form')); ?>

			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
					<input type="hidden" value='<?php  echo !empty($default['id_penilaian'])?$default['id_penilaian']:'' ?>' id="id_kerusakan" name="id_kerusakan">

					<div class="form-group">
						<?php echo form_label('Kode : ','kode',array('class'=>'control-label')); ?>
						<div class="controls">
						<?php echo form_input('kode','','id="kode" class="form-control" placeholder="Masukkan Kode"'); ?>
						</div>
					</div>

					<div class="form-group">
						<?php echo form_label('kerusakan : ','kerusakan',array('class'=>'control-label')); ?>
						<div class="controls">
						<?php echo form_input('kerusakan','','id="kerusakan" class="form-control" placeholder="Masukkan Kerusakan"'); ?>
						</div>
					</div>
					<div class="form-group">
						<?php echo form_label('Keterangan : ','keterangan',array('class'=>'control-label')); ?>
						<div class="controls">
						<?php echo form_input('keterangan','','id="keterangan" class="form-control" placeholder="Masukkan Keterangan"'); ?>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
					<div class="form-group">
						<?php echo form_label('Penyebab : ','penyebab',array('class'=>'control-label')); ?>
						<div class="controls">
						<?php echo form_input('penyebab','','id="penyebab" class="form-control" placeholder="Masukkan Penyebab Kerusakan"'); ?>
						</div>
					</div>

					<div class="form-group">
						<?php echo form_label('Saran Penanggulangan : ','penanggulangan',array('class'=>'control-label')); ?>
						<div class="controls">
						<?php echo form_input('penanggulangan','','id="penanggulangan" class="form-control" placeholder="Masukkan Penanggulangan"'); ?>
						</div>
					</div>
				

				
				</div>
			</div>
			
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<button id="save" type="submit" class="btn btn-md btn-success"><icon class="fa fa-floppy-o"></icon> Simpan</button>
					<button id="save_edit" type="submit" class="btn btn-md btn-primary" style="display:none;"><icon class="fa fa-refresh"></icon> Perbaiki</button>
					<a href="#" id="cancel_edit" class="btn btn-md btn-danger batal" style=""><i class="glyphicon glyphicon-remove"></i> Batal</a>
				</div>
			</div>
		<?php echo form_close();?>
		</div>
	</div>
</div>