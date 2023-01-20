<?php include("utility/header.php"); ?>



    <div class="wrapper">
    <div class="container">


    <div class="row">
        <div class="col-sm-12">
            <div class="card-box table-responsive">
                <script type="text/javascript"
                        src="http://static.fusioncharts.com/code/latest/fusioncharts.js"></script>


                <?php

                class FusionCharts
                {

                    private $constructorOptions = array();
                    private $constructorTemplate = '
        <script type="text/javascript">
            FusionCharts.ready(function () {
                new FusionCharts(__constructorOptions__);
            });
        </script>';
                    private $renderTemplate = '
        <script type="text/javascript">
            FusionCharts.ready(function () {
                FusionCharts("__chartId__").render();
            });
        </script>
        ';

                    // constructor
                    function __construct($type, $id, $width = 400, $height = 300, $renderAt, $dataFormat, $dataSource)
                    {
                        isset($type) ? $this->constructorOptions['type'] = $type : '';
                        isset($id) ? $this->constructorOptions['id'] = $id : 'php-fc-' . time();
                        isset($width) ? $this->constructorOptions['width'] = $width : '';
                        isset($height) ? $this->constructorOptions['height'] = $height : '';
                        isset($renderAt) ? $this->constructorOptions['renderAt'] = $renderAt : '';
                        isset($dataFormat) ? $this->constructorOptions['dataFormat'] = $dataFormat : '';
                        isset($dataSource) ? $this->constructorOptions['dataSource'] = $dataSource : '';
                        $tempArray = array();
                        foreach ($this->constructorOptions as $key => $value) {
                            if ($key === 'dataSource') {
                                $tempArray['dataSource'] = '__dataSource__';
                            } else {
                                $tempArray[$key] = $value;
                            }
                        }

                        $jsonEncodedOptions = json_encode($tempArray);

                        if ($dataFormat === 'json') {
                            $jsonEncodedOptions = preg_replace('/\"__dataSource__\"/', $this->constructorOptions['dataSource'], $jsonEncodedOptions);
                        } elseif ($dataFormat === 'xml') {
                            $jsonEncodedOptions = preg_replace('/\"__dataSource__\"/', '\'__dataSource__\'', $jsonEncodedOptions);
                            $jsonEncodedOptions = preg_replace('/__dataSource__/', $this->constructorOptions['dataSource'], $jsonEncodedOptions);
                        } elseif ($dataFormat === 'xmlurl') {
                            $jsonEncodedOptions = preg_replace('/__dataSource__/', $this->constructorOptions['dataSource'], $jsonEncodedOptions);
                        } elseif ($dataFormat === 'jsonurl') {
                            $jsonEncodedOptions = preg_replace('/__dataSource__/', $this->constructorOptions['dataSource'], $jsonEncodedOptions);
                        }
                        $newChartHTML = preg_replace('/__constructorOptions__/', $jsonEncodedOptions, $this->constructorTemplate);
                        echo $newChartHTML;
                    }
                    // render the chart created
                    // It prints a script and calls the FusionCharts javascript render method of created chart
                    function render()
                    {
                        $renderHTML = preg_replace('/__chartId__/', $this->constructorOptions['id'], $this->renderTemplate);
                        echo $renderHTML;
                    }
                }

                ?>




                <?php

                include "koneksi/koneksi.php";

                $sql = "SELECT COUNT(id_hasil) as jumlah_positif FROM tb_hasil WHERE hasil='Positif'";
                $result = $conn->query($sql);

                if ($result->num_rows > 0) {
                    $i = 1;
                    //output data of each row
                    while ($row = $result->fetch_assoc()) {

                        $sql1 = "SELECT COUNT(id_hasil) as jumlah_negatif FROM tb_hasil WHERE hasil='Negatif'";
                        $result1 = $conn->query($sql1);

                        if ($result1->num_rows > 0) {
                            $i = 1;
                            //output data of each row
                            while ($row1 = $result1->fetch_assoc()) {


                                /*
                                    Create a `area2DChart` chart object using the FusionCharts PHP class constructor. Syntax for the constructor is `FusionCharts("type of chart", "unique chart id", "width of chart", "height of chart", "div id to render the chart", "data format", "data source")`. To load data from a JSON string, `json` is passed as the value for the data format parameter of the constructor. The actual JSON data for the chart is passed as a string to the constructor.
                                */
                                $area2DChart = new FusionCharts("pie2d", "myFirstChart", 600, 300, "chart-1", "json",
                                    '{
                                                "chart": {
                                                    "caption": "Positif vs Negatif",
                                                    "subCaption": "Naive Bayes Classifier",
                                                    "xAxisName": "Data",
                                                    "yAxisName": "Jumlah Data",
                                                    "numberPrefix": "jumlah ",
                                                    "paletteColors": "#0075c2,#1aaf5d,#f2c500,#f45b00,#8e0000",
                                                    "bgColor": "#ffffff",
                                                    "showBorder": "0",
                                                    "showCanvasBorder": "0",
                                                    "plotBorderAlpha": "10",
                                                    "usePlotGradientColor": "0",
                                                    "plotFillAlpha": "50",
                                                    "showXAxisLine": "1",
                                                    "axisLineAlpha": "25",
                                                    "divLineAlpha": "10",
                                                    "showValues": "1",
                                                    "showAlternateHGridColor": "0",
                                                    "captionFontSize": " 14",
                                                    "subcaptionFontSize": "14",
                                                    "subcaptionFontBold": "0",
                                                    "toolTipColor": "#ffffff",
                                                    "toolTipBorderThickness": "0",
                                                    "toolTipBgColor": "#000000",
                                                    " toolTipBgAlpha": "80",
                                                    "toolTipBorderRadius": "2",
                                                    "toolTipPadding": "5"
                                                },
                                                "data": [{
                                                    "label": "",
                                                    " value": ""
                                                }, {
                                                    "label": "Positif",
                                                    "value": ' . $row["jumlah_positif"] . '
                                                }, {
                                                    "label": "Negatif",
                                                    "value": ' . $row1["jumlah_negatif"] . '
                                                }]
                                            }'
                                );


                                // Render the chart
                                $area2DChart->render();

                            }
                        }
                    }
                }
                ?>
                <div id="chart-1">Fusion Charts will render here</div>
            </div>
        </div><!-- end col -->
    </div>
    <!-- end row -->

<?php include("utility/footer.php"); ?>