fun pow(x : int, y : int) = 
    if y = 0
    then 1
    else x * pow(x,y-1);
(* works only if y >= 0 *)

fun cube(x : int) = 
    pow(x,3)

val sixtyfour = cube(4)

val fourtytwo = pow(2, 2+2) + pow(4,2) + cube(2) + 2