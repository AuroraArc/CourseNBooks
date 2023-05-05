annual_salary = float(input("Enter your annual salary: "))
portion_saved = float(input("Enter the percent of your salary to save, as a decimal: "))
total_cost = float(input("Total cost: "))
portion_down_payment = 0.25
down_payment = total_cost * portion_down_payment
current_savings = 0
r = 0.04
monthly_salary = annual_salary / 12
months = 0

"""
First, determine how big the portion of your salary each month
will be dedicated to saving for the down payment.
Calculate return on investment first (r = 0.04),
then add a percentage of your monthly salary.
Use a counter to see how many months it takes to reach
the down payment cost.
Print the number of months.
"""

while current_savings < down_payment:
    current_savings = current_savings + current_savings * r / 12
    current_savings = current_savings + monthly_salary * portion_saved
    months = months + 1
print(f"Number of months: {months}")