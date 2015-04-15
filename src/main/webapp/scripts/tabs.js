$(document).ready(function(){
 
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
    	//alert("json prepearing complete. Url: "+jsonUrl);
    	//alert(""+JSON.stringify(json));
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

});