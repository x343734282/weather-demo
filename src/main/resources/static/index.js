
$(function(){
    $( document ).ajaxError(function(event, XMLHttpRequest, ajaxOptions, thrownError) {
      $( "#error" ).text( XMLHttpRequest.responseJSON.errors[0].message );
    });

$.addTemplateFormatter(
    {celsiusFormat:function(value, template) {
        return value+'&deg;C';
        },
     windFormat:function(value, template){
        return value+'km/h';
     },
     datetime:function(value){
     return moment(value).format('dddd  h:mm a');
     }
    });

    $('#cityDrop').on('change',function(){
         var city=$(this).val();
         if(city){
            $.get('/api/v1/realtime/weather?city='+city,function(response){
                console.log(response);
                $(".container").loadTemplate($("#templateCity"),response);
            });
         }else{
         }
    });
});