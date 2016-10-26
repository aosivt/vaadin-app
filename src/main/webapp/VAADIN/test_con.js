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
  document.getElementById("protocol").value = "254254";
  alert(document.getElementById("protocol").value);
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