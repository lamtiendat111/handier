$(document).ready(function() {
    var page;
    var sapxep = $('input[name="sapxep"]:checked').val();
     var category = $('input[name="category"]:checked').val();
    console.log(sapxep);
    if(page == undefined){
    page = 1;}
    var max = $("#slmax").attr("data-max");
    max = max | 0 ;
    
	$('#input-search').click(function() {
		$('#input-search').autocomplete({
			source: 'api/search'
		});
	});
	$('#input-search1').click(function() {
		$('#input-search1').autocomplete({
			source: 'api/search'
		});
	});
	$("body").on("click", ".page-link1", function() {
        sapxep = $('input[name="sapxep"]:checked').val();
        category = $('input[name="category"]:checked').val();
	if($(this).attr("aria-label") == "Previous"){
	if(page == 1){
    page = max;
   
	}
	else{
        --page;
	}
	
	}
	else if($(this).attr("aria-label") == "Next"){
		if(page == max){
	page = 1;
	}
	else{
      ++page ;
	}
	}
	else{
	page = $(this).text();
	}
	
		
		$.ajax({
			type: 'get',
			url: 'shop/phantrang',
			data: {
				page: page,sapxep: sapxep,category:category
			},
			 dataType: 'json',
            contentType: 'application/json',

			success: function(data) {
			
				$('#container-pagi').empty();
				$('#container-pagi').append(data.content);
			}
		});
    });
    $("body").on("change", 'input[name="sapxep"]', function() {
        sapxep = $('input[name="sapxep"]:checked').val();
        $.ajax({
			type: 'get',
			url: 'shop/phantrang',
			data: {
				page: page,sapxep: sapxep,category:category
			},
			 dataType: 'json',
            contentType: 'application/json',

			success: function(data) {
			
				$('#container-pagi').empty();
				$('#container-pagi').append(data.content);
			}
		});
    });
    $("body").on("change", 'input[name="category"]', function() {
        category = $('input[name="category"]:checked').val();
        $.ajax({
			type: 'get',
			url: 'shop/phantrang',
			data: {
				page: page,sapxep: sapxep,category:category
			},
			 dataType: 'json',
            contentType: 'application/json',

			success: function(data) {
			
				$('#container-pagi').empty();
				$('#container-pagi').append(data.content);
			}
		});
    });
});
