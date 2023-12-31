<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = (String) session.getAttribute("login");
    if(user != null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DG Fashion - Login</title>
    <!-- Include Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="@sweetalert2/theme-minimal/minimal.css">
    <style>
        body {
            background-color: #343a40;
        }
        .login-card {
            max-width: 400px;
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
        <div class="col-12"
            <div id="alertsContainer"></div>         
        </div>
        <!-- Security Question Modal -->
        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">Answer the Question</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div id="securityQuestion" class="modal-body">
                  <div class="row">
                      <div class="col-lg-12">
                          <span id="questionAsk"></span>
                      </div>
                      <div class="col-lg-12">
                          <input class="form-control" placeholder="Enter your answer" id="answerAttempt" type="text">
                      </div>
                  </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" id="checkAnswer" class="btn btn-primary">Answer</button>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Change Password Modal -->
        <div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="staticBackdropLabel">New Password</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div id="securityQuestion" class="modal-body">
                  <div class="row">
                      <div class="col-lg-12">
                          <div class="form-group">
                              <label class="form-label">New Password</label>
                              <input type="password" id="newPass" name="newPass" class="form-control" />
                          </div>
                      </div>
                  </div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" id="changePassword" class="btn btn-primary">Change Password</button>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-6 mx-auto">
            <div class="login-card">
                <h2 class="text-center mb-4">Login</h2>
                <form id="loginform" action="Config?what=login" method="post">
                    <div class="mb-3">
                        <label for="phoneNumber" class="form-label">Phone Number</label>
                        <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter your phone number">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password">
                    </div>
                    <div class="mb-3">
                        <a id="frgPass" style="cursor:pointer;" class="text-decoration-none">Forgot Password?</a>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Login</button>
                </form>
                <hr class="my-4">
                <p class="text-center">Don't have an account? <a href="register.jsp" class="text-decoration-none">Register</a></p>
            </div>
        </div>
    </div>
</div>

<!-- Include Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js" integrity="sha512-rstIgDs0xPgmG6RX1Aba4KV5cWJbAMcvRCVmglpam9SoHZiUCyQVDdH2LPlxoHtrv17XWblE/V/PP+Tr04hbtA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    let question;
    let answer;
    $("#loginform").validate({
        rules : {
            phoneNumber : {
                required : true,
                digits : true,
                minlength : 10,
                maxlength : 10
            },
            password : {
                required : true
            }
        },
        messages : {
            phoneNumber : {
                required : "<span class='text-danger'>*Please enter phone number.</span>",
                digits : "<span class='text-danger'>*Please enter phone number correctly.</span>",
                maxlength : "<span class='text-danger'>*Please enter phone number.</span>",
                maxlength : "<span class='text-danger'>*Please enter phone number.</span>"
            },
            password : {
                required : "<span class='text-danger'>*Please enter password.</span>"
            }
        }
    });
    
    $("#loginform").submit(function(e){
        e.preventDefault();
        if($(this).valid())
        {
            const json = {};
            var formData = $("#loginform").serializeArray();
            $.each(formData, function(){
                json[this.name] = this.value;
            });
            
           $.ajax({
               type : "POST",
               method : "POST",
               dataType : "JSON",
               data : json,
               url : "Config?what=login",
               success : function(response){
                   if(response.success)
                   {
                       displayAlert("success", response.message, 2000);
                       
                       setTimeout(function() {
                           if(!response.admin)
                           {
                                window.location.replace('index.jsp');
                           }
                           else
                           {
                               window.location.replace('admin/dashboard.jsp');
                           }
                        }, 2000);
                   }
                   else
                   {
                       displayAlert("danger", response.message, 2000);
                   }
               },
               error : function(err){
                   Swal.fire({
                       icon : "error",
                       text : "Some error occured."
                   })
               }
           }); 
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
    
    $("#frgPass").click(function(){
        if($("#phoneNumber").val().length != 10)
        {
            displayAlert("danger", "Please enter phone number correctly.", 2000);
        }
        else if(isNaN($("#phoneNumber").val()))
        {
            displayAlert("danger", "Please enter phone number correctly.", 2000);
        }
        else
        {
            const json = {"phone" : $("#phoneNumber").val()};
            $.ajax({
                type : "POST",
                method : "POST",
                data : json,
                dataType : "JSON",
                url : "Config?what=getSecQuestion",
                success : function(response)
                {
                    if(response.success)
                    {
                        question = response.question;
                        answer = response.answer;
                        
                        $("#questionAsk").text(question);
                        $("#answerAttempt").val("");
                        $("#staticBackdrop").modal('show');
                    }
                    else
                    {
                        displayAlert("danger", response.message, 2000);
                    }
                },
                error : function(err)
                {
                    displayAlert("danger", err.toString(), 2000);
                }
            })
        }
    });
    
    $("#checkAnswer").click(function(){
        $("#staticBackdrop").modal('hide');
        
        if($("#answerAttempt").val() != answer)
        {
            displayAlert("danger", "Answer is not correct.", 2000);
        }
        else
        {
            $("#newPass").val("");
            $("#staticBackdrop2").modal('show');
        }
    });
    
    $("#changePassword").click(function(){
        if($("#newPass").val() == "" || $("#newPass").val() == null)
        {
            $("#staticBackdrop2").modal('hide');
            displayAlert("danger", "New password was not in correct format.", 2000);
        }
        else
        {
            const json = {"password" : $("#newPass").val(), "phone" : $("#phoneNumber").val()};
            
            $.ajax({
                type : "POST",
                method : "POST",
                data : json,
                dataType : "JSON",
                url : "Config?what=changePassword",
                success : function(response){
                    $("#staticBackdrop2").modal('hide');
                    if(response.success)
                    {
                        displayAlert("success", response.message, 2000);
                    }
                    else
                    {
                        displayAlert("danger", response.message, 2000);
                    }
                },
                error : function(err){
                    $("#staticBackdrop2").modal('hide');
                    displayAlert("danger", err.toString(), 2000);
                }
            })
        }
    });
</script>
</body>
</html>