$('#button-submit').submit(function(e) {

    e.preventDefault();

    var username = $("input[id='backloginform']").val();
    var password = $("input[id='backpasswordform']").val();

    if (username.length < 3 || password.length < 6) {
        alert("Username must be at least 3 characters and password - at least 6. Be tricky!");
        return;
    }

    if (username && password) {
        $.ajax({
            url: 'http://localhost:5000/auth/oauth/token',
            dataType: 'json',
            type: "post",
            contentType: "application/json",
            data: JSON.stringify({
                username: username,
                password: password
            }),
            success: function (data) {

                requestOauthToken(username, password);
                initAccount(getCurrentAccount());


                $('#registrationforms, .fliptext, #createaccount').fadeOut(300);
                $('#mailform').fadeIn(500);
                setTimeout(function(){ $("#backmailform").focus() }, 10);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                if (xhr.status == 400) {
                    alert("Sorry, account with the same name already exists.");
                } else {
                    alert("An error during account creation. Please, try again.");
                }
            }
        });

    } else {
        alert("Please, fill all the fields.");
    }
});

function login() {


    var username = $("input[id='login']").val();
    var password = $("input[id='password']").val();

    if (requestOauthToken(username, password)) {

        initAccount(getCurrentAccount());

        var userAvatar = $("<img />").attr("src","images/userpic.jpg");
        $(userAvatar).load(function() {
            setTimeout(initGreetingPage, 500);
        });
    } else {
        $("#preloader, #enter, #secondenter").hide();
        flipForm();
        $('.frontforms').val('');
        $("#frontloginform").focus();
        alert("Something went wrong. Please, check your credentials");
    }
}
