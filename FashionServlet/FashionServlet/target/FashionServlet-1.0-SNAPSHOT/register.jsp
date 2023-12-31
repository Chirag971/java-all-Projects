<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DG Fashion - Registration</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #343a40;
        }
        .registration-card {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            color: #333;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <div id="alertsContainer"></div>
        </div>
        <div class="col-lg-8 mx-auto">
            <div class="registration-card">
                <h2 class="text-center mb-4">Registration</h2>
                <form id="registerform">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="Enter your username">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Enter your password">
                    </div>
                    <div class="mb-3">
                        <label for="securityQuestion" class="form-label">Security Question</label>
                        <input type="text" class="form-control" name="securityQuestion" id="securityQuestion" placeholder="Enter your security question">
                    </div>
                    <div class="mb-3">
                        <label for="securityAnswer" class="form-label">Security Answer</label>
                        <input type="text" class="form-control" name="securityAnswer" id="securityAnswer" placeholder="Enter your security answer">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email">
                    </div>
                    <div class="mb-3">
                        <label for="phone" class="form-label">Phone</label>
                        <input type="tel" class="form-control" name="phone" id="phone" placeholder="Enter your phone number">
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Address</label>
                        <textarea class="form-control" id="address" name="address" rows="3" placeholder="Enter your address"></textarea>
                    </div>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label for="pincode" class="form-label">Pincode</label>
                            <input type="text" class="form-control" name="pincode" id="pincode" placeholder="Enter your pincode">
                        </div>
                        <div class="col-md-6">
                            <label for="state" class="form-label">State</label>
                            <input type="text" class="form-control" name="state" readonly id="state" placeholder="Enter your state">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="city" class="form-label">City</label>
                        <input type="text" class="form-control" name="city" readonly id="city" placeholder="Enter your city">
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Register</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Include Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js" integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    $("#registerform").validate({
        rules : {
            username : {
                required : true
            },
            password : {
                required : true
            },
            securityQuestion : {
                required : true
            },
            securityAnswer : {
                required : true
            },
            email : {
                required : true
            },
            phone : {
                required : true,
                digits : true,
                minlength : 10,
                maxlength : 10
            },
            address : {
                required : true
            },
            pincode : {
                required : true,
                digits : true,
                minlength : 6,
                maxlength : 6
            },
            state : {
                required : true
            },
            city : {
                required : true
            }
        },
        messages : {
            username : {
                required : "<span class='text-danger'>*Please enter User Name</span>"
            },
            password : {
                required : "<span class='text-danger'>*Please enter Password</span>"
            },
            securityQuestion : {
                required : "<span class='text-danger'>*Please enter Security Question</span>"
            },
            securityAnswer : {
                required : "<span class='text-danger'>*Please enter Answer to your Question</span>"
            },
            email : {
                required : "<span class='text-danger'>*Please enter Email ID</span>"
            },
            phone : {
                required : "<span class='text-danger'>*Please enter Phone Number</span>",
                digits : "<span class='text-danger'>*Please enter Phone Number in correct format</span>",
                minlength : "<span class='text-danger'>*Please enter Phone Number in correct format</span>",
                maxlength : "<span class='text-danger'>*Please enter Phone Number in correct format</span>"
            },
            address : {
                required : "<span class='text-danger'>*Please enter Address</span>"
            },
            pincode : {
                required : "<span class='text-danger'>*Please enter Pincode</span>",
                digits : "<span class='text-danger'>*Please enter Pincode in correct format</span>",
                minlength : "<span class='text-danger'>*Please enter Pincode in correct format</span>",
                maxlength : "<span class='text-danger'>*Please enter Pincode in correct format</span>"
            },
            state : {
                required : "<span class='text-danger'>*Please enter State</span>"
            },
            city : {
                required : "<span class='text-danger'>*Please enter City</span>"
            }
        }
    });
    
    $("#pincode").blur(function(){
        if($(this).val().length == 6)
        {
            $.ajax({
                type : "GET",
                method : "GET",
                dataType : "JSON",
                url : "https://api.postalpincode.in/pincode/" + $(this).val().trim(),
                success : function(response)
                {
                    if(response[0].Status == "Success")
                    {
                        $("#city").val(response[0].PostOffice[0].District);
                        $("#state").val(response[0].PostOffice[0].State);
                    }
                    else
                    {
                        $("#state").val("");
                        $("#city").val("");
                    }
                }
            })
        }
    });
    
    $("#registerform").submit(function(e){
        e.preventDefault();
        
        if($(this).valid())
        {
            const json = {};
            $.each($("#registerform").serializeArray(), function(){
                json[this.name] = this.value;
            })
            $.ajax({
                type : "POST",
                method : "POST",
                dataType : "JSON",
                data : json,
                url : "Config?what=register",
                success : function(response)
                {
                    if(response.success)
                    {
                        displayAlert("success", response.message, 2000);
                        setTimeout(function() {
                            window.location.replace("login.jsp");
                        }, 2000);
                    }
                    else
                    {
                        displayAlert("danger", response.message, 2000);
                    }
                },
                error : function(err)
                {
                    displayAlert("danger", "Some error occurred.", 2000);
                }
            })
        }
    })
    function displayAlert(type, message, duration) {
        var alertHtml = `
            <div class="alert alert-`+ type +` alert-dismissible fade show" role="alert">
                `+ message +`
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        `;

        $('#alertsContainer').html(alertHtml);
        
        setTimeout(function() {
            $('#alertsContainer .alert').alert('close');
        }, duration);
    }
</script>
</body>
</html>