annual_salary = ...
portion_saved = ...
total_cost = 1000000
semi_annual_raise = .07
portion_down_payment = 0.25
down_payment = total_cost * portion_down_payment
current_savings = 0
r = 0.04
months = 36

count = 0
epsilon = 100
low = 0
high = annual_salary * months
guess_savings = (low + high) / 2.0

while abs(guess_savings - down_payment) > epsilon:
    ...