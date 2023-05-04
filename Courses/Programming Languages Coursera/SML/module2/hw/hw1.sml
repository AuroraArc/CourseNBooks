(* year (positive number) * month (1-12) * day (depends on month) *)


fun is_older (list1 : int * int * int, list2 : int * int * int) =
    if (#1 list1) < (#1 list2)
    then true
    else if (#2 list1) < (#2 list2)
         then true
         else if (#3 list1) < (#3 list2)
              then true
              else false

fun number_in_month (dates : (int * int * int) list, month : int) =
    if null dates
    then 0
    else if #2 (hd dates) = month
         then 1 + number_in_month(tl dates, month)
         else number_in_month(tl dates, month)

fun number_in_months (dates : (int * int * int) list, months : int list) =
    if null months
    then 0
    else number_in_month(dates, hd months) + number_in_months(dates, tl months)

fun dates_in_month (dates : (int * int * int) list, month : int) =
    if null dates
    then []
    else if #2 (hd dates) = month
         then (hd dates) :: dates_in_month(tl dates, month)
         else dates_in_month(tl dates, month)

fun dates_in_months (dates : (int * int * int) list, months : int list) =
    if null months
    then []
    else dates_in_month(dates, hd months) @ dates_in_months(dates, tl months)

fun get_nth (strings : string list , n : int) =
    if n = 1
    then hd strings
    else get_nth(tl strings, n - 1)

fun date_to_string (year : int, month : int, day : int) =
    let
        val months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
    in
        get_nth(months, month) ^ " "  ^ Int.toString(day) ^ ", " ^ Int.toString(year)
    end

fun number_before_reaching_sum (sum : int, posnum : int list) =
    if (hd posnum) > sum orelse (hd posnum) = sum
    then 0
    else 1 + number_before_reaching_sum(sum - (hd posnum), tl posnum)

fun what_month (day : int) =
    let
        val month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    in
        1 + number_before_reaching_sum(day, month)
    end

fun month_range(day1 : int, day2 : int) =
    if day1 > day2
    then []
    else what_month(day1) :: month_range(day1 + 1, day2)

fun oldest (dates : (int * int * int) list) =
    if null dates
    then NONE
    else let
            fun maxdates (dates : (int * int * int) list) =
                if null (tl dates)
                then SOME (hd dates)
                else if is_older(hd(tl(dates)), hd(dates))
                     then maxdates((tl(dates)))
                     else if hd(dates) = hd(tl(dates)) andalso null (tl(tl(dates)))
                          then NONE
                          else maxdates(tl(dates))
         in
            maxdates(dates)
         end
            