def fib_efficient(n, d):
    if n in d:
        return d[n]
    else:
        ans = fib_efficient(n-1, d) + fib_efficient(n-2, d)
        d[n] = ans
        return ans

d = {1:1, 2:2} # d is a dictionary with key 1 and value 1, key 2 and value 2
print(fib_efficient(6, d))