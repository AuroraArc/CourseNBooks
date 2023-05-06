annual_salary = float(input("Enter the starting salary: "))
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
high = round(down_payment / (36.0 * annual_salary / 12.0), 4) # looks for portion saved variable
guess_savings = round((low + high) / 2.0, 4)


while abs(annual_salary / 12.0 * guess_savings * 36.0 - down_payment) > epsilon:
    debug = abs(annual_salary / 12.0 * guess_savings * 36.0 - down_payment)
    if guess_savings * 36.0 < down_payment:
        low = guess_savings
    else:
        high = guess_savings
    guess_savings = round((low + high) / 2.0, 4)
    count += 1
print(f"Best savings rate: {guess_savings}")
print(f"Steps in bisections search: {count}")