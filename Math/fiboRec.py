def fib(n) :
  if n < 2 :
    return n
  else :
    return (fib(n-1) + fib(n-2))%10

liste = []
liste.append(1)
liste.append(2)
for i in range(2,100) : 
	liste.append(fib(i))
	
	
print liste	