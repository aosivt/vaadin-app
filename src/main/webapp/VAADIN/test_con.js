//window.onload = (function (){
//alert("Привеееееееед!!!");
//if (document.getElementById("protocol")!=null)
//{
//alert(document.getElementById("protocol").value);
//}
//});

//  $(window).on("load",function() {
//    alert( "DOMContentLoaded" );
//    document.addEventListener("DOMContentLoaded", function() {
//      test_con();
//    });
//   if (document.getElementById("protocol")!=null)
//   {
//   alert(document.getElementById("protocol").value);
//   }
//  });
//    document.getElementById('protocol').change;
  function test_con()
  {
//  document.getElementById("protocol").value = "254254";
  //alert(document.getElementById("protocol").value);
        var _input = document.getElementById("protocol");
//        var _tag_element = document.getElementsByTagName('protocol');
//        var _tag_element = document.getElementById('protocol');

//        console.log(_tag_element[0].value);
        _input.addEventListener("keydown" , function () {
          var _output="";
          var _output_slash="";
          _output_slash = _input.value;
          if (_output_slash.length == 4)
          {
            _output_slash = _input.value + '/';

            _input.value = _output_slash
          }
          else if (_output_slash.length == 8) {
            _output_slash = _input.value + '/';
            _input.value = _output_slash
          }
          else {
            _output_slash = _input.value;
            _input.value = _output_slash
          }
        })
        sort_grid();
        console.log(_input.value.length);

  }
  function sort_grid()
  {
  var _grid = document.getElementById("search_grid");
//  _grid.columns[0].sortable = true;
//  _grid.sortOrder = [{column: 0, direction: 'desc'}];
  }
