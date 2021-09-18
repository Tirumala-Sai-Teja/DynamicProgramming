# Normal Method
def fact(n):
    if n<=1:
        return 1
    else:
        return n*fact(n-1)
# dp
def fa(n):
    dp=[0]*n
    dp[0]=1
    dp[1]=1
    f=1
    for i in range(2,n):
        f=f*i
        dp[i]=f
    return dp[-1]
print(fa(10000))
