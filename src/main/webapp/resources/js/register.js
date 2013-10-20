function validateUsername(input){
    if(input.value === ""){
        input.setCustomValidity('Ange ett användarnamn.');
    }
    else{
        input.setCustomValidity("");
    }
}

function validatePassword(input){
    if(input.value === ""){
        input.setCustomValidity('Ange ett lösenord.');
    }
    else if(input.value.length < 4 && input.value.length > 16){
        input.setCustomValidity('Lösenordet måste vara mellan 4 och 16 tecken långt.');
    }
    else{
        input.setCustomValidity("");
    }     
}

function validateRepeat(input){
    if(input.value === ""){
        input.setCustomValidity('Repetera lösenord.');
    }
    else if(input.value !== document.forms['register'].password.value){
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

function clear(input){
    input.setCustomValidity('');
}
