package email.policy

# Define the allowed email domain
allowed_domain = "mycompany.com"
default allow := false

# Define the rule to enforce the allowed email domain
allow {
    split(input.email_address, "@")[1] == allowed_domain
}
