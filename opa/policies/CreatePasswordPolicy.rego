package password.policy

 #If your password matches the regex below, it is invalid.
 # If there's no match, your password is valid and contains has at least 8 characters,
 # one upper case letter, one lower case letter and one symbol or special character.
 # And it also contains no spaces, tabs or line breaks.
is_invalid_password(password) {
    re_match(`^(.{0,7}|[^a-z]{1,}|[^A-Z]{1,}|[^\d]{1,}|[^\W]{1,})$|[\s]`, password)
}

default allow := false

allow {
    not is_invalid_password(input.password)
}
