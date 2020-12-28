
$(function(){
    $( document ).ajaxError(function(event, XMLHttpRequest, ajaxOptions, thrownError) {
      $( "#error" ).text( XMLHttpRequest.responseJSON.errors[0].message );
    });

    $('#cityDrop').on('change',function(){
         var city=$(this).val();
         if(city){
            $.get('/api/v1/realtime/weather?city='+city,function(response){
                console.log(response);
            });
         }else{
         }
    });
});