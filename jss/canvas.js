$(document).ready(function(){
    var canvas = new fabric.Canvas('canvas');
    var index = 1

    $('#bprev').click(function() {
        if (index == 1) {
          alert('Esta es la primer hoja');
        }
        else {
          index = index - 1
        }

        $('#numpa').text("Pagina: " + index);

    });
    $('#bsig').click(function() {
        index = index + 1
        $('#numpa').text("Pagina: " + index);

    });
    $('#save').click(function() {
      var textFile = null;
      var data = new Blob([JSON.stringify(canvas)], {type: 'text/plain'});
      if (textFile !== null) {
        window.URL.revokeObjectURL(textFile);
      }
      textFile = window.URL.createObjectURL(data);
      var file = new File([data],"hola.txt")
    });

    $('#shapecolor').change(function() {
      var activeObject = canvas.getActiveObject();
      activeObject.fill = '#' + $(this).val();
      canvas.renderAll();
    });

    $('#delete').click(function() {
      canvas.remove(canvas.getActiveObject());
      canvas.renderAll();
    });

    $('#clearboard').click(function() {
      canvas.clear();
      canvas.renderAll();
    });
    $('#button1').click(function() {
              var circle = new fabric.Circle({
                radius: 20,
                fill: 'black',
                left: 100,
                top: 100
              });
          canvas.getObjects();
          canvas.add(circle);
          canvas.selection = true;
          canvas.renderAll();
          canvas.calcOffset();

    });
    $('#button2').click(function() {
      var rect = new fabric.Rect({
          left: 100,
          top: 100,
          fill: 'black',
          width: 20,
          height: 20
      });
          canvas.getObjects();
          canvas.add(rect);
          canvas.selection = true;
          canvas.renderAll();
          canvas.calcOffset();

    });
    $('#button3').click(function() {
      var line = new fabric.Line([ 250, 125, 250, 175 ], {
        fill: 'red',
        stroke: 'red',
        strokeWidth: 5,
        selectable: true
      });
          canvas.getObjects();
          canvas.add(line);
          canvas.selection = true;
          canvas.renderAll();
          canvas.calcOffset();

    });
    $('#button4').click(function() {
      $.get('svg/bee.svg', function(svg){
          var svgString = svg;
          fabric.loadSVGFromString(svgString, function(results, options) {
            results.reverse()
            var group = new fabric.Group(results, {
              left: 200,
              top: 100
            });
            canvas.add(group);
        });
      }, 'text');
    });
    $('#button5').click(function() {
      $.get('svg/001-gloves.svg', function(svg){
          var svgString = svg;
          fabric.loadSVGFromString(svgString, function(results, options) {
            results.reverse()
            var group = new fabric.Group(results, {
              left: 200,
              top: 100
            });
            canvas.add(group);
        });
      }, 'text');
    });

  });
