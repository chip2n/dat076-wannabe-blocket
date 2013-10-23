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
    else{
        input.setCustomValidity("");
    }
}

function clearValidation(input){
    input.setCustomValidity("");
}
