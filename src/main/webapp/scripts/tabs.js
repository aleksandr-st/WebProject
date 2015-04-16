$(document).ready(function(){
	function checkId(){
		var id = $('#id').val();
		if (((id === "") || (id == undefined))) {
			id = $('#id').text();
			if (((id === "") || (id == undefined))) {
				return false
			};
		};
		return true;
	}
	
    $("#contactData").click(function(){
        $("#contactDataTab").removeClass("hiddenTab");
        $("#contactHobbiesTab").addClass("hiddenTab");
        $("#contactPlacesTab").addClass("hiddenTab");
        $("#contactFriendsTab").addClass("hiddenTab");
        $("#contactDetailsTab").addClass("hiddenTab");
        
        $("#contactData").addClass("activeTab");
        $("#contactHobbies").removeClass("activeTab");
        $("#contactPlaces").removeClass("activeTab");
        $("#contactFriends").removeClass("activeTab");
        $("#contactDetails").removeClass("activeTab");
    });

    $("#contactHobbies").click(function(){
    	if (checkId() == false){
    		return false;
    	}
        $("#contactDataTab").addClass("hiddenTab");
        $("#contactHobbiesTab").removeClass("hiddenTab");
        $("#contactPlacesTab").addClass("hiddenTab");
        $("#contactFriendsTab").addClass("hiddenTab");
        $("#contactDetailsTab").addClass("hiddenTab");
        
        $("#contactData").removeClass("activeTab");
        $("#contactHobbies").addClass("activeTab");
        $("#contactPlaces").removeClass("activeTab");
        $("#contactFriends").removeClass("activeTab");
        $("#contactDetails").removeClass("activeTab");
    });

    $("#contactPlaces").click(function(){
    	if (checkId() == false){
    		return false;
    	}
        $("#contactDataTab").addClass("hiddenTab");
        $("#contactHobbiesTab").addClass("hiddenTab");
        $("#contactPlacesTab").removeClass("hiddenTab");
        $("#contactFriendsTab").addClass("hiddenTab");
        $("#contactDetailsTab").addClass("hiddenTab");
        
        $("#contactData").removeClass("activeTab");
        $("#contactHobbies").removeClass("activeTab");
        $("#contactPlaces").addClass("activeTab");
        $("#contactFriends").removeClass("activeTab");
        $("#contactDetails").removeClass("activeTab");
    });

    $("#contactFriends").click(function(){
    	if (checkId() == false){
    		return false;
    	}
        $("#contactDataTab").addClass("hiddenTab");
        $("#contactHobbiesTab").addClass("hiddenTab");
        $("#contactPlacesTab").addClass("hiddenTab");
        $("#contactFriendsTab").removeClass("hiddenTab");
        $("#contactDetailsTab").addClass("hiddenTab");
        
        $("#contactData").removeClass("activeTab");
        $("#contactHobbies").removeClass("activeTab");
        $("#contactPlaces").removeClass("activeTab");
        $("#contactFriends").addClass("activeTab");
        $("#contactDetails").removeClass("activeTab");
    });

    $("#contactDetails").click(function(){
    	if (checkId() == false){
    		return false;
    	}
        $("#contactDataTab").addClass("hiddenTab");
        $("#contactHobbiesTab").addClass("hiddenTab");
        $("#contactPlacesTab").addClass("hiddenTab");
        $("#contactFriendsTab").addClass("hiddenTab");
        $("#contactDetailsTab").removeClass("hiddenTab");
        
        $("#contactData").removeClass("activeTab");
        $("#contactHobbies").removeClass("activeTab");
        $("#contactPlaces").removeClass("activeTab");
        $("#contactFriends").removeClass("activeTab");
        $("#contactDetails").addClass("activeTab");
    });

    $("#contactSubmit").click(function(event){
    	var firstName = $('#firstName').val();
    	var lastName = $('#lastName').val();
    	var birthDate = $('#birthDate').val();
    	var version = $('#version').val();
    	var id = $('#id').val();
    	var jsonUrl = $("#contactUpdateForm").attr("action");
		if (((id === "") || (id == undefined))) {
			jsonUrl += "?jsonCreate";
		} else {
			jsonUrl += "/" + id +"?jsonUpdate"
		};
    	var hadErrors = false;
    	if ((firstName === "") || (firstName == undefined)) {
    		alert("First name is required!");
    		hadErrors = true;
    	};
    	if ((lastName === "") || (lastName == undefined)) {
    		alert("Last name is required!");
    		hadErrors = true;
    	};
    	if (hadErrors){
    		return false;
    	}
    	var json = {id:id,version:version,firstName:firstName,lastName:lastName,
    			birthDate:birthDate};
    	$.ajax({
    		url: jsonUrl,
    		data: JSON.stringify(json),
    		type: "POST",
    		
    		beforeSend: function(xhr){
    			xhr.setRequestHeader("Accept","application/json");
    			xhr.setRequestHeader("Content-Type","application/json");
    		},
    		success: function(contactJson){
    	    	$('#firstName').val(contactJson.firstName);
    	    	$('#lastName').val(contactJson.lastName);
    	    	$('#birthDate').val(contactJson.birthDate);
    	    	$('#version').val(contactJson.version);
    	    	$('#id').val(contactJson.id);

    	    	$('#operationResultMessage').html('Contact saved successful!');
    			alert("Id "+contactJson.id+" name: "+contactJson.firstName);
    	    	
    	    	$('#viewContact').attr('href',$('#contactUpdateForm').attr('action')+'/'+contactJson.id);
    		}
    	});
    	
    	event.preventDefault();
    });

    $("#MoveRight,#MoveLeft").click(function(event){
        var id = $(event.target).attr("id");
        var selectFrom = id == "MoveRight" ? "#usedHobbies" : "#unusedHobbies";
        var moveTo = id == "MoveRight" ? "#unusedHobbies" : "#usedHobbies";

        var selectedItems = $(selectFrom + " :selected").toArray();
        $(moveTo).append(selectedItems);
        selectedItems.remove;
    });
    
    $('#contactHobbiesSave').click(function(event){
    	var version = $('#version').val();
    	var id = $('#id').val();
    	var jsonUrl = $("#contactUpdateForm").attr("action")+"/" + id +"?jsonHobbyUpdate&version="+version;
    	var hobbies = $('#usedHobbies').toArray();
    	var json = '{[';
    	var list = $("#selectList");
    	$.each(items, function(index, item) {
    	  list.append(new Option(item.text, item.value));
    	});    	alert(""+hobbies);
    	
    	var json = {id:id,version:version,firstName:firstName,lastName:lastName,
    			birthDate:birthDate,hobbies:hobbies};
    	$.ajax({
    		url: jsonUrl,
    		data: JSON.stringify(json),
    		type: "POST",
    		
    		beforeSend: function(xhr){
    			xhr.setRequestHeader("Accept","application/json");
    			xhr.setRequestHeader("Content-Type","application/json");
    		},
    		success: function(contactJson){
    	    	$('#firstName').val(contactJson.firstName);
    	    	$('#lastName').val(contactJson.lastName);
    	    	$('#birthDate').val(contactJson.birthDate);
    	    	$('#version').val(contactJson.version);
    	    	$('#id').val(contactJson.id);
    	    	var hobbiesReseived = contactJson.hobbies;
    	    	alert(""+hobbiesReseived);
    	    	//$('#usedHobbies').removeOption(/./);
    	    	

    	    	$('#operationResultMessage').html('Contact saved successful!');
    			alert("Id "+contactJson.id+" name: "+contactJson.firstName);
    	    	
    	    	$('#viewContact').attr('href',$('#contactUpdateForm').attr('action')+'/'+contactJson.id);
    		}
    	});
    });

});