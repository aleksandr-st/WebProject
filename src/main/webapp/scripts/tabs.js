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
    	if ((firstName === "") || (firstName == undefined)) {
    		alert("First name is required!");
    	};
    	if ((lastName === "") || (lastName == undefined)) {
    		alert("Last name is required!");
    	};
    	event.preventDefault();
    });

});