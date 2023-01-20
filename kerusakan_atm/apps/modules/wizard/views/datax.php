<?php 
$num=count($data);
// echo $num;
?>
<table class="table table-hover table-striped" style="font-size:14px">
	<thead>
		<tr><th>Kerusakan Mesin</th>
			<th>Status Inferensi</th>
			
			<th>Keyakinan</th>
		</tr>
	</thead>
	<tbody>
		<?
			foreach ($data as $key => $value) {
				# code...
				echo "<tr>";
				echo "<td>";
				// echo "<div class='panel panel-info panel-body'><h5>kerusakan</h5>";
				echo "<p>";
				echo($value['detail']['kerusakan']);
				echo "</p>";
				echo "</td>";
				if($value['proses']==true){
					$proses="<span class='label label-warning'>Akan diproses..</span>";
				}else{
					$proses="<span class='label label-default'>Tidak diproses..</span>";
				}
				// echo "<td>".$value['status']." ".$proses."</td>";
				echo "<td>".$value['status']."</td>";

				
				/*echo "<div class='panel panel-warning panel-body'><h5>Perbedaan Antara Masukan dengan Rule</h5>";
				echo "<p>";
				print_r($value['diff']);
				echo "</p></div>";
				echo "<div class='panel panel-success panel-body'><h5>Kesamaan Antara Masukan dengan Rule</h5>";
				echo "<p>";
				print_r($value['union']);
				echo "</p></div>";
				echo "<div class='panel panel-success panel-body'><h5>Gejala Berikut Tidak Termasuk Dalam Inferensi</h5>";
				echo "<p>";
				print_r($value['outfit']);
				echo "</p></div>";
				echo "</td>";*/
				echo "<td>";
				// echo "<div class='panel panel-success panel-body'><h5>Dempster Shafer</h5>";
				// echo "<p>";
				// echo "<label class='label label-success' style='font-size:18px'>".(round($value['hasil'],2)."%")."</label>";
				?>
		
				<div class="progress " style="height:30px;margin-bottom:0px;">
				<?php if($value['hasil']>0): ?>
				  <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="<?php echo $value['hasil']; ?>" aria-valuemin="0" aria-valuemax="100" style="width: <?php echo $value['hasil']."%" ?>">
				    <span class="text-left" style='font-size:18px;font-weight:bold'><?php echo round($value['hasil'],2)."%"; ?></span>
				  </div>
				<?php else: ?>
				<div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="">
				    <span class="" style="font-size:18px;font-weight:bold;color:#000">0%</span>
				  </div>
				<?php endif ?>
				</div>
				<?php
				// echo "</p>";
				echo "</td>";

				echo "</tr>";
			}
			

			?>
		
	</tbody>
</table>



