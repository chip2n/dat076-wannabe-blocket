function validateOldPassword(input){
    if(input.value === ""){
        input.setCustomValidity('Ange ditt gamla lösenord.');
    }
    else{
        input.setCustomValidity("");
    }
}

function validatePassword(input){
    if(input.value === ""){
        input.setCustomValidity('Ange ditt nya lösenord.');
    }
    else if(input.value.length < 4 || input.value.length > 16){
        input.setCustomValidity('Lösenordet måste vara mellan 4 och 16 tecken långt.');
    }
    else{
        input.setCustomValidity("");
        validateRepeat(document.forms['changepassword'].repeat);
    }
}

function validateRepeat(input){
    if(input.value === ""){
        input.setCustomValidity('Repetera ditt nya lösenord.');
    }
    else if(input.value !== document.forms['changepassword'].password.value){
        input.setCustomValidity('Lösenorden måste matcha.');
    }
    else{
        input.setCustomValidity("");
    }  
}

function validateEmail(input){
    if(input.value === ""){
        input.setCustomValidity('Ange en email adress.');
    }
    else if(!input.validity.valid){
        input.setCustomValidity('Ange en giltig email adress.');
    }
    else{
        input.setCustomValidity("");
    }
}

function clearValidation(input){
    input.setCustomValidity("");
}
