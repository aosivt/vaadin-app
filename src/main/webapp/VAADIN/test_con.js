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
        console.log(_input.value.length);

  }
//
//  window.onload = test_con();

//                var observer = new MutationObserver(function(mutations) {
//                    mutations.forEach(function(mutation) {
//                      if (mutation.addedNodes) mutation.addedNodes
//                      for (var i = 0; i < mutation.addedNodes.length; ++i) {
//                            var node = mutation.addedNodes[i];
//                        if(node.id==idWeAreLookingFor){
//                            Do something and then disconnect the observer because we got what we where looking for
//                            test_con();
//                            observer.disconnect();
//                        }
//                      }
//                    });
//                  });
//
//
//                  observer(document.body, {
//                      childList: true
//                    , subtree: true
//                    , attributes: false
//                    , characterData: false
//                  });