#Bootstrap Links
 /META-INF/resources/webjars/bootstrap/5.3.2/css/bootstrap.min.css
 /META-INF/resources/webjars/bootstrap/5.3.2/js/bootstrap.min.js
 webjars/jquery/3.7.1/jquery.min.js
 
 
 ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$
 
 ^                 # start-of-string
(?=.*[0-9])       # a digit must occur at least once
(?=.*[a-z])       # a lower case letter must occur at least once
(?=.*[A-Z])       # an upper case letter must occur at least once
(?=.*[@#$%^&+=])  # a special character must occur at least once
(?=\S+$)          # no whitespace allowed in the entire string
.{8,}             # anything, at least eight places though
$                 # end-of-string