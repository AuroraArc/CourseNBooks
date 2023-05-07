annual_salary = float(input("Enter the starting salary: "))
portion_saved = ...
total_cost = 1000000
semi_annual_raise = .07
portion_down_payment = 0.25
down_payment = total_cost * portion_down_payment
current_savings = 0
r = 0.04
months = 36
total_salary = 0
i = 1

for i in range(months + 1):
    if months % 6 == 0:
        annual_salary = annual_salary + annual_salary * semi_annual_raise
    total_salary += annual_salary
    months += 1
annual_salary = total_salary / 36.0
monthly_salary = annual_salary / 12.0

count = 0
epsilon = 100
low = 0
high = round(down_payment / (36.0 * monthly_salary), 4) # looks for portion saved variable
percent_savings = round((low + high) / 2.0, 4)
factor = 1.04 ** 3


while abs((monthly_salary * percent_savings * 36.0)- down_payment) > epsilon:
    debug = abs((monthly_salary * percent_savings * 36.0)- down_payment)
    if (monthly_salary * percent_savings * 36.0) < down_payment:
        low = percent_savings
    else:
        high = percent_savings
    percent_savings = round((low + high) / 2.0, 4)
    count += 1
print(f"Best savings rate: {percent_savings}")
print(f"Steps in bisections search: {count}")