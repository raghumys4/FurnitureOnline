var register={};
$body = $("body");


$('#firstname').on('change',function(){
    $(this).parents('.form-group').removeClass('has-error');
})
$('#firstname').on('change',function(){
    $(this).parents('.form-group').removeClass('has-error');
})
$('#lastname').on('change',function(){
    $(this).parents('.form-group').removeClass('has-error');
})
$('#email').on('change',function(){
    $(this).parents('.form-group').removeClass('has-error');
})
$('#mobile').on('change',function(){
    $(this).parents('.form-group').removeClass('has-error');
})
$('#password').on('change',function(){
    $(this).parents('.form-group').removeClass('has-error');
})
$('#confirmpassword').on('change',function(){
    $(this).parents('.form-group').removeClass('has-error');
})


function showAlert(modaltitle, modalbody) {

    $('#modalbody').empty();
    $('#modaltitle').empty();
    $('#modaltitle').append(modaltitle);
    $('#modalbody').append(modalbody);
    $('#myModal').modal('show');

    return;
}


function dataclose() {
    $('#modalbody').empty();
    $('#modaltitle').empty();
}
function gettextValue(fieldName) {
    var _result;
    try {
        _result = $(fieldName).val();
    } catch (e) {
    }
    return _result;
}

function dovalidation() {
    //for username
    var firstname=$('#firstname').val();
    var lastname=$('#lastname').val();
    var email=$('#email').val();
    var password=$('#password').val();
    var confirmpassword=$('#confirmpassword').val();
    var mobile=$('#mobile').val();
    if((firstname==null||firstname=="")&&(lastname==null||lastname=="")&&(email==null||email=="")&&(password==null||password=="")&&(confirmpassword==null||confirmpassword=="")&&(mobile==null||mobile==""))
    {
        $('#firstname').parents(".form-group").addClass("has-error");
        $('#lastname').parents(".form-group").addClass("has-error");
        $('#email').parents(".form-group").addClass("has-error");
        $('#password').parents(".form-group").addClass("has-error");
        $('#confirmpassword').parents(".form-group").addClass("has-error");
        $('#mobile').parents(".form-group").addClass("has-error");
    }
    if(firstname==null||firstname=="")
    {
        $('#firstname').parents(".form-group").addClass("has-error");
        //showAlert("validation error","FirstName should not be empty");
        return false;
    }

    else {
        register["at0011"]=firstname;
    }
//for password

    if(lastname==null||lastname=="")
    {
        $('#lastname').parents(".form-group").addClass("has-error");
        return false;
    }
    else
    {
        register["at0012"]=lastname;
    }

//for email

    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");

    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=email.length)
    {
        $('#email').parents(".form-group").addClass("has-error");
        return false;
    }
    else if(email==null||email=="")
    {
        $('#email').parents(".form-group").addClass("has-error");
        return false;
    }
    else
    {
        register["at003"]=email;
    }
//for date

    if(password==null||password=="")
    {
        $('#password').parents(".form-group").addClass("has-error");
        return false;
    }
    else {
        register["at002"]=password;
    }
//for confirmpassword

    if(confirmpassword==null||confirmpassword=="")
    {
        $('#confirmpassword').parents(".form-group").addClass("has-error");
        return false;
    }
    else {
        register["at0021"]=confirmpassword;
    }

    if(password!=confirmpassword)
    {
        showAlert("validation error","Same");
        return false;
    }


    if(mobile==null||mobile=="")
    {
        $('#mobile').parents(".form-group").addClass("has-error");
        return false;
    }
    else {
        register["at046"]=mobile;
    }
    return true;
}



$('#regsister_submit').click(function () {
    $body.addClass("loading");
    if(dovalidation()) {
        $body.addClass("loading");
        alert(JSON.stringify(register));
        $.ajax({
            url: baseurl+"/srv001",
            method: "POST",
            contentType: 'application/json',
            data: JSON.stringify(register),
            crossDomain: true,
            success: function (data) {
                $body.removeClass("loading");

                if(data==":registration sucess") {
                    window.location.href = baseurl + "/assets/public_html/index.html";
                }
            }
        });
    }
});