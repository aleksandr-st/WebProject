$(document).ready(function(){
 
    $("#contactData").click(function(){
        $("#contactDataTab").removeClass("hiddenTab");
        $("#contactHobbiesTab").addClass("hiddenTab");
        $("#contactPlacesTab").addClass("hiddenTab");
        $("#contactFriendsTab").addClass("hiddenTab");
        
        $("#contactData").addClass("activeTab");
        $("#contactHobbies").removeClass("activeTab");
        $("#contactPlaces").removeClass("activeTab");
        $("#contactFriends").removeClass("activeTab");
    });

    $("#contactHobbies").click(function(){
        $("#contactDataTab").addClass("hiddenTab");
        $("#contactHobbiesTab").removeClass("hiddenTab");
        $("#contactPlacesTab").addClass("hiddenTab");
        $("#contactFriendsTab").addClass("hiddenTab");
        
        $("#contactData").removeClass("activeTab");
        $("#contactHobbies").addClass("activeTab");
        $("#contactPlaces").removeClass("activeTab");
        $("#contactFriends").removeClass("activeTab");
    });

    $("#contactPlaces").click(function(){
        $("#contactDataTab").addClass("hiddenTab");
        $("#contactHobbiesTab").addClass("hiddenTab");
        $("#contactPlacesTab").removeClass("hiddenTab");
        $("#contactFriendsTab").addClass("hiddenTab");
        
        $("#contactData").removeClass("activeTab");
        $("#contactHobbies").removeClass("activeTab");
        $("#contactPlaces").addClass("activeTab");
        $("#contactFriends").removeClass("activeTab");
    });

    $("#contactFriends").click(function(){
        $("#contactDataTab").addClass("hiddenTab");
        $("#contactHobbiesTab").addClass("hiddenTab");
        $("#contactPlacesTab").addClass("hiddenTab");
        $("#contactFriendsTab").removeClass("hiddenTab");
        
        $("#contactData").removeClass("activeTab");
        $("#contactHobbies").removeClass("activeTab");
        $("#contactPlaces").removeClass("activeTab");
        $("#contactFriends").addClass("activeTab");
    });

});